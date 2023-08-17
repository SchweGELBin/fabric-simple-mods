package com.schwegelbin.simplemods.mixin.client;

import com.schwegelbin.simplemods.Settings;
import com.schwegelbin.simplemods.tools.XRay;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SideShapeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.world.BlockView;

@Mixin(AbstractBlock.AbstractBlockState.class)
public abstract class BlockStateMixin {
    @Shadow public abstract Block getBlock();

    @Inject(at = @At("HEAD"), method = "isSideInvisible", cancellable = true)
    public void isSideInvisible(BlockState state, Direction direction, CallbackInfoReturnable<Boolean> ci){
        if(Settings.xrayEnabled){
            if(XRay.isInterestingBlock(this.getBlock())){
                ci.setReturnValue(false);
                return;
            }
            ci.setReturnValue(true);
        }
    }

    @Inject(at = @At("HEAD"), method = "isSideSolid", cancellable = true)
    public void isSideSolid(BlockView world, BlockPos pos, Direction direction, SideShapeType shapeType, CallbackInfoReturnable<Boolean> ci){
        if(Settings.xrayEnabled){
            if(XRay.isInterestingBlock(this.getBlock())){
                ci.setReturnValue(true);
                return;
            }
            ci.setReturnValue(false);
        }
    }

    @Inject(at = @At("HEAD"), method = "getLuminance", cancellable = true)
    public void getLuminance(CallbackInfoReturnable<Integer> ci){
        if(Settings.xrayEnabled){
            if(XRay.isInterestingBlock(this.getBlock())){
                ci.setReturnValue(12);
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "getAmbientOcclusionLightLevel", cancellable = true)
    public void getAmbientOcclusionLightLevel(BlockView world, BlockPos pos, CallbackInfoReturnable<Float> ci){
        if(Settings.xrayEnabled){
            if(XRay.isInterestingBlock(this.getBlock())){
                ci.setReturnValue(1.0f);
                return;
            }
            ci.setReturnValue(1.0f);
        }
    }

    @Inject(at = @At("HEAD"), method = "getCullingFace", cancellable = true)
    public void getCullingFace(CallbackInfoReturnable<VoxelShape> ci){
        if(Settings.xrayEnabled){
            if(XRay.isInterestingBlock(this.getBlock())){
                ci.setReturnValue(VoxelShapes.fullCube());
                return;
            }
            ci.setReturnValue(VoxelShapes.empty());
        }
    }
}