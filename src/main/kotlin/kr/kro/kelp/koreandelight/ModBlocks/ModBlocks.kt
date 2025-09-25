package kr.kro.kelp.koreandelight.ModBlocks

import kr.kro.kelp.koreandelight.KoreanDelight
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier


object ModBlocks {
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(KoreanDelight.ID)


    val CHILI_PEPPER: DeferredBlock<ChiliPepperBlock> =
        BLOCKS.registerBlock("chili_pepper") { ChiliPepperBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)) }


}