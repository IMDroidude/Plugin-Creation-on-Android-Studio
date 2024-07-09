import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

val userEmail: String = "zare.ahmer"// gradleLocalProperties(rootDir).getProperty("user.email")
val userPass: String = "123"///gradleLocalProperties(rootDir).getProperty("user.pass")

plugins {
    id("ss.android.library")
    id("ss.hilt")
}
android {
    namespace = "com.ss.skillsync.domain"
    buildTypes {
        getByName("debug") {
            buildConfigField("String", "userEmail", userEmail)
            buildConfigField("String", "userPass", userPass)
        }
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.kotlinx.coroutines.core)
}
