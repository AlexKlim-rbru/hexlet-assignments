pluginManagement {
    repositories {
        maven {
            url = uri("https://artifactory.raiffeisen.ru/artifactory/plugins-gradle")
            credentials {
                username = System.getProperty("artifactory_user")
                password = System.getProperty("artifactory_password")
            }
        }
        gradlePluginPortal()
    }
}

rootProject.name = "error-handling"
// spring.jpa.generate-ddl = true
// spring.jpa.hibernate.ddl-auto
