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
        
        status[0] = "<html><h3 style='font-size:2em;'><span style='color:Green'>&#11014;</span>Level: " + level
                + "<br />" + "<span style='color:Red'>&#9829;</span>HP: " + hp + "/" + maxHp + "</h3></html>";
        status[1] = "<html><h3 style='font-size:2em;'><pre>     </pre><h3></html>";
        status[2] = "<html><h3 style='font-size:2em;'><span style='color:#FFD700'>&#9899;</span>Score: " + score
                + "<br />" + "<span style='color:#708090'>&#9876;</span>Weapon: ";

        if (weapon == null) {
            status[2] += "None";
        } else {
            status[2] += weapon.getDurability() + "/" + weapon.getMaxDurability()
                    + " (" + weapon.getName() + ")";
        }
        
        status[2] += "</h3></html>";
        status[3] = "<html><h2 style='font-size:2.5em;'>Status</h2></html>";
        
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