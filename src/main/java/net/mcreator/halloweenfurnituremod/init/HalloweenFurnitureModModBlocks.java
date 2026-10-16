/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.halloweenfurnituremod.init;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.halloweenfurnituremod.block.PurpleHalloweenCauldronBlock;
import net.mcreator.halloweenfurnituremod.block.OrangeHalloweenCauldronBlock;
import net.mcreator.halloweenfurnituremod.block.GreenHalloweenCauldronBlock;
import net.mcreator.halloweenfurnituremod.HalloweenFurnitureModMod;

import java.util.function.Function;

public class HalloweenFurnitureModModBlocks {
	public static Block PURPLE_HALLOWEEN_CAULDRON;
	public static Block GREEN_HALLOWEEN_CAULDRON;
	public static Block ORANGE_HALLOWEEN_CAULDRON;

	public static void load() {
		PURPLE_HALLOWEEN_CAULDRON = register("purple_halloween_cauldron", PurpleHalloweenCauldronBlock::new);
		GREEN_HALLOWEEN_CAULDRON = register("green_halloween_cauldron", GreenHalloweenCauldronBlock::new);
		ORANGE_HALLOWEEN_CAULDRON = register("orange_halloween_cauldron", OrangeHalloweenCauldronBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> B register(String name, Function<BlockBehaviour.Properties, B> supplier) {
		return (B) Blocks.register(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(HalloweenFurnitureModMod.MODID, name)), (Function<BlockBehaviour.Properties, Block>) supplier, BlockBehaviour.Properties.of());
	}
}