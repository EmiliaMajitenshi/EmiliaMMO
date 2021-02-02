package me.EmiliaMMO.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.EmiliaMMO.skill.SkillOrder;

public class PlayerListeners implements Listener {
    public Player p;
    public String[] skillOrder = { "-", "-", "-" };
    public int counter = 0;

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {

        boolean playerLeftClick = event.getAction() == Action.LEFT_CLICK_AIR;
        boolean playerRightClick = event.getAction() == Action.RIGHT_CLICK_AIR;
        // || event.getAction() == Action.RIGHT_CLICK_BLOCK
        Player player = (Player) event.getPlayer();
        p = (Player) event.getPlayer();

        if (playerLeftClick && (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL)) {
            if (counter != 2) {
                skillOrder[counter] = "Left";
                counter = counter + 1;
                SkillOrder.skillOrderReminder(player, skillOrder);
            } else if (counter == 2) {
                skillOrder[counter] = "Left";
                SkillOrder.skillReleasedReminder(player, skillOrder);
                if (skillOrder[0].equals("Left") && skillOrder[1].equals("Left") && skillOrder[2].equals("Left")) {
                    player.getLocation().getWorld().createExplosion(player.getTargetBlock(null, 12).getLocation(), 2,
                            false, false);
                } else if (skillOrder[0].equals("Left") && skillOrder[1].equals("Right")
                        && skillOrder[2].equals("Left")) {
                    player.getWorld()
                            .spawnEntity(player.getEyeLocation().add(player.getLocation().getDirection()),
                                    EntityType.SNOWBALL)
                            .setVelocity(player.getEyeLocation().add(player.getLocation().getDirection()).getDirection()
                                    .multiply(4.0));
                }
                counter = 0;
                for (int i = 0; i < skillOrder.length; i++) {
                    skillOrder[i] = "-";
                }
            }

        } else if (playerRightClick
                && (player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SHOVEL)) {
            if ((counter != 2) && (counter != 0)) {
                skillOrder[counter] = "Right";
                counter = counter + 1;
                SkillOrder.skillOrderReminder(player, skillOrder);
            } else if (counter == 2) {
                skillOrder[counter] = "Right";
                SkillOrder.skillReleasedReminder(player, skillOrder);
                counter = 0;
                for (int i = 0; i < skillOrder.length; i++) {
                    skillOrder[i] = "-";
                }
            }

        }
    }
}
