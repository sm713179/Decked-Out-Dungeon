/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.model.card;

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
        return "src/main/java/com/sm713179/deckedoutdungeon/content/icon/trap/alt/"
                + altIconPath + ".png";
    }

    //Methods
    public void reactivate() {
        active = true;
    }
    
    public void toggleActive() {
        if (active) {
            active = false;
        } else {
            active = true;
        }
    }
}