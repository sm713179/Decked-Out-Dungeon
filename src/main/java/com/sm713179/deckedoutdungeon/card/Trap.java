/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Trap extends Card {
    int dmg;
    boolean active;
    String altIconPath;

    //Boilerplate
    public Trap(int dmg, String altIconPath, String name, String iconPath) {
        super(name, iconPath);
        this.dmg = dmg;
        this.active = true;
        this.altIconPath = altIconPath;
    }

    public int getDmg() {
        return dmg;
    }

    public boolean isActive() {
        return active;
    }

    public String getAltIconPath() {
        return "asset/trap/alt/" + altIconPath + ".png";
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}