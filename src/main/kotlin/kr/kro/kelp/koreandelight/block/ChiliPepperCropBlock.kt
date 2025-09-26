package kr.kro.kelp.koreandelight.block


import kr.kro.kelp.koreandelight.item.ModItems
import net.minecraft.core.BlockPos
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.CropBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.IntegerProperty
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape


class ChiliPepperCropBlock(properties: Properties) : CropBlock(properties) {
    val myAgeProperty = AGE
    override fun getShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape {
        return SHAPE_BY_AGE[state.getValue(AGE)]
    }

    override fun getBaseSeedId(): ItemLike {
        return ModItems.CHILI_PEPPER_SEEDS.get()
    }

    public override fun getAgeProperty(): IntegerProperty {
        return AGE
    }

    override fun getMaxAge(): Int {
        return MAX_AGE
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(AGE)
    }

    companion object {
        const val MAX_AGE: Int = 3
        val AGE: IntegerProperty = IntegerProperty.create("age", 0, 3)
        private val SHAPE_BY_AGE = arrayOf(
            box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
            box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0)
        )
    }
}