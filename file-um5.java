package com.example.grokguns.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BasicGun extends Item {
    public BasicGun(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        
        // Play a shooting sound
        user.playSound(SoundEvents.ENTITY_ARROW_SHOOT, 1.0F, 1.0F);
        
        if (!world.isClient) {
            // Spawn a projectile (snowball for simplicity)
            SnowballEntity projectile = new SnowballEntity(world, user);
            projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);  // Speed and accuracy
            world.spawnEntity(projectile);
        }
        
        // Optional: Add cooldown or ammo check here
        user.getItemCooldownManager().set(this, 20);  // 1-second cooldown
        
        return TypedActionResult.success(itemStack, world.isClient());
    }
}