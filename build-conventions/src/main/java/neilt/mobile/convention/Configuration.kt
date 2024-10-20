package neilt.mobile.convention

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object Configuration {

    val JAVA_TARGET = JvmTarget.JVM_17
    val JAVA_VERSION = JavaVersion.VERSION_17

    const val COMPILE_SDK = 35
    const val TARGET_SDK = 35
    const val MIN_SDK = 24

    const val APPLICATION_ID = "neilt.mobile.android.app"

    const val VERSION_NAME = "1.0"
    const val VERSION_CODE = 1
}
