package me.EmiliaMMO.skill;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.Sound;

public class SkillOrder {
    static HashMap<UUID, String[]> skillOrderMap = new HashMap<UUID, String[]>();

    public static boolean isMapContainsPlayer(Player player) {
        return skillOrderMap.containsKey(player.getUniqueId());
    }

    public static String[] getMapPlayerSkillOrder(Player player) {
        return skillOrderMap.get(player.getUniqueId());
    }

    public static void initMap(Player player) {
        skillOrderMap.put(player.getUniqueId(), new String[] { "-", "-", "-", "-", "-" });
    }

    public static boolean isSkillReady(Player player) {
        if (getMapPlayerSkillOrder(player)[1].equals("-"))
            return false;
        return true;
    }

    public static boolean noAutoAttackStart(Player player) {
        if (getMapPlayerSkillOrder(player)[0].equals("-"))
            return false;
        return true;
    }

    public static void setLatestSkillOrder(Player player, String key) {
        String[] tempOrder = getMapPlayerSkillOrder(player);
        for (int i = 0; i < tempOrder.length; i++) {
            if (tempOrder[i].equals("-")) {
                tempOrder[i] = key;
                skillOrderMap.put(player.getUniqueId(), tempOrder);
                return;
            }
        }
    }

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