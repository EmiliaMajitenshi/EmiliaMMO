package me.EmiliaMMO.system.listeners;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.EmiliaMMO.skill.SkillOrder;
import me.EmiliaMMO.data.players.PlayerConfigurator;
import me.EmiliaMMO.players.classes.PlayerClassPool;

public class PlayerListeners implements Listener {
    public Player p;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerUse(PlayerInteractEvent event) {

        Player player = (Player) event.getPlayer();
        boolean playerLeftClick = event.getAction() == Action.LEFT_CLICK_AIR;
        boolean playerRightClick = event.getAction() == Action.RIGHT_CLICK_AIR;
        boolean playerWeaponCheck = player.getInventory().getItemInMainHand().getType() == PlayerClassPool
                .getPlayerClass(player).getClassWeapon();
        // || event.getAction() == Action.RIGHT_CLICK_BLOCK

        p = (Player) event.getPlayer();

        if (playerLeftClick) {
            if (!SkillOrder.isSkillReady(player) && (SkillOrder.noMainHandStart(player, "Left"))) {
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

        } else if (playerRightClick) {
            if ((!SkillOrder.isSkillReady(player)) && (SkillOrder.noMainHandStart(player, "Right"))) {
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
        e.setJoinMessage(ChatColor.GOLD + "[EmiliaMMO] " + e.getPlayer().getName() + " joined");
        e.getPlayer().sendMessage("HI");
        SkillOrder.initMap(e.getPlayer());

        ArrayList<String> classNames = (ArrayList<String>) PlayerClassPool.getAllClassNames();
        classNames.forEach(names -> e.getPlayer().sendMessage(names));

        e.getPlayer().sendMessage(PlayerConfigurator.getPlayerClassString(e.getPlayer()));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.GOLD + "[EmiliaMMO] " + e.getPlayer().getName() + " left");
    }

}
