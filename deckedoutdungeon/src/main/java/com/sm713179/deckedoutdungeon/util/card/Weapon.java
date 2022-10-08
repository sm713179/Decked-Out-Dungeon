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
public class Weapon extends Card {
    int durability;
    int baseDurability;

    public Weapon(int durability, int baseDurability, String name, ImageIcon portrait) {
        super(name, portrait);
        this.durability = durability;
        this.baseDurability = baseDurability;
    }

    public int getDurability() {
        return durability;
    }

    public int getBaseDurability() {
        return baseDurability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setBaseDurability(int baseDurability) {
        this.baseDurability = baseDurability;
    }
    
    public void restoreDurability() {
        durability = baseDurability;
    }
}