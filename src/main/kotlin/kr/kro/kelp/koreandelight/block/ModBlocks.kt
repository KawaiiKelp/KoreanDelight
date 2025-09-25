package kr.kro.kelp.koreandelight.block

import kr.kro.kelp.koreandelight.KoreanDelight
import kr.kro.kelp.koreandelight.item.ModItems
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier


object ModBlocks {


    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(KoreanDelight.ID)



    val CHILI_PEPPER_CROP: DeferredBlock<Block> = BLOCKS.register(
        "chili_pepper_crop",
        Supplier<Block> { ChiliPepperCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)) })

    private fun <T : Block?> registerBlock(name: String, block: Supplier<T>): DeferredBlock<T> {
        val toReturn = BLOCKS.register(name, block)
        registerBlockItem(name, toReturn)
        return toReturn
    }

    private fun <T : Block?> registerBlockItem(name: String, block: DeferredBlock<T>) {
        ModItems.ITEMS.registerItem(name) { BlockItem(block.get(), Item.Properties()) }
    }
}