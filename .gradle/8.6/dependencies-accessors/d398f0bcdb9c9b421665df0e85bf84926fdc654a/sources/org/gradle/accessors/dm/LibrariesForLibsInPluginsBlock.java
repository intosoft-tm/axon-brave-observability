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
public class LibrariesForLibsInPluginsBlock extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final IoLibraryAccessors laccForIoLibraryAccessors = new IoLibraryAccessors(owner);
    private final JakartaLibraryAccessors laccForJakartaLibraryAccessors = new JakartaLibraryAccessors(owner);
    private final MeLibraryAccessors laccForMeLibraryAccessors = new MeLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibsInPluginsBlock(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public ComLibraryAccessors getCom() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>io</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public IoLibraryAccessors getIo() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForIoLibraryAccessors;
    }

    /**
     * Group of libraries at <b>jakarta</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public JakartaLibraryAccessors getJakarta() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForJakartaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>me</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public MeLibraryAccessors getMe() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return laccForMeLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public OrgLibraryAccessors getOrg() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
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
     *
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public BundleAccessors getBundles() {
        org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlLibraryAccessors laccForComFasterxmlLibraryAccessors = new ComFasterxmlLibraryAccessors(owner);
        private final ComGithubLibraryAccessors laccForComGithubLibraryAccessors = new ComGithubLibraryAccessors(owner);
        private final ComGoogleLibraryAccessors laccForComGoogleLibraryAccessors = new ComGoogleLibraryAccessors(owner);
        private final ComTngtechLibraryAccessors laccForComTngtechLibraryAccessors = new ComTngtechLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComFasterxmlLibraryAccessors getFasterxml() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComFasterxmlLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.github</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGithubLibraryAccessors getGithub() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGithubLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.google</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleLibraryAccessors getGoogle() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.tngtech</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComTngtechLibraryAccessors getTngtech() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComTngtechLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComFasterxmlLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonLibraryAccessors laccForComFasterxmlJacksonLibraryAccessors = new ComFasterxmlJacksonLibraryAccessors(owner);

        public ComFasterxmlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComFasterxmlJacksonLibraryAccessors getJackson() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComFasterxmlJacksonLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComFasterxmlJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleLibraryAccessors laccForComFasterxmlJacksonModuleLibraryAccessors = new ComFasterxmlJacksonModuleLibraryAccessors(owner);

        public ComFasterxmlJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.module</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComFasterxmlJacksonModuleLibraryAccessors getModule() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComFasterxmlJacksonModuleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComFasterxmlJacksonModuleLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleJacksonLibraryAccessors laccForComFasterxmlJacksonModuleJacksonLibraryAccessors = new ComFasterxmlJacksonModuleJacksonLibraryAccessors(owner);

        public ComFasterxmlJacksonModuleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.module.jackson</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComFasterxmlJacksonModuleJacksonLibraryAccessors getJackson() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComFasterxmlJacksonModuleJacksonLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComFasterxmlJacksonModuleJacksonLibraryAccessors extends SubDependencyFactory {
        private final ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors laccForComFasterxmlJacksonModuleJacksonModuleLibraryAccessors = new ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors(owner);

        public ComFasterxmlJacksonModuleJacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.fasterxml.jackson.module.jackson.module</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors getModule() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComFasterxmlJacksonModuleJacksonModuleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors extends SubDependencyFactory {

        public ComFasterxmlJacksonModuleJacksonModuleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kotlin</b> with <b>com.fasterxml.jackson.module:jackson-module-kotlin</b> coordinates and
         * with version reference <b>jackson.module.kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.fasterxml.jackson.module.jackson.module.kotlin");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGithubLibraryAccessors extends SubDependencyFactory {
        private final ComGithubAvroLibraryAccessors laccForComGithubAvroLibraryAccessors = new ComGithubAvroLibraryAccessors(owner);

        public ComGithubLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.avro</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGithubAvroLibraryAccessors getAvro() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGithubAvroLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGithubAvroLibraryAccessors extends SubDependencyFactory {
        private final ComGithubAvroKotlinLibraryAccessors laccForComGithubAvroKotlinLibraryAccessors = new ComGithubAvroKotlinLibraryAccessors(owner);

        public ComGithubAvroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.avro.kotlin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGithubAvroKotlinLibraryAccessors getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGithubAvroKotlinLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGithubAvroKotlinLibraryAccessors extends SubDependencyFactory {
        private final ComGithubAvroKotlinAvro4kLibraryAccessors laccForComGithubAvroKotlinAvro4kLibraryAccessors = new ComGithubAvroKotlinAvro4kLibraryAccessors(owner);

        public ComGithubAvroKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.github.avro.kotlin.avro4k</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGithubAvroKotlinAvro4kLibraryAccessors getAvro4k() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGithubAvroKotlinAvro4kLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGithubAvroKotlinAvro4kLibraryAccessors extends SubDependencyFactory {

        public ComGithubAvroKotlinAvro4kLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>com.github.avro-kotlin.avro4k:avro4k-core</b> coordinates and
         * with version reference <b>com.github.avro.kotlin.avro4k.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.github.avro.kotlin.avro4k.core");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsLibraryAccessors laccForComGoogleDevtoolsLibraryAccessors = new ComGoogleDevtoolsLibraryAccessors(owner);

        public ComGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.devtools</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleDevtoolsLibraryAccessors getDevtools() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleDevtoolsLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleDevtoolsLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspLibraryAccessors laccForComGoogleDevtoolsKspLibraryAccessors = new ComGoogleDevtoolsKspLibraryAccessors(owner);

        public ComGoogleDevtoolsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.devtools.ksp</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleDevtoolsKspLibraryAccessors getKsp() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleDevtoolsKspLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleDevtoolsKspLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspSymbolLibraryAccessors laccForComGoogleDevtoolsKspSymbolLibraryAccessors = new ComGoogleDevtoolsKspSymbolLibraryAccessors(owner);

        public ComGoogleDevtoolsKspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.devtools.ksp.symbol</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleDevtoolsKspSymbolLibraryAccessors getSymbol() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleDevtoolsKspSymbolLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleDevtoolsKspSymbolLibraryAccessors extends SubDependencyFactory {
        private final ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors laccForComGoogleDevtoolsKspSymbolProcessingLibraryAccessors = new ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors(owner);

        public ComGoogleDevtoolsKspSymbolLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.google.devtools.ksp.symbol.processing</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors getProcessing() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComGoogleDevtoolsKspSymbolProcessingLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors extends SubDependencyFactory {

        public ComGoogleDevtoolsKspSymbolProcessingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>com.google.devtools.ksp:symbol-processing-api</b> coordinates and
         * with version reference <b>com.google.devtools.ksp</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.google.devtools.ksp.symbol.processing.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComTngtechLibraryAccessors extends SubDependencyFactory {
        private final ComTngtechArchunitLibraryAccessors laccForComTngtechArchunitLibraryAccessors = new ComTngtechArchunitLibraryAccessors(owner);

        public ComTngtechLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.tngtech.archunit</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComTngtechArchunitLibraryAccessors getArchunit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComTngtechArchunitLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComTngtechArchunitLibraryAccessors extends SubDependencyFactory {
        private final ComTngtechArchunitArchunitLibraryAccessors laccForComTngtechArchunitArchunitLibraryAccessors = new ComTngtechArchunitArchunitLibraryAccessors(owner);

        public ComTngtechArchunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.tngtech.archunit.archunit</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComTngtechArchunitArchunitLibraryAccessors getArchunit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComTngtechArchunitArchunitLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComTngtechArchunitArchunitLibraryAccessors extends SubDependencyFactory {
        private final ComTngtechArchunitArchunitJunit5LibraryAccessors laccForComTngtechArchunitArchunitJunit5LibraryAccessors = new ComTngtechArchunitArchunitJunit5LibraryAccessors(owner);

        public ComTngtechArchunitArchunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.tngtech.archunit.archunit.junit5</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public ComTngtechArchunitArchunitJunit5LibraryAccessors getJunit5() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForComTngtechArchunitArchunitJunit5LibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class ComTngtechArchunitArchunitJunit5LibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public ComTngtechArchunitArchunitJunit5LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit5</b> with <b>com.tngtech.archunit:archunit-junit5</b> coordinates and
         * with version reference <b>com.tngtech.archunit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.tngtech.archunit.archunit.junit5");
        }

        /**
         * Dependency provider for <b>api</b> with <b>com.tngtech.archunit:archunit-junit5-api</b> coordinates and
         * with version reference <b>com.tngtech.archunit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("com.tngtech.archunit.archunit.junit5.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoLibraryAccessors extends SubDependencyFactory {
        private final IoAxoniqLibraryAccessors laccForIoAxoniqLibraryAccessors = new IoAxoniqLibraryAccessors(owner);
        private final IoGithubLibraryAccessors laccForIoGithubLibraryAccessors = new IoGithubLibraryAccessors(owner);
        private final IoHolixonLibraryAccessors laccForIoHolixonLibraryAccessors = new IoHolixonLibraryAccessors(owner);
        private final IoKotestLibraryAccessors laccForIoKotestLibraryAccessors = new IoKotestLibraryAccessors(owner);
        private final IoMcarleLibraryAccessors laccForIoMcarleLibraryAccessors = new IoMcarleLibraryAccessors(owner);
        private final IoMicrometerLibraryAccessors laccForIoMicrometerLibraryAccessors = new IoMicrometerLibraryAccessors(owner);
        private final IoMongockLibraryAccessors laccForIoMongockLibraryAccessors = new IoMongockLibraryAccessors(owner);
        private final IoProjectreactorLibraryAccessors laccForIoProjectreactorLibraryAccessors = new IoProjectreactorLibraryAccessors(owner);
        private final IoZipkinLibraryAccessors laccForIoZipkinLibraryAccessors = new IoZipkinLibraryAccessors(owner);

        public IoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.axoniq</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoAxoniqLibraryAccessors getAxoniq() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoAxoniqLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.github</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoGithubLibraryAccessors getGithub() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoGithubLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.holixon</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoHolixonLibraryAccessors getHolixon() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoHolixonLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.kotest</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoKotestLibraryAccessors getKotest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoKotestLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.mcarle</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMcarleLibraryAccessors getMcarle() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMcarleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.micrometer</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMicrometerLibraryAccessors getMicrometer() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMicrometerLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.mongock</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMongockLibraryAccessors getMongock() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMongockLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.projectreactor</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoProjectreactorLibraryAccessors getProjectreactor() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoProjectreactorLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.zipkin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoZipkinLibraryAccessors getZipkin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoZipkinLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoAxoniqLibraryAccessors extends SubDependencyFactory {
        private final IoAxoniqConsoleLibraryAccessors laccForIoAxoniqConsoleLibraryAccessors = new IoAxoniqConsoleLibraryAccessors(owner);

        public IoAxoniqLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.axoniq.console</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoAxoniqConsoleLibraryAccessors getConsole() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoAxoniqConsoleLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoAxoniqConsoleLibraryAccessors extends SubDependencyFactory {
        private final IoAxoniqConsoleFrameworkLibraryAccessors laccForIoAxoniqConsoleFrameworkLibraryAccessors = new IoAxoniqConsoleFrameworkLibraryAccessors(owner);

        public IoAxoniqConsoleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.axoniq.console.framework</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoAxoniqConsoleFrameworkLibraryAccessors getFramework() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoAxoniqConsoleFrameworkLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoAxoniqConsoleFrameworkLibraryAccessors extends SubDependencyFactory {
        private final IoAxoniqConsoleFrameworkClientLibraryAccessors laccForIoAxoniqConsoleFrameworkClientLibraryAccessors = new IoAxoniqConsoleFrameworkClientLibraryAccessors(owner);

        public IoAxoniqConsoleFrameworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.axoniq.console.framework.client</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoAxoniqConsoleFrameworkClientLibraryAccessors getClient() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoAxoniqConsoleFrameworkClientLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoAxoniqConsoleFrameworkClientLibraryAccessors extends SubDependencyFactory {
        private final IoAxoniqConsoleFrameworkClientSpringLibraryAccessors laccForIoAxoniqConsoleFrameworkClientSpringLibraryAccessors = new IoAxoniqConsoleFrameworkClientSpringLibraryAccessors(owner);

        public IoAxoniqConsoleFrameworkClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.axoniq.console.framework.client.spring</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoAxoniqConsoleFrameworkClientSpringLibraryAccessors getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoAxoniqConsoleFrameworkClientSpringLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoAxoniqConsoleFrameworkClientSpringLibraryAccessors extends SubDependencyFactory {
        private final IoAxoniqConsoleFrameworkClientSpringBootLibraryAccessors laccForIoAxoniqConsoleFrameworkClientSpringBootLibraryAccessors = new IoAxoniqConsoleFrameworkClientSpringBootLibraryAccessors(owner);

        public IoAxoniqConsoleFrameworkClientSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.axoniq.console.framework.client.spring.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoAxoniqConsoleFrameworkClientSpringBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoAxoniqConsoleFrameworkClientSpringBootLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoAxoniqConsoleFrameworkClientSpringBootLibraryAccessors extends SubDependencyFactory {

        public IoAxoniqConsoleFrameworkClientSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>starter</b> with <b>io.axoniq.console:console-framework-client-spring-boot-starter</b> coordinates and
         * with version reference <b>io.axoniq.console.framework.client.spring.boot.starter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getStarter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.axoniq.console.framework.client.spring.boot.starter");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoGithubLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiLibraryAccessors laccForIoGithubOshaiLibraryAccessors = new IoGithubOshaiLibraryAccessors(owner);

        public IoGithubLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.github.oshai</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoGithubOshaiLibraryAccessors getOshai() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoGithubOshaiLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoGithubOshaiLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiKotlinLibraryAccessors laccForIoGithubOshaiKotlinLibraryAccessors = new IoGithubOshaiKotlinLibraryAccessors(owner);

        public IoGithubOshaiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.github.oshai.kotlin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoGithubOshaiKotlinLibraryAccessors getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoGithubOshaiKotlinLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoGithubOshaiKotlinLibraryAccessors extends SubDependencyFactory {
        private final IoGithubOshaiKotlinLoggingLibraryAccessors laccForIoGithubOshaiKotlinLoggingLibraryAccessors = new IoGithubOshaiKotlinLoggingLibraryAccessors(owner);

        public IoGithubOshaiKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.github.oshai.kotlin.logging</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoGithubOshaiKotlinLoggingLibraryAccessors getLogging() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoGithubOshaiKotlinLoggingLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoGithubOshaiKotlinLoggingLibraryAccessors extends SubDependencyFactory {

        public IoGithubOshaiKotlinLoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jvm</b> with <b>io.github.oshai:kotlin-logging-jvm</b> coordinates and
         * with version reference <b>kotlin.logging.jvm</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJvm() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.github.oshai.kotlin.logging.jvm");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoHolixonLibraryAccessors extends SubDependencyFactory {
        private final IoHolixonAxonLibraryAccessors laccForIoHolixonAxonLibraryAccessors = new IoHolixonAxonLibraryAccessors(owner);

        public IoHolixonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.holixon.axon</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoHolixonAxonLibraryAccessors getAxon() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoHolixonAxonLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoHolixonAxonLibraryAccessors extends SubDependencyFactory {
        private final IoHolixonAxonAvroLibraryAccessors laccForIoHolixonAxonAvroLibraryAccessors = new IoHolixonAxonAvroLibraryAccessors(owner);

        public IoHolixonAxonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.holixon.axon.avro</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoHolixonAxonAvroLibraryAccessors getAvro() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoHolixonAxonAvroLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoHolixonAxonAvroLibraryAccessors extends SubDependencyFactory {
        private final IoHolixonAxonAvroSerializerLibraryAccessors laccForIoHolixonAxonAvroSerializerLibraryAccessors = new IoHolixonAxonAvroSerializerLibraryAccessors(owner);

        public IoHolixonAxonAvroLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.holixon.axon.avro.serializer</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoHolixonAxonAvroSerializerLibraryAccessors getSerializer() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoHolixonAxonAvroSerializerLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoHolixonAxonAvroSerializerLibraryAccessors extends SubDependencyFactory {

        public IoHolixonAxonAvroSerializerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>spring</b> with <b>io.holixon.axon.avro:axon-avro-serializer-spring</b> coordinates and
         * with version reference <b>io.holixon.axon.avro.serializer.spring</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.holixon.axon.avro.serializer.spring");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoKotestLibraryAccessors extends SubDependencyFactory {
        private final IoKotestExtensionsLibraryAccessors laccForIoKotestExtensionsLibraryAccessors = new IoKotestExtensionsLibraryAccessors(owner);
        private final IoKotestKotestLibraryAccessors laccForIoKotestKotestLibraryAccessors = new IoKotestKotestLibraryAccessors(owner);

        public IoKotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.kotest.extensions</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoKotestExtensionsLibraryAccessors getExtensions() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoKotestExtensionsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.kotest.kotest</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoKotestKotestLibraryAccessors getKotest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoKotestKotestLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoKotestExtensionsLibraryAccessors extends SubDependencyFactory {
        private final IoKotestExtensionsKotestLibraryAccessors laccForIoKotestExtensionsKotestLibraryAccessors = new IoKotestExtensionsKotestLibraryAccessors(owner);

        public IoKotestExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.kotest.extensions.kotest</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoKotestExtensionsKotestLibraryAccessors getKotest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoKotestExtensionsKotestLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoKotestExtensionsKotestLibraryAccessors extends SubDependencyFactory {
        private final IoKotestExtensionsKotestExtensionsLibraryAccessors laccForIoKotestExtensionsKotestExtensionsLibraryAccessors = new IoKotestExtensionsKotestExtensionsLibraryAccessors(owner);

        public IoKotestExtensionsKotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.kotest.extensions.kotest.extensions</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoKotestExtensionsKotestExtensionsLibraryAccessors getExtensions() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoKotestExtensionsKotestExtensionsLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoKotestExtensionsKotestExtensionsLibraryAccessors extends SubDependencyFactory {

        public IoKotestExtensionsKotestExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>spring</b> with <b>io.kotest.extensions:kotest-extensions-spring</b> coordinates and
         * with version reference <b>kotest.extensions.spring</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.kotest.extensions.kotest.extensions.spring");
        }

        /**
         * Dependency provider for <b>testcontainers</b> with <b>io.kotest.extensions:kotest-extensions-testcontainers</b> coordinates and
         * with version reference <b>kotest.extensions.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTestcontainers() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.kotest.extensions.kotest.extensions.testcontainers");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoKotestKotestLibraryAccessors extends SubDependencyFactory {
        private final IoKotestKotestAssertionsLibraryAccessors laccForIoKotestKotestAssertionsLibraryAccessors = new IoKotestKotestAssertionsLibraryAccessors(owner);
        private final IoKotestKotestRunnerLibraryAccessors laccForIoKotestKotestRunnerLibraryAccessors = new IoKotestKotestRunnerLibraryAccessors(owner);

        public IoKotestKotestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>property</b> with <b>io.kotest:kotest-property</b> coordinates and
         * with version reference <b>io.kotest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getProperty() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.kotest.kotest.property");
        }

        /**
         * Group of libraries at <b>io.kotest.kotest.assertions</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoKotestKotestAssertionsLibraryAccessors getAssertions() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoKotestKotestAssertionsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.kotest.kotest.runner</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoKotestKotestRunnerLibraryAccessors getRunner() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoKotestKotestRunnerLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoKotestKotestAssertionsLibraryAccessors extends SubDependencyFactory {

        public IoKotestKotestAssertionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>io.kotest:kotest-assertions-core</b> coordinates and
         * with version reference <b>io.kotest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.kotest.kotest.assertions.core");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoKotestKotestRunnerLibraryAccessors extends SubDependencyFactory {

        public IoKotestKotestRunnerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit5</b> with <b>io.kotest:kotest-runner-junit5</b> coordinates and
         * with version reference <b>io.kotest</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJunit5() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.kotest.kotest.runner.junit5");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMcarleLibraryAccessors extends SubDependencyFactory {
        private final IoMcarleKonvertLibraryAccessors laccForIoMcarleKonvertLibraryAccessors = new IoMcarleKonvertLibraryAccessors(owner);

        public IoMcarleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.mcarle.konvert</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMcarleKonvertLibraryAccessors getKonvert() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMcarleKonvertLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMcarleKonvertLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public IoMcarleKonvertLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>konvert</b> with <b>io.mcarle:konvert</b> coordinates and
         * with version reference <b>io.mcarle.konvert.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.mcarle.konvert");
        }

        /**
         * Dependency provider for <b>api</b> with <b>io.mcarle:konvert-api</b> coordinates and
         * with version reference <b>io.mcarle.konvert.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.mcarle.konvert.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMicrometerLibraryAccessors extends SubDependencyFactory {
        private final IoMicrometerMicrometerLibraryAccessors laccForIoMicrometerMicrometerLibraryAccessors = new IoMicrometerMicrometerLibraryAccessors(owner);

        public IoMicrometerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.micrometer.micrometer</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMicrometerMicrometerLibraryAccessors getMicrometer() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMicrometerMicrometerLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMicrometerMicrometerLibraryAccessors extends SubDependencyFactory {
        private final IoMicrometerMicrometerRegistryLibraryAccessors laccForIoMicrometerMicrometerRegistryLibraryAccessors = new IoMicrometerMicrometerRegistryLibraryAccessors(owner);
        private final IoMicrometerMicrometerTracingLibraryAccessors laccForIoMicrometerMicrometerTracingLibraryAccessors = new IoMicrometerMicrometerTracingLibraryAccessors(owner);

        public IoMicrometerMicrometerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.micrometer.micrometer.registry</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMicrometerMicrometerRegistryLibraryAccessors getRegistry() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMicrometerMicrometerRegistryLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.micrometer.micrometer.tracing</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMicrometerMicrometerTracingLibraryAccessors getTracing() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMicrometerMicrometerTracingLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMicrometerMicrometerRegistryLibraryAccessors extends SubDependencyFactory {

        public IoMicrometerMicrometerRegistryLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>prometheus</b> with <b>io.micrometer:micrometer-registry-prometheus</b> coordinates and
         * with version reference <b>micrometer.registry.prometheus</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getPrometheus() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.micrometer.micrometer.registry.prometheus");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMicrometerMicrometerTracingLibraryAccessors extends SubDependencyFactory {
        private final IoMicrometerMicrometerTracingBridgeLibraryAccessors laccForIoMicrometerMicrometerTracingBridgeLibraryAccessors = new IoMicrometerMicrometerTracingBridgeLibraryAccessors(owner);

        public IoMicrometerMicrometerTracingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>test</b> with <b>io.micrometer:micrometer-tracing-test</b> coordinates and
         * with version reference <b>io.micrometer.micrometer.tracing.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.micrometer.micrometer.tracing.test");
        }

        /**
         * Group of libraries at <b>io.micrometer.micrometer.tracing.bridge</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMicrometerMicrometerTracingBridgeLibraryAccessors getBridge() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMicrometerMicrometerTracingBridgeLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMicrometerMicrometerTracingBridgeLibraryAccessors extends SubDependencyFactory {

        public IoMicrometerMicrometerTracingBridgeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>brave</b> with <b>io.micrometer:micrometer-tracing-bridge-brave</b> coordinates and
         * with version reference <b>micrometer.tracing.bridge.brave</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getBrave() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.micrometer.micrometer.tracing.bridge.brave");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMongockLibraryAccessors extends SubDependencyFactory {
        private final IoMongockMongockLibraryAccessors laccForIoMongockMongockLibraryAccessors = new IoMongockMongockLibraryAccessors(owner);
        private final IoMongockMongodbLibraryAccessors laccForIoMongockMongodbLibraryAccessors = new IoMongockMongodbLibraryAccessors(owner);

        public IoMongockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.mongock.mongock</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMongockMongockLibraryAccessors getMongock() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMongockMongockLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.mongock.mongodb</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMongockMongodbLibraryAccessors getMongodb() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMongockMongodbLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMongockMongockLibraryAccessors extends SubDependencyFactory {

        public IoMongockMongockLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bom</b> with <b>io.mongock:mongock-bom</b> coordinates and
         * with version reference <b>io.mongock.mongock</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getBom() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.mongock.mongock.bom");
        }

        /**
         * Dependency provider for <b>springboot</b> with <b>io.mongock:mongock-springboot</b> coordinates and
         * with version reference <b>io.mongock.mongock</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSpringboot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.mongock.mongock.springboot");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMongockMongodbLibraryAccessors extends SubDependencyFactory {
        private final IoMongockMongodbReactiveLibraryAccessors laccForIoMongockMongodbReactiveLibraryAccessors = new IoMongockMongodbReactiveLibraryAccessors(owner);

        public IoMongockMongodbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.mongock.mongodb.reactive</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoMongockMongodbReactiveLibraryAccessors getReactive() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoMongockMongodbReactiveLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoMongockMongodbReactiveLibraryAccessors extends SubDependencyFactory {

        public IoMongockMongodbReactiveLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>driver</b> with <b>io.mongock:mongodb-reactive-driver</b> coordinates and
         * with version reference <b>io.mongock.mongock</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getDriver() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.mongock.mongodb.reactive.driver");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoProjectreactorLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKafkaLibraryAccessors laccForIoProjectreactorKafkaLibraryAccessors = new IoProjectreactorKafkaLibraryAccessors(owner);
        private final IoProjectreactorKotlinLibraryAccessors laccForIoProjectreactorKotlinLibraryAccessors = new IoProjectreactorKotlinLibraryAccessors(owner);
        private final IoProjectreactorReactorLibraryAccessors laccForIoProjectreactorReactorLibraryAccessors = new IoProjectreactorReactorLibraryAccessors(owner);

        public IoProjectreactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.projectreactor.kafka</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoProjectreactorKafkaLibraryAccessors getKafka() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoProjectreactorKafkaLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.projectreactor.kotlin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoProjectreactorKotlinLibraryAccessors getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoProjectreactorKotlinLibraryAccessors;
        }

        /**
         * Group of libraries at <b>io.projectreactor.reactor</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoProjectreactorReactorLibraryAccessors getReactor() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoProjectreactorReactorLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoProjectreactorKafkaLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKafkaReactorLibraryAccessors laccForIoProjectreactorKafkaReactorLibraryAccessors = new IoProjectreactorKafkaReactorLibraryAccessors(owner);

        public IoProjectreactorKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.projectreactor.kafka.reactor</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoProjectreactorKafkaReactorLibraryAccessors getReactor() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoProjectreactorKafkaReactorLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoProjectreactorKafkaReactorLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorKafkaReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kafka</b> with <b>io.projectreactor.kafka:reactor-kafka</b> coordinates and
         * with version reference <b>reactor.kafka</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getKafka() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.projectreactor.kafka.reactor.kafka");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoProjectreactorKotlinLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKotlinReactorLibraryAccessors laccForIoProjectreactorKotlinReactorLibraryAccessors = new IoProjectreactorKotlinReactorLibraryAccessors(owner);

        public IoProjectreactorKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.projectreactor.kotlin.reactor</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoProjectreactorKotlinReactorLibraryAccessors getReactor() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoProjectreactorKotlinReactorLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoProjectreactorKotlinReactorLibraryAccessors extends SubDependencyFactory {
        private final IoProjectreactorKotlinReactorKotlinLibraryAccessors laccForIoProjectreactorKotlinReactorKotlinLibraryAccessors = new IoProjectreactorKotlinReactorKotlinLibraryAccessors(owner);

        public IoProjectreactorKotlinReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.projectreactor.kotlin.reactor.kotlin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoProjectreactorKotlinReactorKotlinLibraryAccessors getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoProjectreactorKotlinReactorKotlinLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoProjectreactorKotlinReactorKotlinLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorKotlinReactorKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>extensions</b> with <b>io.projectreactor.kotlin:reactor-kotlin-extensions</b> coordinates and
         * with version reference <b>reactor.kotlin.extensions</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getExtensions() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.projectreactor.kotlin.reactor.kotlin.extensions");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoProjectreactorReactorLibraryAccessors extends SubDependencyFactory {

        public IoProjectreactorReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>test</b> with <b>io.projectreactor:reactor-test</b> coordinates and
         * with version reference <b>reactor.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.projectreactor.reactor.test");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoZipkinLibraryAccessors extends SubDependencyFactory {
        private final IoZipkinReporter2LibraryAccessors laccForIoZipkinReporter2LibraryAccessors = new IoZipkinReporter2LibraryAccessors(owner);

        public IoZipkinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.zipkin.reporter2</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoZipkinReporter2LibraryAccessors getReporter2() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoZipkinReporter2LibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoZipkinReporter2LibraryAccessors extends SubDependencyFactory {
        private final IoZipkinReporter2ZipkinLibraryAccessors laccForIoZipkinReporter2ZipkinLibraryAccessors = new IoZipkinReporter2ZipkinLibraryAccessors(owner);

        public IoZipkinReporter2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.zipkin.reporter2.zipkin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoZipkinReporter2ZipkinLibraryAccessors getZipkin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoZipkinReporter2ZipkinLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoZipkinReporter2ZipkinLibraryAccessors extends SubDependencyFactory {
        private final IoZipkinReporter2ZipkinReporterLibraryAccessors laccForIoZipkinReporter2ZipkinReporterLibraryAccessors = new IoZipkinReporter2ZipkinReporterLibraryAccessors(owner);

        public IoZipkinReporter2ZipkinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>io.zipkin.reporter2.zipkin.reporter</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public IoZipkinReporter2ZipkinReporterLibraryAccessors getReporter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForIoZipkinReporter2ZipkinReporterLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class IoZipkinReporter2ZipkinReporterLibraryAccessors extends SubDependencyFactory {

        public IoZipkinReporter2ZipkinReporterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>brave</b> with <b>io.zipkin.reporter2:zipkin-reporter-brave</b> coordinates and
         * with version reference <b>zipkin.reporter.brave</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getBrave() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("io.zipkin.reporter2.zipkin.reporter.brave");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaValidationLibraryAccessors laccForJakartaValidationLibraryAccessors = new JakartaValidationLibraryAccessors(owner);

        public JakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.validation</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public JakartaValidationLibraryAccessors getValidation() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForJakartaValidationLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class JakartaValidationLibraryAccessors extends SubDependencyFactory {

        public JakartaValidationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.validation:jakarta.validation-api</b> coordinates and
         * with version reference <b>jakarta.validation.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getApi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("jakarta.validation.api");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class MeLibraryAccessors extends SubDependencyFactory {
        private final MeTmarciniakLibraryAccessors laccForMeTmarciniakLibraryAccessors = new MeTmarciniakLibraryAccessors(owner);

        public MeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>me.tmarciniak</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public MeTmarciniakLibraryAccessors getTmarciniak() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForMeTmarciniakLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class MeTmarciniakLibraryAccessors extends SubDependencyFactory {
        private final MeTmarciniakAxonLibraryAccessors laccForMeTmarciniakAxonLibraryAccessors = new MeTmarciniakAxonLibraryAccessors(owner);

        public MeTmarciniakLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>me.tmarciniak.axon</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public MeTmarciniakAxonLibraryAccessors getAxon() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForMeTmarciniakAxonLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class MeTmarciniakAxonLibraryAccessors extends SubDependencyFactory {
        private final MeTmarciniakAxonBraveLibraryAccessors laccForMeTmarciniakAxonBraveLibraryAccessors = new MeTmarciniakAxonBraveLibraryAccessors(owner);

        public MeTmarciniakAxonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>me.tmarciniak.axon.brave</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public MeTmarciniakAxonBraveLibraryAccessors getBrave() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForMeTmarciniakAxonBraveLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class MeTmarciniakAxonBraveLibraryAccessors extends SubDependencyFactory {

        public MeTmarciniakAxonBraveLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>observability</b> with <b>me.tmarciniak:axon-brave-observability</b> coordinates and
         * with version reference <b>me.tmarciniak.axon.observability</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getObservability() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("me.tmarciniak.axon.brave.observability");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgAspectjLibraryAccessors laccForOrgAspectjLibraryAccessors = new OrgAspectjLibraryAccessors(owner);
        private final OrgAxonLibraryAccessors laccForOrgAxonLibraryAccessors = new OrgAxonLibraryAccessors(owner);
        private final OrgJetbrainsLibraryAccessors laccForOrgJetbrainsLibraryAccessors = new OrgJetbrainsLibraryAccessors(owner);
        private final OrgJunitLibraryAccessors laccForOrgJunitLibraryAccessors = new OrgJunitLibraryAccessors(owner);
        private final OrgMockitoLibraryAccessors laccForOrgMockitoLibraryAccessors = new OrgMockitoLibraryAccessors(owner);
        private final OrgSpringdocLibraryAccessors laccForOrgSpringdocLibraryAccessors = new OrgSpringdocLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);
        private final OrgTestcontainersLibraryAccessors laccForOrgTestcontainersLibraryAccessors = new OrgTestcontainersLibraryAccessors(owner);
        private final OrgYamlLibraryAccessors laccForOrgYamlLibraryAccessors = new OrgYamlLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheLibraryAccessors getApache() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.aspectj</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAspectjLibraryAccessors getAspectj() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAspectjLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.axon</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAxonLibraryAccessors getAxon() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAxonLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.jetbrains</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJetbrainsLibraryAccessors getJetbrains() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJetbrainsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.junit</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJunitLibraryAccessors getJunit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJunitLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mockito</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMockitoLibraryAccessors getMockito() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMockitoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springdoc</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringdocLibraryAccessors getSpringdoc() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringdocLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.testcontainers</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgTestcontainersLibraryAccessors getTestcontainers() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgTestcontainersLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.yaml</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgYamlLibraryAccessors getYaml() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgYamlLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheCommonsLibraryAccessors laccForOrgApacheCommonsLibraryAccessors = new OrgApacheCommonsLibraryAccessors(owner);
        private final OrgApacheLoggingLibraryAccessors laccForOrgApacheLoggingLibraryAccessors = new OrgApacheLoggingLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>avro</b> with <b>org.apache.avro:avro</b> coordinates and
         * with version reference <b>org.apache.avro</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getAvro() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.avro");
        }

        /**
         * Group of libraries at <b>org.apache.commons</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheCommonsLibraryAccessors getCommons() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheCommonsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.apache.logging</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheLoggingLibraryAccessors getLogging() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheLoggingLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheCommonsLibraryAccessors extends SubDependencyFactory {

        public OrgApacheCommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compress</b> with <b>org.apache.commons:commons-compress</b> coordinates and
         * with version reference <b>org.apache.commons.compress</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCompress() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.commons.compress");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheLoggingLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLibraryAccessors = new OrgApacheLoggingLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.logging.log4j</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheLoggingLog4jLibraryAccessors getLog4j() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheLoggingLog4jLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheLoggingLog4jLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLoggingLog4jLog4jLibraryAccessors laccForOrgApacheLoggingLog4jLog4jLibraryAccessors = new OrgApacheLoggingLog4jLog4jLibraryAccessors(owner);

        public OrgApacheLoggingLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.logging.log4j.log4j</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgApacheLoggingLog4jLog4jLibraryAccessors getLog4j() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgApacheLoggingLog4jLog4jLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgApacheLoggingLog4jLog4jLibraryAccessors extends SubDependencyFactory {

        public OrgApacheLoggingLog4jLog4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.apache.logging.log4j:log4j-core</b> coordinates and
         * with version reference <b>log4j.core</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCore() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.apache.logging.log4j.log4j.core");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAspectjLibraryAccessors extends SubDependencyFactory {

        public OrgAspectjLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>aspectjrt</b> with <b>org.aspectj:aspectjrt</b> coordinates and
         * with version reference <b>org.aspectj.aspect</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getAspectjrt() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.aspectj.aspectjrt");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAxonLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsLibraryAccessors laccForOrgAxonExtensionsLibraryAccessors = new OrgAxonExtensionsLibraryAccessors(owner);
        private final OrgAxonSpringLibraryAccessors laccForOrgAxonSpringLibraryAccessors = new OrgAxonSpringLibraryAccessors(owner);

        public OrgAxonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>micrometer</b> with <b>org.axonframework:axon-micrometer</b> coordinates and
         * with version reference <b>axon.micrometer</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getMicrometer() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.axon.micrometer");
        }

        /**
         * Group of libraries at <b>org.axon.extensions</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAxonExtensionsLibraryAccessors getExtensions() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAxonExtensionsLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.axon.spring</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAxonSpringLibraryAccessors getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAxonSpringLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAxonExtensionsLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorLibraryAccessors laccForOrgAxonExtensionsReactorLibraryAccessors = new OrgAxonExtensionsReactorLibraryAccessors(owner);
        private final OrgAxonExtensionsSpringLibraryAccessors laccForOrgAxonExtensionsSpringLibraryAccessors = new OrgAxonExtensionsSpringLibraryAccessors(owner);

        public OrgAxonExtensionsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>mongo</b> with <b>org.axonframework.extensions.mongo:axon-mongo</b> coordinates and
         * with version reference <b>axon.extensions.spring.aot</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getMongo() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.axon.extensions.mongo");
        }

        /**
         * Group of libraries at <b>org.axon.extensions.reactor</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAxonExtensionsReactorLibraryAccessors getReactor() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAxonExtensionsReactorLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.axon.extensions.spring</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAxonExtensionsSpringLibraryAccessors getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAxonExtensionsSpringLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAxonExtensionsReactorLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorSpringLibraryAccessors laccForOrgAxonExtensionsReactorSpringLibraryAccessors = new OrgAxonExtensionsReactorSpringLibraryAccessors(owner);

        public OrgAxonExtensionsReactorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.axon.extensions.reactor.spring</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAxonExtensionsReactorSpringLibraryAccessors getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAxonExtensionsReactorSpringLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAxonExtensionsReactorSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonExtensionsReactorSpringBootLibraryAccessors laccForOrgAxonExtensionsReactorSpringBootLibraryAccessors = new OrgAxonExtensionsReactorSpringBootLibraryAccessors(owner);

        public OrgAxonExtensionsReactorSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.axon.extensions.reactor.spring.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAxonExtensionsReactorSpringBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAxonExtensionsReactorSpringBootLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAxonExtensionsReactorSpringBootLibraryAccessors extends SubDependencyFactory {

        public OrgAxonExtensionsReactorSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>starter</b> with <b>org.axonframework.extensions.reactor:axon-reactor-spring-boot-starter</b> coordinates and
         * with version reference <b>axon.extensions.reactor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getStarter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.axon.extensions.reactor.spring.boot.starter");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAxonExtensionsSpringLibraryAccessors extends SubDependencyFactory {

        public OrgAxonExtensionsSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>aot</b> with <b>org.axonframework.extensions.spring-aot:axon-spring-aot</b> coordinates and
         * with version <b>4.9.1</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getAot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.axon.extensions.spring.aot");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAxonSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgAxonSpringBootLibraryAccessors laccForOrgAxonSpringBootLibraryAccessors = new OrgAxonSpringBootLibraryAccessors(owner);

        public OrgAxonSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.axon.spring.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgAxonSpringBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgAxonSpringBootLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgAxonSpringBootLibraryAccessors extends SubDependencyFactory {

        public OrgAxonSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>starter</b> with <b>org.axonframework:axon-spring-boot-starter</b> coordinates and
         * with version reference <b>axon.spring.boot.starter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getStarter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.axon.spring.boot.starter");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJetbrainsLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinLibraryAccessors laccForOrgJetbrainsKotlinLibraryAccessors = new OrgJetbrainsKotlinLibraryAccessors(owner);
        private final OrgJetbrainsKotlinxLibraryAccessors laccForOrgJetbrainsKotlinxLibraryAccessors = new OrgJetbrainsKotlinxLibraryAccessors(owner);

        public OrgJetbrainsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>annotations</b> with <b>org.jetbrains:annotations</b> coordinates and
         * with version reference <b>org.jetbrains.annotations</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getAnnotations() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.jetbrains.annotations");
        }

        /**
         * Group of libraries at <b>org.jetbrains.kotlin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJetbrainsKotlinLibraryAccessors getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJetbrainsKotlinLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.jetbrains.kotlinx</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJetbrainsKotlinxLibraryAccessors getKotlinx() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJetbrainsKotlinxLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJetbrainsKotlinLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinKotlinLibraryAccessors laccForOrgJetbrainsKotlinKotlinLibraryAccessors = new OrgJetbrainsKotlinKotlinLibraryAccessors(owner);

        public OrgJetbrainsKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.jetbrains.kotlin.kotlin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJetbrainsKotlinKotlinLibraryAccessors getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJetbrainsKotlinKotlinLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJetbrainsKotlinKotlinLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinKotlinStdlibLibraryAccessors laccForOrgJetbrainsKotlinKotlinStdlibLibraryAccessors = new OrgJetbrainsKotlinKotlinStdlibLibraryAccessors(owner);

        public OrgJetbrainsKotlinKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>reflect</b> with <b>org.jetbrains.kotlin:kotlin-reflect</b> coordinates and
         * with version <b>1.9.22</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getReflect() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.jetbrains.kotlin.kotlin.reflect");
        }

        /**
         * Group of libraries at <b>org.jetbrains.kotlin.kotlin.stdlib</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJetbrainsKotlinKotlinStdlibLibraryAccessors getStdlib() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJetbrainsKotlinKotlinStdlibLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJetbrainsKotlinKotlinStdlibLibraryAccessors extends SubDependencyFactory {

        public OrgJetbrainsKotlinKotlinStdlibLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jdk8</b> with <b>org.jetbrains.kotlin:kotlin-stdlib-jdk8</b> coordinates and
         * with version <b>1.9.22</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJdk8() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.jetbrains.kotlin.kotlin.stdlib.jdk8");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJetbrainsKotlinxLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinxKotlinxLibraryAccessors laccForOrgJetbrainsKotlinxKotlinxLibraryAccessors = new OrgJetbrainsKotlinxKotlinxLibraryAccessors(owner);

        public OrgJetbrainsKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.jetbrains.kotlinx.kotlinx</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJetbrainsKotlinxKotlinxLibraryAccessors getKotlinx() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJetbrainsKotlinxKotlinxLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJetbrainsKotlinxKotlinxLibraryAccessors extends SubDependencyFactory {
        private final OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors laccForOrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors = new OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors(owner);

        public OrgJetbrainsKotlinxKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.jetbrains.kotlinx.kotlinx.coroutines</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors getCoroutines() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public OrgJetbrainsKotlinxKotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>reactor</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-reactor</b> coordinates and
         * with version reference <b>kotlinx.coroutines.reactor</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getReactor() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.jetbrains.kotlinx.kotlinx.coroutines.reactor");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitPlatformLibraryAccessors laccForOrgJunitPlatformLibraryAccessors = new OrgJunitPlatformLibraryAccessors(owner);

        public OrgJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.platform</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJunitPlatformLibraryAccessors getPlatform() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJunitPlatformLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJunitPlatformLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitPlatformJunitLibraryAccessors laccForOrgJunitPlatformJunitLibraryAccessors = new OrgJunitPlatformJunitLibraryAccessors(owner);

        public OrgJunitPlatformLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.platform.junit</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJunitPlatformJunitLibraryAccessors getJunit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJunitPlatformJunitLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJunitPlatformJunitLibraryAccessors extends SubDependencyFactory {
        private final OrgJunitPlatformJunitPlatformLibraryAccessors laccForOrgJunitPlatformJunitPlatformLibraryAccessors = new OrgJunitPlatformJunitPlatformLibraryAccessors(owner);

        public OrgJunitPlatformJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.junit.platform.junit.platform</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgJunitPlatformJunitPlatformLibraryAccessors getPlatform() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgJunitPlatformJunitPlatformLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgJunitPlatformJunitPlatformLibraryAccessors extends SubDependencyFactory {

        public OrgJunitPlatformJunitPlatformLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>launcher</b> with <b>org.junit.platform:junit-platform-launcher</b> coordinates and
         * with version <b>1.10.2</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getLauncher() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.junit.platform.junit.platform.launcher");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMockitoLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoKotlinLibraryAccessors laccForOrgMockitoKotlinLibraryAccessors = new OrgMockitoKotlinLibraryAccessors(owner);

        public OrgMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mockito.kotlin</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMockitoKotlinLibraryAccessors getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMockitoKotlinLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMockitoKotlinLibraryAccessors extends SubDependencyFactory {
        private final OrgMockitoKotlinMockitoLibraryAccessors laccForOrgMockitoKotlinMockitoLibraryAccessors = new OrgMockitoKotlinMockitoLibraryAccessors(owner);

        public OrgMockitoKotlinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mockito.kotlin.mockito</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgMockitoKotlinMockitoLibraryAccessors getMockito() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgMockitoKotlinMockitoLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgMockitoKotlinMockitoLibraryAccessors extends SubDependencyFactory {

        public OrgMockitoKotlinMockitoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kotlin</b> with <b>org.mockito.kotlin:mockito-kotlin</b> coordinates and
         * with version reference <b>mockito.kotlin</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getKotlin() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.mockito.kotlin.mockito.kotlin");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringdocLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocOpenapiLibraryAccessors laccForOrgSpringdocOpenapiLibraryAccessors = new OrgSpringdocOpenapiLibraryAccessors(owner);

        public OrgSpringdocLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springdoc.openapi</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringdocOpenapiLibraryAccessors getOpenapi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringdocOpenapiLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringdocOpenapiLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocOpenapiStarterLibraryAccessors laccForOrgSpringdocOpenapiStarterLibraryAccessors = new OrgSpringdocOpenapiStarterLibraryAccessors(owner);

        public OrgSpringdocOpenapiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springdoc.openapi.starter</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringdocOpenapiStarterLibraryAccessors getStarter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringdocOpenapiStarterLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringdocOpenapiStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringdocOpenapiStarterWebfluxLibraryAccessors laccForOrgSpringdocOpenapiStarterWebfluxLibraryAccessors = new OrgSpringdocOpenapiStarterWebfluxLibraryAccessors(owner);

        public OrgSpringdocOpenapiStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>common</b> with <b>org.springdoc:springdoc-openapi-starter-common</b> coordinates and
         * with version reference <b>org.springdoc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCommon() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springdoc.openapi.starter.common");
        }

        /**
         * Group of libraries at <b>org.springdoc.openapi.starter.webflux</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringdocOpenapiStarterWebfluxLibraryAccessors getWebflux() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringdocOpenapiStarterWebfluxLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringdocOpenapiStarterWebfluxLibraryAccessors extends SubDependencyFactory {

        public OrgSpringdocOpenapiStarterWebfluxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>org.springdoc:springdoc-openapi-starter-webflux-ui</b> coordinates and
         * with version reference <b>org.springdoc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getUi() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springdoc.openapi.starter.webflux.ui");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);
        private final OrgSpringframeworkKafkaLibraryAccessors laccForOrgSpringframeworkKafkaLibraryAccessors = new OrgSpringframeworkKafkaLibraryAccessors(owner);
        private final OrgSpringframeworkSecurityLibraryAccessors laccForOrgSpringframeworkSecurityLibraryAccessors = new OrgSpringframeworkSecurityLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>hateoas</b> with <b>org.springframework.hateoas:spring-hateoas</b> coordinates and
         * with version reference <b>org.springframework.hateoas</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getHateoas() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.hateoas");
        }

        /**
         * Group of libraries at <b>org.springframework.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.kafka</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkKafkaLibraryAccessors getKafka() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkKafkaLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.security</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkSecurityLibraryAccessors getSecurity() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkSecurityLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootDockerLibraryAccessors laccForOrgSpringframeworkBootSpringBootDockerLibraryAccessors = new OrgSpringframeworkBootSpringBootDockerLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>dependencies</b> with <b>org.springframework.boot:spring-boot-dependencies</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getDependencies() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.dependencies");
        }

        /**
         * Dependency provider for <b>testcontainers</b> with <b>org.springframework.boot:spring-boot-testcontainers</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTestcontainers() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.testcontainers");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.docker</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootDockerLibraryAccessors getDocker() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootDockerLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootDockerLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootDockerLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>org.springframework.boot:spring-boot-docker-compose</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getCompose() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.docker.compose");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(owner);
        private final OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>actuator</b> with <b>org.springframework.boot:spring-boot-starter-actuator</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getActuator() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.actuator");
        }

        /**
         * Dependency provider for <b>security</b> with <b>org.springframework.boot:spring-boot-starter-security</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSecurity() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.security");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.boot:spring-boot-starter-test</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.test");
        }

        /**
         * Dependency provider for <b>validation</b> with <b>org.springframework.boot:spring-boot-starter-validation</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getValidation() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.validation");
        }

        /**
         * Dependency provider for <b>webflux</b> with <b>org.springframework.boot:spring-boot-starter-webflux</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getWebflux() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.webflux");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.data</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.oauth2</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors getOauth2() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.data.mongodb</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors getMongodb() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataMongodbLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>reactive</b> with <b>org.springframework.boot:spring-boot-starter-data-mongodb-reactive</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getReactive() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.data.mongodb.reactive");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterOauth2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.oauth2.resource</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors getResource() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterOauth2ResourceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>server</b> with <b>org.springframework.boot:spring-boot-starter-oauth2-resource-server</b> coordinates and
         * with <b>no version specified</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getServer() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.boot.spring.boot.starter.oauth2.resource.server");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkKafkaLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OrgSpringframeworkKafkaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>kafka</b> with <b>org.springframework.kafka:spring-kafka</b> coordinates and
         * with version reference <b>org.springframework.kafka</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.kafka");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.kafka:spring-kafka-test</b> coordinates and
         * with version reference <b>org.springframework.kafka</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.kafka.test");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgSpringframeworkSecurityLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkSecurityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.security:spring-security-test</b> coordinates and
         * with version reference <b>spring.security.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getTest() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.springframework.security.test");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgTestcontainersLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final OrgTestcontainersJunitLibraryAccessors laccForOrgTestcontainersJunitLibraryAccessors = new OrgTestcontainersJunitLibraryAccessors(owner);

        public OrgTestcontainersLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>testcontainers</b> with <b>org.testcontainers:testcontainers</b> coordinates and
         * with version reference <b>org.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> asProvider() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.testcontainers");
        }

        /**
         * Dependency provider for <b>kafka</b> with <b>org.testcontainers:kafka</b> coordinates and
         * with version reference <b>org.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getKafka() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.testcontainers.kafka");
        }

        /**
         * Dependency provider for <b>mongodb</b> with <b>org.testcontainers:mongodb</b> coordinates and
         * with version reference <b>org.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getMongodb() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.testcontainers.mongodb");
        }

        /**
         * Group of libraries at <b>org.testcontainers.junit</b>
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public OrgTestcontainersJunitLibraryAccessors getJunit() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return laccForOrgTestcontainersJunitLibraryAccessors;
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgTestcontainersJunitLibraryAccessors extends SubDependencyFactory {

        public OrgTestcontainersJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jupiter</b> with <b>org.testcontainers:junit-jupiter</b> coordinates and
         * with version reference <b>org.testcontainers</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getJupiter() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
            return create("org.testcontainers.junit.jupiter");
        }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
    public static class OrgYamlLibraryAccessors extends SubDependencyFactory {

        public OrgYamlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>snakeyaml</b> with <b>org.yaml:snakeyaml</b> coordinates and
         * with version reference <b>snakeyaml</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         *
         * @deprecated Will be removed in Gradle 9.0.
         */
        @Deprecated
        public Provider<MinimalExternalModuleDependency> getSnakeyaml() {
            org.gradle.internal.deprecation.DeprecationLogger.deprecateBehaviour("Accessing libraries or bundles from version catalogs in the plugins block.").withAdvice("Only use versions or plugins from catalogs in the plugins block.").willBeRemovedInGradle9().withUpgradeGuideSection(8, "kotlin_dsl_deprecated_catalogs_plugins_block").nagUser();
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
        private final KotlinxVersionAccessors vaccForKotlinxVersionAccessors = new KotlinxVersionAccessors(providers, config);
        private final Log4jVersionAccessors vaccForLog4jVersionAccessors = new Log4jVersionAccessors(providers, config);
        private final MeVersionAccessors vaccForMeVersionAccessors = new MeVersionAccessors(providers, config);
        private final MicrometerVersionAccessors vaccForMicrometerVersionAccessors = new MicrometerVersionAccessors(providers, config);
        private final MockitoVersionAccessors vaccForMockitoVersionAccessors = new MockitoVersionAccessors(providers, config);
        private final NlVersionAccessors vaccForNlVersionAccessors = new NlVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        private final ReactorVersionAccessors vaccForReactorVersionAccessors = new ReactorVersionAccessors(providers, config);
        private final SpringVersionAccessors vaccForSpringVersionAccessors = new SpringVersionAccessors(providers, config);
        private final ZipkinVersionAccessors vaccForZipkinVersionAccessors = new ZipkinVersionAccessors(providers, config);
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
         * Group of versions at <b>versions.kotlinx</b>
         */
        public KotlinxVersionAccessors getKotlinx() {
            return vaccForKotlinxVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.log4j</b>
         */
        public Log4jVersionAccessors getLog4j() {
            return vaccForLog4jVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.me</b>
         */
        public MeVersionAccessors getMe() {
            return vaccForMeVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.micrometer</b>
         */
        public MicrometerVersionAccessors getMicrometer() {
            return vaccForMicrometerVersionAccessors;
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

        /**
         * Group of versions at <b>versions.spring</b>
         */
        public SpringVersionAccessors getSpring() {
            return vaccForSpringVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.zipkin</b>
         */
        public ZipkinVersionAccessors getZipkin() {
            return vaccForZipkinVersionAccessors;
        }

    }

    public static class AxonVersionAccessors extends VersionFactory  {

        private final AxonExtensionsVersionAccessors vaccForAxonExtensionsVersionAccessors = new AxonExtensionsVersionAccessors(providers, config);
        private final AxonSpringVersionAccessors vaccForAxonSpringVersionAccessors = new AxonSpringVersionAccessors(providers, config);
        public AxonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>axon.micrometer</b> with value <b>4.9.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMicrometer() { return getVersion("axon.micrometer"); }

        /**
         * Group of versions at <b>versions.axon.extensions</b>
         */
        public AxonExtensionsVersionAccessors getExtensions() {
            return vaccForAxonExtensionsVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.axon.spring</b>
         */
        public AxonSpringVersionAccessors getSpring() {
            return vaccForAxonSpringVersionAccessors;
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

    public static class AxonSpringVersionAccessors extends VersionFactory  {

        private final AxonSpringBootVersionAccessors vaccForAxonSpringBootVersionAccessors = new AxonSpringBootVersionAccessors(providers, config);
        public AxonSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.axon.spring.boot</b>
         */
        public AxonSpringBootVersionAccessors getBoot() {
            return vaccForAxonSpringBootVersionAccessors;
        }

    }

    public static class AxonSpringBootVersionAccessors extends VersionFactory  {

        public AxonSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>axon.spring.boot.starter</b> with value <b>4.9.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getStarter() { return getVersion("axon.spring.boot.starter"); }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComAutonomousappsVersionAccessors vaccForComAutonomousappsVersionAccessors = new ComAutonomousappsVersionAccessors(providers, config);
        private final ComGithubVersionAccessors vaccForComGithubVersionAccessors = new ComGithubVersionAccessors(providers, config);
        private final ComGoogleVersionAccessors vaccForComGoogleVersionAccessors = new ComGoogleVersionAccessors(providers, config);
        private final ComTngtechVersionAccessors vaccForComTngtechVersionAccessors = new ComTngtechVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.autonomousapps</b>
         */
        public ComAutonomousappsVersionAccessors getAutonomousapps() {
            return vaccForComAutonomousappsVersionAccessors;
        }

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

    public static class ComAutonomousappsVersionAccessors extends VersionFactory  {

        private final ComAutonomousappsDependencyVersionAccessors vaccForComAutonomousappsDependencyVersionAccessors = new ComAutonomousappsDependencyVersionAccessors(providers, config);
        public ComAutonomousappsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.autonomousapps.dependency</b>
         */
        public ComAutonomousappsDependencyVersionAccessors getDependency() {
            return vaccForComAutonomousappsDependencyVersionAccessors;
        }

    }

    public static class ComAutonomousappsDependencyVersionAccessors extends VersionFactory  {

        public ComAutonomousappsDependencyVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.autonomousapps.dependency.analysis</b> with value <b>1.30.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAnalysis() { return getVersion("com.autonomousapps.dependency.analysis"); }

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

        private final IoAxoniqVersionAccessors vaccForIoAxoniqVersionAccessors = new IoAxoniqVersionAccessors(providers, config);
        private final IoFreefairVersionAccessors vaccForIoFreefairVersionAccessors = new IoFreefairVersionAccessors(providers, config);
        private final IoHolixonVersionAccessors vaccForIoHolixonVersionAccessors = new IoHolixonVersionAccessors(providers, config);
        private final IoMcarleVersionAccessors vaccForIoMcarleVersionAccessors = new IoMcarleVersionAccessors(providers, config);
        private final IoMicrometerVersionAccessors vaccForIoMicrometerVersionAccessors = new IoMicrometerVersionAccessors(providers, config);
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
         * Group of versions at <b>versions.io.axoniq</b>
         */
        public IoAxoniqVersionAccessors getAxoniq() {
            return vaccForIoAxoniqVersionAccessors;
        }

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
         * Group of versions at <b>versions.io.micrometer</b>
         */
        public IoMicrometerVersionAccessors getMicrometer() {
            return vaccForIoMicrometerVersionAccessors;
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

    public static class IoAxoniqVersionAccessors extends VersionFactory  {

        private final IoAxoniqConsoleVersionAccessors vaccForIoAxoniqConsoleVersionAccessors = new IoAxoniqConsoleVersionAccessors(providers, config);
        public IoAxoniqVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.axoniq.console</b>
         */
        public IoAxoniqConsoleVersionAccessors getConsole() {
            return vaccForIoAxoniqConsoleVersionAccessors;
        }

    }

    public static class IoAxoniqConsoleVersionAccessors extends VersionFactory  {

        private final IoAxoniqConsoleFrameworkVersionAccessors vaccForIoAxoniqConsoleFrameworkVersionAccessors = new IoAxoniqConsoleFrameworkVersionAccessors(providers, config);
        public IoAxoniqConsoleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.axoniq.console.framework</b>
         */
        public IoAxoniqConsoleFrameworkVersionAccessors getFramework() {
            return vaccForIoAxoniqConsoleFrameworkVersionAccessors;
        }

    }

    public static class IoAxoniqConsoleFrameworkVersionAccessors extends VersionFactory  {

        private final IoAxoniqConsoleFrameworkClientVersionAccessors vaccForIoAxoniqConsoleFrameworkClientVersionAccessors = new IoAxoniqConsoleFrameworkClientVersionAccessors(providers, config);
        public IoAxoniqConsoleFrameworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.axoniq.console.framework.client</b>
         */
        public IoAxoniqConsoleFrameworkClientVersionAccessors getClient() {
            return vaccForIoAxoniqConsoleFrameworkClientVersionAccessors;
        }

    }

    public static class IoAxoniqConsoleFrameworkClientVersionAccessors extends VersionFactory  {

        private final IoAxoniqConsoleFrameworkClientSpringVersionAccessors vaccForIoAxoniqConsoleFrameworkClientSpringVersionAccessors = new IoAxoniqConsoleFrameworkClientSpringVersionAccessors(providers, config);
        public IoAxoniqConsoleFrameworkClientVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.axoniq.console.framework.client.spring</b>
         */
        public IoAxoniqConsoleFrameworkClientSpringVersionAccessors getSpring() {
            return vaccForIoAxoniqConsoleFrameworkClientSpringVersionAccessors;
        }

    }

    public static class IoAxoniqConsoleFrameworkClientSpringVersionAccessors extends VersionFactory  {

        private final IoAxoniqConsoleFrameworkClientSpringBootVersionAccessors vaccForIoAxoniqConsoleFrameworkClientSpringBootVersionAccessors = new IoAxoniqConsoleFrameworkClientSpringBootVersionAccessors(providers, config);
        public IoAxoniqConsoleFrameworkClientSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.axoniq.console.framework.client.spring.boot</b>
         */
        public IoAxoniqConsoleFrameworkClientSpringBootVersionAccessors getBoot() {
            return vaccForIoAxoniqConsoleFrameworkClientSpringBootVersionAccessors;
        }

    }

    public static class IoAxoniqConsoleFrameworkClientSpringBootVersionAccessors extends VersionFactory  {

        public IoAxoniqConsoleFrameworkClientSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.axoniq.console.framework.client.spring.boot.starter</b> with value <b>1.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getStarter() { return getVersion("io.axoniq.console.framework.client.spring.boot.starter"); }

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

    public static class IoMicrometerVersionAccessors extends VersionFactory  {

        private final IoMicrometerMicrometerVersionAccessors vaccForIoMicrometerMicrometerVersionAccessors = new IoMicrometerMicrometerVersionAccessors(providers, config);
        public IoMicrometerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.micrometer.micrometer</b>
         */
        public IoMicrometerMicrometerVersionAccessors getMicrometer() {
            return vaccForIoMicrometerMicrometerVersionAccessors;
        }

    }

    public static class IoMicrometerMicrometerVersionAccessors extends VersionFactory  {

        private final IoMicrometerMicrometerTracingVersionAccessors vaccForIoMicrometerMicrometerTracingVersionAccessors = new IoMicrometerMicrometerTracingVersionAccessors(providers, config);
        public IoMicrometerMicrometerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.io.micrometer.micrometer.tracing</b>
         */
        public IoMicrometerMicrometerTracingVersionAccessors getTracing() {
            return vaccForIoMicrometerMicrometerTracingVersionAccessors;
        }

    }

    public static class IoMicrometerMicrometerTracingVersionAccessors extends VersionFactory  {

        public IoMicrometerMicrometerTracingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>io.micrometer.micrometer.tracing.test</b> with value <b>1.2.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("io.micrometer.micrometer.tracing.test"); }

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

    public static class KotlinxVersionAccessors extends VersionFactory  {

        private final KotlinxCoroutinesVersionAccessors vaccForKotlinxCoroutinesVersionAccessors = new KotlinxCoroutinesVersionAccessors(providers, config);
        public KotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.kotlinx.coroutines</b>
         */
        public KotlinxCoroutinesVersionAccessors getCoroutines() {
            return vaccForKotlinxCoroutinesVersionAccessors;
        }

    }

    public static class KotlinxCoroutinesVersionAccessors extends VersionFactory  {

        public KotlinxCoroutinesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>kotlinx.coroutines.reactor</b> with value <b>1.8.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getReactor() { return getVersion("kotlinx.coroutines.reactor"); }

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

    public static class MeVersionAccessors extends VersionFactory  {

        private final MeTmarciniakVersionAccessors vaccForMeTmarciniakVersionAccessors = new MeTmarciniakVersionAccessors(providers, config);
        public MeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.me.tmarciniak</b>
         */
        public MeTmarciniakVersionAccessors getTmarciniak() {
            return vaccForMeTmarciniakVersionAccessors;
        }

    }

    public static class MeTmarciniakVersionAccessors extends VersionFactory  {

        private final MeTmarciniakAxonVersionAccessors vaccForMeTmarciniakAxonVersionAccessors = new MeTmarciniakAxonVersionAccessors(providers, config);
        public MeTmarciniakVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.me.tmarciniak.axon</b>
         */
        public MeTmarciniakAxonVersionAccessors getAxon() {
            return vaccForMeTmarciniakAxonVersionAccessors;
        }

    }

    public static class MeTmarciniakAxonVersionAccessors extends VersionFactory  {

        public MeTmarciniakAxonVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>me.tmarciniak.axon.observability</b> with value <b>0.0.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getObservability() { return getVersion("me.tmarciniak.axon.observability"); }

    }

    public static class MicrometerVersionAccessors extends VersionFactory  {

        private final MicrometerRegistryVersionAccessors vaccForMicrometerRegistryVersionAccessors = new MicrometerRegistryVersionAccessors(providers, config);
        private final MicrometerTracingVersionAccessors vaccForMicrometerTracingVersionAccessors = new MicrometerTracingVersionAccessors(providers, config);
        public MicrometerVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.micrometer.registry</b>
         */
        public MicrometerRegistryVersionAccessors getRegistry() {
            return vaccForMicrometerRegistryVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.micrometer.tracing</b>
         */
        public MicrometerTracingVersionAccessors getTracing() {
            return vaccForMicrometerTracingVersionAccessors;
        }

    }

    public static class MicrometerRegistryVersionAccessors extends VersionFactory  {

        public MicrometerRegistryVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>micrometer.registry.prometheus</b> with value <b>1.12.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getPrometheus() { return getVersion("micrometer.registry.prometheus"); }

    }

    public static class MicrometerTracingVersionAccessors extends VersionFactory  {

        private final MicrometerTracingBridgeVersionAccessors vaccForMicrometerTracingBridgeVersionAccessors = new MicrometerTracingBridgeVersionAccessors(providers, config);
        public MicrometerTracingVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.micrometer.tracing.bridge</b>
         */
        public MicrometerTracingBridgeVersionAccessors getBridge() {
            return vaccForMicrometerTracingBridgeVersionAccessors;
        }

    }

    public static class MicrometerTracingBridgeVersionAccessors extends VersionFactory  {

        public MicrometerTracingBridgeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>micrometer.tracing.bridge.brave</b> with value <b>1.2.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBrave() { return getVersion("micrometer.tracing.bridge.brave"); }

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

        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgAspectjVersionAccessors vaccForOrgAspectjVersionAccessors = new OrgAspectjVersionAccessors(providers, config);
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
         * Group of versions at <b>versions.org.apache</b>
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.aspectj</b>
         */
        public OrgAspectjVersionAccessors getAspectj() {
            return vaccForOrgAspectjVersionAccessors;
        }

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

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheCommonsVersionAccessors vaccForOrgApacheCommonsVersionAccessors = new OrgApacheCommonsVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.avro</b> with value <b>1.11.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAvro() { return getVersion("org.apache.avro"); }

        /**
         * Group of versions at <b>versions.org.apache.commons</b>
         */
        public OrgApacheCommonsVersionAccessors getCommons() {
            return vaccForOrgApacheCommonsVersionAccessors;
        }

    }

    public static class OrgApacheCommonsVersionAccessors extends VersionFactory  {

        public OrgApacheCommonsVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.commons.compress</b> with value <b>1.26.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCompress() { return getVersion("org.apache.commons.compress"); }

    }

    public static class OrgAspectjVersionAccessors extends VersionFactory  {

        public OrgAspectjVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.aspectj.aspect</b> with value <b>1.9.21.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAspect() { return getVersion("org.aspectj.aspect"); }

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

        /**
         * Version alias <b>org.springframework.kafka</b> with value <b>3.1.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKafka() { return getVersion("org.springframework.kafka"); }

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

    public static class SpringVersionAccessors extends VersionFactory  {

        private final SpringSecurityVersionAccessors vaccForSpringSecurityVersionAccessors = new SpringSecurityVersionAccessors(providers, config);
        public SpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.spring.security</b>
         */
        public SpringSecurityVersionAccessors getSecurity() {
            return vaccForSpringSecurityVersionAccessors;
        }

    }

    public static class SpringSecurityVersionAccessors extends VersionFactory  {

        public SpringSecurityVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>spring.security.test</b> with value <b>6.2.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("spring.security.test"); }

    }

    public static class ZipkinVersionAccessors extends VersionFactory  {

        private final ZipkinReporterVersionAccessors vaccForZipkinReporterVersionAccessors = new ZipkinReporterVersionAccessors(providers, config);
        public ZipkinVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.zipkin.reporter</b>
         */
        public ZipkinReporterVersionAccessors getReporter() {
            return vaccForZipkinReporterVersionAccessors;
        }

    }

    public static class ZipkinReporterVersionAccessors extends VersionFactory  {

        public ZipkinReporterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>zipkin.reporter.brave</b> with value <b>3.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBrave() { return getVersion("zipkin.reporter.brave"); }

    }

    /**
     * @deprecated Will be removed in Gradle 9.0.
     */
    @Deprecated
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
        private final ComAutonomousappsPluginAccessors paccForComAutonomousappsPluginAccessors = new ComAutonomousappsPluginAccessors(providers, config);
        private final ComGithubPluginAccessors paccForComGithubPluginAccessors = new ComGithubPluginAccessors(providers, config);
        private final ComGooglePluginAccessors paccForComGooglePluginAccessors = new ComGooglePluginAccessors(providers, config);

        public ComPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.com.autonomousapps</b>
         */
        public ComAutonomousappsPluginAccessors getAutonomousapps() {
            return paccForComAutonomousappsPluginAccessors;
        }

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

    public static class ComAutonomousappsPluginAccessors extends PluginFactory {
        private final ComAutonomousappsDependencyPluginAccessors paccForComAutonomousappsDependencyPluginAccessors = new ComAutonomousappsDependencyPluginAccessors(providers, config);

        public ComAutonomousappsPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.com.autonomousapps.dependency</b>
         */
        public ComAutonomousappsDependencyPluginAccessors getDependency() {
            return paccForComAutonomousappsDependencyPluginAccessors;
        }

    }

    public static class ComAutonomousappsDependencyPluginAccessors extends PluginFactory {

        public ComAutonomousappsDependencyPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>com.autonomousapps.dependency.analysis</b> with plugin id <b>com.autonomousapps.dependency-analysis</b> and
         * with version reference <b>com.autonomousapps.dependency.analysis</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAnalysis() { return createPlugin("com.autonomousapps.dependency.analysis"); }

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
