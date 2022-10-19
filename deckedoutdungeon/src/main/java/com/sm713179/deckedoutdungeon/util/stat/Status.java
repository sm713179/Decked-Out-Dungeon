/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.stat;

import com.sm713179.deckedoutdungeon.util.card.Player;
import com.sm713179.deckedoutdungeon.util.card.Weapon;

/**
 *
 * @author Samuel McClatchey
 */
public class Status {
    Player player;
    int level;
    int score;

    public Status(Player player) {
        this.player = player;
        this.level = 1;
        this.score = 0;
    }
    
    public String getHp() {
        return "<span style='color:Red'>&#9829;</span>HP: " + player.getHp() + "/" + player.getMaxHp();
    }
    
    public String getWeapon() {
        String weaponStat = "<span style='color:#708090'>&#9876;</span>Weapon: ";
        Weapon weapon = player.getWeapon();
        
        if (weapon == null) {
            weaponStat += "None";
        } else {
            weaponStat += weapon.getDurability() + "/" + weapon.getMaxDurability() + " (" + weapon.getName() + ")";
        }
        
        return weaponStat;
    }
    
    public String getLevel() {
        return "<span style='color:Green'>&#11014;</span>Level: " + level;
    }
    
    public String getScore() {
        return "<span style='color:#FFD700'>&#9899;</span>Score: " + score;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void increaseLevel() {
        level++;
    }
    
    public void increaseScore(int value) {
        score += value;
    }
}
