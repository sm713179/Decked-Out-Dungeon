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

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }
    
    public void restoreHp() {
        hp = baseHp;
    }
}