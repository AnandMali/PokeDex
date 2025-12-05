plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.anandmali.pokedex.core.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    // module dependencies
    implementation(project(":core-network"))
    implementation(project(":core-model"))
    implementation(project(":core-database"))

    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // network retrofit and okHTTP
    implementation(libs.retrofit.core)
    implementation(libs.gson.convertor)
    implementation(libs.okhttp.loggin)
    implementation(libs.okhttp.mock.server)
    implementation(libs.okhttp.profiler)

    // paging
    implementation(libs.paging.compose)

    // hilt
    implementation(libs.hilt.android.core)
    ksp(libs.hilt.compiler)

}