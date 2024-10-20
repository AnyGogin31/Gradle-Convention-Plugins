plugins {
    `kotlin-dsl`
}

group = "neilt.mobile.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.application.gradlePlugin)
    compileOnly(libs.android.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "neilt.mobile.android.application"
            implementationClass = "neilt.mobile.AndroidApplicationConventionPlugin"
        }
    }
}
