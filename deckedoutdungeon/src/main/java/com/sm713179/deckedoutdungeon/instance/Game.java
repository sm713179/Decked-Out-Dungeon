/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.instance;

import com.sm713179.deckedoutdungeon.util.card.Player;
import com.sm713179.deckedoutdungeon.util.deck.*;
import com.sm713179.deckedoutdungeon.util.frame.Frame;
import com.sm713179.deckedoutdungeon.util.grid.CardGrid;

/**
 *
 * @author Samuel McClatchey
 */
public class Game {
    
    public static void createInstance(Frame frame) {
        frame.reset();
        
        Deck deck = DeckBuilder.buildDeck("crypt.xml");
        //Create shortsword
        Player player = new Player(10, 12, "Player", "misc/emptyTile.png");
        int rows = 3;
        int cols = 4;
        CardGrid cardGrid = new CardGrid(deck, player, rows, cols);
        
        for (int x = 0; x < rows; x++) {
            String msg = "";
            for (int y = 0; y < cols; y++) {
                msg += cardGrid.getCard(x, y).getName() + ", ";
            }
            System.out.println(msg);
        }
        
        frame.display();
    }
}
