package neilt.mobile

import com.android.build.api.dsl.LibraryExtension
import neilt.mobile.convention.configureAndroidKotlin
import neilt.mobile.convention.extension.getPlugin
import neilt.mobile.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidKotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPlugin("android.kotlin").get().pluginId)
            }

            extensions.configure<LibraryExtension> {
                configureAndroidKotlin(this)
            }
        }
    }
}
