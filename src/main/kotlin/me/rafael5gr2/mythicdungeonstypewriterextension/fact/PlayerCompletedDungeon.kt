package me.rafael5gr2.mythicdungeonstypewriterextension.fact

import com.typewritermc.core.books.pages.Colors
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.entries.emptyRef
import com.typewritermc.core.extension.annotations.Entry
import com.typewritermc.core.extension.annotations.Help
import com.typewritermc.engine.paper.entry.entries.GroupEntry
import com.typewritermc.engine.paper.entry.entries.ReadableFactEntry
import com.typewritermc.engine.paper.facts.FactData

import me.rafael5gr2.mythicdungeonstypewriterextension.MythicDungeonsInitializer

import org.bukkit.entity.Player

@Entry("player_completed_dungeon_fact", "If the player has completed a specified dungeon", Colors.PURPLE, "fa6-solid:dungeon")
class PlayerCompletedDungeon(
    override val id: String = "",
    override val comment: String = "",
    override val name: String = "",
    override val group: Ref<GroupEntry> = emptyRef(),
    @Help("The name of the dungeon")
    val dungeonName: String = ""
) : ReadableFactEntry {

    override fun readSinglePlayer(player: Player): FactData {
        val mythicDungeonsService = MythicDungeonsInitializer.mythicDungeonsService ?: return FactData(-1)
        val dungeon = mythicDungeonsService.allDungeons.firstOrNull { it.worldName == dungeonName } ?: return FactData(-1)
        val hasCompletedDungeon = dungeon.hasPlayerCompletedDungeon(player)
        return FactData(if (hasCompletedDungeon) 1 else 0)
    }

}