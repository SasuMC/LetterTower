plugins {
    `java-library`
    id("com.gradleup.shadow") version "8.3.5"
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.14"
    id("xyz.jpenilla.run-paper") version "2.3.1"
    id("xyz.jpenilla.resource-factory-bukkit-convention") version "1.2.0"
}

group = "vermillion.productions"
version = "1.0.0-SNAPSHOT"
description = "Template with all the basics to start developing a PaperMC 1.21.4 plugin fast."

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}


repositories {
    repositories {
        maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    }
    maven {
        url = uri("https://repo.aikar.co/content/groups/aikar/")
    }

    mavenCentral()
}

dependencies {
    // Paper.
    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")

    // Bukkit.
    implementation("net.kyori:adventure-platform-bukkit:4.3.4")

    // Paper NMS.
    implementation("co.aikar:acf-paper:0.5.1-SNAPSHOT")

    // ProjectLombok.
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    testCompileOnly("org.projectlombok:lombok:1.18.36")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(21)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name()
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name()
    }
    shadowJar {
        relocate ("co.aikar.taskchain", "vermillion.productions.taskchain")
        relocate ("co.aikar.commands", "vermillion.productions.acf")
        relocate ("co.aikar.locales", "vermillion.productions.locales")
    }
}

bukkitPluginYaml {
    main = "vermillion.productions.Main"
    version = "1.0"
    apiVersion = "1.21"
    author = "VermillionTeam"
    website = "https://vermillion.productions"
}
