package me.rafael5gr2.mythicdungeonstypewriterextension.event

import com.typewritermc.core.books.pages.Colors
import com.typewritermc.core.entries.Query
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.extension.annotations.Entry
import com.typewritermc.core.extension.annotations.EntryListener
import com.typewritermc.core.extension.annotations.Help
import com.typewritermc.engine.paper.entry.TriggerableEntry
import com.typewritermc.engine.paper.entry.entries.EventEntry
import com.typewritermc.engine.paper.entry.triggerAllFor

import net.playavalon.mythicdungeons.api.events.dungeon.PlayerFinishDungeonEvent

@Entry("on_player_finish_dungeon", "When a player finishes a dungeon", Colors.YELLOW, "fa6-solid:dungeon")
class PlayerFinishedDungeonEventEntry(
    override val id: String = "",
    override val name: String = "",
    override val triggers: List<Ref<TriggerableEntry>> = emptyList(),
    @Help("The name of the dungeon")
    val dungeonName: String = ""
) : EventEntry

@EntryListener(PlayerFinishedDungeonEventEntry::class)
fun onPlayerFinishDungeonEvent(event: PlayerFinishDungeonEvent, query: Query<PlayerFinishedDungeonEventEntry>) {
    query findWhere { it.dungeonName in event.dungeon.worldName } triggerAllFor event.player
}