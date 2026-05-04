pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "AndroidShopApp"
include(":app")
include(":core")
include(":domain")
include(":data")
include(":feature:catalog")
include(":feature:cart")
include(":feature:auth")
include(":feature:profile")
