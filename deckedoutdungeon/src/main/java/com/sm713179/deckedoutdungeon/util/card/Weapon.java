/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Weapon extends Card {
    int durability;
    int maxDurability;

    public Weapon(int durability, int baseDurability, String name, String iconPath) {
        super(name, iconPath);
        this.durability = durability;
        this.maxDurability = baseDurability;
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }
    
    public void restoreDurability() {
        durability = maxDurability;
    }
    
    public void repair(int value) {
        durability = durability + value;
        if (durability > maxDurability) {
            durability = maxDurability;
        }
    }
}