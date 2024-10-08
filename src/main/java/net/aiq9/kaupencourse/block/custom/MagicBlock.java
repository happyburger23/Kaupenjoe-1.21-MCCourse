package net.aiq9.kaupencourse.block.custom;

import net.aiq9.kaupencourse.sound.ModSounds;
import net.aiq9.kaupencourse.util.CustomTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    //right click block w/ hand
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos,
                                 PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, ModSounds.MAGIC_BLOCK_HIT, SoundCategory.BLOCKS, 1f, 1f);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity item) {
            if (isValidItem(item.getStack())) {
                item.setStack(new ItemStack(Items.DIAMOND, item.getStack().getCount())); //gets count of item thrown on block & gives respective # of other item
            }

            world.playSound(item, pos, ModSounds.MAGIC_BLOCK_STEP, SoundCategory.BLOCKS, 1f, 1f);
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    /* HARDCODED LIST
    private boolean isValidItem(ItemStack stack) {
        return stack.getItem() == ModItems.FLUORITE || stack.getItem() == ModItems.RAW_FLUORITE || stack.getItem() == Items.COAL;
    }
    */

    //List with custom tag
    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(CustomTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.kaupencourse.magic_block.tooltip.1"));

        super.appendTooltip(stack, context, tooltip, options);
    }
}
