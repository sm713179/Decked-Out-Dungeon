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

/**
 *
 * @author Samuel McClatchey
 */
public class GameController {
    Frame frame = new Frame();
    Deck deck;
    Player player;
    CardGrid cardGrid;
    int level = 0;
    int score = 0;
    int highScore = 0; //Get from txt
    int playerX = 0;
    int playerY = 0;

    //Boilerplate
    public Frame getFrame() {
        return frame;
    }

    public Deck getDeck() {
        return deck;
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
        deck = DeckParser.read("crypt");
        Weapon weapon = new Weapon(3, 
                "Sword", "weapon/sword_iron");
        player = new Player(10, 12, weapon,
                "Player", "player/default");
        
        cardGrid = new CardGrid(3, 4);
        int[] playerAxis = cardGrid.spawnPlayer(player);
        playerX = playerAxis[0];
        playerY = playerAxis[1];
        cardGrid.populate(deck);
        
        System.out.println(playerX + ", " + playerY);
        
        Game.display(this);
    }
}