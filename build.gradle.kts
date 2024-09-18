plugins {
    id("java")
    kotlin("jvm") version "2.0.20"
    id("com.typewritermc.module-plugin") version "1.0.0"
}

group = "me.rafael5gr2.mythicdungeonstypewriterextention"
version = "0.6.0" // The version is the same with the plugin to avoid confusion. :)

repositories {
    //maven("https://maven.aestrus.io/releases")
    flatDir { // This is a temporary solution, because the MythicDungeons maven repo doesn't have the v2 api yet.
        dirs("libs")
    }
}

dependencies {
    //compileOnly("net.playavalon:MythicDungeons:1.3.0-SNAPSHOT")
    compileOnly(":MythicDungeons") // This is a temporary solution, because the MythicDungeons maven repo doesn't have the v2 api yet.
}

typewriter {

    engine {
        version = "0.6.0"
        channel = com.typewritermc.moduleplugin.ReleaseChannel.BETA
    }

    namespace = "rafael5gr2"

    extension {
        name = "MythicDungeons"
        shortDescription = "A simple Typewriter extension that adds support for the plugin MythicDungeons."
        description =
            """
                A simple Typewriter extension that adds support for the plugin MythicDungeons. 
                It adds an event entry for when a player finishes a dungeon and a fact for if a player 
                has finished a dungeon or not.
            """.trimIndent()
        paper {
            dependency("MythicDungeons")
        }
    }
}

kotlin {
    jvmToolchain(21)
}