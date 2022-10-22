/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Player extends Card {
    int hp, maxHp, level, score;
    Weapon weapon;

    //Boilerplate
    public Player() {}

    public Player(int hp, int maxHp, Weapon weapon, String name, String iconPath) {
        super(name, iconPath);
        this.hp = hp;
        this.maxHp = maxHp;
        this.weapon = weapon;
        level = 1;
        score = 0;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }
    
    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    @Override
    public String getCardType() {
        return "Player";
    }
    
    //Methods
    public void incLevel() {
        level++;
    }
    
    public void incScore(int value) {
        score += value;
    }
    
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
        if (hp < 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public void repairWeapon(int value) {
        weapon.repair(value);
    }
}