package kr.kro.kelp.koreandelight.ModBlocks


import kr.kro.kelp.koreandelight.ModItems.ModItems
import net.minecraft.core.BlockPos
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class ChiliPepperBlock(properties: Properties) : CropBlock(properties) {
    fun getPlant(world: BlockGetter, pos: BlockPos): BlockState {
        return ModBlocks.CHILI_PEPPER.get().defaultBlockState()
    }

    override fun getBaseSeedId(): ItemLike {
        return ModItems.CHILI_PEPPER_SEEDS.get()
    }

    public override fun getShape(
        state: BlockState,
        worldIn: BlockGetter,
        pos: BlockPos,
        context: CollisionContext
    ): VoxelShape {
        return SHAPE_BY_AGE[state.getValue(this.ageProperty)]
    }

    companion object {
        private val SHAPE_BY_AGE = arrayOf<VoxelShape>(
            box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 9.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 9.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0)
        )
    }
}