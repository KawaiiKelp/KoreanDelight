package kr.kro.kelp.koreandelight.ModItems

import kr.kro.kelp.koreandelight.KoreanDelight
import kr.kro.kelp.koreandelight.ModBlocks.ModBlocks
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemNameBlockItem
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister


object ModItems {
    val ITEMS = DeferredRegister.createItems(KoreanDelight.ID)

    val KIMCHI: DeferredItem<Item> = ITEMS.registerSimpleItem("kimchi",
        Item.Properties().food(ModFoods.KIMCHI))
    val BIBIMBAP: DeferredItem<Item> = ITEMS.registerSimpleItem("bibimbap",
        Item.Properties().stacksTo(16).food(ModFoods.BIBIMBAP))

    val CHILI_PEPPER: DeferredItem<Item> = ITEMS.registerSimpleItem("chili_pepper",
        Item.Properties().food(ModFoods.CHILI_PEPPER))
    val CHILI_PEPPER_SEEDS: DeferredItem<Item> =
        ITEMS.registerItem("chili_pepper_seeds") {
            ItemNameBlockItem(
                ModBlocks.CHILI_PEPPER.get(), // 여기서 get()은 괜찮음, 실행 시점은 '등록 이벤트'니까
                Item.Properties()
            )
        }

    val CHILI_POWDER: DeferredItem<Item> = ITEMS.registerSimpleItem("chili_powder",
        Item.Properties().food(ModFoods.CHILI_POWDER))
}