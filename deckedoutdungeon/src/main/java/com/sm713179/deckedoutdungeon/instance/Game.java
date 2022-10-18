/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.instance;

import com.sm713179.deckedoutdungeon.util.card.Card;
import com.sm713179.deckedoutdungeon.util.deck.Deck;
import com.sm713179.deckedoutdungeon.util.deck.DeckBuilder;
import com.sm713179.deckedoutdungeon.util.frame.Frame;
import com.sm713179.deckedoutdungeon.util.grid.CardGrid;
import static java.awt.SystemColor.text;
import java.util.ListIterator;

/**
 *
 * @author Samuel McClatchey
 */
public class Game {
    
    public static void createInstance(Frame frame) {
        frame.reset();
        
        Deck deck = DeckBuilder.buildDeck("crypt.xml");
        int rows = 3;
        int cols = 4;
        CardGrid cardGrid = new CardGrid(deck, 3, 4);
        
        System.out.println(rows + ", " + cols);
        
        for (int x = 0; x < rows; x++) {
            String msg = "";
            for (int y = 0; y < cols; y++) {
                msg += cardGrid.getCard(x, y).getName() + ", ";
            }
            System.out.println(msg);
        }
        
        //System.out.println(deck.getDeck().toArray().length);
        
        frame.display();
    }
}
