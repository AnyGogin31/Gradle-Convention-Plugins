package neilt.mobile.convention

import com.android.build.api.dsl.CommonExtension
import neilt.mobile.convention.extension.getPlugin
import neilt.mobile.convention.extension.libs
import org.gradle.api.Project

internal fun Project.configureAndroidApplication(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    pluginManager.apply(libs.getPlugin("android.application").get().pluginId)

    commonExtension.apply {
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}
