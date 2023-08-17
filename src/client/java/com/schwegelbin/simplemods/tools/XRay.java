package com.schwegelbin.simplemods.tools;

import net.minecraft.block.Block;

import java.util.HashSet;

public class XRay{
    private static HashSet<String> xRayBlocks = new HashSet<>();

    public XRay(){
        // Ores
        xRayBlocks.add("Block{minecraft:coal_ore}");
        xRayBlocks.add("Block{minecraft:iron_ore}");
        xRayBlocks.add("Block{minecraft:gold_ore}");
        xRayBlocks.add("Block{minecraft:diamond_ore}");
        xRayBlocks.add("Block{minecraft:emerald_ore}");
        xRayBlocks.add("Block{minecraft:lapis_ore}");
        xRayBlocks.add("Block{minecraft:redstone_ore}");
        // Deepslate Ores
        xRayBlocks.add("Block{minecraft:deepslate_coal_ore}");
        xRayBlocks.add("Block{minecraft:deepslate_iron_ore}");
        xRayBlocks.add("Block{minecraft:deepslate_gold_ore}");
        xRayBlocks.add("Block{minecraft:deepslate_diamond_ore}");
        xRayBlocks.add("Block{minecraft:deepslate_emerald_ore}");
        xRayBlocks.add("Block{minecraft:deepslate_lapis_ore}");
        xRayBlocks.add("Block{minecraft:deepslate_redstone_ore}");
        // Ore Blocks
        xRayBlocks.add("Block{minecraft:coal_block}");
        xRayBlocks.add("Block{minecraft:iron_block}");
        xRayBlocks.add("Block{minecraft:gold_block}");
        xRayBlocks.add("Block{minecraft:diamond_block}");
        xRayBlocks.add("Block{minecraft:emerald_block}");
        xRayBlocks.add("Block{minecraft:lapis_block}");
        xRayBlocks.add("Block{minecraft:redstone_block}");
        // Special
        xRayBlocks.add("Block{minecraft:chest}");
        xRayBlocks.add("Block{minecraft:mob_spawner}");
        xRayBlocks.add("Block{minecraft:spawner}");
        xRayBlocks.add("Block{minecraft:bookshelf}");
        // Nether
        xRayBlocks.add("Block{minecraft:ancient_debris}");
        xRayBlocks.add("Block{minecraft:nether_gold_ore}");
        xRayBlocks.add("Block{minecraft:nether_quartz_ore}");
        xRayBlocks.add("Block{minecraft:blackstone}");
        xRayBlocks.add("Block{minecraft:glowstone}");
        xRayBlocks.add("Block{minecraft:bone_block}");
        xRayBlocks.add("Block{minecraft:obsidian}");
        xRayBlocks.add("Block{minecraft:nether_brick}");
        xRayBlocks.add("Block{minecraft:magma_block}");
        // Liquids
        xRayBlocks.add("Block{minecraft:lava}");
        xRayBlocks.add("Block{minecraft:water}");
    }

    public static boolean isInterestingBlock(Block block){
        return xRayBlocks.contains(block.toString());
    }
}
