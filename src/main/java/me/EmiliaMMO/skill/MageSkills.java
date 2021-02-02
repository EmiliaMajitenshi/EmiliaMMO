package me.EmiliaMMO.skill;

import org.bukkit.entity.Player;

public class MageSkills {

    public void MageFirstSkill(Player player) {
        player.getLocation().getWorld().createExplosion(player.getTargetBlock(null, 12).getLocation(), 2, false, false);
    }
}
