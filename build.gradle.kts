plugins {
    id("com.gtnewhorizons.gtnhconvention")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
    testing {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }
}

minecraft {
    javaCompatibilityVersion.set(21)

    extraRunJvmArguments.add("-Dangelica.enableTestBlocks=true")
}

// Regular runClient/runServer tasks run in Java 17 in this project.
/*tasks.runClient17 { enabled = false }
tasks.runClient21 { enabled = false }
tasks.runServer17 { enabled = false }
tasks.runServer21 { enabled = false }
*/
tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
    javaLauncher = javaToolchains.launcherFor {
        languageVersion = JavaLanguageVersion.of(8)
    }
    dependsOn(tasks.extractNatives2)
    jvmArgs("-Djava.library.path=${tasks.extractNatives2.get().destinationFolder.asFile.get().path}")
}

tasks.processResources {
    inputs.property("version", project.version.toString())
    filesMatching("META-INF/rfb-plugin/*") {
        expand("version" to project.version.toString())
    }
}

tasks.register<Copy>("copyDependencies") {
    group = "Angelica"
    description = "Collect dependencies into the testDependencies folder"
    from(configurations.default)
    into("testDependencies")
}
