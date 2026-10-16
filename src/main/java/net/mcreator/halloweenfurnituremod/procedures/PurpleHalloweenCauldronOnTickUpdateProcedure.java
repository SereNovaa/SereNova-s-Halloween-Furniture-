package net.mcreator.halloweenfurnituremod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class PurpleHalloweenCauldronOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SCULK_SOUL, (x + 0.5), (y + 0.75), (z + 0.5), 1, 0.2, 0.2, 0.2, 0);
	}
}