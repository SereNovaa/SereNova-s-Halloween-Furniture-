/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halloweenfurnituremod.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.halloweenfurnituremod.HalloweenFurnitureModMod;

import java.util.function.Function;

public class HalloweenFurnitureModModItems {
	public static Item PURPLE_HALLOWEEN_CAULDRON;
	public static Item GREEN_HALLOWEEN_CAULDRON;
	public static Item ORANGE_HALLOWEEN_CAULDRON;

	public static void load() {
		PURPLE_HALLOWEEN_CAULDRON = block(HalloweenFurnitureModModBlocks.PURPLE_HALLOWEEN_CAULDRON, "purple_halloween_cauldron", new Item.Properties().stacksTo(1).fireResistant());
		GREEN_HALLOWEEN_CAULDRON = block(HalloweenFurnitureModModBlocks.GREEN_HALLOWEEN_CAULDRON, "green_halloween_cauldron", new Item.Properties().stacksTo(1).fireResistant());
		ORANGE_HALLOWEEN_CAULDRON = block(HalloweenFurnitureModModBlocks.ORANGE_HALLOWEEN_CAULDRON, "orange_halloween_cauldron", new Item.Properties().stacksTo(1).fireResistant());
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Properties, ? extends I> supplier) {
		return (I) Items.registerItem(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(HalloweenFurnitureModMod.MODID, name)), (Function<Item.Properties, Item>) supplier);
	}

	private static Item block(Block block, String name) {
		return block(block, name, new Item.Properties());
	}

	private static Item block(Block block, String name, Item.Properties properties) {
		return Items.registerItem(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(HalloweenFurnitureModMod.MODID, name)), prop -> new BlockItem(block, prop), properties);
	}
}