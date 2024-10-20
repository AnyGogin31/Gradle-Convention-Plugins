package neilt.mobile

import com.android.build.api.dsl.ApplicationExtension
import neilt.mobile.convention.configureAndroidApplication
import neilt.mobile.convention.extension.getPlugin
import neilt.mobile.convention.extension.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPlugin("android.application").get().pluginId)
            }

            extensions.configure<ApplicationExtension> {
                configureAndroidApplication(this)
            }
        }
    }
}
