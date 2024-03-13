import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jlleitschuh.gradle.ktlint.KtlintExtension

group = "me.tmarciniak"
version = "0.0.1-SNAPSHOT"

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

    alias(libs.plugins.io.spring.dependency.management)
}

repositories {
    maven(url = "https://repo1.maven.org/maven2/")
    mavenLocal()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_20
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
    implementation(libs.io.micrometer.micrometer.tracing.bridge.brave)

    implementation(libs.io.zipkin.reporter2.zipkin.reporter.brave)

    implementation(libs.jakarta.validation.api)

    implementation(libs.org.jetbrains.kotlin.kotlin.reflect)
    implementation(libs.org.jetbrains.kotlin.kotlin.stdlib.jdk8)

    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.reactor)

    implementation(libs.io.github.oshai.kotlin.logging.jvm)
    implementation(libs.io.projectreactor.kotlin.reactor.kotlin.extensions)

    runtimeOnly(libs.io.micrometer.micrometer.registry.prometheus)

    testImplementation(libs.org.springframework.boot.spring.boot.starter.test)
    testImplementation(libs.org.springframework.boot.spring.boot.testcontainers)

    testImplementation(libs.io.projectreactor.reactor.test)

    testImplementation(libs.io.kotest.kotest.runner.junit5)
    testImplementation(libs.io.kotest.kotest.assertions.core)
    testImplementation(libs.io.kotest.kotest.property)

    testImplementation(libs.io.kotest.extensions.kotest.extensions.spring)
    testImplementation(libs.io.kotest.extensions.kotest.extensions.testcontainers)

    testImplementation(libs.io.micrometer.micrometer.tracing.test)

    testImplementation(libs.org.mockito.kotlin.mockito.kotlin)
}

configurations {
    compileClasspath { extendsFrom(configurations.annotationProcessor.get()) }
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict", "-Xlint:unchecked")
            jvmTarget = JavaVersion.VERSION_20.majorVersion
        }
    }

    withType<Test> {
        useJUnitPlatform {
        }
    }

    bootJar {
        enabled = false
    }

    bootRun {
        enabled = false
    }

    jar {
        enabled = true
        archiveClassifier.set("")
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "me.tmarciniak"
            artifactId = "axon-brave-observability"
            version = "0.0.1"

            from(components["java"])
        }
    }
}
    

configure<KtlintExtension> {
    filter { exclude { it.file.path.startsWith(layout.buildDirectory.asFile.get().path) } }
}