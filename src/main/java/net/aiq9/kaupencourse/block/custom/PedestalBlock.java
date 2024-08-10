package net.aiq9.kaupencourse.block.custom;

import com.mojang.serialization.MapCodec;
import net.aiq9.kaupencourse.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PedestalBlock extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape VOXEL_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 13, 14);
    public static final MapCodec<PedestalBlock> CODEC = createCodec(PedestalBlock::new);

    public PedestalBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VOXEL_SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PedestalBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);

            if (blockEntity instanceof PedestalBlockEntity) {
                ItemScatterer.spawn(world, pos, ((PedestalBlockEntity) blockEntity));

                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.getBlockEntity(pos) instanceof PedestalBlockEntity pedestalBlockEntity) {
            if (pedestalBlockEntity.isEmpty() && !stack.isEmpty()) { //no item in inventory & being right clicked w/ item;
                // take item from player and put it in inventory
                pedestalBlockEntity.setStack(0, stack);
                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 2f);

                stack.decrement(1); //hand stack decrements by 1.

            } else if (stack.isEmpty()) {
                ItemStack stackOnPedestal = pedestalBlockEntity.getStack(0);

                player.setStackInHand(Hand.MAIN_HAND, stackOnPedestal);

                world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);

                pedestalBlockEntity.clear();
            }
        }

        return ItemActionResult.SUCCESS;
    }
}
