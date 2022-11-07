/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.controller;

import com.sm713179.deckedoutdungeon.view.Game;
import com.sm713179.deckedoutdungeon.model.card.collection.*;
import com.sm713179.deckedoutdungeon.util.parser.DeckParser;
import com.sm713179.deckedoutdungeon.model.card.*;
import com.sm713179.deckedoutdungeon.view.Frame;
import com.sm713179.deckedoutdungeon.view.Menu;
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
    int playerRow, playerCol, level, score;

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
    
    //Methods
    public int getHighScore() {
        return 0; //get from txt
    }
    
    public void displayMenu() {
        Menu.display(this);
    }
    
    public void start() {
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
        
        Game.display(this);
        frame.addKeyListener(this);
    }
    
    public void move(int keyCode) {
        Card target;
        
        switch (keyCode) {
            case 87, 38 -> {  //Up
                target = cardGrid.getCard(playerRow - 1, playerCol);
                
                if (target != null) {
                    //check card types
                    
                    cardGrid.shiftCards('U',
                            playerRow, playerCol);
                    playerRow -= 1;
                    
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
                    
                    Game.display(this);
                }
            }
        }
        if (player.isDead()) {
            if (score > getHighScore()) {
                //scoreParser.write(score)
            }
            displayMenu();
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