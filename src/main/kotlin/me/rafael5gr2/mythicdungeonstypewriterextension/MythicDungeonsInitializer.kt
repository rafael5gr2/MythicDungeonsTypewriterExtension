package me.rafael5gr2.mythicdungeonstypewriterextension

import com.typewritermc.core.extension.Initializable
import com.typewritermc.core.extension.annotations.Initializer
import com.typewritermc.engine.paper.logger

import lirand.api.extensions.server.server

import net.playavalon.mythicdungeons.api.MythicDungeonsService

import org.bukkit.Bukkit.getServer

@Initializer
object MythicDungeonsInitializer : Initializable {

    var mythicDungeonsService : MythicDungeonsService ?= null
        private set

    override fun initialize() {

        val mythicDungeonsPlugin = server.pluginManager.getPlugin("MythicDungeons")
        if (mythicDungeonsPlugin == null) {
            logger.warning("MythicDungeons is not installed!")
            return
        }

        mythicDungeonsService = getServer().servicesManager.load(
            MythicDungeonsService::class.java
        )
    }

    override fun shutdown() {
        mythicDungeonsService = null
    }
}