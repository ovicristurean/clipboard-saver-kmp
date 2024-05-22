import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
    id("com.vanniktech.maven.publish") version "0.28.0"
}

group = "io.github.ovicristurean"
version = "0.1.2"

mavenPublishing {
    // Define coordinates for the published artifact
    coordinates(
        groupId = "io.github.ovicristurean",
        artifactId = "clipboard-saver",
        version = "0.1.2"
    )

    // Configure POM metadata for the published artifact
    pom {
        name.set("KMP Library for saving data to the clipboard")
        description.set("This library can be used by Android and iOS targets for the shared functionality of saving data to the clipboard")
        inceptionYear.set("2024")
        url.set("https://github.com/ovicristurean/clipboard-saver-kmp")

        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        // Specify developers information
        developers {
            developer {
                id.set("ovicristurean")
                name.set("Ovidiu Cristurean")
                email.set("cristurean.marius.ovidiu@gmail.com")
            }
        }

        // Specify SCM information
        scm {
            url.set("https://github.com/ovicristurean/clipboard-saver-kmp")
        }
    }

    // Configure publishing to Maven Central
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    // Enable GPG signing for all publications
    signAllPublications()
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        publishLibraryVariants("release", "debug")
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "clipboard-saver"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.ovidiucristurean.clipboardsaver"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
