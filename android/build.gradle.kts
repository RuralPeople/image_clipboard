group = "com.tencent.cloud.chat.flutter.image_clipboard"
version = "1.0-SNAPSHOT"

buildscript {
    val kotlinVersion by extra("1.7.10")

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.3.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.tencent.cloud.chat.flutter.image_clipboard"
    compileSdk = 31

    defaultConfig {
        minSdk = 16
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    sourceSets["main"].java.srcDirs("src/main/kotlin")
    sourceSets["test"].java.srcDirs("src/test/kotlin")

    testOptions {
        unitTests.all {
            it.useJUnitPlatform()

            it.testLogging.apply {
                events("passed", "skipped", "failed", "standardOut", "standardError")
                isShowStandardStreams = true
            }

            it.outputs.upToDateWhen { false }
        }
    }
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.mockito:mockito-core:5.0.0")
}