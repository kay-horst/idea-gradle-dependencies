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

    dependencies {
        testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.6.2")
        testImplementation(group = "org.assertj", name = "assertj-core", version = "3.11.1")
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
