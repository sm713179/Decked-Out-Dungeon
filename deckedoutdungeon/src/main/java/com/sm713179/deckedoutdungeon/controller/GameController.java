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

/**
 *
 * @author Samuel McClatchey
 */
public class GameController {
    
    public static void createInstance(Frame frame) {
        Deck deck = DeckParser.read("crypt");
        Weapon weapon = new Weapon(3, 
                "Sword", "weapon/sword_iron");
        Player player = new Player(10, 12, weapon,
                "Player", "player/default");
        CardGrid cardGrid = new CardGrid(deck, player, 3, 4);
        
        Game.display(frame, player, cardGrid);
    }
}