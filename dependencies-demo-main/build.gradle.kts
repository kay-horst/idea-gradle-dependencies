dependencies {
}

plugins {
    application
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
