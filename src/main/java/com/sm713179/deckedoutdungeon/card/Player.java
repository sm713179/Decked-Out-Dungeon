/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Player extends Card {
    int hp, maxHp;
    Weapon weapon;

    //Boilerplate
    public Player(int hp, int maxHp, Weapon weapon, String name, String iconPath) {
        super(name, iconPath);
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

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    //Methods
    public void heal(int value) {
        hp += value;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }
    
    public void dmg(int value) {
        hp = hp - value;
    }
    
    public boolean isDead() {
        if (hp <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void repairWeapon(int value) {
        weapon.repair(value);
    }
}