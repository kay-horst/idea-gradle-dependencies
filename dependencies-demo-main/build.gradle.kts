dependencies {
}

plugins {
    application
}

dependencies {
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.6.2")
    testImplementation(group = "org.assertj", name = "assertj-core", version = "3.11.1")
}

tasks {
    withType<Jar> {
        manifest {
            attributes["Main-Class"] = "org.khu.Main"
        }
    }
}

buildTestJar()

/**
 * Build a plain library with test and main classes / resources.
 * Needed i.e. by the test suite.
 */
fun buildTestJar() {

    configurations.register("testJar") {
        extendsFrom(configurations.testCompile.get())
    }
    tasks.register<Jar>(name = "testJar") {
        from(project.sourceSets.main.get().output, project.sourceSets.test.get().output)
        description = "Create a jar with all main and test classes / resources"
        archiveClassifier.set("test")
    }

    artifacts {
        add("testJar", tasks.getByName("testJar"))
    }
}
