/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.instance;

import com.sm713179.deckedoutdungeon.util.card.Card;
import com.sm713179.deckedoutdungeon.util.deck.Deck;
import com.sm713179.deckedoutdungeon.util.deck.DeckBuilder;
import com.sm713179.deckedoutdungeon.util.frame.Frame;
import java.util.ListIterator;

/**
 *
 * @author Samuel McClatchey
 */
public class Game {
    
    public static void createInstance(Frame frame) {
        frame.reset();
        
        Deck deck = DeckBuilder.buildDeck("crypt.xml");
        String text = "<html>";
        
        ListIterator<Card> deckIterator = deck.getDeck().listIterator();
        int num = 1;
        while (deckIterator.hasNext()) {
            text += num + ". " + deckIterator.next().getName() + "<br/>";
            num++;
        }
        
        text += "</html>";
        frame.addLbl(text);
        
        frame.display();
    }
}
