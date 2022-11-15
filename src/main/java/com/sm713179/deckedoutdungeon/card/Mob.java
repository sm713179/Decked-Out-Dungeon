/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Mob extends Card {
    int hp, maxHp;

    //Boilerplate
    public Mob(int hp, String name, String iconPath) {
        super(name, iconPath);
        this.hp = hp;
        this.maxHp = hp;
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
    
    public void dmg(int ap) {
        hp -= ap;
    }
    
    public static Mob copy(Mob mob) {
        return new Mob(mob.hp, mob.name, mob.iconPath);
    }
}