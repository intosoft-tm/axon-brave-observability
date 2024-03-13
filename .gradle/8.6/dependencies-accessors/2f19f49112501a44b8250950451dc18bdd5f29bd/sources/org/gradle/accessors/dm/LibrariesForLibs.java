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
 * A catalog of dependencies accessible via the {@code libs} extension.
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
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>io</b>
     */
    public IoLibraryAccessors getIo() {
        return laccForIoLibraryAccessors;
    }

    /**
     * Group of libraries at <b>jakarta</b>
     */
    public JakartaLibraryAccessors getJakarta() {
        return laccForJakartaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
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
         * Group of libraries at <b>com.fasterxml</b>
         */
        public ComFasterxmlLibraryAccessors getFasterxml() {
            return laccForComFasterxmlLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.github</b>
         */
        public ComGithubLibraryAccessors getGithub() {
            return laccForComGithubLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google</b>
         */
        public ComGoogleLibraryAccessors getGoogle() {
            return laccForComGoogleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.tngtech</b>
         */
        public ComTngtechLibraryAccessors getTngtech() {
            return laccForComTngtechLibraryAccessors;
        }

    }

    public static class ComFasterxmlLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonLibraryAccessors laccForComFasterxmlJacksonLibraryAccessors = new ComFasterxmlJacksonLibraryAccessors(owner);

        public ComFasterxmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson</b>
         */
        public ComFasterxmlJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleLibraryAccessors laccForComFasterxmlJacksonModuleLibraryAccessors = new ComFasterxmlJacksonModuleLibraryAccessors(owner);

        public ComFasterxmlJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.module</b>
         */
        public ComFasterxmlJacksonModuleLibraryAccessors getModule() {
            return laccForComFasterxmlJacksonModuleLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonModuleLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleJacksonLibraryAccessors laccForComFasterxmlJacksonModuleJacksonLibraryAccessors = new ComFasterxmlJacksonModuleJacksonLibraryAccessors(owner);

        public ComFasterxmlJacksonModuleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.module.jackson</b>
         */
        public ComFasterxmlJacksonModuleJacksonLibraryAccessors getJackson() {
            return laccForComFasterxmlJacksonModuleJacksonLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonModuleJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors laccForComFasterxmlJacksonModuleJacksonModuleLibraryAccessors = new ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors(owner);

        public ComFasterxmlJacksonModuleJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.module.jackson.module</b>
         */
        public ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors getModule() {
            return laccForComFasterxmlJacksonModuleJacksonModuleLibraryAccessors;
        }

    }

    public static class ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors extends SubDependencyFactory {

        public ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kotlin</b> with <b>com.fasterxml.jackson.module:jackson-module-kotlin</b> coordinates and
         * with version reference <b>jackson.module.kotlin</b>
         * <p>
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
         * Group of libraries at <b>com.github.avro</b>
         */
        public ComGithubAvroLibraryAccessors getAvro() {
            return laccForComGithubAvroLibraryAccessors;
        }

    }

    public static class ComGithubAvroLibraryAccessors extends SubDependencyFactory {
        private final ComGithubAvroKotlinLibraryAccessors laccForComGithubAvroKotlinLibraryAccessors = new ComGithubAvroKotlinLibraryAccessors(owner);

        public ComGithubAvroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.avro.kotlin</b>
         */
        public ComGithubAvroKotlinLibraryAccessors getKotlin() {
            return laccForComGithubAvroKotlinLibraryAccessors;
        }

    }

    public static class ComGithubAvroKotlinLibraryAccessors extends SubDependencyFactory {
        private final ComGithubAvroKotlinAvro4kLibraryAccessors laccForComGithubAvroKotlinAvro4kLibraryAccessors = new ComGithubAvroKotlinAvro4kLibraryAccessors(owner);

        public ComGithubAvroKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.avro.kotlin.avro4k</b>
         */
        public ComGithubAvroKotlinAvro4kLibraryAccessors getAvro4k() {
            return laccForComGithubAvroKotlinAvro4kLibraryAccessors;
        }

    }

    public static class ComGithubAvroKotlinAvro4kLibraryAccessors extends SubDependencyFactory {

        public ComGithubAvroKotlinAvro4kLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>com.github.avro-kotlin.avro4k:avro4k-core</b> coordinates and
         * with version reference <b>com.github.avro.kotlin.avro4k.core</b>
         * <p>
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
         * Group of libraries at <b>com.google.devtools</b>
         */
        public ComGoogleDevtoolsLibraryAccessors getDevtools() {
            return laccForComGoogleDevtoolsLibraryAccessors;
        }

    }

    public static class ComGoogleDevtoolsLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspLibraryAccessors laccForComGoogleDevtoolsKspLibraryAccessors = new ComGoogleDevtoolsKspLibraryAccessors(owner);

        public ComGoogleDevtoolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.devtools.ksp</b>
         */
        public ComGoogleDevtoolsKspLibraryAccessors getKsp() {
            return laccForComGoogleDevtoolsKspLibraryAccessors;
        }

    }

    public static class ComGoogleDevtoolsKspLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspSymbolLibraryAccessors laccForComGoogleDevtoolsKspSymbolLibraryAccessors = new ComGoogleDevtoolsKspSymbolLibraryAccessors(owner);

        public ComGoogleDevtoolsKspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.devtools.ksp.symbol</b>
         */
        public ComGoogleDevtoolsKspSymbolLibraryAccessors getSymbol() {
            return laccForComGoogleDevtoolsKspSymbolLibraryAccessors;
        }

    }

    public static class ComGoogleDevtoolsKspSymbolLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors laccForComGoogleDevtoolsKspSymbolProcessingLibraryAccessors = new ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors(owner);

        public ComGoogleDevtoolsKspSymbolLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.devtools.ksp.symbol.processing</b>
         */
        public ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors getProcessing() {
            return laccForComGoogleDevtoolsKspSymbolProcessingLibraryAccessors;
        }

    }

    public static class ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors extends SubDependencyFactory {

        public ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>com.google.devtools.ksp:symbol-processing-api</b> coordinates and
         * with version reference <b>com.google.devtools.ksp</b>
         * <p>
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
         * Group of libraries at <b>com.tngtech.archunit</b>
         */
        public ComTngtechArchunitLibraryAccessors getArchunit() {
            return laccForComTngtechArchunitLibraryAccessors;
        }

    }

    public static class ComTngtechArchunitLibraryAccessors extends SubDependencyFactory {
        private final ComTngtechArchunitArchunitLibraryAccessors laccForComTngtechArchunitArchunitLibraryAccessors = new ComTngtechArchunitArchunitLibraryAccessors(owner);

        public ComTngtechArchunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.tngtech.archunit.archunit</b>
         */
        public ComTngtechArchunitArchunitLibraryAccessors getArchunit() {
            return laccForComTngtechArchunitArchunitLibraryAccessors;
        }

    }

    public static class ComTngtechArchunitArchunitLibraryAccessors extends SubDependencyFactory {
        private final ComTngtechArchunitArchunitJunit5LibraryAccessors laccForComTngtechArchunitArchunitJunit5LibraryAccessors = new ComTngtechArchunitArchunitJunit5LibraryAccessors(owner);

        public ComTngtechArchunitArchunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.tngtech.archunit.archunit.junit5</b>
         */
        public ComTngtechArchunitArchunitJunit5LibraryAccessors getJunit5() {
            return laccForComTngtechArchunitArchunitJunit5LibraryAccessors;
        }

    }

    public static class ComTngtechArchunitArchunitJunit5LibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ComTngtechArchunitArchunitJunit5LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit5</b> with <b>com.tngtech.archunit:archunit-junit5</b> coordinates and
         * with version reference <b>com.tngtech.archunit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("com.tngtech.archunit.archunit.junit5");
        }

        /**
         * Dependency provider for <b>api</b> with <b>com.tngtech.archunit:archunit-junit5-api</b> coordinates and
         * with version reference <b>com.tngtech.archunit</b>
         * <p>
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
         * Group of libraries at <b>io.github</b>
         */
        public IoGithubLibraryAccessors getGithub() {
            return laccForIoGithubLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.holixon</b>
         */
        public IoHolixonLibraryAccessors getHolixon() {
            return laccForIoHolixonLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.kotest</b>
         */
        public IoKotestLibraryAccessors getKotest() {
            return laccForIoKotestLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.mcarle</b>
         */
        public IoMcarleLibraryAccessors getMcarle() {
            return laccForIoMcarleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.mongock</b>
         */
        public IoMongockLibraryAccessors getMongock() {
            return laccForIoMongockLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.projectreactor</b>
         */
        public IoProjectreactorLibraryAccessors getProjectreactor() {
            return laccForIoProjectreactorLibraryAccessors;
        }

    }

    public static class IoGithubLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiLibraryAccessors laccForIoGithubOshaiLibraryAccessors = new IoGithubOshaiLibraryAccessors(owner);

        public IoGithubLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.github.oshai</b>
         */
        public IoGithubOshaiLibraryAccessors getOshai() {
            return laccForIoGithubOshaiLibraryAccessors;
        }

    }

    public static class IoGithubOshaiLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiKotlinLibraryAccessors laccForIoGithubOshaiKotlinLibraryAccessors = new IoGithubOshaiKotlinLibraryAccessors(owner);

        public IoGithubOshaiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.github.oshai.kotlin</b>
         */
        public IoGithubOshaiKotlinLibraryAccessors getKotlin() {
            return laccForIoGithubOshaiKotlinLibraryAccessors;
        }

    }

    public static class IoGithubOshaiKotlinLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiKotlinLoggingLibraryAccessors laccForIoGithubOshaiKotlinLoggingLibraryAccessors = new IoGithubOshaiKotlinLoggingLibraryAccessors(owner);

        public IoGithubOshaiKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.github.oshai.kotlin.logging</b>
         */
        public IoGithubOshaiKotlinLoggingLibraryAccessors getLogging() {
            return laccForIoGithubOshaiKotlinLoggingLibraryAccessors;
        }

    }

    public static class IoGithubOshaiKotlinLoggingLibraryAccessors extends SubDependencyFactory {

        public IoGithubOshaiKotlinLoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jvm</b> with <b>io.github.oshai:kotlin-logging-jvm</b> coordinates and
         * with version reference <b>kotlin.logging.jvm</b>
         * <p>
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
         * Group of libraries at <b>io.holixon.axon</b>
         */
        public IoHolixonAxonLibraryAccessors getAxon() {
            return laccForIoHolixonAxonLibraryAccessors;
        }

    }

    public static class IoHolixonAxonLibraryAccessors extends SubDependencyFactory {
        private final IoHolixonAxonAvroLibraryAccessors laccForIoHolixonAxonAvroLibraryAccessors = new IoHolixonAxonAvroLibraryAccessors(owner);

        public IoHolixonAxonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.holixon.axon.avro</b>
         */
        public IoHolixonAxonAvroLibraryAccessors getAvro() {
            return laccForIoHolixonAxonAvroLibraryAccessors;
        }

    }

    public static class IoHolixonAxonAvroLibraryAccessors extends SubDependencyFactory {
        private final IoHolixonAxonAvroSerializerLibraryAccessors laccForIoHolixonAxonAvroSerializerLibraryAccessors = new IoHolixonAxonAvroSerializerLibraryAccessors(owner);

        public IoHolixonAxonAvroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.holixon.axon.avro.serializer</b>
         */
        public IoHolixonAxonAvroSerializerLibraryAccessors getSerializer() {
            return laccForIoHolixonAxonAvroSerializerLibraryAccessors;
        }

    }

    public static class IoHolixonAxonAvroSerializerLibraryAccessors extends SubDependencyFactory {

        public IoHolixonAxonAvroSerializerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>spring</b> with <b>io.holixon.axon.avro:axon-avro-serializer-spring</b> coordinates and
         * with version reference <b>io.holixon.axon.avro.serializer.spring</b>
         * <p>
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
         * Group of libraries at <b>io.kotest.extensions</b>
         */
        public IoKotestExtensionsLibraryAccessors getExtensions() {
            return laccForIoKotestExtensionsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.kotest.kotest</b>
         */
        public IoKotestKotestLibraryAccessors getKotest() {
            return laccForIoKotestKotestLibraryAccessors;
        }

    }

    public static class IoKotestExtensionsLibraryAccessors extends SubDependencyFactory {
        private final IoKotestExtensionsKotestLibraryAccessors laccForIoKotestExtensionsKotestLibraryAccessors = new IoKotestExtensionsKotestLibraryAccessors(owner);

        public IoKotestExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.kotest.extensions.kotest</b>
         */
        public IoKotestExtensionsKotestLibraryAccessors getKotest() {
            return laccForIoKotestExtensionsKotestLibraryAccessors;
        }

    }

    public static class IoKotestExtensionsKotestLibraryAccessors extends SubDependencyFactory {
        private final IoKotestExtensionsKotestExtensionsLibraryAccessors laccForIoKotestExtensionsKotestExtensionsLibraryAccessors = new IoKotestExtensionsKotestExtensionsLibraryAccessors(owner);

        public IoKotestExtensionsKotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.kotest.extensions.kotest.extensions</b>
         */
        public IoKotestExtensionsKotestExtensionsLibraryAccessors getExtensions() {
            return laccForIoKotestExtensionsKotestExtensionsLibraryAccessors;
        }

    }

    public static class IoKotestExtensionsKotestExtensionsLibraryAccessors extends SubDependencyFactory {

        public IoKotestExtensionsKotestExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>spring</b> with <b>io.kotest.extensions:kotest-extensions-spring</b> coordinates and
         * with version reference <b>kotest.extensions.spring</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSpring() {
            return create("io.kotest.extensions.kotest.extensions.spring");
        }

        /**
         * Dependency provider for <b>testcontainers</b> with <b>io.kotest.extensions:kotest-extensions-testcontainers</b> coordinates and
         * with version reference <b>kotest.extensions.testcontainers</b>
         * <p>
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
         * Dependency provider for <b>property</b> with <b>io.kotest:kotest-property</b> coordinates and
         * with version reference <b>io.kotest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getProperty() {
            return create("io.kotest.kotest.property");
        }

        /**
         * Group of libraries at <b>io.kotest.kotest.assertions</b>
         */
        public IoKotestKotestAssertionsLibraryAccessors getAssertions() {
            return laccForIoKotestKotestAssertionsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.kotest.kotest.runner</b>
         */
        public IoKotestKotestRunnerLibraryAccessors getRunner() {
            return laccForIoKotestKotestRunnerLibraryAccessors;
        }

    }

    public static class IoKotestKotestAssertionsLibraryAccessors extends SubDependencyFactory {

        public IoKotestKotestAssertionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>io.kotest:kotest-assertions-core</b> coordinates and
         * with version reference <b>io.kotest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("io.kotest.kotest.assertions.core");
        }

    }

    public static class IoKotestKotestRunnerLibraryAccessors extends SubDependencyFactory {

        public IoKotestKotestRunnerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit5</b> with <b>io.kotest:kotest-runner-junit5</b> coordinates and
         * with version reference <b>io.kotest</b>
         * <p>
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
         * Group of libraries at <b>io.mcarle.konvert</b>
         */
        public IoMcarleKonvertLibraryAccessors getKonvert() {
            return laccForIoMcarleKonvertLibraryAccessors;
        }

    }

    public static class IoMcarleKonvertLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public IoMcarleKonvertLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>konvert</b> with <b>io.mcarle:konvert</b> coordinates and
         * with version reference <b>io.mcarle.konvert.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("io.mcarle.konvert");
        }

        /**
         * Dependency provider for <b>api</b> with <b>io.mcarle:konvert-api</b> coordinates and
         * with version reference <b>io.mcarle.konvert.api</b>
         * <p>
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
         * Group of libraries at <b>io.mongock.mongock</b>
         */
        public IoMongockMongockLibraryAccessors getMongock() {
            return laccForIoMongockMongockLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.mongock.mongodb</b>
         */
        public IoMongockMongodbLibraryAccessors getMongodb() {
            return laccForIoMongockMongodbLibraryAccessors;
        }

    }

    public static class IoMongockMongockLibraryAccessors extends SubDependencyFactory {

        public IoMongockMongockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bom</b> with <b>io.mongock:mongock-bom</b> coordinates and
         * with version reference <b>io.mongock.mongock</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBom() {
            return create("io.mongock.mongock.bom");
        }

        /**
         * Dependency provider for <b>springboot</b> with <b>io.mongock:mongock-springboot</b> coordinates and
         * with version reference <b>io.mongock.mongock</b>
         * <p>
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
         * Group of libraries at <b>io.mongock.mongodb.reactive</b>
         */
        public IoMongockMongodbReactiveLibraryAccessors getReactive() {
            return laccForIoMongockMongodbReactiveLibraryAccessors;
        }

    }

    public static class IoMongockMongodbReactiveLibraryAccessors extends SubDependencyFactory {

        public IoMongockMongodbReactiveLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>driver</b> with <b>io.mongock:mongodb-reactive-driver</b> coordinates and
         * with version reference <b>io.mongock.mongock</b>
         * <p>
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
         * Group of libraries at <b>io.projectreactor.kafka</b>
         */
        public IoProjectreactorKafkaLibraryAccessors getKafka() {
            return laccForIoProjectreactorKafkaLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.projectreactor.kotlin</b>
         */
        public IoProjectreactorKotlinLibraryAccessors getKotlin() {
            return laccForIoProjectreactorKotlinLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.projectreactor.reactor</b>
         */
        public IoProjectreactorReactorLibraryAccessors getReactor() {
            return laccForIoProjectreactorReactorLibraryAccessors;
        }

    }

    public static class IoProjectreactorKafkaLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKafkaReactorLibraryAccessors laccForIoProjectreactorKafkaReactorLibraryAccessors = new IoProjectreactorKafkaReactorLibraryAccessors(owner);

        public IoProjectreactorKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.projectreactor.kafka.reactor</b>
         */
        public IoProjectreactorKafkaReactorLibraryAccessors getReactor() {
            return laccForIoProjectreactorKafkaReactorLibraryAccessors;
        }

    }

    public static class IoProjectreactorKafkaReactorLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorKafkaReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kafka</b> with <b>io.projectreactor.kafka:reactor-kafka</b> coordinates and
         * with version reference <b>reactor.kafka</b>
         * <p>
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
         * Group of libraries at <b>io.projectreactor.kotlin.reactor</b>
         */
        public IoProjectreactorKotlinReactorLibraryAccessors getReactor() {
            return laccForIoProjectreactorKotlinReactorLibraryAccessors;
        }

    }

    public static class IoProjectreactorKotlinReactorLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKotlinReactorKotlinLibraryAccessors laccForIoProjectreactorKotlinReactorKotlinLibraryAccessors = new IoProjectreactorKotlinReactorKotlinLibraryAccessors(owner);

        public IoProjectreactorKotlinReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.projectreactor.kotlin.reactor.kotlin</b>
         */
        public IoProjectreactorKotlinReactorKotlinLibraryAccessors getKotlin() {
            return laccForIoProjectreactorKotlinReactorKotlinLibraryAccessors;
        }

    }

    public static class IoProjectreactorKotlinReactorKotlinLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorKotlinReactorKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>extensions</b> with <b>io.projectreactor.kotlin:reactor-kotlin-extensions</b> coordinates and
         * with version reference <b>reactor.kotlin.extensions</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getExtensions() {
            return create("io.projectreactor.kotlin.reactor.kotlin.extensions");
        }

    }

    public static class IoProjectreactorReactorLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>test</b> with <b>io.projectreactor:reactor-test</b> coordinates and
         * with version reference <b>reactor.test</b>
         * <p>
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
         * Group of libraries at <b>jakarta.validation</b>
         */
        public JakartaValidationLibraryAccessors getValidation() {
            return laccForJakartaValidationLibraryAccessors;
        }

    }

    public static class JakartaValidationLibraryAccessors extends SubDependencyFactory {

        public JakartaValidationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.validation:jakarta.validation-api</b> coordinates and
         * with version reference <b>jakarta.validation.api</b>
         * <p>
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
         * Group of libraries at <b>org.apache</b>
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.axon</b>
         */
        public OrgAxonLibraryAccessors getAxon() {
            return laccForOrgAxonLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.jetbrains</b>
         */
        public OrgJetbrainsLibraryAccessors getJetbrains() {
            return laccForOrgJetbrainsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mockito</b>
         */
        public OrgMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springdoc</b>
         */
        public OrgSpringdocLibraryAccessors getSpringdoc() {
            return laccForOrgSpringdocLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework</b>
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.testcontainers</b>
         */
        public OrgTestcontainersLibraryAccessors getTestcontainers() {
            return laccForOrgTestcontainersLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.yaml</b>
         */
        public OrgYamlLibraryAccessors getYaml() {
            return laccForOrgYamlLibraryAccessors;
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLibraryAccessors laccForOrgApacheLoggingLibraryAccessors = new OrgApacheLoggingLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.logging</b>
         */
        public OrgApacheLoggingLibraryAccessors getLogging() {
            return laccForOrgApacheLoggingLibraryAccessors;
        }

    }

    public static class OrgApacheLoggingLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLibraryAccessors = new OrgApacheLoggingLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.logging.log4j</b>
         */
        public OrgApacheLoggingLog4jLibraryAccessors getLog4j() {
            return laccForOrgApacheLoggingLog4jLibraryAccessors;
        }

    }

    public static class OrgApacheLoggingLog4jLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLog4jLibraryAccessors = new OrgApacheLoggingLog4jLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.logging.log4j.log4j</b>
         */
        public OrgApacheLoggingLog4jLog4jLibraryAccessors getLog4j() {
            return laccForOrgApacheLoggingLog4jLog4jLibraryAccessors;
        }

    }

    public static class OrgApacheLoggingLog4jLog4jLibraryAccessors extends SubDependencyFactory {

        public OrgApacheLoggingLog4jLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.apache.logging.log4j:log4j-core</b> coordinates and
         * with version reference <b>log4j.core</b>
         * <p>
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
         * Group of libraries at <b>org.axon.extensions</b>
         */
        public OrgAxonExtensionsLibraryAccessors getExtensions() {
            return laccForOrgAxonExtensionsLibraryAccessors;
        }

    }

    public static class OrgAxonExtensionsLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorLibraryAccessors laccForOrgAxonExtensionsReactorLibraryAccessors = new OrgAxonExtensionsReactorLibraryAccessors(owner);

        public OrgAxonExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mongo</b> with <b>org.axonframework.extensions.mongo:axon-mongo</b> coordinates and
         * with version reference <b>axon.extensions.spring.aot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMongo() {
            return create("org.axon.extensions.mongo");
        }

        /**
         * Group of libraries at <b>org.axon.extensions.reactor</b>
         */
        public OrgAxonExtensionsReactorLibraryAccessors getReactor() {
            return laccForOrgAxonExtensionsReactorLibraryAccessors;
        }

    }

    public static class OrgAxonExtensionsReactorLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorSpringLibraryAccessors laccForOrgAxonExtensionsReactorSpringLibraryAccessors = new OrgAxonExtensionsReactorSpringLibraryAccessors(owner);

        public OrgAxonExtensionsReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.axon.extensions.reactor.spring</b>
         */
        public OrgAxonExtensionsReactorSpringLibraryAccessors getSpring() {
            return laccForOrgAxonExtensionsReactorSpringLibraryAccessors;
        }

    }

    public static class OrgAxonExtensionsReactorSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorSpringBootLibraryAccessors laccForOrgAxonExtensionsReactorSpringBootLibraryAccessors = new OrgAxonExtensionsReactorSpringBootLibraryAccessors(owner);

        public OrgAxonExtensionsReactorSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.axon.extensions.reactor.spring.boot</b>
         */
        public OrgAxonExtensionsReactorSpringBootLibraryAccessors getBoot() {
            return laccForOrgAxonExtensionsReactorSpringBootLibraryAccessors;
        }

    }

    public static class OrgAxonExtensionsReactorSpringBootLibraryAccessors extends SubDependencyFactory {

        public OrgAxonExtensionsReactorSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>starter</b> with <b>org.axonframework.extensions.reactor:axon-reactor-spring-boot-starter</b> coordinates and
         * with version reference <b>axon.extensions.reactor</b>
         * <p>
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
         * Dependency provider for <b>annotations</b> with <b>org.jetbrains:annotations</b> coordinates and
         * with version reference <b>org.jetbrains.annotations</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnnotations() {
            return create("org.jetbrains.annotations");
        }

        /**
         * Group of libraries at <b>org.jetbrains.kotlin</b>
         */
        public OrgJetbrainsKotlinLibraryAccessors getKotlin() {
            return laccForOrgJetbrainsKotlinLibraryAccessors;
        }

    }

    public static class OrgJetbrainsKotlinLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinKotlinLibraryAccessors laccForOrgJetbrainsKotlinKotlinLibraryAccessors = new OrgJetbrainsKotlinKotlinLibraryAccessors(owner);

        public OrgJetbrainsKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.jetbrains.kotlin.kotlin</b>
         */
        public OrgJetbrainsKotlinKotlinLibraryAccessors getKotlin() {
            return laccForOrgJetbrainsKotlinKotlinLibraryAccessors;
        }

    }

    public static class OrgJetbrainsKotlinKotlinLibraryAccessors extends SubDependencyFactory {

        public OrgJetbrainsKotlinKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>reflect</b> with <b>org.jetbrains.kotlin:kotlin-reflect</b> coordinates and
         * with version <b>1.9.22</b>
         * <p>
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
         * Group of libraries at <b>org.mockito.kotlin</b>
         */
        public OrgMockitoKotlinLibraryAccessors getKotlin() {
            return laccForOrgMockitoKotlinLibraryAccessors;
        }

    }

    public static class OrgMockitoKotlinLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoKotlinMockitoLibraryAccessors laccForOrgMockitoKotlinMockitoLibraryAccessors = new OrgMockitoKotlinMockitoLibraryAccessors(owner);

        public OrgMockitoKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mockito.kotlin.mockito</b>
         */
        public OrgMockitoKotlinMockitoLibraryAccessors getMockito() {
            return laccForOrgMockitoKotlinMockitoLibraryAccessors;
        }

    }

    public static class OrgMockitoKotlinMockitoLibraryAccessors extends SubDependencyFactory {

        public OrgMockitoKotlinMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kotlin</b> with <b>org.mockito.kotlin:mockito-kotlin</b> coordinates and
         * with version reference <b>mockito.kotlin</b>
         * <p>
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
         * Group of libraries at <b>org.springdoc.openapi</b>
         */
        public OrgSpringdocOpenapiLibraryAccessors getOpenapi() {
            return laccForOrgSpringdocOpenapiLibraryAccessors;
        }

    }

    public static class OrgSpringdocOpenapiLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocOpenapiStarterLibraryAccessors laccForOrgSpringdocOpenapiStarterLibraryAccessors = new OrgSpringdocOpenapiStarterLibraryAccessors(owner);

        public OrgSpringdocOpenapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springdoc.openapi.starter</b>
         */
        public OrgSpringdocOpenapiStarterLibraryAccessors getStarter() {
            return laccForOrgSpringdocOpenapiStarterLibraryAccessors;
        }

    }

    public static class OrgSpringdocOpenapiStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocOpenapiStarterWebfluxLibraryAccessors laccForOrgSpringdocOpenapiStarterWebfluxLibraryAccessors = new OrgSpringdocOpenapiStarterWebfluxLibraryAccessors(owner);

        public OrgSpringdocOpenapiStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>common</b> with <b>org.springdoc:springdoc-openapi-starter-common</b> coordinates and
         * with version reference <b>org.springdoc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCommon() {
            return create("org.springdoc.openapi.starter.common");
        }

        /**
         * Group of libraries at <b>org.springdoc.openapi.starter.webflux</b>
         */
        public OrgSpringdocOpenapiStarterWebfluxLibraryAccessors getWebflux() {
            return laccForOrgSpringdocOpenapiStarterWebfluxLibraryAccessors;
        }

    }

    public static class OrgSpringdocOpenapiStarterWebfluxLibraryAccessors extends SubDependencyFactory {

        public OrgSpringdocOpenapiStarterWebfluxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>org.springdoc:springdoc-openapi-starter-webflux-ui</b> coordinates and
         * with version reference <b>org.springdoc</b>
         * <p>
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
         * Dependency provider for <b>hateoas</b> with <b>org.springframework.hateoas:spring-hateoas</b> coordinates and
         * with version reference <b>org.springframework.hateoas</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getHateoas() {
            return create("org.springframework.hateoas");
        }

        /**
         * Group of libraries at <b>org.springframework.boot</b>
         */
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring</b>
         */
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot</b>
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
         * Dependency provider for <b>dependencies</b> with <b>org.springframework.boot:spring-boot-dependencies</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDependencies() {
            return create("org.springframework.boot.spring.boot.dependencies");
        }

        /**
         * Dependency provider for <b>testcontainers</b> with <b>org.springframework.boot:spring-boot-testcontainers</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTestcontainers() {
            return create("org.springframework.boot.spring.boot.testcontainers");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.docker</b>
         */
        public OrgSpringframeworkBootSpringBootDockerLibraryAccessors getDocker() {
            return laccForOrgSpringframeworkBootSpringBootDockerLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter</b>
         */
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootDockerLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootDockerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>org.springframework.boot:spring-boot-docker-compose</b> coordinates and
         * with <b>no version specified</b>
         * <p>
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
         * Dependency provider for <b>actuator</b> with <b>org.springframework.boot:spring-boot-starter-actuator</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getActuator() {
            return create("org.springframework.boot.spring.boot.starter.actuator");
        }

        /**
         * Dependency provider for <b>security</b> with <b>org.springframework.boot:spring-boot-starter-security</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getSecurity() {
            return create("org.springframework.boot.spring.boot.starter.security");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.boot:spring-boot-starter-test</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("org.springframework.boot.spring.boot.starter.test");
        }

        /**
         * Dependency provider for <b>validation</b> with <b>org.springframework.boot:spring-boot-starter-validation</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getValidation() {
            return create("org.springframework.boot.spring.boot.starter.validation");
        }

        /**
         * Dependency provider for <b>webflux</b> with <b>org.springframework.boot:spring-boot-starter-webflux</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWebflux() {
            return create("org.springframework.boot.spring.boot.starter.webflux");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.data</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.oauth2</b>
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors getOauth2() {
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.data.mongodb</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors getMongodb() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>reactive</b> with <b>org.springframework.boot:spring-boot-starter-data-mongodb-reactive</b> coordinates and
         * with <b>no version specified</b>
         * <p>
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
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.oauth2.resource</b>
         */
        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors getResource() {
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>server</b> with <b>org.springframework.boot:spring-boot-starter-oauth2-resource-server</b> coordinates and
         * with <b>no version specified</b>
         * <p>
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
         * Dependency provider for <b>testcontainers</b> with <b>org.testcontainers:testcontainers</b> coordinates and
         * with version reference <b>org.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("org.testcontainers");
        }

        /**
         * Dependency provider for <b>kafka</b> with <b>org.testcontainers:kafka</b> coordinates and
         * with version reference <b>org.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKafka() {
            return create("org.testcontainers.kafka");
        }

        /**
         * Dependency provider for <b>mongodb</b> with <b>org.testcontainers:mongodb</b> coordinates and
         * with version reference <b>org.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMongodb() {
            return create("org.testcontainers.mongodb");
        }

        /**
         * Group of libraries at <b>org.testcontainers.junit</b>
         */
        public OrgTestcontainersJunitLibraryAccessors getJunit() {
            return laccForOrgTestcontainersJunitLibraryAccessors;
        }

    }

    public static class OrgTestcontainersJunitLibraryAccessors extends SubDependencyFactory {

        public OrgTestcontainersJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jupiter</b> with <b>org.testcontainers:junit-jupiter</b> coordinates and
         * with version reference <b>org.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJupiter() {
            return create("org.testcontainers.junit.jupiter");
        }

    }

    public static class OrgYamlLibraryAccessors extends SubDependencyFactory {

        public OrgYamlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>snakeyaml</b> with <b>org.yaml:snakeyaml</b> coordinates and
         * with version reference <b>snakeyaml</b>
         * <p>
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
         * Version alias <b>snakeyaml</b> with value <b>2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSnakeyaml() { return getVersion("snakeyaml"); }

        /**
         * Group of versions at <b>versions.axon</b>
         */
        public AxonVersionAccessors getAxon() {
            return vaccForAxonVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io</b>
         */
        public IoVersionAccessors getIo() {
            return vaccForIoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jackson</b>
         */
        public JacksonVersionAccessors getJackson() {
            return vaccForJacksonVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta</b>
         */
        public JakartaVersionAccessors getJakarta() {
            return vaccForJakartaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotest</b>
         */
        public KotestVersionAccessors getKotest() {
            return vaccForKotestVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.kotlin</b>
         */
        public KotlinVersionAccessors getKotlin() {
            return vaccForKotlinVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.log4j</b>
         */
        public Log4jVersionAccessors getLog4j() {
            return vaccForLog4jVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.mockito</b>
         */
        public MockitoVersionAccessors getMockito() {
            return vaccForMockitoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.nl</b>
         */
        public NlVersionAccessors getNl() {
            return vaccForNlVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.reactor</b>
         */
        public ReactorVersionAccessors getReactor() {
            return vaccForReactorVersionAccessors;
        }

    }

    public static class AxonVersionAccessors extends VersionFactory  {

        private final AxonExtensionsVersionAccessors vaccForAxonExtensionsVersionAccessors = new AxonExtensionsVersionAccessors(providers, config);
        public AxonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.axon.extensions</b>
         */
        public AxonExtensionsVersionAccessors getExtensions() {
            return vaccForAxonExtensionsVersionAccessors;
        }

    }

    public static class AxonExtensionsVersionAccessors extends VersionFactory  {

        private final AxonExtensionsSpringVersionAccessors vaccForAxonExtensionsSpringVersionAccessors = new AxonExtensionsSpringVersionAccessors(providers, config);
        public AxonExtensionsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>axon.extensions.reactor</b> with value <b>4.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getReactor() { return getVersion("axon.extensions.reactor"); }

        /**
         * Group of versions at <b>versions.axon.extensions.spring</b>
         */
        public AxonExtensionsSpringVersionAccessors getSpring() {
            return vaccForAxonExtensionsSpringVersionAccessors;
        }

    }

    public static class AxonExtensionsSpringVersionAccessors extends VersionFactory  {

        public AxonExtensionsSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>axon.extensions.spring.aot</b> with value <b>4.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
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
         * Group of versions at <b>versions.com.github</b>
         */
        public ComGithubVersionAccessors getGithub() {
            return vaccForComGithubVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.google</b>
         */
        public ComGoogleVersionAccessors getGoogle() {
            return vaccForComGoogleVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.tngtech</b>
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
         * Group of versions at <b>versions.com.github.avro</b>
         */
        public ComGithubAvroVersionAccessors getAvro() {
            return vaccForComGithubAvroVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.github.ben</b>
         */
        public ComGithubBenVersionAccessors getBen() {
            return vaccForComGithubBenVersionAccessors;
        }

    }

    public static class ComGithubAvroVersionAccessors extends VersionFactory  {

        private final ComGithubAvroKotlinVersionAccessors vaccForComGithubAvroKotlinVersionAccessors = new ComGithubAvroKotlinVersionAccessors(providers, config);
        public ComGithubAvroVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.avro.kotlin</b>
         */
        public ComGithubAvroKotlinVersionAccessors getKotlin() {
            return vaccForComGithubAvroKotlinVersionAccessors;
        }

    }

    public static class ComGithubAvroKotlinVersionAccessors extends VersionFactory  {

        private final ComGithubAvroKotlinAvro4kVersionAccessors vaccForComGithubAvroKotlinAvro4kVersionAccessors = new ComGithubAvroKotlinAvro4kVersionAccessors(providers, config);
        public ComGithubAvroKotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.avro.kotlin.avro4k</b>
         */
        public ComGithubAvroKotlinAvro4kVersionAccessors getAvro4k() {
            return vaccForComGithubAvroKotlinAvro4kVersionAccessors;
        }

    }

    public static class ComGithubAvroKotlinAvro4kVersionAccessors extends VersionFactory  {

        public ComGithubAvroKotlinAvro4kVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.github.avro.kotlin.avro4k.core</b> with value <b>1.10.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("com.github.avro.kotlin.avro4k.core"); }

    }

    public static class ComGithubBenVersionAccessors extends VersionFactory  {

        private final ComGithubBenManesVersionAccessors vaccForComGithubBenManesVersionAccessors = new ComGithubBenManesVersionAccessors(providers, config);
        public ComGithubBenVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.github.ben.manes</b>
         */
        public ComGithubBenManesVersionAccessors getManes() {
            return vaccForComGithubBenManesVersionAccessors;
        }

    }

    public static class ComGithubBenManesVersionAccessors extends VersionFactory  {

        public ComGithubBenManesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.github.ben.manes.versions</b> with value <b>0.51.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getVersions() { return getVersion("com.github.ben.manes.versions"); }

    }

    public static class ComGoogleVersionAccessors extends VersionFactory  {

        private final ComGoogleDevtoolsVersionAccessors vaccForComGoogleDevtoolsVersionAccessors = new ComGoogleDevtoolsVersionAccessors(providers, config);
        public ComGoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.google.devtools</b>
         */
        public ComGoogleDevtoolsVersionAccessors getDevtools() {
            return vaccForComGoogleDevtoolsVersionAccessors;
        }

    }

    public static class ComGoogleDevtoolsVersionAccessors extends VersionFactory  {

        public ComGoogleDevtoolsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.google.devtools.ksp</b> with value <b>1.9.22-1.0.17</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKsp() { return getVersion("com.google.devtools.ksp"); }

    }

    public static class ComTngtechVersionAccessors extends VersionFactory  {

        public ComTngtechVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.tngtech.archunit</b> with value <b>1.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
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
         * Version alias <b>io.kotest</b> with value <b>5.8.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotest() { return getVersion("io.kotest"); }

        /**
         * Group of versions at <b>versions.io.freefair</b>
         */
        public IoFreefairVersionAccessors getFreefair() {
            return vaccForIoFreefairVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io.holixon</b>
         */
        public IoHolixonVersionAccessors getHolixon() {
            return vaccForIoHolixonVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io.mcarle</b>
         */
        public IoMcarleVersionAccessors getMcarle() {
            return vaccForIoMcarleVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io.mongock</b>
         */
        public IoMongockVersionAccessors getMongock() {
            return vaccForIoMongockVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.io.spring</b>
         */
        public IoSpringVersionAccessors getSpring() {
            return vaccForIoSpringVersionAccessors;
        }

    }

    public static class IoFreefairVersionAccessors extends VersionFactory  {

        private final IoFreefairAspectjVersionAccessors vaccForIoFreefairAspectjVersionAccessors = new IoFreefairAspectjVersionAccessors(providers, config);
        public IoFreefairVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.freefair.aspectj</b>
         */
        public IoFreefairAspectjVersionAccessors getAspectj() {
            return vaccForIoFreefairAspectjVersionAccessors;
        }

    }

    public static class IoFreefairAspectjVersionAccessors extends VersionFactory  {

        private final IoFreefairAspectjPostVersionAccessors vaccForIoFreefairAspectjPostVersionAccessors = new IoFreefairAspectjPostVersionAccessors(providers, config);
        public IoFreefairAspectjVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.freefair.aspectj.post</b>
         */
        public IoFreefairAspectjPostVersionAccessors getPost() {
            return vaccForIoFreefairAspectjPostVersionAccessors;
        }

    }

    public static class IoFreefairAspectjPostVersionAccessors extends VersionFactory  {

        private final IoFreefairAspectjPostCompileVersionAccessors vaccForIoFreefairAspectjPostCompileVersionAccessors = new IoFreefairAspectjPostCompileVersionAccessors(providers, config);
        public IoFreefairAspectjPostVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.freefair.aspectj.post.compile</b>
         */
        public IoFreefairAspectjPostCompileVersionAccessors getCompile() {
            return vaccForIoFreefairAspectjPostCompileVersionAccessors;
        }

    }

    public static class IoFreefairAspectjPostCompileVersionAccessors extends VersionFactory  {

        public IoFreefairAspectjPostCompileVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.freefair.aspectj.post.compile.weaving</b> with value <b>8.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWeaving() { return getVersion("io.freefair.aspectj.post.compile.weaving"); }

    }

    public static class IoHolixonVersionAccessors extends VersionFactory  {

        private final IoHolixonAxonVersionAccessors vaccForIoHolixonAxonVersionAccessors = new IoHolixonAxonVersionAccessors(providers, config);
        public IoHolixonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.holixon.axon</b>
         */
        public IoHolixonAxonVersionAccessors getAxon() {
            return vaccForIoHolixonAxonVersionAccessors;
        }

    }

    public static class IoHolixonAxonVersionAccessors extends VersionFactory  {

        private final IoHolixonAxonAvroVersionAccessors vaccForIoHolixonAxonAvroVersionAccessors = new IoHolixonAxonAvroVersionAccessors(providers, config);
        public IoHolixonAxonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.holixon.axon.avro</b>
         */
        public IoHolixonAxonAvroVersionAccessors getAvro() {
            return vaccForIoHolixonAxonAvroVersionAccessors;
        }

    }

    public static class IoHolixonAxonAvroVersionAccessors extends VersionFactory  {

        private final IoHolixonAxonAvroSerializerVersionAccessors vaccForIoHolixonAxonAvroSerializerVersionAccessors = new IoHolixonAxonAvroSerializerVersionAccessors(providers, config);
        public IoHolixonAxonAvroVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.holixon.axon.avro.serializer</b>
         */
        public IoHolixonAxonAvroSerializerVersionAccessors getSerializer() {
            return vaccForIoHolixonAxonAvroSerializerVersionAccessors;
        }

    }

    public static class IoHolixonAxonAvroSerializerVersionAccessors extends VersionFactory  {

        public IoHolixonAxonAvroSerializerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.holixon.axon.avro.serializer.spring</b> with value <b>0.0.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSpring() { return getVersion("io.holixon.axon.avro.serializer.spring"); }

    }

    public static class IoMcarleVersionAccessors extends VersionFactory  {

        private final IoMcarleKonvertVersionAccessors vaccForIoMcarleKonvertVersionAccessors = new IoMcarleKonvertVersionAccessors(providers, config);
        public IoMcarleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.mcarle.konvert</b>
         */
        public IoMcarleKonvertVersionAccessors getKonvert() {
            return vaccForIoMcarleKonvertVersionAccessors;
        }

    }

    public static class IoMcarleKonvertVersionAccessors extends VersionFactory  {

        public IoMcarleKonvertVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.mcarle.konvert.api</b> with value <b>3.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("io.mcarle.konvert.api"); }

    }

    public static class IoMongockVersionAccessors extends VersionFactory  {

        public IoMongockVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.mongock.mongock</b> with value <b>5.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMongock() { return getVersion("io.mongock.mongock"); }

    }

    public static class IoSpringVersionAccessors extends VersionFactory  {

        private final IoSpringDependencyVersionAccessors vaccForIoSpringDependencyVersionAccessors = new IoSpringDependencyVersionAccessors(providers, config);
        public IoSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.spring.dependency</b>
         */
        public IoSpringDependencyVersionAccessors getDependency() {
            return vaccForIoSpringDependencyVersionAccessors;
        }

    }

    public static class IoSpringDependencyVersionAccessors extends VersionFactory  {

        public IoSpringDependencyVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.spring.dependency.management</b> with value <b>1.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getManagement() { return getVersion("io.spring.dependency.management"); }

    }

    public static class JacksonVersionAccessors extends VersionFactory  {

        private final JacksonModuleVersionAccessors vaccForJacksonModuleVersionAccessors = new JacksonModuleVersionAccessors(providers, config);
        public JacksonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jackson.module</b>
         */
        public JacksonModuleVersionAccessors getModule() {
            return vaccForJacksonModuleVersionAccessors;
        }

    }

    public static class JacksonModuleVersionAccessors extends VersionFactory  {

        public JacksonModuleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jackson.module.kotlin</b> with value <b>2.16.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("jackson.module.kotlin"); }

    }

    public static class JakartaVersionAccessors extends VersionFactory  {

        private final JakartaValidationVersionAccessors vaccForJakartaValidationVersionAccessors = new JakartaValidationVersionAccessors(providers, config);
        public JakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.validation</b>
         */
        public JakartaValidationVersionAccessors getValidation() {
            return vaccForJakartaValidationVersionAccessors;
        }

    }

    public static class JakartaValidationVersionAccessors extends VersionFactory  {

        public JakartaValidationVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.validation.api</b> with value <b>3.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.validation.api"); }

    }

    public static class KotestVersionAccessors extends VersionFactory  {

        private final KotestExtensionsVersionAccessors vaccForKotestExtensionsVersionAccessors = new KotestExtensionsVersionAccessors(providers, config);
        public KotestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.kotest.extensions</b>
         */
        public KotestExtensionsVersionAccessors getExtensions() {
            return vaccForKotestExtensionsVersionAccessors;
        }

    }

    public static class KotestExtensionsVersionAccessors extends VersionFactory  {

        public KotestExtensionsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotest.extensions.spring</b> with value <b>1.1.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSpring() { return getVersion("kotest.extensions.spring"); }

        /**
         * Version alias <b>kotest.extensions.testcontainers</b> with value <b>2.0.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTestcontainers() { return getVersion("kotest.extensions.testcontainers"); }

    }

    public static class KotlinVersionAccessors extends VersionFactory  {

        private final KotlinLoggingVersionAccessors vaccForKotlinLoggingVersionAccessors = new KotlinLoggingVersionAccessors(providers, config);
        public KotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.kotlin.logging</b>
         */
        public KotlinLoggingVersionAccessors getLogging() {
            return vaccForKotlinLoggingVersionAccessors;
        }

    }

    public static class KotlinLoggingVersionAccessors extends VersionFactory  {

        public KotlinLoggingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlin.logging.jvm</b> with value <b>6.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJvm() { return getVersion("kotlin.logging.jvm"); }

    }

    public static class Log4jVersionAccessors extends VersionFactory  {

        public Log4jVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>log4j.core</b> with value <b>2.23.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCore() { return getVersion("log4j.core"); }

    }

    public static class MockitoVersionAccessors extends VersionFactory  {

        public MockitoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>mockito.kotlin</b> with value <b>5.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("mockito.kotlin"); }

    }

    public static class NlVersionAccessors extends VersionFactory  {

        private final NlLittlerobotsVersionAccessors vaccForNlLittlerobotsVersionAccessors = new NlLittlerobotsVersionAccessors(providers, config);
        public NlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.nl.littlerobots</b>
         */
        public NlLittlerobotsVersionAccessors getLittlerobots() {
            return vaccForNlLittlerobotsVersionAccessors;
        }

    }

    public static class NlLittlerobotsVersionAccessors extends VersionFactory  {

        private final NlLittlerobotsVersionVersionAccessors vaccForNlLittlerobotsVersionVersionAccessors = new NlLittlerobotsVersionVersionAccessors(providers, config);
        public NlLittlerobotsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.nl.littlerobots.version</b>
         */
        public NlLittlerobotsVersionVersionAccessors getVersion() {
            return vaccForNlLittlerobotsVersionVersionAccessors;
        }

    }

    public static class NlLittlerobotsVersionVersionAccessors extends VersionFactory  {

        private final NlLittlerobotsVersionCatalogVersionAccessors vaccForNlLittlerobotsVersionCatalogVersionAccessors = new NlLittlerobotsVersionCatalogVersionAccessors(providers, config);
        public NlLittlerobotsVersionVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.nl.littlerobots.version.catalog</b>
         */
        public NlLittlerobotsVersionCatalogVersionAccessors getCatalog() {
            return vaccForNlLittlerobotsVersionCatalogVersionAccessors;
        }

    }

    public static class NlLittlerobotsVersionCatalogVersionAccessors extends VersionFactory  {

        public NlLittlerobotsVersionCatalogVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>nl.littlerobots.version.catalog.update</b> with value <b>0.8.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
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
         * Version alias <b>org.springdoc</b> with value <b>2.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSpringdoc() { return getVersion("org.springdoc"); }

        /**
         * Version alias <b>org.testcontainers</b> with value <b>1.19.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTestcontainers() { return getVersion("org.testcontainers"); }

        /**
         * Group of versions at <b>versions.org.graalvm</b>
         */
        public OrgGraalvmVersionAccessors getGraalvm() {
            return vaccForOrgGraalvmVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.jetbrains</b>
         */
        public OrgJetbrainsVersionAccessors getJetbrains() {
            return vaccForOrgJetbrainsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.jlleitschuh</b>
         */
        public OrgJlleitschuhVersionAccessors getJlleitschuh() {
            return vaccForOrgJlleitschuhVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.openapi</b>
         */
        public OrgOpenapiVersionAccessors getOpenapi() {
            return vaccForOrgOpenapiVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework</b>
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgGraalvmVersionAccessors extends VersionFactory  {

        private final OrgGraalvmBuildtoolsVersionAccessors vaccForOrgGraalvmBuildtoolsVersionAccessors = new OrgGraalvmBuildtoolsVersionAccessors(providers, config);
        public OrgGraalvmVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.graalvm.buildtools</b>
         */
        public OrgGraalvmBuildtoolsVersionAccessors getBuildtools() {
            return vaccForOrgGraalvmBuildtoolsVersionAccessors;
        }

    }

    public static class OrgGraalvmBuildtoolsVersionAccessors extends VersionFactory  {

        public OrgGraalvmBuildtoolsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.graalvm.buildtools.native</b> with value <b>0.10.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNative() { return getVersion("org.graalvm.buildtools.native"); }

    }

    public static class OrgJetbrainsVersionAccessors extends VersionFactory  {

        public OrgJetbrainsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.jetbrains.annotations</b> with value <b>13.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnnotations() { return getVersion("org.jetbrains.annotations"); }

        /**
         * Version alias <b>org.jetbrains.kotlin</b> with value <b>1.9.22</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("org.jetbrains.kotlin"); }

    }

    public static class OrgJlleitschuhVersionAccessors extends VersionFactory  {

        private final OrgJlleitschuhGradleVersionAccessors vaccForOrgJlleitschuhGradleVersionAccessors = new OrgJlleitschuhGradleVersionAccessors(providers, config);
        public OrgJlleitschuhVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.jlleitschuh.gradle</b>
         */
        public OrgJlleitschuhGradleVersionAccessors getGradle() {
            return vaccForOrgJlleitschuhGradleVersionAccessors;
        }

    }

    public static class OrgJlleitschuhGradleVersionAccessors extends VersionFactory  {

        public OrgJlleitschuhGradleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.jlleitschuh.gradle.ktlint</b> with value <b>12.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKtlint() { return getVersion("org.jlleitschuh.gradle.ktlint"); }

    }

    public static class OrgOpenapiVersionAccessors extends VersionFactory  {

        public OrgOpenapiVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.openapi.generator</b> with value <b>7.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGenerator() { return getVersion("org.openapi.generator"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot</b> with value <b>3.2.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBoot() { return getVersion("org.springframework.boot"); }

        /**
         * Version alias <b>org.springframework.hateoas</b> with value <b>2.2.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getHateoas() { return getVersion("org.springframework.hateoas"); }

    }

    public static class ReactorVersionAccessors extends VersionFactory  {

        private final ReactorKotlinVersionAccessors vaccForReactorKotlinVersionAccessors = new ReactorKotlinVersionAccessors(providers, config);
        public ReactorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>reactor.kafka</b> with value <b>1.3.22</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKafka() { return getVersion("reactor.kafka"); }

        /**
         * Version alias <b>reactor.test</b> with value <b>3.6.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("reactor.test"); }

        /**
         * Group of versions at <b>versions.reactor.kotlin</b>
         */
        public ReactorKotlinVersionAccessors getKotlin() {
            return vaccForReactorKotlinVersionAccessors;
        }

    }

    public static class ReactorKotlinVersionAccessors extends VersionFactory  {

        public ReactorKotlinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>reactor.kotlin.extensions</b> with value <b>1.2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
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
         * Group of plugins at <b>plugins.com</b>
         */
        public ComPluginAccessors getCom() {
            return paccForComPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.io</b>
         */
        public IoPluginAccessors getIo() {
            return paccForIoPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.nl</b>
         */
        public NlPluginAccessors getNl() {
            return paccForNlPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.org</b>
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
         * Group of plugins at <b>plugins.com.github</b>
         */
        public ComGithubPluginAccessors getGithub() {
            return paccForComGithubPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.com.google</b>
         */
        public ComGooglePluginAccessors getGoogle() {
            return paccForComGooglePluginAccessors;
        }

    }

    public static class ComGithubPluginAccessors extends PluginFactory {
        private final ComGithubBenPluginAccessors paccForComGithubBenPluginAccessors = new ComGithubBenPluginAccessors(providers, config);

        public ComGithubPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.com.github.ben</b>
         */
        public ComGithubBenPluginAccessors getBen() {
            return paccForComGithubBenPluginAccessors;
        }

    }

    public static class ComGithubBenPluginAccessors extends PluginFactory {
        private final ComGithubBenManesPluginAccessors paccForComGithubBenManesPluginAccessors = new ComGithubBenManesPluginAccessors(providers, config);

        public ComGithubBenPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.com.github.ben.manes</b>
         */
        public ComGithubBenManesPluginAccessors getManes() {
            return paccForComGithubBenManesPluginAccessors;
        }

    }

    public static class ComGithubBenManesPluginAccessors extends PluginFactory {

        public ComGithubBenManesPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>com.github.ben.manes.versions</b> with plugin id <b>com.github.ben-manes.versions</b> and
         * with version reference <b>com.github.ben.manes.versions</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getVersions() { return createPlugin("com.github.ben.manes.versions"); }

    }

    public static class ComGooglePluginAccessors extends PluginFactory {
        private final ComGoogleDevtoolsPluginAccessors paccForComGoogleDevtoolsPluginAccessors = new ComGoogleDevtoolsPluginAccessors(providers, config);

        public ComGooglePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.com.google.devtools</b>
         */
        public ComGoogleDevtoolsPluginAccessors getDevtools() {
            return paccForComGoogleDevtoolsPluginAccessors;
        }

    }

    public static class ComGoogleDevtoolsPluginAccessors extends PluginFactory {

        public ComGoogleDevtoolsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>com.google.devtools.ksp</b> with plugin id <b>com.google.devtools.ksp</b> and
         * with version reference <b>com.google.devtools.ksp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKsp() { return createPlugin("com.google.devtools.ksp"); }

    }

    public static class IoPluginAccessors extends PluginFactory {
        private final IoFreefairPluginAccessors paccForIoFreefairPluginAccessors = new IoFreefairPluginAccessors(providers, config);
        private final IoSpringPluginAccessors paccForIoSpringPluginAccessors = new IoSpringPluginAccessors(providers, config);

        public IoPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.io.freefair</b>
         */
        public IoFreefairPluginAccessors getFreefair() {
            return paccForIoFreefairPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.io.spring</b>
         */
        public IoSpringPluginAccessors getSpring() {
            return paccForIoSpringPluginAccessors;
        }

    }

    public static class IoFreefairPluginAccessors extends PluginFactory {
        private final IoFreefairAspectjPluginAccessors paccForIoFreefairAspectjPluginAccessors = new IoFreefairAspectjPluginAccessors(providers, config);

        public IoFreefairPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.io.freefair.aspectj</b>
         */
        public IoFreefairAspectjPluginAccessors getAspectj() {
            return paccForIoFreefairAspectjPluginAccessors;
        }

    }

    public static class IoFreefairAspectjPluginAccessors extends PluginFactory {
        private final IoFreefairAspectjPostPluginAccessors paccForIoFreefairAspectjPostPluginAccessors = new IoFreefairAspectjPostPluginAccessors(providers, config);

        public IoFreefairAspectjPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.io.freefair.aspectj.post</b>
         */
        public IoFreefairAspectjPostPluginAccessors getPost() {
            return paccForIoFreefairAspectjPostPluginAccessors;
        }

    }

    public static class IoFreefairAspectjPostPluginAccessors extends PluginFactory {
        private final IoFreefairAspectjPostCompilePluginAccessors paccForIoFreefairAspectjPostCompilePluginAccessors = new IoFreefairAspectjPostCompilePluginAccessors(providers, config);

        public IoFreefairAspectjPostPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.io.freefair.aspectj.post.compile</b>
         */
        public IoFreefairAspectjPostCompilePluginAccessors getCompile() {
            return paccForIoFreefairAspectjPostCompilePluginAccessors;
        }

    }

    public static class IoFreefairAspectjPostCompilePluginAccessors extends PluginFactory {

        public IoFreefairAspectjPostCompilePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>io.freefair.aspectj.post.compile.weaving</b> with plugin id <b>io.freefair.aspectj.post-compile-weaving</b> and
         * with version reference <b>io.freefair.aspectj.post.compile.weaving</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getWeaving() { return createPlugin("io.freefair.aspectj.post.compile.weaving"); }

    }

    public static class IoSpringPluginAccessors extends PluginFactory {
        private final IoSpringDependencyPluginAccessors paccForIoSpringDependencyPluginAccessors = new IoSpringDependencyPluginAccessors(providers, config);

        public IoSpringPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.io.spring.dependency</b>
         */
        public IoSpringDependencyPluginAccessors getDependency() {
            return paccForIoSpringDependencyPluginAccessors;
        }

    }

    public static class IoSpringDependencyPluginAccessors extends PluginFactory {

        public IoSpringDependencyPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>io.spring.dependency.management</b> with plugin id <b>io.spring.dependency-management</b> and
         * with version reference <b>io.spring.dependency.management</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getManagement() { return createPlugin("io.spring.dependency.management"); }

    }

    public static class NlPluginAccessors extends PluginFactory {
        private final NlLittlerobotsPluginAccessors paccForNlLittlerobotsPluginAccessors = new NlLittlerobotsPluginAccessors(providers, config);

        public NlPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.nl.littlerobots</b>
         */
        public NlLittlerobotsPluginAccessors getLittlerobots() {
            return paccForNlLittlerobotsPluginAccessors;
        }

    }

    public static class NlLittlerobotsPluginAccessors extends PluginFactory {
        private final NlLittlerobotsVersionPluginAccessors paccForNlLittlerobotsVersionPluginAccessors = new NlLittlerobotsVersionPluginAccessors(providers, config);

        public NlLittlerobotsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.nl.littlerobots.version</b>
         */
        public NlLittlerobotsVersionPluginAccessors getVersion() {
            return paccForNlLittlerobotsVersionPluginAccessors;
        }

    }

    public static class NlLittlerobotsVersionPluginAccessors extends PluginFactory {
        private final NlLittlerobotsVersionCatalogPluginAccessors paccForNlLittlerobotsVersionCatalogPluginAccessors = new NlLittlerobotsVersionCatalogPluginAccessors(providers, config);

        public NlLittlerobotsVersionPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.nl.littlerobots.version.catalog</b>
         */
        public NlLittlerobotsVersionCatalogPluginAccessors getCatalog() {
            return paccForNlLittlerobotsVersionCatalogPluginAccessors;
        }

    }

    public static class NlLittlerobotsVersionCatalogPluginAccessors extends PluginFactory {

        public NlLittlerobotsVersionCatalogPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>nl.littlerobots.version.catalog.update</b> with plugin id <b>nl.littlerobots.version-catalog-update</b> and
         * with version reference <b>nl.littlerobots.version.catalog.update</b>
         * <p>
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
         * Group of plugins at <b>plugins.org.graalvm</b>
         */
        public OrgGraalvmPluginAccessors getGraalvm() {
            return paccForOrgGraalvmPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.org.jetbrains</b>
         */
        public OrgJetbrainsPluginAccessors getJetbrains() {
            return paccForOrgJetbrainsPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.org.jlleitschuh</b>
         */
        public OrgJlleitschuhPluginAccessors getJlleitschuh() {
            return paccForOrgJlleitschuhPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.org.openapi</b>
         */
        public OrgOpenapiPluginAccessors getOpenapi() {
            return paccForOrgOpenapiPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.org.springframework</b>
         */
        public OrgSpringframeworkPluginAccessors getSpringframework() {
            return paccForOrgSpringframeworkPluginAccessors;
        }

    }

    public static class OrgGraalvmPluginAccessors extends PluginFactory {
        private final OrgGraalvmBuildtoolsPluginAccessors paccForOrgGraalvmBuildtoolsPluginAccessors = new OrgGraalvmBuildtoolsPluginAccessors(providers, config);

        public OrgGraalvmPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.org.graalvm.buildtools</b>
         */
        public OrgGraalvmBuildtoolsPluginAccessors getBuildtools() {
            return paccForOrgGraalvmBuildtoolsPluginAccessors;
        }

    }

    public static class OrgGraalvmBuildtoolsPluginAccessors extends PluginFactory {

        public OrgGraalvmBuildtoolsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>org.graalvm.buildtools.native</b> with plugin id <b>org.graalvm.buildtools.native</b> and
         * with version reference <b>org.graalvm.buildtools.native</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getNative() { return createPlugin("org.graalvm.buildtools.native"); }

    }

    public static class OrgJetbrainsPluginAccessors extends PluginFactory {
        private final OrgJetbrainsKotlinPluginAccessors paccForOrgJetbrainsKotlinPluginAccessors = new OrgJetbrainsKotlinPluginAccessors(providers, config);

        public OrgJetbrainsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.org.jetbrains.kotlin</b>
         */
        public OrgJetbrainsKotlinPluginAccessors getKotlin() {
            return paccForOrgJetbrainsKotlinPluginAccessors;
        }

    }

    public static class OrgJetbrainsKotlinPluginAccessors extends PluginFactory {
        private final OrgJetbrainsKotlinPluginPluginAccessors paccForOrgJetbrainsKotlinPluginPluginAccessors = new OrgJetbrainsKotlinPluginPluginAccessors(providers, config);

        public OrgJetbrainsKotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>org.jetbrains.kotlin.jvm</b> with plugin id <b>org.jetbrains.kotlin.jvm</b> and
         * with version reference <b>org.jetbrains.kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getJvm() { return createPlugin("org.jetbrains.kotlin.jvm"); }

        /**
         * Group of plugins at <b>plugins.org.jetbrains.kotlin.plugin</b>
         */
        public OrgJetbrainsKotlinPluginPluginAccessors getPlugin() {
            return paccForOrgJetbrainsKotlinPluginPluginAccessors;
        }

    }

    public static class OrgJetbrainsKotlinPluginPluginAccessors extends PluginFactory {

        public OrgJetbrainsKotlinPluginPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>org.jetbrains.kotlin.plugin.allopen</b> with plugin id <b>org.jetbrains.kotlin.plugin.allopen</b> and
         * with version reference <b>org.jetbrains.kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAllopen() { return createPlugin("org.jetbrains.kotlin.plugin.allopen"); }

        /**
         * Plugin provider for <b>org.jetbrains.kotlin.plugin.spring</b> with plugin id <b>org.jetbrains.kotlin.plugin.spring</b> and
         * with version reference <b>org.jetbrains.kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getSpring() { return createPlugin("org.jetbrains.kotlin.plugin.spring"); }

    }

    public static class OrgJlleitschuhPluginAccessors extends PluginFactory {
        private final OrgJlleitschuhGradlePluginAccessors paccForOrgJlleitschuhGradlePluginAccessors = new OrgJlleitschuhGradlePluginAccessors(providers, config);

        public OrgJlleitschuhPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.org.jlleitschuh.gradle</b>
         */
        public OrgJlleitschuhGradlePluginAccessors getGradle() {
            return paccForOrgJlleitschuhGradlePluginAccessors;
        }

    }

    public static class OrgJlleitschuhGradlePluginAccessors extends PluginFactory {

        public OrgJlleitschuhGradlePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>org.jlleitschuh.gradle.ktlint</b> with plugin id <b>org.jlleitschuh.gradle.ktlint</b> and
         * with version reference <b>org.jlleitschuh.gradle.ktlint</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getKtlint() { return createPlugin("org.jlleitschuh.gradle.ktlint"); }

    }

    public static class OrgOpenapiPluginAccessors extends PluginFactory {

        public OrgOpenapiPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>org.openapi.generator</b> with plugin id <b>org.openapi.generator</b> and
         * with version reference <b>org.openapi.generator</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getGenerator() { return createPlugin("org.openapi.generator"); }

    }

    public static class OrgSpringframeworkPluginAccessors extends PluginFactory {

        public OrgSpringframeworkPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>org.springframework.boot</b> with plugin id <b>org.springframework.boot</b> and
         * with version reference <b>org.springframework.boot</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getBoot() { return createPlugin("org.springframework.boot"); }

    }

}
