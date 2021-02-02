package me.EmiliaMMO.skill;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.Sound;

public class SkillOrder {
    public static void skillOrderReminder(Player player, String[] skillOrder) {
        String message = ChatColor.GOLD + skillOrder[0] + " " + skillOrder[1] + " " + skillOrder[2];
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    public static void skillReleasedReminder(Player player, String[] skillOrder) {
        player.getLocation().getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
        String message = ChatColor.GOLD + skillOrder[0] + " " + skillOrder[1] + " " + skillOrder[2]
                + " Has been released!";
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }
}