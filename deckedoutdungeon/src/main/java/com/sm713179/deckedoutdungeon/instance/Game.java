/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.instance;

import com.sm713179.deckedoutdungeon.util.card.*;
import com.sm713179.deckedoutdungeon.util.card.collection.*;
import com.sm713179.deckedoutdungeon.util.graphic.*;

/**
 *
 * @author Samuel McClatchey
 */
public class Game {
    
    public static void createInstance(Frame frame) {
        Deck deck = DeckBuilder.buildDeck("crypt.xml");
        //Create default weapon
        Player player = new Player(10, 12, null, "Player", "misc/emptyTile.png");
        CardGrid cardGrid = new CardGrid(deck, player, 3, 4);
        
        GamePanel.display(frame, player, cardGrid);
    }
}