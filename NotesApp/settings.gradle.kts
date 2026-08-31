pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "9.2.1" apply false
        id("com.android.library") version "9.2.1" apply false
        id("org.jetbrains.kotlin.android") version "2.1.20" apply false
        id("com.google.devtools.ksp") version "2.1.20-1.0.25" apply false
        id("androidx.navigation.safeargs.kotlin") version "2.8.0" apply false
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Notes App"
include(":app")