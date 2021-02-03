package me.EmiliaMMO.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import me.EmiliaMMO.skill.SkillOrder;

public class PlayerListeners implements Listener {
    public Player p;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerUse(PlayerInteractEvent event) {

        boolean playerLeftClick = event.getAction() == Action.LEFT_CLICK_AIR;
        boolean playerRightClick = event.getAction() == Action.RIGHT_CLICK_AIR;
        // || event.getAction() == Action.RIGHT_CLICK_BLOCK
        Player player = (Player) event.getPlayer();
        p = (Player) event.getPlayer();

        if (playerLeftClick && (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL)) {
            if (!SkillOrder.isSkillReady(player)) {
                SkillOrder.setLatestSkillOrder(player, "Left");
                SkillOrder.skillOrderReminder(player, SkillOrder.getMapPlayerSkillOrder(player));
            } else if (SkillOrder.isSkillReady(player)) {
                SkillOrder.setLatestSkillOrder(player, "Left");
                SkillOrder.skillOrderReminder(player, SkillOrder.getMapPlayerSkillOrder(player));
                if (SkillOrder.getMapPlayerSkillOrder(player)[0].equals("Left")
                        && SkillOrder.getMapPlayerSkillOrder(player)[1].equals("Left")
                        && SkillOrder.getMapPlayerSkillOrder(player)[2].equals("Left")) {
                    player.getLocation().getWorld().createExplosion(player.getTargetBlock(null, 12).getLocation(), 2,
                            false, false);
                } else if (SkillOrder.getMapPlayerSkillOrder(player)[0].equals("Left")
                        && SkillOrder.getMapPlayerSkillOrder(player)[1].equals("Right")
                        && SkillOrder.getMapPlayerSkillOrder(player)[2].equals("Left")) {
                    player.getWorld()
                            .spawnEntity(player.getEyeLocation().add(player.getLocation().getDirection()),
                                    EntityType.SNOWBALL)
                            .setVelocity(player.getEyeLocation().add(player.getLocation().getDirection()).getDirection()
                                    .multiply(4.0));
                }
                SkillOrder.initMap(player);
            }

        } else if (playerRightClick
                && (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL)) {
            if ((!SkillOrder.isSkillReady(player)) && (SkillOrder.noAutoAttackStart(player))) {
                SkillOrder.setLatestSkillOrder(player, "Right");
                SkillOrder.skillOrderReminder(player, SkillOrder.getMapPlayerSkillOrder(player));
            } else if (SkillOrder.isSkillReady(player)) {
                SkillOrder.setLatestSkillOrder(player, "Right");
                SkillOrder.skillOrderReminder(player, SkillOrder.getMapPlayerSkillOrder(player));
                SkillOrder.initMap(player);
            }

        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.GOLD + "Hrac " + e.getPlayer().getName() + " joined");
        SkillOrder.initMap(e.getPlayer());
    }

}
