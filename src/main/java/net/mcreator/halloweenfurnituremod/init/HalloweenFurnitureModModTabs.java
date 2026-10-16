/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halloweenfurnituremod.init;

import net.minecraft.world.item.CreativeModeTabs;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public class HalloweenFurnitureModModTabs {
	public static void load() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(tabData -> {
			tabData.accept(HalloweenFurnitureModModBlocks.PURPLE_HALLOWEEN_CAULDRON.asItem());
			tabData.accept(HalloweenFurnitureModModBlocks.GREEN_HALLOWEEN_CAULDRON.asItem());
			tabData.accept(HalloweenFurnitureModModBlocks.ORANGE_HALLOWEEN_CAULDRON.asItem());
		});
	}
}