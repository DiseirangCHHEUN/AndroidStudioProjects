plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.passingdata_between_activities"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.passingdata_between_activities"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }

    composeOptions{

    }
}


dependencies {
    implementation (libs.androidx.appcompat.v161)
    implementation (libs.material.v1110)
    implementation (libs.androidx.constraintlayout)
}
