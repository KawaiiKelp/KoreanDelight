package kr.kro.kelp.koreandelight.datagen

import kr.kro.kelp.koreandelight.KoreanDelight
import kr.kro.kelp.koreandelight.item.ModItems
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredItem


class ModItemModelProvider(
    output: PackOutput,
    existingFileHelper: ExistingFileHelper
) : ItemModelProvider(output, KoreanDelight.ID, existingFileHelper) {
    override fun registerModels() {
        basicItem(ModItems.CHILI_PEPPER_SEEDS.get())
        basicItem(ModItems.GARLIC.get())
    }
    private fun handheldItem(item: DeferredItem<*>): ItemModelBuilder {
        return withExistingParent(
            item.id.path,
            ResourceLocation.parse("item/handheld")
        ).texture(
            "layer0",
            ResourceLocation.fromNamespaceAndPath(KoreanDelight.ID, "item/" + item.id.path)
        )
    }
}
