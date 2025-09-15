package com.example.grokguns;

import com.example.grokguns.items.BasicGun;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class GrokGunsMod implements ModInitializer {
    public static final String MOD_ID = "grokguns";

    // Register the gun item
    public static final Item BASIC_GUN = new BasicGun(new FabricItemSettings().maxCount(1));

    @Override
    public void onInitialize() {
        // Register the item
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "basic_gun"), BASIC_GUN);
        
        // Add to creative tab (e.g., Combat tab)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(BASIC_GUN);
        });
        
        System.out.println("GrokGuns mod initialized!");
    }
}