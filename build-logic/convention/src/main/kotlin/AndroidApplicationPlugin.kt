import com.android.build.gradle.BaseExtension
import com.ss.pluginApproach.buildlogic.pluginConfig
//import com.ss.pluginApproach.task.CreateFeatureModuleTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.application")
                apply("kotlin-android")
                ///apply("ss.lint")
            }

            extensions.configure(BaseExtension::class.java) {
                commonAndroid(project)
                configureCompose(project)

                namespace = pluginConfig.APPLICATION_ID
                defaultConfig {
                    vectorDrawables.useSupportLibrary = true
                    applicationId = pluginConfig.APPLICATION_ID
                    versionCode = pluginConfig.VERSION_CODE
                    versionName = pluginConfig.VERSION_NAME
                }

                buildTypes {
                    maybeCreate("staging").apply {
                        isShrinkResources = true
                    }
                    maybeCreate("release").apply {
                        isShrinkResources = true
                    }
                }
            }

            //tasks.register("createFeature", CreateFeatureModuleTask::class.java)

        }
    }
}
