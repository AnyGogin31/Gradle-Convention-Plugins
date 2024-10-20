package neilt.mobile.convention

import com.android.build.api.dsl.CommonExtension
import neilt.mobile.convention.extension.getPlugin
import neilt.mobile.convention.extension.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal fun Project.configureAndroidKotlin(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    pluginManager.apply(libs.getPlugin("android.kotlin").get().pluginId)

    commonExtension.apply {
        compileOptions {
            sourceCompatibility = Configuration.JAVA_VERSION
            targetCompatibility = Configuration.JAVA_VERSION
        }

        kotlinOptions {
            jvmTarget.set(Configuration.JAVA_TARGET)
        }
    }
}

internal fun Project.kotlinOptions(block: KotlinJvmCompilerOptions.() -> Unit) {
    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            block()
        }
    }
}
