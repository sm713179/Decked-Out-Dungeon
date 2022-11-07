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
    Deck deck;
    CardGrid cardGrid;
    int playerRow, playerCol, level, score;

    //Boilerplate
    public Frame getFrame() {
        return frame;
    }
    
    public Player getPlayer() {
        return player;
    }

    public Deck getDeck() {
        return deck;
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
    public void displayMenu() {
        Menu.display(this);
    }
    
    public void start() {
        Weapon weapon = new Weapon(3, 
                "Sword", "weapon/sword_iron");
        player = new Player(10, 12, weapon,
                "Player", "player/default");

        deck = DeckParser.read("crypt");
        cardGrid = new CardGrid(3, 4);
        int[] playerLocation = cardGrid.spawnPlayer(player);
        playerRow = playerLocation[0];
        playerCol = playerLocation[1];
        cardGrid.populate(deck);
        
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
                    
                    deck.bury(target);
                    cardGrid.shiftCards('U',
                            playerRow, playerCol);
                    cardGrid.setCard(cardGrid.getRows(), playerCol,
                            deck.draw());
                    playerRow -= 1;
                }
            }
            case 65, 37 -> { //Left
                target = cardGrid.getCard(playerRow, playerCol - 1);
                
                if (target != null) {
                    //check card types
                    
                    deck.bury(target);
                    cardGrid.shiftCards('L',
                            playerRow, playerCol);
                    cardGrid.setCard(playerRow, cardGrid.getCols(), 
                            deck.draw());
                    playerCol -= 1;
                }
            }
            case 83, 40 -> { //Down
                target = cardGrid.getCard(playerRow + 1, playerCol);
                
                if (target != null) {
                    //check card types
                    
                    deck.bury(target);
                    cardGrid.shiftCards('D',
                            playerRow, playerCol);
                    cardGrid.setCard(0, playerCol,
                            deck.draw());
                    playerRow += 1;
                }
            }
            case 68, 39 -> { //Right
                target = cardGrid.getCard(playerRow, playerCol + 1);
                
                if (target != null) {
                    //check card types
                    
                    deck.bury(target);
                    cardGrid.shiftCards('R',
                            playerRow, playerCol);
                    cardGrid.setCard(playerRow, 0, 
                            deck.draw());
                    playerCol += 1;
                }
            }
        }
        //should be nested in switch to prevent flashing
        Game.display(this);
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