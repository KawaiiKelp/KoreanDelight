package kr.kro.kelp.koreandelight.component

import kr.kro.kelp.koreandelight.KoreanDelight
import net.minecraft.core.BlockPos
import net.minecraft.core.component.DataComponentType
import net.minecraft.core.registries.Registries
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier
import java.util.function.UnaryOperator


object ModDataComponents {
    val DATA_COMPONENT_TYPES: DeferredRegister<DataComponentType<*>> =
        DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, KoreanDelight.ID)


    val COORDINATES: DeferredHolder<DataComponentType<*>, DataComponentType<BlockPos?>> = register(
        "coordinates"
    ) { builder: DataComponentType.Builder<BlockPos?> -> builder.persistent(BlockPos.CODEC) }


    private fun <T> register(
        name: String,
        builderOperator: UnaryOperator<DataComponentType.Builder<T>>
    ): DeferredHolder<DataComponentType<*>, DataComponentType<T>> {
        return DATA_COMPONENT_TYPES.register(
            name,
            Supplier { builderOperator.apply(DataComponentType.builder()).build() })
    }

    fun register(eventBus: IEventBus) {
        DATA_COMPONENT_TYPES.register(eventBus)
    }
}