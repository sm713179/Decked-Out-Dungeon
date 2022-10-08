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
    ImageIcon inactivePortrait;

    public Trap(int dmg, boolean isActive, ImageIcon inactivePortrait, String name, ImageIcon portrait) {
        super(name, portrait);
        this.dmg = dmg;
        this.isActive = isActive;
        this.inactivePortrait = inactivePortrait;
    }

    public int getDmg() {
        return dmg;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public ImageIcon getInactivePortrait() {
        return inactivePortrait;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setInactivePortrait(ImageIcon inactivePortrait) {
        this.inactivePortrait = inactivePortrait;
    }
    
    public void toggleActive() {
        if (isActive) {
            isActive = false;
        } else {
            isActive = true;
        }
    }
}