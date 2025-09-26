package kr.kro.kelp.koreandelight.datagen

import kr.kro.kelp.koreandelight.KoreanDelight
import kr.kro.kelp.koreandelight.block.ChiliPepperCropBlock
import kr.kro.kelp.koreandelight.block.GarlicCropBlock
import kr.kro.kelp.koreandelight.block.ModBlocks
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.state.BlockState
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.client.model.generators.ConfiguredModel
import net.neoforged.neoforge.common.data.ExistingFileHelper


class ModBlockStateProvider(output: PackOutput?, exFileHelper: ExistingFileHelper?) :
    BlockStateProvider(output!!, KoreanDelight.ID, exFileHelper!!) {
        override fun registerStatesAndModels() {
        makeCrop((ModBlocks.CHILI_PEPPER_CROP.get() as CropBlock), "chili_pepper_stage", "chili_pepper_stage")
        makeCrop((ModBlocks.GARLIC_CROP.get() as CropBlock), "garlic_stage", "garlic_stage")
    }

    fun makeCrop(block: CropBlock, modelName: String?, textureName: String?) {
        val function: (BlockState) -> Array<ConfiguredModel> = { state ->
            states(state, block, modelName!!, textureName!!)
        }

        getVariantBuilder(block).forAllStates(function)

    }
    private fun states(
        state: BlockState,
        block: CropBlock,
        modelName: String,
        textureName: String
    ): Array<ConfiguredModel> {
        val age = when(block) {
            is ChiliPepperCropBlock -> state.getValue(block.myAgeProperty)
            is GarlicCropBlock -> state.getValue(block.myAgeProperty)
            else -> throw IllegalArgumentException("Unsupported crop block: ${block::class.simpleName}")
        }
        val models = arrayOf(
            ConfiguredModel(
                models().crop(
                    modelName + age,
                    ResourceLocation.fromNamespaceAndPath(
                        KoreanDelight.ID,
                        "block/" + textureName + age
                    )
                ).renderType("cutout")
            )
        )

        return models
    }

}