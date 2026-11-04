plugins {
    id("com.android.application")
}

android {
    namespace = "si.fitmenjava"
    compileSdk = 35

    defaultConfig {
        applicationId = "si.fitmenjava"
        minSdk = 29          // Android 10+
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
