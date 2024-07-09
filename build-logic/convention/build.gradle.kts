import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.ss.pluginApproach.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.ktlint.gradle)
    implementation(libs.detekt.gradle)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}


//register the plugin
gradlePlugin {
    plugins {
        register("pluginApproachHilt") {
            id = "ss.hilt"
            implementationClass = "HiltPlugin"
        }

    }
}
