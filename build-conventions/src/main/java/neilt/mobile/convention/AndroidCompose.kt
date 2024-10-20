package neilt.mobile.convention

import com.android.build.api.dsl.CommonExtension
import neilt.mobile.convention.extension.debugImplementation
import neilt.mobile.convention.extension.getLibrary
import neilt.mobile.convention.extension.getPlugin
import neilt.mobile.convention.extension.implementation
import neilt.mobile.convention.extension.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    pluginManager.apply(libs.getPlugin("compose.compiler").get().pluginId)

    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"
        }

        dependencies {
            implementation(platform(libs.getLibrary("androidx.compose.bom")))

            implementation(libs.getLibrary("androidx.activity.compose"))
            implementation(libs.getLibrary("androidx.ui"))
            implementation(libs.getLibrary("androidx.ui.graphics"))
            implementation(libs.getLibrary("androidx.ui.tooling.preview"))
            implementation(libs.getLibrary("androidx.material3"))
            debugImplementation(libs.getLibrary("androidx.ui.tooling"))
            debugImplementation(libs.getLibrary("androidx.ui.test.manifest"))
        }
    }
}
