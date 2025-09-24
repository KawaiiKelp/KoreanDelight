package kr.kro.kelp.koreandelight.ModItems

import kr.kro.kelp.koreandelight.KoreanDelight
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

object ModItems {
    val ITEMS = DeferredRegister.createItems(KoreanDelight.ID)

    val KIMCHI: DeferredItem<Item> = ITEMS.registerSimpleItem(
        "kimchi",
        Item.Properties().food(
            FoodProperties.Builder()
                .nutrition(3)
                .saturationModifier(0.2f)
                .build()
        )
    )
    val BIBIMBAP: DeferredItem<Item> = ITEMS.registerSimpleItem(
        "bibimbap",
        Item.Properties().food(
            FoodProperties.Builder()
                .nutrition(8)
                .saturationModifier(0.3f)
                .build()
        )
    )
}