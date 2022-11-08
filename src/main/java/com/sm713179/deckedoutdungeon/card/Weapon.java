/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Weapon extends Card {
    int durability, maxDurability;

    //Boilerplate
    public Weapon(int durability, String name, String iconPath) {
        super(name, iconPath);
        this.durability = durability;
        this.maxDurability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }
    
    //Methods
    public void restoreDurability() {
        durability = maxDurability;
    }
    
    public void repair(int value) {
        durability += value;
        if (durability > maxDurability) {
            durability = maxDurability;
        }
    }
}