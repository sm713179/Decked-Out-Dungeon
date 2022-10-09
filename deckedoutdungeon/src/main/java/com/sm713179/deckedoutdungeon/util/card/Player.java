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
public class Player extends Card {
    int hp;
    int maxHp;
    Weapon weapon;

    public Player(int hp, int maxHp, Weapon weapon, String name, ImageIcon portrait) {
        super(name, portrait);
        this.hp = hp;
        this.maxHp = maxHp;
        this.weapon = weapon;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}