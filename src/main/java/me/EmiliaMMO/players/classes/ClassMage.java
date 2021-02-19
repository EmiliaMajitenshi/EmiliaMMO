package me.EmiliaMMO.players.classes;

import org.bukkit.ChatColor;
import org.bukkit.Material;

import me.EmiliaMMO.system.annotations.CharacterClass;

@CharacterClass
public class ClassMage implements PlayerClass {

    @Override
    public String getClassName() {
        return "MAGE";
    }

    @Override
    public String getClassDescription() {
        return "Born a Wise Man";
    }

    @Override
    public ChatColor getClassColor() {
        return ChatColor.DARK_PURPLE;
    }

    @Override
    public Material getClassWeapon() {
        return Material.STICK;
    }

    @Override
    public String getClassMainHand() {
        return "Left";
    }

    @Override
    public void getFirstSkill() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getSecondSkill() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getThirdSkill() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getFinalSkill() {
        // TODO Auto-generated method stub

    }

}
