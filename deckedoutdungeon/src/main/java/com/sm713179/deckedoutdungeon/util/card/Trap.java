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
    String altIconPath;

    //Boilerplate
    public Trap(int dmg, boolean isActive, String altIconPath, String name, String iconPath) {
        super(name, iconPath);
        this.dmg = dmg;
        this.isActive = isActive;
        this.altIconPath = "src/main/java/com/sm713179/deckedoutdungeon/resource/icon/trap/inactive/"
                + altIconPath;
    }

    public int getDmg() {
        return dmg;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getAltIconPath() {
        return altIconPath;
    }

    //Methods
    public void reactivate() {
        isActive = true;
    }
    
    public void toggleActive() {
        if (isActive) {
            isActive = false;
        } else {
            isActive = true;
        }
    }
}