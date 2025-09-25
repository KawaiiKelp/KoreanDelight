package kr.kro.kelp.koreandelight.ModItems

import kr.kro.kelp.koreandelight.KoreanDelight
import kr.kro.kelp.koreandelight.KoreanDelight.ID
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object ModCreativeTabs {

    val CREATIVE_MODE_TAB: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create<CreativeModeTab>(Registries.CREATIVE_MODE_TAB, KoreanDelight.ID)

    val KOREAN_DELIGHT_TAB: Supplier<CreativeModeTab> = CREATIVE_MODE_TAB.register<CreativeModeTab>(
        "korean_delight",
        Supplier {
            CreativeModeTab.builder().icon(Supplier { ItemStack(ModItems.KIMCHI.get()) })
                .title(Component.translatable("itemGroup.${ID}"))
                .displayItems( { param, output ->
                    output.accept(ModItems.KIMCHI)
                    output.accept(ModItems.BIBIMBAP)
                    output.accept(ModItems.CHILI_POWDER)
                    output.accept(ModItems.CHILI_PEPPER)
                    output.accept(ModItems.CHILI_PEPPER_SEEDS)
                }).build()
        })

}