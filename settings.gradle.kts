pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = """Planeswalker's Assistant"""

include(
    ":app:app-base",
    ":app:app-vanilla",
    ":core",
    ":scryfall:scryfall-api",
    ":scryfall:scryfall-impl",
)
