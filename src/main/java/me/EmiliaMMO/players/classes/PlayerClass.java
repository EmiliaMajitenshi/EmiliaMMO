package me.EmiliaMMO.players.classes;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public interface PlayerClass {
    public String getClassName();

    public String getClassDescription();

    public ChatColor getClassColor();

    public Material getClassWeapon();

    public String getClassMainHand();

    public void getFirstSkill(); // "Left", "Left", "Left"

    public void getSecondSkill(); // "Left", "Left", "Right"

    public void getThirdSkill(); // "Left", "Right", "Right"

    public void getFinalSkill(); // "Left", "Right", "Left"
}
