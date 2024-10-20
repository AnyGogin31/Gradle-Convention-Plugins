package neilt.mobile.convention.extension

import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.VersionConstraint
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugin.use.PluginDependency

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun VersionCatalog.getPlugin(pluginName: String): Provider<PluginDependency> {
    return findPlugin(pluginName).orElseThrow {
        NoSuchElementException("Plugin with name $pluginName not found in the catalog")
    }
}

internal fun VersionCatalog.getBundle(bundleName: String): Provider<ExternalModuleDependencyBundle> {
    return findBundle(bundleName).orElseThrow {
        NoSuchElementException("Bundle with name $bundleName not found in the catalog")
    }
}

internal fun VersionCatalog.getLibrary(libraryName: String): Provider<MinimalExternalModuleDependency> {
    return findLibrary(libraryName).orElseThrow {
        NoSuchElementException("Library with name $libraryName not found in the catalog")
    }
}

internal fun VersionCatalog.getVersion(versionName: String): VersionConstraint {
    return findVersion(versionName).orElseThrow {
        NoSuchElementException("Version with name $versionName not found in the catalog")
    }
}
