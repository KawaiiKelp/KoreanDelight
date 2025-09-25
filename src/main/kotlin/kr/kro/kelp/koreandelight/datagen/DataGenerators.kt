package kr.kro.kelp.koreandelight.datagen

import kr.kro.kelp.koreandelight.KoreanDelight
import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.bus.api.Event
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.data.event.GatherDataEvent
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import java.util.List


object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val packOutput = generator.packOutput
        val existingFileHelper = event.existingFileHelper
        val lookupProvider = event.lookupProvider

        generator.addProvider(
            event.includeServer(), LootTableProvider(
                packOutput, emptySet(),
                listOf(SubProviderEntry({ registries: HolderLookup.Provider? ->
                    ModBlockLootTableProvider(
                        registries!!
                    )
                }, LootContextParamSets.BLOCK)), lookupProvider
            )
        )
        generator.addProvider(event.includeClient(), ModItemModelProvider(packOutput, existingFileHelper))
        generator.addProvider(event.includeClient(), ModBlockStateProvider(packOutput, existingFileHelper))
    }
}