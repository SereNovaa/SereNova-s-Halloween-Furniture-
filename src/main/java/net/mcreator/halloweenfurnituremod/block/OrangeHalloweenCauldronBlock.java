package net.mcreator.halloweenfurnituremod.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.halloweenfurnituremod.procedures.PurpleHalloweenCauldronOnTickUpdateProcedure;
import net.mcreator.halloweenfurnituremod.procedures.OrangeHalloweenCauldronOnBlockRightclicked2Procedure;

import java.util.function.Function;

public class OrangeHalloweenCauldronBlock extends Block {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	private final Function<BlockState, VoxelShape> shapes = this.makeShapes();

	public OrangeHalloweenCauldronBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(new SoundType(1.0f, 1.0f, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.ghast.warn")), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.metal.step")),
				BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.metal.place")), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("entity.ghast.ambient")),
				BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.anvil.fall")))).strength(1f, 10f).lightLevel(blockstate -> 10).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	private Function<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(4, 2, 3, 12, 7, 4), box(4, 2, 4, 12, 7, 12), box(4, 2, 12, 12, 7, 13), box(12, 2, 4, 13, 7, 12), box(12, 2, 3, 13, 8, 4), box(12, 1, 4, 13, 2, 12), box(3, 1, 4, 4, 2, 12), box(11, 0, 5, 12, 1, 11),
						box(4, 0, 5, 5, 1, 11), box(12, 7, 4, 13, 9, 12), box(12, 2, 12, 13, 8, 13), box(3, 7, 4, 4, 9, 12), box(3, 2, 12, 4, 8, 13), box(3, 2, 4, 4, 7, 12), box(3, 2, 3, 4, 8, 4), box(4, 7, 12, 12, 9, 13), box(4, 1, 12, 12, 2, 13),
						box(4, 7, 3, 12, 9, 4), box(4, 1, 3, 12, 2, 4), box(2, 3, 4, 3, 7, 12), box(5, 7, 2, 11, 8, 3), box(4, 2, 12, 12, 7, 13), box(4, 2, 3, 12, 7, 4), box(5, 0, 4, 11, 1, 12), box(13, 3, 4, 14, 7, 12), box(5, 7, 2, 11, 8, 3),
						box(13, 2, 5, 14, 3, 11), box(13, 2, 5, 14, 3, 11), box(13, 2, 5, 14, 3, 11), box(5, 7, 13, 11, 8, 14), box(4, 3, 13, 12, 7, 14), box(5, 7, 2, 11, 8, 3), box(13, 3, 4, 14, 7, 12));
				case EAST -> Shapes.or(box(12, 2, 4, 13, 7, 12), box(4, 2, 4, 12, 7, 12), box(3, 2, 4, 4, 7, 12), box(4, 2, 12, 12, 7, 13), box(12, 2, 12, 13, 8, 13), box(4, 1, 12, 12, 2, 13), box(4, 1, 3, 12, 2, 4), box(5, 0, 11, 11, 1, 12),
						box(5, 0, 4, 11, 1, 5), box(4, 7, 12, 12, 9, 13), box(3, 2, 12, 4, 8, 13), box(4, 7, 3, 12, 9, 4), box(3, 2, 3, 4, 8, 4), box(4, 2, 3, 12, 7, 4), box(12, 2, 3, 13, 8, 4), box(3, 7, 4, 4, 9, 12), box(3, 1, 4, 4, 2, 12),
						box(12, 7, 4, 13, 9, 12), box(12, 1, 4, 13, 2, 12), box(4, 3, 2, 12, 7, 3), box(13, 7, 5, 14, 8, 11), box(3, 2, 4, 4, 7, 12), box(12, 2, 4, 13, 7, 12), box(4, 0, 5, 12, 1, 11), box(4, 3, 13, 12, 7, 14),
						box(13, 7, 5, 14, 8, 11), box(5, 2, 13, 11, 3, 14), box(5, 2, 13, 11, 3, 14), box(5, 2, 13, 11, 3, 14), box(2, 7, 5, 3, 8, 11), box(2, 3, 4, 3, 7, 12), box(13, 7, 5, 14, 8, 11), box(4, 3, 13, 12, 7, 14));
				case WEST -> Shapes.or(box(3, 2, 4, 4, 7, 12), box(4, 2, 4, 12, 7, 12), box(12, 2, 4, 13, 7, 12), box(4, 2, 3, 12, 7, 4), box(3, 2, 3, 4, 8, 4), box(4, 1, 3, 12, 2, 4), box(4, 1, 12, 12, 2, 13), box(5, 0, 4, 11, 1, 5),
						box(5, 0, 11, 11, 1, 12), box(4, 7, 3, 12, 9, 4), box(12, 2, 3, 13, 8, 4), box(4, 7, 12, 12, 9, 13), box(12, 2, 12, 13, 8, 13), box(4, 2, 12, 12, 7, 13), box(3, 2, 12, 4, 8, 13), box(12, 7, 4, 13, 9, 12),
						box(12, 1, 4, 13, 2, 12), box(3, 7, 4, 4, 9, 12), box(3, 1, 4, 4, 2, 12), box(4, 3, 13, 12, 7, 14), box(2, 7, 5, 3, 8, 11), box(12, 2, 4, 13, 7, 12), box(3, 2, 4, 4, 7, 12), box(4, 0, 5, 12, 1, 11), box(4, 3, 2, 12, 7, 3),
						box(2, 7, 5, 3, 8, 11), box(5, 2, 2, 11, 3, 3), box(5, 2, 2, 11, 3, 3), box(5, 2, 2, 11, 3, 3), box(13, 7, 5, 14, 8, 11), box(13, 3, 4, 14, 7, 12), box(2, 7, 5, 3, 8, 11), box(4, 3, 2, 12, 7, 3));
				default -> Shapes.or(box(4, 2, 12, 12, 7, 13), box(4, 2, 4, 12, 7, 12), box(4, 2, 3, 12, 7, 4), box(3, 2, 4, 4, 7, 12), box(3, 2, 12, 4, 8, 13), box(3, 1, 4, 4, 2, 12), box(12, 1, 4, 13, 2, 12), box(4, 0, 5, 5, 1, 11),
						box(11, 0, 5, 12, 1, 11), box(3, 7, 4, 4, 9, 12), box(3, 2, 3, 4, 8, 4), box(12, 7, 4, 13, 9, 12), box(12, 2, 3, 13, 8, 4), box(12, 2, 4, 13, 7, 12), box(12, 2, 12, 13, 8, 13), box(4, 7, 3, 12, 9, 4), box(4, 1, 3, 12, 2, 4),
						box(4, 7, 12, 12, 9, 13), box(4, 1, 12, 12, 2, 13), box(13, 3, 4, 14, 7, 12), box(5, 7, 13, 11, 8, 14), box(4, 2, 3, 12, 7, 4), box(4, 2, 12, 12, 7, 13), box(5, 0, 4, 11, 1, 12), box(2, 3, 4, 3, 7, 12),
						box(5, 7, 13, 11, 8, 14), box(2, 2, 5, 3, 3, 11), box(2, 2, 5, 3, 3, 11), box(2, 2, 5, 3, 3, 11), box(5, 7, 2, 11, 8, 3), box(4, 3, 2, 12, 7, 3), box(5, 7, 13, 11, 8, 14), box(2, 3, 4, 3, 7, 12));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.apply(state);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 20);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		PurpleHalloweenCauldronOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		world.scheduleTick(pos, this, 20);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		OrangeHalloweenCauldronOnBlockRightclicked2Procedure.execute(entity);
		return InteractionResult.SUCCESS;
	}
}