import org.gradle.api.tasks.testing.logging.TestExceptionFormat

val jdkVersion = JavaVersion.VERSION_11

plugins {
    `java-library`
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {

    apply(plugin = "java-library")

    java {
        sourceCompatibility = jdkVersion
        targetCompatibility = jdkVersion
    }

    // This is needed in order to execute the JUnit tests in src/test/java
    tasks {
        test {
            testLogging {
                exceptionFormat = TestExceptionFormat.FULL
            }
            useJUnitPlatform()
        }
    }
}
