package kr.kro.kelp.koreandelight.item

import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.Items
import vectorwing.farmersdelight.common.FoodValues
import vectorwing.farmersdelight.common.registry.ModEffects
import java.util.function.Supplier


object ModFoods {
    val KIMCHI: FoodProperties = FoodProperties.Builder().nutrition(4).saturationModifier(0.2f).build()
    val BIBIMBAP: FoodProperties = FoodProperties.Builder().nutrition(8).saturationModifier(0.4f)
        .effect(Supplier { MobEffectInstance(ModEffects.NOURISHMENT, FoodValues.LONG_DURATION, 0) }, 1.0f)
        .usingConvertsTo(Items.BOWL).build()
    val CHILI_PEPPER: FoodProperties = FoodProperties.Builder().nutrition(3).saturationModifier(0.1f).build()
    val CHILI_POWDER: FoodProperties = FoodProperties.Builder().nutrition(1).build()

}