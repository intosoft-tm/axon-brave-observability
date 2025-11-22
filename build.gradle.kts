import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jlleitschuh.gradle.ktlint.KtlintExtension

val currentVersion: String by project

group = "me.tmarciniak"
version = currentVersion

plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.com.github.ben.manes.versions)
    alias(libs.plugins.com.google.devtools.ksp)

    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.allopen)
    alias(libs.plugins.org.jetbrains.kotlin.plugin.spring)

    alias(libs.plugins.org.jlleitschuh.gradle.ktlint)
    alias(libs.plugins.org.springframework.boot)

    alias(libs.plugins.nl.littlerobots.version.catalog.update)
    alias(libs.plugins.io.spring.dependency.management)
}

repositories {
    maven(url = "https://repo1.maven.org/maven2/")
    mavenLocal()
    mavenCentral()
}

kotlin {
    compilerOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
    jvmToolchain(21)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation(libs.com.google.devtools.ksp.symbol.processing.api)
    implementation(libs.com.fasterxml.jackson.module.jackson.module.kotlin)

    implementation(libs.org.springframework.boot.spring.boot.starter.actuator)

    implementation(libs.org.axon.spring.boot.starter)
    implementation(libs.org.axon.extensions.reactor.spring.boot.starter)
    implementation(libs.org.axon.micrometer)

    implementation(libs.org.yaml.snakeyaml)

    implementation(libs.io.axoniq.console.framework.client.spring.boot.starter)
    implementation(libs.io.micrometer.tracing.bridge.brave)

    implementation(libs.io.zipkin.reporter2.zipkin.reporter.brave)

    implementation(libs.jakarta.validation.api)

    implementation(libs.org.jetbrains.kotlin.kotlin.reflect)
    implementation(libs.org.jetbrains.kotlin.kotlin.stdlib.jdk8)

    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.reactor)

    implementation(libs.io.github.oshai.kotlin.logging.jvm)
    implementation(libs.io.projectreactor.kotlin.reactor.kotlin.extensions)

    runtimeOnly(libs.io.micrometer.registry.prometheus)

    testImplementation(libs.org.springframework.boot.spring.boot.starter.test)
    testImplementation(libs.org.springframework.boot.spring.boot.testcontainers)

    testImplementation(libs.io.projectreactor.reactor.test)

    testImplementation(libs.io.kotest.runner.junit5)
    testImplementation(libs.io.kotest.assertions.core)
    testImplementation(libs.io.kotest.property)

    testImplementation(libs.io.kotest.extensions.spring)
    testImplementation(libs.io.kotest.extensions.testcontainers)

    testImplementation(libs.io.micrometer.tracing.test)
    testImplementation(libs.io.micrometer.observation.test)
    testImplementation(libs.io.mockk)
}

configurations {
    compileClasspath { extendsFrom(configurations.annotationProcessor.get()) }
}

tasks {
    withType<DependencyUpdatesTask> { rejectVersionIf { isNonStable(candidate.version) } }
    withType<Test> { useJUnitPlatform {} }

    // Empty for now, required by shared GitHub action
    register<Test>("integrationTest")
    register<Test>("archUnitTest")

    bootJar { enabled = false }
    bootRun { enabled = false }

    jar {
        enabled = true
        archiveClassifier.set("")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/intosoft-tm/axon-brave-observability")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

configure<KtlintExtension> {
    filter { exclude { it.file.path.startsWith(layout.buildDirectory.asFile.get().path) } }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}