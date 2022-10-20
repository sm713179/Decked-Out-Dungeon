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
    
    public void incLevel() {
        level++;
    }
    
    public void incScore(int value) {
        score += value;
    }
    
    public String[] getStatus() {
        String[] status = new String[4];
        
        status[0] = "<span style='color:Green'>&#11014;</span>Level: " + level;
        status[1] = "<span style='color:Red'>&#9829;</span>HP: " + hp + "/" + maxHp;
        status[2] = "<span style='color:#FFD700'>&#9899;</span>Score: " + score;
        
        status[3] = "<span style='color:#708090'>&#9876;</span>Weapon: ";
        if (weapon == null) {
            status[3] += "None";
        } else {
            status[3] += weapon.getDurability() + "/" + weapon.getMaxDurability() + " (" + weapon.getName() + ")";
        }
        
        return status;
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