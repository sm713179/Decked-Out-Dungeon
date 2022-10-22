/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Mob extends Card {
    int hp, baseHp;

    //Boilerplate
    public Mob(int hp, int baseHp, String name, String iconPath) {
        super(name, iconPath);
        this.hp = hp;
        this.baseHp = baseHp;
    }

    public int getHp() {
        return hp;
    }

    public int getBaseHp() {
        return baseHp;
    }
    
    @Override
    public String getCardType() {
        return "Mob";
    }
    
    //Methods
    public void restoreHp() {
        hp = baseHp;
    }
}