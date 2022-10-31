/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.model.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Mob extends Card {
    int hp, maxHp;

    //Boilerplate
    public Mob(int hp, int maxHp, String name, String iconPath) {
        super(name, iconPath);
        this.hp = hp;
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }
    
    //Methods
    public void restoreHp() {
        hp = maxHp;
    }
}