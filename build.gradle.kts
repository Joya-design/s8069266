buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.6")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    //alias(libs.plugins.jetbrains.kotlin.androidx) apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}