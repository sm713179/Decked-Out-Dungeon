/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.card;

import javax.swing.ImageIcon;

/**
 *
 * @author Samuel McClatchey
 */
public class Trap extends Card {
    int dmg;
    boolean isActive;
    ImageIcon inactiveIcon;

    public Trap(int dmg, boolean isActive, String inactiveIconPath, String name, String iconPath) {
        super(name, iconPath);
        this.dmg = dmg;
        this.isActive = isActive;
        this.inactiveIcon = new ImageIcon("src/main/java/com/sm713179/deckedoutdungeon/asset/icon/trap/inactive/" + inactiveIconPath);
    }

    public int getDmg() {
        return dmg;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public ImageIcon getInactiveIcon() {
        return inactiveIcon;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setInactiveIcon(String inactiveIconPath) {
        this.inactiveIcon = new ImageIcon("src/main/java/com/sm713179/deckedoutdungeon/asset/icon/trap/inactive/" + inactiveIconPath);
    }
    
    public void toggleActive() {
        if (isActive) {
            isActive = false;
        } else {
            isActive = true;
        }
    }
}