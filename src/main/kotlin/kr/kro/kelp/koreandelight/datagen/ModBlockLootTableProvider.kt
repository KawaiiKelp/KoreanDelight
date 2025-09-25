package kr.kro.kelp.koreandelight.datagen

import kr.kro.kelp.koreandelight.block.ChiliPepperCropBlock
import kr.kro.kelp.koreandelight.block.ModBlocks
import kr.kro.kelp.koreandelight.item.ModItems
import net.minecraft.advancements.critereon.StatePropertiesPredicate
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator


class ModBlockLootTableProvider(
    registries: HolderLookup.Provider
) : BlockLootSubProvider(
    setOf(),
    FeatureFlags.REGISTRY.allFlags(),
    registries
) {

    override fun generate() {
        val lootItemConditionBuilder: LootItemCondition.Builder =
            LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CHILI_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ChiliPepperCropBlock.AGE, 3))

        this.add(
            ModBlocks.CHILI_PEPPER_CROP.get(), this.createCropDrops(
                ModBlocks.CHILI_PEPPER_CROP.get(),
                ModItems.CHILI_PEPPER.get(), ModItems.CHILI_PEPPER_SEEDS.get(), lootItemConditionBuilder
            )
        )
    }

    override fun getKnownBlocks(): Iterable<Block> {
        return ModBlocks.BLOCKS.entries
            .map { obj -> obj.value() }  // Holder<Block> -> Block
    }


}
