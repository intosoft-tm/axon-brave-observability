package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final IoLibraryAccessors laccForIoLibraryAccessors = new IoLibraryAccessors(owner);
    private final JakartaLibraryAccessors laccForJakartaLibraryAccessors = new JakartaLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Returns the group of libraries at com
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Returns the group of libraries at io
     */
    public IoLibraryAccessors getIo() {
        return laccForIoLibraryAccessors;
    }

    /**
     * Returns the group of libraries at jakarta
     */
    public JakartaLibraryAccessors getJakarta() {
        return laccForJakartaLibraryAccessors;
    }

    /**
     * Returns the group of libraries at org
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlLibraryAccessors laccForComFasterxmlLibraryAccessors = new ComFasterxmlLibraryAccessors(owner);
        private final ComGithubLibraryAccessors laccForComGithubLibraryAccessors = new ComGithubLibraryAccessors(owner);
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);
        private final ComTngtechLibraryAccessors laccForComTngtechLibraryAccessors = new ComTngtechLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml
         */
        public ComFasterxmlLibraryAccessors getFasterxml() {
            return laccForComFasterxmlLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.github
         */
        public ComGithubLibraryAccessors getGithub() {
            return laccForComGithubLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.google
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

        /**
         * Returns the group of libraries at com.tngtech
         */
        public ComTngtechLibraryAccessors getTngtech() {
            return laccForComTngtechLibraryAccessors;
        }

    }

    public static class ComFasterxmlLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonLibraryAccessors laccForComFasterxmlJacksonLibraryAccessors = new ComFasterxmlJacksonLibraryAccessors(owner);

        public ComFasterxmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson
         */
        public ComFasterxmlJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleLibraryAccessors laccForComFasterxmlJacksonModuleLibraryAccessors = new ComFasterxmlJacksonModuleLibraryAccessors(owner);

        public ComFasterxmlJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson.module
         */
        public ComFasterxmlJacksonModuleLibraryAccessors getModule() {
            return laccForComFasterxmlJacksonModuleLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonModuleLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleJacksonLibraryAccessors laccForComFasterxmlJacksonModuleJacksonLibraryAccessors = new ComFasterxmlJacksonModuleJacksonLibraryAccessors(owner);

        public ComFasterxmlJacksonModuleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson.module.jackson
         */
        public ComFasterxmlJacksonModuleJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonModuleJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonModuleJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors laccForComFasterxmlJacksonModuleJacksonModuleLibraryAccessors = new ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors(owner);

        public ComFasterxmlJacksonModuleJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.fasterxml.jackson.module.jackson.module
         */
        public ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors getModule() {
            return laccForComFasterxmlJacksonModuleJacksonModuleLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors extends SubDependencyFactory {

        public ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for kotlin (com.fasterxml.jackson.module:jackson-module-kotlin)
         * with versionRef 'jackson.module.kotlin'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKotlin() {
                return create("com.fasterxml.jackson.module.jackson.module.kotlin");
        }

    }

    public static class ComGithubLibraryAccessors extends SubDependencyFactory {
        private final ComGithubAvroLibraryAccessors laccForComGithubAvroLibraryAccessors = new ComGithubAvroLibraryAccessors(owner);

        public ComGithubLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.github.avro
         */
        public ComGithubAvroLibraryAccessors getAvro() {
            return laccForComGithubAvroLibraryAccessors;
        }

    }

    public static class ComGithubAvroLibraryAccessors extends SubDependencyFactory {
        private final ComGithubAvroKotlinLibraryAccessors laccForComGithubAvroKotlinLibraryAccessors = new ComGithubAvroKotlinLibraryAccessors(owner);

        public ComGithubAvroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.github.avro.kotlin
         */
        public ComGithubAvroKotlinLibraryAccessors getKotlin() {
            return laccForComGithubAvroKotlinLibraryAccessors;
        }

    }

    public static class ComGithubAvroKotlinLibraryAccessors extends SubDependencyFactory {
        private final ComGithubAvroKotlinAvro4kLibraryAccessors laccForComGithubAvroKotlinAvro4kLibraryAccessors = new ComGithubAvroKotlinAvro4kLibraryAccessors(owner);

        public ComGithubAvroKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.github.avro.kotlin.avro4k
         */
        public ComGithubAvroKotlinAvro4kLibraryAccessors getAvro4k() {
            return laccForComGithubAvroKotlinAvro4kLibraryAccessors;
        }

    }

    public static class ComGithubAvroKotlinAvro4kLibraryAccessors extends SubDependencyFactory {

        public ComGithubAvroKotlinAvro4kLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (com.github.avro-kotlin.avro4k:avro4k-core)
         * with versionRef 'com.github.avro.kotlin.avro4k.core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("com.github.avro.kotlin.avro4k.core");
        }

    }

    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsLibraryAccessors laccForComGoogleDevtoolsLibraryAccessors = new ComGoogleDevtoolsLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.devtools
         */
        public ComGoogleDevtoolsLibraryAccessors getDevtools() {
            return laccForComGoogleDevtoolsLibraryAccessors;
        }

    }

    public static class ComGoogleDevtoolsLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspLibraryAccessors laccForComGoogleDevtoolsKspLibraryAccessors = new ComGoogleDevtoolsKspLibraryAccessors(owner);

        public ComGoogleDevtoolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.devtools.ksp
         */
        public ComGoogleDevtoolsKspLibraryAccessors getKsp() {
            return laccForComGoogleDevtoolsKspLibraryAccessors;
        }

    }

    public static class ComGoogleDevtoolsKspLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspSymbolLibraryAccessors laccForComGoogleDevtoolsKspSymbolLibraryAccessors = new ComGoogleDevtoolsKspSymbolLibraryAccessors(owner);

        public ComGoogleDevtoolsKspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.devtools.ksp.symbol
         */
        public ComGoogleDevtoolsKspSymbolLibraryAccessors getSymbol() {
            return laccForComGoogleDevtoolsKspSymbolLibraryAccessors;
        }

    }

    public static class ComGoogleDevtoolsKspSymbolLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors laccForComGoogleDevtoolsKspSymbolProcessingLibraryAccessors = new ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors(owner);

        public ComGoogleDevtoolsKspSymbolLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.google.devtools.ksp.symbol.processing
         */
        public ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors getProcessing() {
            return laccForComGoogleDevtoolsKspSymbolProcessingLibraryAccessors;
        }

    }

    public static class ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors extends SubDependencyFactory {

        public ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (com.google.devtools.ksp:symbol-processing-api)
         * with versionRef 'com.google.devtools.ksp'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("com.google.devtools.ksp.symbol.processing.api");
        }

    }

    public static class ComTngtechLibraryAccessors extends SubDependencyFactory {
        private final ComTngtechArchunitLibraryAccessors laccForComTngtechArchunitLibraryAccessors = new ComTngtechArchunitLibraryAccessors(owner);

        public ComTngtechLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.tngtech.archunit
         */
        public ComTngtechArchunitLibraryAccessors getArchunit() {
            return laccForComTngtechArchunitLibraryAccessors;
        }

    }

    public static class ComTngtechArchunitLibraryAccessors extends SubDependencyFactory {
        private final ComTngtechArchunitArchunitLibraryAccessors laccForComTngtechArchunitArchunitLibraryAccessors = new ComTngtechArchunitArchunitLibraryAccessors(owner);

        public ComTngtechArchunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.tngtech.archunit.archunit
         */
        public ComTngtechArchunitArchunitLibraryAccessors getArchunit() {
            return laccForComTngtechArchunitArchunitLibraryAccessors;
        }

    }

    public static class ComTngtechArchunitArchunitLibraryAccessors extends SubDependencyFactory {
        private final ComTngtechArchunitArchunitJunit5LibraryAccessors laccForComTngtechArchunitArchunitJunit5LibraryAccessors = new ComTngtechArchunitArchunitJunit5LibraryAccessors(owner);

        public ComTngtechArchunitArchunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at com.tngtech.archunit.archunit.junit5
         */
        public ComTngtechArchunitArchunitJunit5LibraryAccessors getJunit5() {
            return laccForComTngtechArchunitArchunitJunit5LibraryAccessors;
        }

    }

    public static class ComTngtechArchunitArchunitJunit5LibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ComTngtechArchunitArchunitJunit5LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit5 (com.tngtech.archunit:archunit-junit5)
         * with versionRef 'com.tngtech.archunit'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("com.tngtech.archunit.archunit.junit5");
        }

            /**
             * Creates a dependency provider for api (com.tngtech.archunit:archunit-junit5-api)
         * with versionRef 'com.tngtech.archunit'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("com.tngtech.archunit.archunit.junit5.api");
        }

    }

    public static class IoLibraryAccessors extends SubDependencyFactory {
        private final IoGithubLibraryAccessors laccForIoGithubLibraryAccessors = new IoGithubLibraryAccessors(owner);
        private final IoHolixonLibraryAccessors laccForIoHolixonLibraryAccessors = new IoHolixonLibraryAccessors(owner);
        private final IoKotestLibraryAccessors laccForIoKotestLibraryAccessors = new IoKotestLibraryAccessors(owner);
        private final IoMcarleLibraryAccessors laccForIoMcarleLibraryAccessors = new IoMcarleLibraryAccessors(owner);
        private final IoMongockLibraryAccessors laccForIoMongockLibraryAccessors = new IoMongockLibraryAccessors(owner);
        private final IoProjectreactorLibraryAccessors laccForIoProjectreactorLibraryAccessors = new IoProjectreactorLibraryAccessors(owner);

        public IoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.github
         */
        public IoGithubLibraryAccessors getGithub() {
            return laccForIoGithubLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.holixon
         */
        public IoHolixonLibraryAccessors getHolixon() {
            return laccForIoHolixonLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.kotest
         */
        public IoKotestLibraryAccessors getKotest() {
            return laccForIoKotestLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.mcarle
         */
        public IoMcarleLibraryAccessors getMcarle() {
            return laccForIoMcarleLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.mongock
         */
        public IoMongockLibraryAccessors getMongock() {
            return laccForIoMongockLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.projectreactor
         */
        public IoProjectreactorLibraryAccessors getProjectreactor() {
            return laccForIoProjectreactorLibraryAccessors;
        }

    }

    public static class IoGithubLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiLibraryAccessors laccForIoGithubOshaiLibraryAccessors = new IoGithubOshaiLibraryAccessors(owner);

        public IoGithubLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.github.oshai
         */
        public IoGithubOshaiLibraryAccessors getOshai() {
            return laccForIoGithubOshaiLibraryAccessors;
        }

    }

    public static class IoGithubOshaiLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiKotlinLibraryAccessors laccForIoGithubOshaiKotlinLibraryAccessors = new IoGithubOshaiKotlinLibraryAccessors(owner);

        public IoGithubOshaiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.github.oshai.kotlin
         */
        public IoGithubOshaiKotlinLibraryAccessors getKotlin() {
            return laccForIoGithubOshaiKotlinLibraryAccessors;
        }

    }

    public static class IoGithubOshaiKotlinLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiKotlinLoggingLibraryAccessors laccForIoGithubOshaiKotlinLoggingLibraryAccessors = new IoGithubOshaiKotlinLoggingLibraryAccessors(owner);

        public IoGithubOshaiKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.github.oshai.kotlin.logging
         */
        public IoGithubOshaiKotlinLoggingLibraryAccessors getLogging() {
            return laccForIoGithubOshaiKotlinLoggingLibraryAccessors;
        }

    }

    public static class IoGithubOshaiKotlinLoggingLibraryAccessors extends SubDependencyFactory {

        public IoGithubOshaiKotlinLoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jvm (io.github.oshai:kotlin-logging-jvm)
         * with versionRef 'kotlin.logging.jvm'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJvm() {
                return create("io.github.oshai.kotlin.logging.jvm");
        }

    }

    public static class IoHolixonLibraryAccessors extends SubDependencyFactory {
        private final IoHolixonAxonLibraryAccessors laccForIoHolixonAxonLibraryAccessors = new IoHolixonAxonLibraryAccessors(owner);

        public IoHolixonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.holixon.axon
         */
        public IoHolixonAxonLibraryAccessors getAxon() {
            return laccForIoHolixonAxonLibraryAccessors;
        }

    }

    public static class IoHolixonAxonLibraryAccessors extends SubDependencyFactory {
        private final IoHolixonAxonAvroLibraryAccessors laccForIoHolixonAxonAvroLibraryAccessors = new IoHolixonAxonAvroLibraryAccessors(owner);

        public IoHolixonAxonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.holixon.axon.avro
         */
        public IoHolixonAxonAvroLibraryAccessors getAvro() {
            return laccForIoHolixonAxonAvroLibraryAccessors;
        }

    }

    public static class IoHolixonAxonAvroLibraryAccessors extends SubDependencyFactory {
        private final IoHolixonAxonAvroSerializerLibraryAccessors laccForIoHolixonAxonAvroSerializerLibraryAccessors = new IoHolixonAxonAvroSerializerLibraryAccessors(owner);

        public IoHolixonAxonAvroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.holixon.axon.avro.serializer
         */
        public IoHolixonAxonAvroSerializerLibraryAccessors getSerializer() {
            return laccForIoHolixonAxonAvroSerializerLibraryAccessors;
        }

    }

    public static class IoHolixonAxonAvroSerializerLibraryAccessors extends SubDependencyFactory {

        public IoHolixonAxonAvroSerializerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for spring (io.holixon.axon.avro:axon-avro-serializer-spring)
         * with versionRef 'io.holixon.axon.avro.serializer.spring'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSpring() {
                return create("io.holixon.axon.avro.serializer.spring");
        }

    }

    public static class IoKotestLibraryAccessors extends SubDependencyFactory {
        private final IoKotestExtensionsLibraryAccessors laccForIoKotestExtensionsLibraryAccessors = new IoKotestExtensionsLibraryAccessors(owner);
        private final IoKotestKotestLibraryAccessors laccForIoKotestKotestLibraryAccessors = new IoKotestKotestLibraryAccessors(owner);

        public IoKotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.kotest.extensions
         */
        public IoKotestExtensionsLibraryAccessors getExtensions() {
            return laccForIoKotestExtensionsLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.kotest.kotest
         */
        public IoKotestKotestLibraryAccessors getKotest() {
            return laccForIoKotestKotestLibraryAccessors;
        }

    }

    public static class IoKotestExtensionsLibraryAccessors extends SubDependencyFactory {
        private final IoKotestExtensionsKotestLibraryAccessors laccForIoKotestExtensionsKotestLibraryAccessors = new IoKotestExtensionsKotestLibraryAccessors(owner);

        public IoKotestExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.kotest.extensions.kotest
         */
        public IoKotestExtensionsKotestLibraryAccessors getKotest() {
            return laccForIoKotestExtensionsKotestLibraryAccessors;
        }

    }

    public static class IoKotestExtensionsKotestLibraryAccessors extends SubDependencyFactory {
        private final IoKotestExtensionsKotestExtensionsLibraryAccessors laccForIoKotestExtensionsKotestExtensionsLibraryAccessors = new IoKotestExtensionsKotestExtensionsLibraryAccessors(owner);

        public IoKotestExtensionsKotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.kotest.extensions.kotest.extensions
         */
        public IoKotestExtensionsKotestExtensionsLibraryAccessors getExtensions() {
            return laccForIoKotestExtensionsKotestExtensionsLibraryAccessors;
        }

    }

    public static class IoKotestExtensionsKotestExtensionsLibraryAccessors extends SubDependencyFactory {

        public IoKotestExtensionsKotestExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for spring (io.kotest.extensions:kotest-extensions-spring)
         * with versionRef 'kotest.extensions.spring'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSpring() {
                return create("io.kotest.extensions.kotest.extensions.spring");
        }

            /**
             * Creates a dependency provider for testcontainers (io.kotest.extensions:kotest-extensions-testcontainers)
         * with versionRef 'kotest.extensions.testcontainers'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTestcontainers() {
                return create("io.kotest.extensions.kotest.extensions.testcontainers");
        }

    }

    public static class IoKotestKotestLibraryAccessors extends SubDependencyFactory {
        private final IoKotestKotestAssertionsLibraryAccessors laccForIoKotestKotestAssertionsLibraryAccessors = new IoKotestKotestAssertionsLibraryAccessors(owner);
        private final IoKotestKotestRunnerLibraryAccessors laccForIoKotestKotestRunnerLibraryAccessors = new IoKotestKotestRunnerLibraryAccessors(owner);

        public IoKotestKotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for property (io.kotest:kotest-property)
         * with versionRef 'io.kotest'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getProperty() {
                return create("io.kotest.kotest.property");
        }

        /**
         * Returns the group of libraries at io.kotest.kotest.assertions
         */
        public IoKotestKotestAssertionsLibraryAccessors getAssertions() {
            return laccForIoKotestKotestAssertionsLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.kotest.kotest.runner
         */
        public IoKotestKotestRunnerLibraryAccessors getRunner() {
            return laccForIoKotestKotestRunnerLibraryAccessors;
        }

    }

    public static class IoKotestKotestAssertionsLibraryAccessors extends SubDependencyFactory {

        public IoKotestKotestAssertionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (io.kotest:kotest-assertions-core)
         * with versionRef 'io.kotest'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("io.kotest.kotest.assertions.core");
        }

    }

    public static class IoKotestKotestRunnerLibraryAccessors extends SubDependencyFactory {

        public IoKotestKotestRunnerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit5 (io.kotest:kotest-runner-junit5)
         * with versionRef 'io.kotest'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit5() {
                return create("io.kotest.kotest.runner.junit5");
        }

    }

    public static class IoMcarleLibraryAccessors extends SubDependencyFactory {
        private final IoMcarleKonvertLibraryAccessors laccForIoMcarleKonvertLibraryAccessors = new IoMcarleKonvertLibraryAccessors(owner);

        public IoMcarleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.mcarle.konvert
         */
        public IoMcarleKonvertLibraryAccessors getKonvert() {
            return laccForIoMcarleKonvertLibraryAccessors;
        }

    }

    public static class IoMcarleKonvertLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public IoMcarleKonvertLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for konvert (io.mcarle:konvert)
         * with versionRef 'io.mcarle.konvert.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("io.mcarle.konvert");
        }

            /**
             * Creates a dependency provider for api (io.mcarle:konvert-api)
         * with versionRef 'io.mcarle.konvert.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("io.mcarle.konvert.api");
        }

    }

    public static class IoMongockLibraryAccessors extends SubDependencyFactory {
        private final IoMongockMongockLibraryAccessors laccForIoMongockMongockLibraryAccessors = new IoMongockMongockLibraryAccessors(owner);
        private final IoMongockMongodbLibraryAccessors laccForIoMongockMongodbLibraryAccessors = new IoMongockMongodbLibraryAccessors(owner);

        public IoMongockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.mongock.mongock
         */
        public IoMongockMongockLibraryAccessors getMongock() {
            return laccForIoMongockMongockLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.mongock.mongodb
         */
        public IoMongockMongodbLibraryAccessors getMongodb() {
            return laccForIoMongockMongodbLibraryAccessors;
        }

    }

    public static class IoMongockMongockLibraryAccessors extends SubDependencyFactory {

        public IoMongockMongockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for bom (io.mongock:mongock-bom)
         * with versionRef 'io.mongock.mongock'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBom() {
                return create("io.mongock.mongock.bom");
        }

            /**
             * Creates a dependency provider for springboot (io.mongock:mongock-springboot)
         * with versionRef 'io.mongock.mongock'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSpringboot() {
                return create("io.mongock.mongock.springboot");
        }

    }

    public static class IoMongockMongodbLibraryAccessors extends SubDependencyFactory {
        private final IoMongockMongodbReactiveLibraryAccessors laccForIoMongockMongodbReactiveLibraryAccessors = new IoMongockMongodbReactiveLibraryAccessors(owner);

        public IoMongockMongodbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.mongock.mongodb.reactive
         */
        public IoMongockMongodbReactiveLibraryAccessors getReactive() {
            return laccForIoMongockMongodbReactiveLibraryAccessors;
        }

    }

    public static class IoMongockMongodbReactiveLibraryAccessors extends SubDependencyFactory {

        public IoMongockMongodbReactiveLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for driver (io.mongock:mongodb-reactive-driver)
         * with versionRef 'io.mongock.mongock'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDriver() {
                return create("io.mongock.mongodb.reactive.driver");
        }

    }

    public static class IoProjectreactorLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKafkaLibraryAccessors laccForIoProjectreactorKafkaLibraryAccessors = new IoProjectreactorKafkaLibraryAccessors(owner);
        private final IoProjectreactorKotlinLibraryAccessors laccForIoProjectreactorKotlinLibraryAccessors = new IoProjectreactorKotlinLibraryAccessors(owner);
        private final IoProjectreactorReactorLibraryAccessors laccForIoProjectreactorReactorLibraryAccessors = new IoProjectreactorReactorLibraryAccessors(owner);

        public IoProjectreactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.projectreactor.kafka
         */
        public IoProjectreactorKafkaLibraryAccessors getKafka() {
            return laccForIoProjectreactorKafkaLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.projectreactor.kotlin
         */
        public IoProjectreactorKotlinLibraryAccessors getKotlin() {
            return laccForIoProjectreactorKotlinLibraryAccessors;
        }

        /**
         * Returns the group of libraries at io.projectreactor.reactor
         */
        public IoProjectreactorReactorLibraryAccessors getReactor() {
            return laccForIoProjectreactorReactorLibraryAccessors;
        }

    }

    public static class IoProjectreactorKafkaLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKafkaReactorLibraryAccessors laccForIoProjectreactorKafkaReactorLibraryAccessors = new IoProjectreactorKafkaReactorLibraryAccessors(owner);

        public IoProjectreactorKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.projectreactor.kafka.reactor
         */
        public IoProjectreactorKafkaReactorLibraryAccessors getReactor() {
            return laccForIoProjectreactorKafkaReactorLibraryAccessors;
        }

    }

    public static class IoProjectreactorKafkaReactorLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorKafkaReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for kafka (io.projectreactor.kafka:reactor-kafka)
         * with versionRef 'reactor.kafka'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKafka() {
                return create("io.projectreactor.kafka.reactor.kafka");
        }

    }

    public static class IoProjectreactorKotlinLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKotlinReactorLibraryAccessors laccForIoProjectreactorKotlinReactorLibraryAccessors = new IoProjectreactorKotlinReactorLibraryAccessors(owner);

        public IoProjectreactorKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.projectreactor.kotlin.reactor
         */
        public IoProjectreactorKotlinReactorLibraryAccessors getReactor() {
            return laccForIoProjectreactorKotlinReactorLibraryAccessors;
        }

    }

    public static class IoProjectreactorKotlinReactorLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKotlinReactorKotlinLibraryAccessors laccForIoProjectreactorKotlinReactorKotlinLibraryAccessors = new IoProjectreactorKotlinReactorKotlinLibraryAccessors(owner);

        public IoProjectreactorKotlinReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at io.projectreactor.kotlin.reactor.kotlin
         */
        public IoProjectreactorKotlinReactorKotlinLibraryAccessors getKotlin() {
            return laccForIoProjectreactorKotlinReactorKotlinLibraryAccessors;
        }

    }

    public static class IoProjectreactorKotlinReactorKotlinLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorKotlinReactorKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for extensions (io.projectreactor.kotlin:reactor-kotlin-extensions)
         * with versionRef 'reactor.kotlin.extensions'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExtensions() {
                return create("io.projectreactor.kotlin.reactor.kotlin.extensions");
        }

    }

    public static class IoProjectreactorReactorLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for test (io.projectreactor:reactor-test)
         * with versionRef 'reactor.test'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("io.projectreactor.reactor.test");
        }

    }

    public static class JakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaValidationLibraryAccessors laccForJakartaValidationLibraryAccessors = new JakartaValidationLibraryAccessors(owner);

        public JakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at jakarta.validation
         */
        public JakartaValidationLibraryAccessors getValidation() {
            return laccForJakartaValidationLibraryAccessors;
        }

    }

    public static class JakartaValidationLibraryAccessors extends SubDependencyFactory {

        public JakartaValidationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (jakarta.validation:jakarta.validation-api)
         * with versionRef 'jakarta.validation.api'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() {
                return create("jakarta.validation.api");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgAxonLibraryAccessors laccForOrgAxonLibraryAccessors = new OrgAxonLibraryAccessors(owner);
        private final OrgJetbrainsLibraryAccessors laccForOrgJetbrainsLibraryAccessors = new OrgJetbrainsLibraryAccessors(owner);
        private final OrgMockitoLibraryAccessors laccForOrgMockitoLibraryAccessors = new OrgMockitoLibraryAccessors(owner);
        private final OrgSpringdocLibraryAccessors laccForOrgSpringdocLibraryAccessors = new OrgSpringdocLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);
        private final OrgTestcontainersLibraryAccessors laccForOrgTestcontainersLibraryAccessors = new OrgTestcontainersLibraryAccessors(owner);
        private final OrgYamlLibraryAccessors laccForOrgYamlLibraryAccessors = new OrgYamlLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.axon
         */
        public OrgAxonLibraryAccessors getAxon() {
            return laccForOrgAxonLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.jetbrains
         */
        public OrgJetbrainsLibraryAccessors getJetbrains() {
            return laccForOrgJetbrainsLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.mockito
         */
        public OrgMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springdoc
         */
        public OrgSpringdocLibraryAccessors getSpringdoc() {
            return laccForOrgSpringdocLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.testcontainers
         */
        public OrgTestcontainersLibraryAccessors getTestcontainers() {
            return laccForOrgTestcontainersLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.yaml
         */
        public OrgYamlLibraryAccessors getYaml() {
            return laccForOrgYamlLibraryAccessors;
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLibraryAccessors laccForOrgApacheLoggingLibraryAccessors = new OrgApacheLoggingLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.logging
         */
        public OrgApacheLoggingLibraryAccessors getLogging() {
            return laccForOrgApacheLoggingLibraryAccessors;
        }

    }

    public static class OrgApacheLoggingLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLibraryAccessors = new OrgApacheLoggingLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.logging.log4j
         */
        public OrgApacheLoggingLog4jLibraryAccessors getLog4j() {
            return laccForOrgApacheLoggingLog4jLibraryAccessors;
        }

    }

    public static class OrgApacheLoggingLog4jLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLog4jLibraryAccessors = new OrgApacheLoggingLog4jLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.apache.logging.log4j.log4j
         */
        public OrgApacheLoggingLog4jLog4jLibraryAccessors getLog4j() {
            return laccForOrgApacheLoggingLog4jLog4jLibraryAccessors;
        }

    }

    public static class OrgApacheLoggingLog4jLog4jLibraryAccessors extends SubDependencyFactory {

        public OrgApacheLoggingLog4jLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.apache.logging.log4j:log4j-core)
         * with versionRef 'log4j.core'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() {
                return create("org.apache.logging.log4j.log4j.core");
        }

    }

    public static class OrgAxonLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsLibraryAccessors laccForOrgAxonExtensionsLibraryAccessors = new OrgAxonExtensionsLibraryAccessors(owner);

        public OrgAxonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.axon.extensions
         */
        public OrgAxonExtensionsLibraryAccessors getExtensions() {
            return laccForOrgAxonExtensionsLibraryAccessors;
        }

    }

    public static class OrgAxonExtensionsLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorLibraryAccessors laccForOrgAxonExtensionsReactorLibraryAccessors = new OrgAxonExtensionsReactorLibraryAccessors(owner);

        public OrgAxonExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for mongo (org.axonframework.extensions.mongo:axon-mongo)
         * with versionRef 'axon.extensions.spring.aot'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMongo() {
                return create("org.axon.extensions.mongo");
        }

        /**
         * Returns the group of libraries at org.axon.extensions.reactor
         */
        public OrgAxonExtensionsReactorLibraryAccessors getReactor() {
            return laccForOrgAxonExtensionsReactorLibraryAccessors;
        }

    }

    public static class OrgAxonExtensionsReactorLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorSpringLibraryAccessors laccForOrgAxonExtensionsReactorSpringLibraryAccessors = new OrgAxonExtensionsReactorSpringLibraryAccessors(owner);

        public OrgAxonExtensionsReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.axon.extensions.reactor.spring
         */
        public OrgAxonExtensionsReactorSpringLibraryAccessors getSpring() {
            return laccForOrgAxonExtensionsReactorSpringLibraryAccessors;
        }

    }

    public static class OrgAxonExtensionsReactorSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorSpringBootLibraryAccessors laccForOrgAxonExtensionsReactorSpringBootLibraryAccessors = new OrgAxonExtensionsReactorSpringBootLibraryAccessors(owner);

        public OrgAxonExtensionsReactorSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.axon.extensions.reactor.spring.boot
         */
        public OrgAxonExtensionsReactorSpringBootLibraryAccessors getBoot() {
            return laccForOrgAxonExtensionsReactorSpringBootLibraryAccessors;
        }

    }

    public static class OrgAxonExtensionsReactorSpringBootLibraryAccessors extends SubDependencyFactory {

        public OrgAxonExtensionsReactorSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for starter (org.axonframework.extensions.reactor:axon-reactor-spring-boot-starter)
         * with versionRef 'axon.extensions.reactor'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStarter() {
                return create("org.axon.extensions.reactor.spring.boot.starter");
        }

    }

    public static class OrgJetbrainsLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinLibraryAccessors laccForOrgJetbrainsKotlinLibraryAccessors = new OrgJetbrainsKotlinLibraryAccessors(owner);

        public OrgJetbrainsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for annotations (org.jetbrains:annotations)
         * with versionRef 'org.jetbrains.annotations'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAnnotations() {
                return create("org.jetbrains.annotations");
        }

        /**
         * Returns the group of libraries at org.jetbrains.kotlin
         */
        public OrgJetbrainsKotlinLibraryAccessors getKotlin() {
            return laccForOrgJetbrainsKotlinLibraryAccessors;
        }

    }

    public static class OrgJetbrainsKotlinLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinKotlinLibraryAccessors laccForOrgJetbrainsKotlinKotlinLibraryAccessors = new OrgJetbrainsKotlinKotlinLibraryAccessors(owner);

        public OrgJetbrainsKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.jetbrains.kotlin.kotlin
         */
        public OrgJetbrainsKotlinKotlinLibraryAccessors getKotlin() {
            return laccForOrgJetbrainsKotlinKotlinLibraryAccessors;
        }

    }

    public static class OrgJetbrainsKotlinKotlinLibraryAccessors extends SubDependencyFactory {

        public OrgJetbrainsKotlinKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for reflect (org.jetbrains.kotlin:kotlin-reflect)
         * with version '1.9.22'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getReflect() {
                return create("org.jetbrains.kotlin.kotlin.reflect");
        }

    }

    public static class OrgMockitoLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoKotlinLibraryAccessors laccForOrgMockitoKotlinLibraryAccessors = new OrgMockitoKotlinLibraryAccessors(owner);

        public OrgMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mockito.kotlin
         */
        public OrgMockitoKotlinLibraryAccessors getKotlin() {
            return laccForOrgMockitoKotlinLibraryAccessors;
        }

    }

    public static class OrgMockitoKotlinLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoKotlinMockitoLibraryAccessors laccForOrgMockitoKotlinMockitoLibraryAccessors = new OrgMockitoKotlinMockitoLibraryAccessors(owner);

        public OrgMockitoKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.mockito.kotlin.mockito
         */
        public OrgMockitoKotlinMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoKotlinMockitoLibraryAccessors;
        }

    }

    public static class OrgMockitoKotlinMockitoLibraryAccessors extends SubDependencyFactory {

        public OrgMockitoKotlinMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for kotlin (org.mockito.kotlin:mockito-kotlin)
         * with versionRef 'mockito.kotlin'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKotlin() {
                return create("org.mockito.kotlin.mockito.kotlin");
        }

    }

    public static class OrgSpringdocLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocOpenapiLibraryAccessors laccForOrgSpringdocOpenapiLibraryAccessors = new OrgSpringdocOpenapiLibraryAccessors(owner);

        public OrgSpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.openapi
         */
        public OrgSpringdocOpenapiLibraryAccessors getOpenapi() {
            return laccForOrgSpringdocOpenapiLibraryAccessors;
        }

    }

    public static class OrgSpringdocOpenapiLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocOpenapiStarterLibraryAccessors laccForOrgSpringdocOpenapiStarterLibraryAccessors = new OrgSpringdocOpenapiStarterLibraryAccessors(owner);

        public OrgSpringdocOpenapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springdoc.openapi.starter
         */
        public OrgSpringdocOpenapiStarterLibraryAccessors getStarter() {
            return laccForOrgSpringdocOpenapiStarterLibraryAccessors;
        }

    }

    public static class OrgSpringdocOpenapiStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocOpenapiStarterWebfluxLibraryAccessors laccForOrgSpringdocOpenapiStarterWebfluxLibraryAccessors = new OrgSpringdocOpenapiStarterWebfluxLibraryAccessors(owner);

        public OrgSpringdocOpenapiStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for common (org.springdoc:springdoc-openapi-starter-common)
         * with versionRef 'org.springdoc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCommon() {
                return create("org.springdoc.openapi.starter.common");
        }

        /**
         * Returns the group of libraries at org.springdoc.openapi.starter.webflux
         */
        public OrgSpringdocOpenapiStarterWebfluxLibraryAccessors getWebflux() {
            return laccForOrgSpringdocOpenapiStarterWebfluxLibraryAccessors;
        }

    }

    public static class OrgSpringdocOpenapiStarterWebfluxLibraryAccessors extends SubDependencyFactory {

        public OrgSpringdocOpenapiStarterWebfluxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ui (org.springdoc:springdoc-openapi-starter-webflux-ui)
         * with versionRef 'org.springdoc'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() {
                return create("org.springdoc.openapi.starter.webflux.ui");
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for hateoas (org.springframework.hateoas:spring-hateoas)
         * with versionRef 'org.springframework.hateoas'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getHateoas() {
                return create("org.springframework.hateoas");
        }

        /**
         * Returns the group of libraries at org.springframework.boot
         */
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring
         */
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot
         */
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootDockerLibraryAccessors laccForOrgSpringframeworkBootSpringBootDockerLibraryAccessors = new OrgSpringframeworkBootSpringBootDockerLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for dependencies (org.springframework.boot:spring-boot-dependencies)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDependencies() {
                return create("org.springframework.boot.spring.boot.dependencies");
        }

            /**
             * Creates a dependency provider for testcontainers (org.springframework.boot:spring-boot-testcontainers)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTestcontainers() {
                return create("org.springframework.boot.spring.boot.testcontainers");
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.docker
         */
        public OrgSpringframeworkBootSpringBootDockerLibraryAccessors getDocker() {
            return laccForOrgSpringframeworkBootSpringBootDockerLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter
         */
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootDockerLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootDockerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for compose (org.springframework.boot:spring-boot-docker-compose)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompose() {
                return create("org.springframework.boot.spring.boot.docker.compose");
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for actuator (org.springframework.boot:spring-boot-starter-actuator)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getActuator() {
                return create("org.springframework.boot.spring.boot.starter.actuator");
        }

            /**
             * Creates a dependency provider for security (org.springframework.boot:spring-boot-starter-security)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSecurity() {
                return create("org.springframework.boot.spring.boot.starter.security");
        }

            /**
             * Creates a dependency provider for test (org.springframework.boot:spring-boot-starter-test)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() {
                return create("org.springframework.boot.spring.boot.starter.test");
        }

            /**
             * Creates a dependency provider for validation (org.springframework.boot:spring-boot-starter-validation)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getValidation() {
                return create("org.springframework.boot.spring.boot.starter.validation");
        }

            /**
             * Creates a dependency provider for webflux (org.springframework.boot:spring-boot-starter-webflux)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getWebflux() {
                return create("org.springframework.boot.spring.boot.starter.webflux");
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter.data
         */
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter.oauth2
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors getOauth2() {
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter.data.mongodb
         */
        public OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors getMongodb() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for reactive (org.springframework.boot:spring-boot-starter-data-mongodb-reactive)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getReactive() {
                return create("org.springframework.boot.spring.boot.starter.data.mongodb.reactive");
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at org.springframework.boot.spring.boot.starter.oauth2.resource
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors getResource() {
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for server (org.springframework.boot:spring-boot-starter-oauth2-resource-server)
         * with no version specified
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getServer() {
                return create("org.springframework.boot.spring.boot.starter.oauth2.resource.server");
        }

    }

    public static class OrgTestcontainersLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final OrgTestcontainersJunitLibraryAccessors laccForOrgTestcontainersJunitLibraryAccessors = new OrgTestcontainersJunitLibraryAccessors(owner);

        public OrgTestcontainersLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for testcontainers (org.testcontainers:testcontainers)
         * with versionRef 'org.testcontainers'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() {
                return create("org.testcontainers");
        }

            /**
             * Creates a dependency provider for kafka (org.testcontainers:kafka)
         * with versionRef 'org.testcontainers'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKafka() {
                return create("org.testcontainers.kafka");
        }

            /**
             * Creates a dependency provider for mongodb (org.testcontainers:mongodb)
         * with versionRef 'org.testcontainers'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMongodb() {
                return create("org.testcontainers.mongodb");
        }

        /**
         * Returns the group of libraries at org.testcontainers.junit
         */
        public OrgTestcontainersJunitLibraryAccessors getJunit() {
            return laccForOrgTestcontainersJunitLibraryAccessors;
        }

    }

    public static class OrgTestcontainersJunitLibraryAccessors extends SubDependencyFactory {

        public OrgTestcontainersJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for jupiter (org.testcontainers:junit-jupiter)
         * with versionRef 'org.testcontainers'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJupiter() {
                return create("org.testcontainers.junit.jupiter");
        }

    }

    public static class OrgYamlLibraryAccessors extends SubDependencyFactory {

        public OrgYamlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for snakeyaml (org.yaml:snakeyaml)
         * with versionRef 'snakeyaml'.
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSnakeyaml() {
                return create("org.yaml.snakeyaml");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AxonVersionAccessors vaccForAxonVersionAccessors = new AxonVersionAccessors(providers, config);
        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final IoVersionAccessors vaccForIoVersionAccessors = new IoVersionAccessors(providers, config);
        private final JacksonVersionAccessors vaccForJacksonVersionAccessors = new JacksonVersionAccessors(providers, config);
        private final JakartaVersionAccessors vaccForJakartaVersionAccessors = new JakartaVersionAccessors(providers, config);
        private final KotestVersionAccessors vaccForKotestVersionAccessors = new KotestVersionAccessors(providers, config);
        private final KotlinVersionAccessors vaccForKotlinVersionAccessors = new KotlinVersionAccessors(providers, config);
        private final Log4jVersionAccessors vaccForLog4jVersionAccessors = new Log4jVersionAccessors(providers, config);
        private final MockitoVersionAccessors vaccForMockitoVersionAccessors = new MockitoVersionAccessors(providers, config);
        private final NlVersionAccessors vaccForNlVersionAccessors = new NlVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        private final ReactorVersionAccessors vaccForReactorVersionAccessors = new ReactorVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: snakeyaml (2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSnakeyaml() { return getVersion("snakeyaml"); }

        /**
         * Returns the group of versions at versions.axon
         */
        public AxonVersionAccessors getAxon() {
            return vaccForAxonVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.io
         */
        public IoVersionAccessors getIo() {
            return vaccForIoVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.jackson
         */
        public JacksonVersionAccessors getJackson() {
            return vaccForJacksonVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.jakarta
         */
        public JakartaVersionAccessors getJakarta() {
            return vaccForJakartaVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.kotest
         */
        public KotestVersionAccessors getKotest() {
            return vaccForKotestVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.kotlin
         */
        public KotlinVersionAccessors getKotlin() {
            return vaccForKotlinVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.log4j
         */
        public Log4jVersionAccessors getLog4j() {
            return vaccForLog4jVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.mockito
         */
        public MockitoVersionAccessors getMockito() {
            return vaccForMockitoVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.nl
         */
        public NlVersionAccessors getNl() {
            return vaccForNlVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.reactor
         */
        public ReactorVersionAccessors getReactor() {
            return vaccForReactorVersionAccessors;
        }

    }

    public static class AxonVersionAccessors extends VersionFactory  {

        private final AxonExtensionsVersionAccessors vaccForAxonExtensionsVersionAccessors = new AxonExtensionsVersionAccessors(providers, config);
        public AxonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.axon.extensions
         */
        public AxonExtensionsVersionAccessors getExtensions() {
            return vaccForAxonExtensionsVersionAccessors;
        }

    }

    public static class AxonExtensionsVersionAccessors extends VersionFactory  {

        private final AxonExtensionsSpringVersionAccessors vaccForAxonExtensionsSpringVersionAccessors = new AxonExtensionsSpringVersionAccessors(providers, config);
        public AxonExtensionsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: axon.extensions.reactor (4.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getReactor() { return getVersion("axon.extensions.reactor"); }

        /**
         * Returns the group of versions at versions.axon.extensions.spring
         */
        public AxonExtensionsSpringVersionAccessors getSpring() {
            return vaccForAxonExtensionsSpringVersionAccessors;
        }

    }

    public static class AxonExtensionsSpringVersionAccessors extends VersionFactory  {

        public AxonExtensionsSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: axon.extensions.spring.aot (4.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAot() { return getVersion("axon.extensions.spring.aot"); }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComGithubVersionAccessors vaccForComGithubVersionAccessors = new ComGithubVersionAccessors(providers, config);
        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        private final ComTngtechVersionAccessors vaccForComTngtechVersionAccessors = new ComTngtechVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github
         */
        public ComGithubVersionAccessors getGithub() {
            return vaccForComGithubVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.google
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.tngtech
         */
        public ComTngtechVersionAccessors getTngtech() {
            return vaccForComTngtechVersionAccessors;
        }

    }

    public static class ComGithubVersionAccessors extends VersionFactory  {

        private final ComGithubAvroVersionAccessors vaccForComGithubAvroVersionAccessors = new ComGithubAvroVersionAccessors(providers, config);
        private final ComGithubBenVersionAccessors vaccForComGithubBenVersionAccessors = new ComGithubBenVersionAccessors(providers, config);
        public ComGithubVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github.avro
         */
        public ComGithubAvroVersionAccessors getAvro() {
            return vaccForComGithubAvroVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.com.github.ben
         */
        public ComGithubBenVersionAccessors getBen() {
            return vaccForComGithubBenVersionAccessors;
        }

    }

    public static class ComGithubAvroVersionAccessors extends VersionFactory  {

        private final ComGithubAvroKotlinVersionAccessors vaccForComGithubAvroKotlinVersionAccessors = new ComGithubAvroKotlinVersionAccessors(providers, config);
        public ComGithubAvroVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github.avro.kotlin
         */
        public ComGithubAvroKotlinVersionAccessors getKotlin() {
            return vaccForComGithubAvroKotlinVersionAccessors;
        }

    }

    public static class ComGithubAvroKotlinVersionAccessors extends VersionFactory  {

        private final ComGithubAvroKotlinAvro4kVersionAccessors vaccForComGithubAvroKotlinAvro4kVersionAccessors = new ComGithubAvroKotlinAvro4kVersionAccessors(providers, config);
        public ComGithubAvroKotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github.avro.kotlin.avro4k
         */
        public ComGithubAvroKotlinAvro4kVersionAccessors getAvro4k() {
            return vaccForComGithubAvroKotlinAvro4kVersionAccessors;
        }

    }

    public static class ComGithubAvroKotlinAvro4kVersionAccessors extends VersionFactory  {

        public ComGithubAvroKotlinAvro4kVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.github.avro.kotlin.avro4k.core (1.10.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("com.github.avro.kotlin.avro4k.core"); }

    }

    public static class ComGithubBenVersionAccessors extends VersionFactory  {

        private final ComGithubBenManesVersionAccessors vaccForComGithubBenManesVersionAccessors = new ComGithubBenManesVersionAccessors(providers, config);
        public ComGithubBenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.github.ben.manes
         */
        public ComGithubBenManesVersionAccessors getManes() {
            return vaccForComGithubBenManesVersionAccessors;
        }

    }

    public static class ComGithubBenManesVersionAccessors extends VersionFactory  {

        public ComGithubBenManesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.github.ben.manes.versions (0.51.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getVersions() { return getVersion("com.github.ben.manes.versions"); }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleDevtoolsVersionAccessors vaccForComGoogleDevtoolsVersionAccessors = new ComGoogleDevtoolsVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.com.google.devtools
         */
        public ComGoogleDevtoolsVersionAccessors getDevtools() {
            return vaccForComGoogleDevtoolsVersionAccessors;
        }

    }

    public static class ComGoogleDevtoolsVersionAccessors extends VersionFactory  {

        public ComGoogleDevtoolsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.google.devtools.ksp (1.9.22-1.0.17)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKsp() { return getVersion("com.google.devtools.ksp"); }

    }

    public static class ComTngtechVersionAccessors extends VersionFactory  {

        public ComTngtechVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: com.tngtech.archunit (1.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getArchunit() { return getVersion("com.tngtech.archunit"); }

    }

    public static class IoVersionAccessors extends VersionFactory  {

        private final IoFreefairVersionAccessors vaccForIoFreefairVersionAccessors = new IoFreefairVersionAccessors(providers, config);
        private final IoHolixonVersionAccessors vaccForIoHolixonVersionAccessors = new IoHolixonVersionAccessors(providers, config);
        private final IoMcarleVersionAccessors vaccForIoMcarleVersionAccessors = new IoMcarleVersionAccessors(providers, config);
        private final IoMongockVersionAccessors vaccForIoMongockVersionAccessors = new IoMongockVersionAccessors(providers, config);
        private final IoSpringVersionAccessors vaccForIoSpringVersionAccessors = new IoSpringVersionAccessors(providers, config);
        public IoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.kotest (5.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotest() { return getVersion("io.kotest"); }

        /**
         * Returns the group of versions at versions.io.freefair
         */
        public IoFreefairVersionAccessors getFreefair() {
            return vaccForIoFreefairVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.io.holixon
         */
        public IoHolixonVersionAccessors getHolixon() {
            return vaccForIoHolixonVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.io.mcarle
         */
        public IoMcarleVersionAccessors getMcarle() {
            return vaccForIoMcarleVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.io.mongock
         */
        public IoMongockVersionAccessors getMongock() {
            return vaccForIoMongockVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.io.spring
         */
        public IoSpringVersionAccessors getSpring() {
            return vaccForIoSpringVersionAccessors;
        }

    }

    public static class IoFreefairVersionAccessors extends VersionFactory  {

        private final IoFreefairAspectjVersionAccessors vaccForIoFreefairAspectjVersionAccessors = new IoFreefairAspectjVersionAccessors(providers, config);
        public IoFreefairVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.freefair.aspectj
         */
        public IoFreefairAspectjVersionAccessors getAspectj() {
            return vaccForIoFreefairAspectjVersionAccessors;
        }

    }

    public static class IoFreefairAspectjVersionAccessors extends VersionFactory  {

        private final IoFreefairAspectjPostVersionAccessors vaccForIoFreefairAspectjPostVersionAccessors = new IoFreefairAspectjPostVersionAccessors(providers, config);
        public IoFreefairAspectjVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.freefair.aspectj.post
         */
        public IoFreefairAspectjPostVersionAccessors getPost() {
            return vaccForIoFreefairAspectjPostVersionAccessors;
        }

    }

    public static class IoFreefairAspectjPostVersionAccessors extends VersionFactory  {

        private final IoFreefairAspectjPostCompileVersionAccessors vaccForIoFreefairAspectjPostCompileVersionAccessors = new IoFreefairAspectjPostCompileVersionAccessors(providers, config);
        public IoFreefairAspectjPostVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.freefair.aspectj.post.compile
         */
        public IoFreefairAspectjPostCompileVersionAccessors getCompile() {
            return vaccForIoFreefairAspectjPostCompileVersionAccessors;
        }

    }

    public static class IoFreefairAspectjPostCompileVersionAccessors extends VersionFactory  {

        public IoFreefairAspectjPostCompileVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.freefair.aspectj.post.compile.weaving (8.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWeaving() { return getVersion("io.freefair.aspectj.post.compile.weaving"); }

    }

    public static class IoHolixonVersionAccessors extends VersionFactory  {

        private final IoHolixonAxonVersionAccessors vaccForIoHolixonAxonVersionAccessors = new IoHolixonAxonVersionAccessors(providers, config);
        public IoHolixonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.holixon.axon
         */
        public IoHolixonAxonVersionAccessors getAxon() {
            return vaccForIoHolixonAxonVersionAccessors;
        }

    }

    public static class IoHolixonAxonVersionAccessors extends VersionFactory  {

        private final IoHolixonAxonAvroVersionAccessors vaccForIoHolixonAxonAvroVersionAccessors = new IoHolixonAxonAvroVersionAccessors(providers, config);
        public IoHolixonAxonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.holixon.axon.avro
         */
        public IoHolixonAxonAvroVersionAccessors getAvro() {
            return vaccForIoHolixonAxonAvroVersionAccessors;
        }

    }

    public static class IoHolixonAxonAvroVersionAccessors extends VersionFactory  {

        private final IoHolixonAxonAvroSerializerVersionAccessors vaccForIoHolixonAxonAvroSerializerVersionAccessors = new IoHolixonAxonAvroSerializerVersionAccessors(providers, config);
        public IoHolixonAxonAvroVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.holixon.axon.avro.serializer
         */
        public IoHolixonAxonAvroSerializerVersionAccessors getSerializer() {
            return vaccForIoHolixonAxonAvroSerializerVersionAccessors;
        }

    }

    public static class IoHolixonAxonAvroSerializerVersionAccessors extends VersionFactory  {

        public IoHolixonAxonAvroSerializerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.holixon.axon.avro.serializer.spring (0.0.6)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpring() { return getVersion("io.holixon.axon.avro.serializer.spring"); }

    }

    public static class IoMcarleVersionAccessors extends VersionFactory  {

        private final IoMcarleKonvertVersionAccessors vaccForIoMcarleKonvertVersionAccessors = new IoMcarleKonvertVersionAccessors(providers, config);
        public IoMcarleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.mcarle.konvert
         */
        public IoMcarleKonvertVersionAccessors getKonvert() {
            return vaccForIoMcarleKonvertVersionAccessors;
        }

    }

    public static class IoMcarleKonvertVersionAccessors extends VersionFactory  {

        public IoMcarleKonvertVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.mcarle.konvert.api (3.0.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("io.mcarle.konvert.api"); }

    }

    public static class IoMongockVersionAccessors extends VersionFactory  {

        public IoMongockVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.mongock.mongock (5.4.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMongock() { return getVersion("io.mongock.mongock"); }

    }

    public static class IoSpringVersionAccessors extends VersionFactory  {

        private final IoSpringDependencyVersionAccessors vaccForIoSpringDependencyVersionAccessors = new IoSpringDependencyVersionAccessors(providers, config);
        public IoSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.io.spring.dependency
         */
        public IoSpringDependencyVersionAccessors getDependency() {
            return vaccForIoSpringDependencyVersionAccessors;
        }

    }

    public static class IoSpringDependencyVersionAccessors extends VersionFactory  {

        public IoSpringDependencyVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: io.spring.dependency.management (1.1.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getManagement() { return getVersion("io.spring.dependency.management"); }

    }

    public static class JacksonVersionAccessors extends VersionFactory  {

        private final JacksonModuleVersionAccessors vaccForJacksonModuleVersionAccessors = new JacksonModuleVersionAccessors(providers, config);
        public JacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.jackson.module
         */
        public JacksonModuleVersionAccessors getModule() {
            return vaccForJacksonModuleVersionAccessors;
        }

    }

    public static class JacksonModuleVersionAccessors extends VersionFactory  {

        public JacksonModuleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: jackson.module.kotlin (2.16.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("jackson.module.kotlin"); }

    }

    public static class JakartaVersionAccessors extends VersionFactory  {

        private final JakartaValidationVersionAccessors vaccForJakartaValidationVersionAccessors = new JakartaValidationVersionAccessors(providers, config);
        public JakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.jakarta.validation
         */
        public JakartaValidationVersionAccessors getValidation() {
            return vaccForJakartaValidationVersionAccessors;
        }

    }

    public static class JakartaValidationVersionAccessors extends VersionFactory  {

        public JakartaValidationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: jakarta.validation.api (3.0.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getApi() { return getVersion("jakarta.validation.api"); }

    }

    public static class KotestVersionAccessors extends VersionFactory  {

        private final KotestExtensionsVersionAccessors vaccForKotestExtensionsVersionAccessors = new KotestExtensionsVersionAccessors(providers, config);
        public KotestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.kotest.extensions
         */
        public KotestExtensionsVersionAccessors getExtensions() {
            return vaccForKotestExtensionsVersionAccessors;
        }

    }

    public static class KotestExtensionsVersionAccessors extends VersionFactory  {

        public KotestExtensionsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: kotest.extensions.spring (1.1.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpring() { return getVersion("kotest.extensions.spring"); }

            /**
             * Returns the version associated to this alias: kotest.extensions.testcontainers (2.0.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTestcontainers() { return getVersion("kotest.extensions.testcontainers"); }

    }

    public static class KotlinVersionAccessors extends VersionFactory  {

        private final KotlinLoggingVersionAccessors vaccForKotlinLoggingVersionAccessors = new KotlinLoggingVersionAccessors(providers, config);
        public KotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.kotlin.logging
         */
        public KotlinLoggingVersionAccessors getLogging() {
            return vaccForKotlinLoggingVersionAccessors;
        }

    }

    public static class KotlinLoggingVersionAccessors extends VersionFactory  {

        public KotlinLoggingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: kotlin.logging.jvm (6.0.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJvm() { return getVersion("kotlin.logging.jvm"); }

    }

    public static class Log4jVersionAccessors extends VersionFactory  {

        public Log4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: log4j.core (2.23.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCore() { return getVersion("log4j.core"); }

    }

    public static class MockitoVersionAccessors extends VersionFactory  {

        public MockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: mockito.kotlin (5.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("mockito.kotlin"); }

    }

    public static class NlVersionAccessors extends VersionFactory  {

        private final NlLittlerobotsVersionAccessors vaccForNlLittlerobotsVersionAccessors = new NlLittlerobotsVersionAccessors(providers, config);
        public NlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.nl.littlerobots
         */
        public NlLittlerobotsVersionAccessors getLittlerobots() {
            return vaccForNlLittlerobotsVersionAccessors;
        }

    }

    public static class NlLittlerobotsVersionAccessors extends VersionFactory  {

        private final NlLittlerobotsVersionVersionAccessors vaccForNlLittlerobotsVersionVersionAccessors = new NlLittlerobotsVersionVersionAccessors(providers, config);
        public NlLittlerobotsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.nl.littlerobots.version
         */
        public NlLittlerobotsVersionVersionAccessors getVersion() {
            return vaccForNlLittlerobotsVersionVersionAccessors;
        }

    }

    public static class NlLittlerobotsVersionVersionAccessors extends VersionFactory  {

        private final NlLittlerobotsVersionCatalogVersionAccessors vaccForNlLittlerobotsVersionCatalogVersionAccessors = new NlLittlerobotsVersionCatalogVersionAccessors(providers, config);
        public NlLittlerobotsVersionVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.nl.littlerobots.version.catalog
         */
        public NlLittlerobotsVersionCatalogVersionAccessors getCatalog() {
            return vaccForNlLittlerobotsVersionCatalogVersionAccessors;
        }

    }

    public static class NlLittlerobotsVersionCatalogVersionAccessors extends VersionFactory  {

        public NlLittlerobotsVersionCatalogVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: nl.littlerobots.version.catalog.update (0.8.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getUpdate() { return getVersion("nl.littlerobots.version.catalog.update"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgGraalvmVersionAccessors vaccForOrgGraalvmVersionAccessors = new OrgGraalvmVersionAccessors(providers, config);
        private final OrgJetbrainsVersionAccessors vaccForOrgJetbrainsVersionAccessors = new OrgJetbrainsVersionAccessors(providers, config);
        private final OrgJlleitschuhVersionAccessors vaccForOrgJlleitschuhVersionAccessors = new OrgJlleitschuhVersionAccessors(providers, config);
        private final OrgOpenapiVersionAccessors vaccForOrgOpenapiVersionAccessors = new OrgOpenapiVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springdoc (2.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSpringdoc() { return getVersion("org.springdoc"); }

            /**
             * Returns the version associated to this alias: org.testcontainers (1.19.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTestcontainers() { return getVersion("org.testcontainers"); }

        /**
         * Returns the group of versions at versions.org.graalvm
         */
        public OrgGraalvmVersionAccessors getGraalvm() {
            return vaccForOrgGraalvmVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.jetbrains
         */
        public OrgJetbrainsVersionAccessors getJetbrains() {
            return vaccForOrgJetbrainsVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.jlleitschuh
         */
        public OrgJlleitschuhVersionAccessors getJlleitschuh() {
            return vaccForOrgJlleitschuhVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.openapi
         */
        public OrgOpenapiVersionAccessors getOpenapi() {
            return vaccForOrgOpenapiVersionAccessors;
        }

        /**
         * Returns the group of versions at versions.org.springframework
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgGraalvmVersionAccessors extends VersionFactory  {

        private final OrgGraalvmBuildtoolsVersionAccessors vaccForOrgGraalvmBuildtoolsVersionAccessors = new OrgGraalvmBuildtoolsVersionAccessors(providers, config);
        public OrgGraalvmVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.graalvm.buildtools
         */
        public OrgGraalvmBuildtoolsVersionAccessors getBuildtools() {
            return vaccForOrgGraalvmBuildtoolsVersionAccessors;
        }

    }

    public static class OrgGraalvmBuildtoolsVersionAccessors extends VersionFactory  {

        public OrgGraalvmBuildtoolsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.graalvm.buildtools.native (0.10.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNative() { return getVersion("org.graalvm.buildtools.native"); }

    }

    public static class OrgJetbrainsVersionAccessors extends VersionFactory  {

        public OrgJetbrainsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.jetbrains.annotations (13.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAnnotations() { return getVersion("org.jetbrains.annotations"); }

            /**
             * Returns the version associated to this alias: org.jetbrains.kotlin (1.9.22)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("org.jetbrains.kotlin"); }

    }

    public static class OrgJlleitschuhVersionAccessors extends VersionFactory  {

        private final OrgJlleitschuhGradleVersionAccessors vaccForOrgJlleitschuhGradleVersionAccessors = new OrgJlleitschuhGradleVersionAccessors(providers, config);
        public OrgJlleitschuhVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.org.jlleitschuh.gradle
         */
        public OrgJlleitschuhGradleVersionAccessors getGradle() {
            return vaccForOrgJlleitschuhGradleVersionAccessors;
        }

    }

    public static class OrgJlleitschuhGradleVersionAccessors extends VersionFactory  {

        public OrgJlleitschuhGradleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.jlleitschuh.gradle.ktlint (12.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtlint() { return getVersion("org.jlleitschuh.gradle.ktlint"); }

    }

    public static class OrgOpenapiVersionAccessors extends VersionFactory  {

        public OrgOpenapiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.openapi.generator (7.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getGenerator() { return getVersion("org.openapi.generator"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: org.springframework.boot (3.2.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getBoot() { return getVersion("org.springframework.boot"); }

            /**
             * Returns the version associated to this alias: org.springframework.hateoas (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getHateoas() { return getVersion("org.springframework.hateoas"); }

    }

    public static class ReactorVersionAccessors extends VersionFactory  {

        private final ReactorKotlinVersionAccessors vaccForReactorKotlinVersionAccessors = new ReactorKotlinVersionAccessors(providers, config);
        public ReactorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: reactor.kafka (1.3.22)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKafka() { return getVersion("reactor.kafka"); }

            /**
             * Returns the version associated to this alias: reactor.test (3.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTest() { return getVersion("reactor.test"); }

        /**
         * Returns the group of versions at versions.reactor.kotlin
         */
        public ReactorKotlinVersionAccessors getKotlin() {
            return vaccForReactorKotlinVersionAccessors;
        }

    }

    public static class ReactorKotlinVersionAccessors extends VersionFactory  {

        public ReactorKotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: reactor.kotlin.extensions (1.2.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getExtensions() { return getVersion("reactor.kotlin.extensions"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final ComPluginAccessors paccForComPluginAccessors = new ComPluginAccessors(providers, config);
        private final IoPluginAccessors paccForIoPluginAccessors = new IoPluginAccessors(providers, config);
        private final NlPluginAccessors paccForNlPluginAccessors = new NlPluginAccessors(providers, config);
        private final OrgPluginAccessors paccForOrgPluginAccessors = new OrgPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com
         */
        public ComPluginAccessors getCom() {
            return paccForComPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.io
         */
        public IoPluginAccessors getIo() {
            return paccForIoPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.nl
         */
        public NlPluginAccessors getNl() {
            return paccForNlPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.org
         */
        public OrgPluginAccessors getOrg() {
            return paccForOrgPluginAccessors;
        }

    }

    public static class ComPluginAccessors extends PluginFactory {
        private final ComGithubPluginAccessors paccForComGithubPluginAccessors = new ComGithubPluginAccessors(providers, config);
        private final ComGooglePluginAccessors paccForComGooglePluginAccessors = new ComGooglePluginAccessors(providers, config);

        public ComPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.github
         */
        public ComGithubPluginAccessors getGithub() {
            return paccForComGithubPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.com.google
         */
        public ComGooglePluginAccessors getGoogle() {
            return paccForComGooglePluginAccessors;
        }

    }

    public static class ComGithubPluginAccessors extends PluginFactory {
        private final ComGithubBenPluginAccessors paccForComGithubBenPluginAccessors = new ComGithubBenPluginAccessors(providers, config);

        public ComGithubPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.github.ben
         */
        public ComGithubBenPluginAccessors getBen() {
            return paccForComGithubBenPluginAccessors;
        }

    }

    public static class ComGithubBenPluginAccessors extends PluginFactory {
        private final ComGithubBenManesPluginAccessors paccForComGithubBenManesPluginAccessors = new ComGithubBenManesPluginAccessors(providers, config);

        public ComGithubBenPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.github.ben.manes
         */
        public ComGithubBenManesPluginAccessors getManes() {
            return paccForComGithubBenManesPluginAccessors;
        }

    }

    public static class ComGithubBenManesPluginAccessors extends PluginFactory {

        public ComGithubBenManesPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.github.ben.manes.versions to the plugin id 'com.github.ben-manes.versions'
             * with versionRef 'com.github.ben.manes.versions'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getVersions() { return createPlugin("com.github.ben.manes.versions"); }

    }

    public static class ComGooglePluginAccessors extends PluginFactory {
        private final ComGoogleDevtoolsPluginAccessors paccForComGoogleDevtoolsPluginAccessors = new ComGoogleDevtoolsPluginAccessors(providers, config);

        public ComGooglePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.com.google.devtools
         */
        public ComGoogleDevtoolsPluginAccessors getDevtools() {
            return paccForComGoogleDevtoolsPluginAccessors;
        }

    }

    public static class ComGoogleDevtoolsPluginAccessors extends PluginFactory {

        public ComGoogleDevtoolsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for com.google.devtools.ksp to the plugin id 'com.google.devtools.ksp'
             * with versionRef 'com.google.devtools.ksp'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKsp() { return createPlugin("com.google.devtools.ksp"); }

    }

    public static class IoPluginAccessors extends PluginFactory {
        private final IoFreefairPluginAccessors paccForIoFreefairPluginAccessors = new IoFreefairPluginAccessors(providers, config);
        private final IoSpringPluginAccessors paccForIoSpringPluginAccessors = new IoSpringPluginAccessors(providers, config);

        public IoPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.io.freefair
         */
        public IoFreefairPluginAccessors getFreefair() {
            return paccForIoFreefairPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.io.spring
         */
        public IoSpringPluginAccessors getSpring() {
            return paccForIoSpringPluginAccessors;
        }

    }

    public static class IoFreefairPluginAccessors extends PluginFactory {
        private final IoFreefairAspectjPluginAccessors paccForIoFreefairAspectjPluginAccessors = new IoFreefairAspectjPluginAccessors(providers, config);

        public IoFreefairPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.io.freefair.aspectj
         */
        public IoFreefairAspectjPluginAccessors getAspectj() {
            return paccForIoFreefairAspectjPluginAccessors;
        }

    }

    public static class IoFreefairAspectjPluginAccessors extends PluginFactory {
        private final IoFreefairAspectjPostPluginAccessors paccForIoFreefairAspectjPostPluginAccessors = new IoFreefairAspectjPostPluginAccessors(providers, config);

        public IoFreefairAspectjPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.io.freefair.aspectj.post
         */
        public IoFreefairAspectjPostPluginAccessors getPost() {
            return paccForIoFreefairAspectjPostPluginAccessors;
        }

    }

    public static class IoFreefairAspectjPostPluginAccessors extends PluginFactory {
        private final IoFreefairAspectjPostCompilePluginAccessors paccForIoFreefairAspectjPostCompilePluginAccessors = new IoFreefairAspectjPostCompilePluginAccessors(providers, config);

        public IoFreefairAspectjPostPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.io.freefair.aspectj.post.compile
         */
        public IoFreefairAspectjPostCompilePluginAccessors getCompile() {
            return paccForIoFreefairAspectjPostCompilePluginAccessors;
        }

    }

    public static class IoFreefairAspectjPostCompilePluginAccessors extends PluginFactory {

        public IoFreefairAspectjPostCompilePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for io.freefair.aspectj.post.compile.weaving to the plugin id 'io.freefair.aspectj.post-compile-weaving'
             * with versionRef 'io.freefair.aspectj.post.compile.weaving'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getWeaving() { return createPlugin("io.freefair.aspectj.post.compile.weaving"); }

    }

    public static class IoSpringPluginAccessors extends PluginFactory {
        private final IoSpringDependencyPluginAccessors paccForIoSpringDependencyPluginAccessors = new IoSpringDependencyPluginAccessors(providers, config);

        public IoSpringPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.io.spring.dependency
         */
        public IoSpringDependencyPluginAccessors getDependency() {
            return paccForIoSpringDependencyPluginAccessors;
        }

    }

    public static class IoSpringDependencyPluginAccessors extends PluginFactory {

        public IoSpringDependencyPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for io.spring.dependency.management to the plugin id 'io.spring.dependency-management'
             * with versionRef 'io.spring.dependency.management'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getManagement() { return createPlugin("io.spring.dependency.management"); }

    }

    public static class NlPluginAccessors extends PluginFactory {
        private final NlLittlerobotsPluginAccessors paccForNlLittlerobotsPluginAccessors = new NlLittlerobotsPluginAccessors(providers, config);

        public NlPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots
         */
        public NlLittlerobotsPluginAccessors getLittlerobots() {
            return paccForNlLittlerobotsPluginAccessors;
        }

    }

    public static class NlLittlerobotsPluginAccessors extends PluginFactory {
        private final NlLittlerobotsVersionPluginAccessors paccForNlLittlerobotsVersionPluginAccessors = new NlLittlerobotsVersionPluginAccessors(providers, config);

        public NlLittlerobotsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots.version
         */
        public NlLittlerobotsVersionPluginAccessors getVersion() {
            return paccForNlLittlerobotsVersionPluginAccessors;
        }

    }

    public static class NlLittlerobotsVersionPluginAccessors extends PluginFactory {
        private final NlLittlerobotsVersionCatalogPluginAccessors paccForNlLittlerobotsVersionCatalogPluginAccessors = new NlLittlerobotsVersionCatalogPluginAccessors(providers, config);

        public NlLittlerobotsVersionPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.nl.littlerobots.version.catalog
         */
        public NlLittlerobotsVersionCatalogPluginAccessors getCatalog() {
            return paccForNlLittlerobotsVersionCatalogPluginAccessors;
        }

    }

    public static class NlLittlerobotsVersionCatalogPluginAccessors extends PluginFactory {

        public NlLittlerobotsVersionCatalogPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for nl.littlerobots.version.catalog.update to the plugin id 'nl.littlerobots.version-catalog-update'
             * with versionRef 'nl.littlerobots.version.catalog.update'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getUpdate() { return createPlugin("nl.littlerobots.version.catalog.update"); }

    }

    public static class OrgPluginAccessors extends PluginFactory {
        private final OrgGraalvmPluginAccessors paccForOrgGraalvmPluginAccessors = new OrgGraalvmPluginAccessors(providers, config);
        private final OrgJetbrainsPluginAccessors paccForOrgJetbrainsPluginAccessors = new OrgJetbrainsPluginAccessors(providers, config);
        private final OrgJlleitschuhPluginAccessors paccForOrgJlleitschuhPluginAccessors = new OrgJlleitschuhPluginAccessors(providers, config);
        private final OrgOpenapiPluginAccessors paccForOrgOpenapiPluginAccessors = new OrgOpenapiPluginAccessors(providers, config);
        private final OrgSpringframeworkPluginAccessors paccForOrgSpringframeworkPluginAccessors = new OrgSpringframeworkPluginAccessors(providers, config);

        public OrgPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.graalvm
         */
        public OrgGraalvmPluginAccessors getGraalvm() {
            return paccForOrgGraalvmPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.org.jetbrains
         */
        public OrgJetbrainsPluginAccessors getJetbrains() {
            return paccForOrgJetbrainsPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.org.jlleitschuh
         */
        public OrgJlleitschuhPluginAccessors getJlleitschuh() {
            return paccForOrgJlleitschuhPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.org.openapi
         */
        public OrgOpenapiPluginAccessors getOpenapi() {
            return paccForOrgOpenapiPluginAccessors;
        }

        /**
         * Returns the group of plugins at plugins.org.springframework
         */
        public OrgSpringframeworkPluginAccessors getSpringframework() {
            return paccForOrgSpringframeworkPluginAccessors;
        }

    }

    public static class OrgGraalvmPluginAccessors extends PluginFactory {
        private final OrgGraalvmBuildtoolsPluginAccessors paccForOrgGraalvmBuildtoolsPluginAccessors = new OrgGraalvmBuildtoolsPluginAccessors(providers, config);

        public OrgGraalvmPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.graalvm.buildtools
         */
        public OrgGraalvmBuildtoolsPluginAccessors getBuildtools() {
            return paccForOrgGraalvmBuildtoolsPluginAccessors;
        }

    }

    public static class OrgGraalvmBuildtoolsPluginAccessors extends PluginFactory {

        public OrgGraalvmBuildtoolsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.graalvm.buildtools.native to the plugin id 'org.graalvm.buildtools.native'
             * with versionRef 'org.graalvm.buildtools.native'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getNative() { return createPlugin("org.graalvm.buildtools.native"); }

    }

    public static class OrgJetbrainsPluginAccessors extends PluginFactory {
        private final OrgJetbrainsKotlinPluginAccessors paccForOrgJetbrainsKotlinPluginAccessors = new OrgJetbrainsKotlinPluginAccessors(providers, config);

        public OrgJetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.jetbrains.kotlin
         */
        public OrgJetbrainsKotlinPluginAccessors getKotlin() {
            return paccForOrgJetbrainsKotlinPluginAccessors;
        }

    }

    public static class OrgJetbrainsKotlinPluginAccessors extends PluginFactory {
        private final OrgJetbrainsKotlinPluginPluginAccessors paccForOrgJetbrainsKotlinPluginPluginAccessors = new OrgJetbrainsKotlinPluginPluginAccessors(providers, config);

        public OrgJetbrainsKotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.jetbrains.kotlin.jvm to the plugin id 'org.jetbrains.kotlin.jvm'
             * with versionRef 'org.jetbrains.kotlin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getJvm() { return createPlugin("org.jetbrains.kotlin.jvm"); }

        /**
         * Returns the group of plugins at plugins.org.jetbrains.kotlin.plugin
         */
        public OrgJetbrainsKotlinPluginPluginAccessors getPlugin() {
            return paccForOrgJetbrainsKotlinPluginPluginAccessors;
        }

    }

    public static class OrgJetbrainsKotlinPluginPluginAccessors extends PluginFactory {

        public OrgJetbrainsKotlinPluginPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.jetbrains.kotlin.plugin.allopen to the plugin id 'org.jetbrains.kotlin.plugin.allopen'
             * with versionRef 'org.jetbrains.kotlin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getAllopen() { return createPlugin("org.jetbrains.kotlin.plugin.allopen"); }

            /**
             * Creates a plugin provider for org.jetbrains.kotlin.plugin.spring to the plugin id 'org.jetbrains.kotlin.plugin.spring'
             * with versionRef 'org.jetbrains.kotlin'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getSpring() { return createPlugin("org.jetbrains.kotlin.plugin.spring"); }

    }

    public static class OrgJlleitschuhPluginAccessors extends PluginFactory {
        private final OrgJlleitschuhGradlePluginAccessors paccForOrgJlleitschuhGradlePluginAccessors = new OrgJlleitschuhGradlePluginAccessors(providers, config);

        public OrgJlleitschuhPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of plugins at plugins.org.jlleitschuh.gradle
         */
        public OrgJlleitschuhGradlePluginAccessors getGradle() {
            return paccForOrgJlleitschuhGradlePluginAccessors;
        }

    }

    public static class OrgJlleitschuhGradlePluginAccessors extends PluginFactory {

        public OrgJlleitschuhGradlePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.jlleitschuh.gradle.ktlint to the plugin id 'org.jlleitschuh.gradle.ktlint'
             * with versionRef 'org.jlleitschuh.gradle.ktlint'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getKtlint() { return createPlugin("org.jlleitschuh.gradle.ktlint"); }

    }

    public static class OrgOpenapiPluginAccessors extends PluginFactory {

        public OrgOpenapiPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.openapi.generator to the plugin id 'org.openapi.generator'
             * with versionRef 'org.openapi.generator'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getGenerator() { return createPlugin("org.openapi.generator"); }

    }

    public static class OrgSpringframeworkPluginAccessors extends PluginFactory {

        public OrgSpringframeworkPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for org.springframework.boot to the plugin id 'org.springframework.boot'
             * with versionRef 'org.springframework.boot'.
             * This plugin was declared in catalog libs.versions.toml
             */
            public Provider<PluginDependency> getBoot() { return createPlugin("org.springframework.boot"); }

    }

}
