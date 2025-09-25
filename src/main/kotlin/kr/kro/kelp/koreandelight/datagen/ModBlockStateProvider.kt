package kr.kro.kelp.koreandelight.datagen

import kr.kro.kelp.koreandelight.KoreanDelight
import kr.kro.kelp.koreandelight.block.ChiliPepperCropBlock
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
    protected override fun registerStatesAndModels() {
        makeCrop((ModBlocks.CHILI_PEPPER_CROP.get() as CropBlock), "radish_crop_stage", "radish_crop_stage")
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
    ): Array<ConfiguredModel> {   // <- 여기서 ? 제거
        val models = arrayOf(
            ConfiguredModel(
                models().crop(
                    modelName + state.getValue((block as ChiliPepperCropBlock).getAgeProperty()),
                    ResourceLocation.fromNamespaceAndPath(
                        KoreanDelight.ID,
                        "block/" + textureName + state.getValue((block as ChiliPepperCropBlock).getAgeProperty())
                    )
                ).renderType("cutout")
            )
        )

        return models
    }

}