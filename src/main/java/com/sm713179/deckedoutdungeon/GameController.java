/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon;

import com.sm713179.deckedoutdungeon.card.*;
import com.sm713179.deckedoutdungeon.card.collection.*;
import com.sm713179.deckedoutdungeon.ui.*;
import com.sm713179.deckedoutdungeon.util.parser.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Samuel McClatchey
 */
public class GameController implements KeyListener {
    Frame frame = new Frame();
    Player player;
    CardGrid cardGrid;
    Card target;
    int playerRow, playerCol, level, score;
    int highScore = ScoreParser.read();
    boolean trapsActive = true;

    //Boilerplate
    public Frame getFrame() {
        return frame;
    }
    
    public Player getPlayer() {
        return player;
    }

    public CardGrid getCardGrid() {
        return cardGrid;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
    
    public int getHighScore() {
        return highScore;
    }
    
    //Methods
    public void displayMenu() {
        Menu.display(this);
    }
    
    public void start() {
        init();
        Game.display(this);
        frame.addKeyListener(this);
    }
    
    public void init() {
        player = new Player(10, null,
                "Player", "player/default");
        Deck deck = DeckParser.read("crypt");
        
        cardGrid = new CardGrid(deck, 3, 4);
        playerRow = cardGrid.getRows() / 2;
        playerCol = (cardGrid.getCols() - 1) / 2;
        cardGrid.setCard(playerRow, playerCol, player); //Spawn Player
        cardGrid.populate();
        
        level = 0;
        score = 0;
    }
    
    public void updatePlayer() {
        if (player.isDead()) {
            if (score > highScore) {
                ScoreParser.write(score);
                highScore = score;
            }
            displayMenu();
        }
        cardGrid.setCard(playerRow, playerCol,player);
    }
    
    public void updateTraps() {
        trapsActive = !trapsActive;
        
        for (Card[] row : cardGrid.getGrid()) {
            for (Card card : row) {
                if (card.isType("Trap")) {
                    Trap trap = (Trap) card;
                    trap.setActive(trapsActive);
                    card = trap;
                }
            }
        }
    }
    
    //Actions
    public void move(int keyCode) {
        switch (keyCode) {
            case 87, 38 -> {  //Up
                target = cardGrid.getCard(playerRow - 1, playerCol);
                
                if (target != null) {
                    if (attack()) {
                        cardGrid.shiftCards('U',
                                playerRow, playerCol);
                        playerRow -= 1;
                        interact();
                    }
                    Game.display(this);
                }
            }
            case 65, 37 -> { //Left
                target = cardGrid.getCard(playerRow, playerCol - 1);
                
                if (target != null) {
                    if (attack()) {
                        cardGrid.shiftCards('L',
                                playerRow, playerCol);
                        playerCol -= 1;
                        interact();
                    }
                    Game.display(this);
                }
            }
            case 83, 40 -> { //Down
                target = cardGrid.getCard(playerRow + 1, playerCol);
                
                if (target != null) {
                    if (attack()) {
                        cardGrid.shiftCards('D',
                                playerRow, playerCol);
                        playerRow += 1;
                        interact();
                    }
                    Game.display(this);
                }
            }
            case 68, 39 -> { //Right
                target = cardGrid.getCard(playerRow, playerCol + 1);
                
                if (target != null) {
                    if (attack()) {
                        cardGrid.shiftCards('R',
                                playerRow, playerCol);
                        playerCol += 1;
                        interact();
                    }
                    Game.display(this);
                }
            }
        }
        updatePlayer();
        updateTraps();
    }
    
    public boolean attack() {
        if (target.isType("Mob")) {
            Mob mob = (Mob) target;
            int hp = mob.getHp();
            
            if (player.getWeapon() != null) {
                Weapon weapon = player.getWeapon();
                int durability = weapon.getDurability();
                
                if (durability > hp) {
                    weapon.degrade(hp);
                    score += ThreadLocalRandom.current().nextInt(2, 4);
                    return true;
                
                } else if (durability == hp) {
                    player.setWeapon(null);
                    score += ThreadLocalRandom.current().nextInt(2, 4);
                    return true;
                    
                } else {
                    mob.dmg(durability);
                    player.setWeapon(null);
                    return false;
                }
            } else {
                player.dmg(hp);
                return true;
            }
        } else {
            return true;
        }
    }
    
    public void interact() {
        if (target.isType("Item")) {
            Item item = (Item) target;
            String itemType = item.getItemType();
            int value = item.getValue();
            
            switch (itemType) {
                case "HEAL" -> {
                    player.heal(value);
                }
                case "SCORE" -> {
                    score += value;
                }
                case "REPAIR" -> {
                    if (player.getWeapon() != null) {
                        player.repairWeapon(value);
                    }
                }
                case "EXIT" -> {
                    level += 1;
                    score += 10;
                    cardGrid.populate();
                }
            }
        } else if (target.isType("Weapon")) {
            Weapon weapon = Weapon.copy((Weapon) target);
            player.setWeapon(weapon);
            
        } else if (target.isType("Trap")) {
            Trap trap = (Trap) target;
            
            if (trap.isActive()) {
                player.dmg(trap.getDmg());
            }
        }
    }
   
    @Override
    public void keyPressed(KeyEvent e) {
        move(e.getKeyCode());
    }
    
    //Unused
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}