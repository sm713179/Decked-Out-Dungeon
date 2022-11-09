/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon;

import com.sm713179.deckedoutdungeon.card.*;
import com.sm713179.deckedoutdungeon.card.collection.*;
import com.sm713179.deckedoutdungeon.ui.*;
import com.sm713179.deckedoutdungeon.util.parser.DeckParser;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    int highScore = 0; //get from txt
    boolean areTrapsActive = true;

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
        Weapon weapon = new Weapon(3, 
                "Sword", "weapon/sword_iron");
        player = new Player(10, 12, weapon,
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
                //scoreParser.write(score)
                highScore = score;
            }
            displayMenu();
        }
        cardGrid.setCard(playerRow, playerCol,player);
    }
    
    public void updateTraps() {
        areTrapsActive = !areTrapsActive;
        
        for (Card[] row : cardGrid.getGrid()) {
            for (Card card : row) {
                if (card.isType("Trap")) {
                    Trap trap = (Trap) card;
                    trap.setActive(areTrapsActive);
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
                    //check card types
                    
                    cardGrid.shiftCards('U',
                            playerRow, playerCol);
                    playerRow -= 1;
                    interact();
                    
                    Game.display(this);
                }
            }
            case 65, 37 -> { //Left
                target = cardGrid.getCard(playerRow, playerCol - 1);
                
                if (target != null) {
                    //check card types
                    
                    cardGrid.shiftCards('L',
                            playerRow, playerCol);
                    playerCol -= 1;
                    interact();
                    
                    Game.display(this);
                }
            }
            case 83, 40 -> { //Down
                target = cardGrid.getCard(playerRow + 1, playerCol);
                
                if (target != null) {
                    //check card types
                    
                    cardGrid.shiftCards('D',
                            playerRow, playerCol);
                    playerRow += 1;
                    interact();
                    
                    Game.display(this);
                }
            }
            case 68, 39 -> { //Right
                target = cardGrid.getCard(playerRow, playerCol + 1);
                
                if (target != null) {
                    //check card types

                    cardGrid.shiftCards('R',
                            playerRow, playerCol);
                    playerCol += 1;
                    interact();
                    
                    Game.display(this);
                }
            }
        }
        updatePlayer();
        updateTraps();
    }
    
    public void attack() {
        if (target.isType("Mob")) {
            //WIP
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
                    player.repairWeapon(value);
                }
                case "EXIT" -> {
                    level += 1;
                    score += 10;
                    cardGrid.populate();
                }
            }
        } else if (target.isType("Weapon")) {
            Weapon weapon = (Weapon) target;
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