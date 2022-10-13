/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sm713179.deckedoutdungeon;

import com.sm713179.deckedoutdungeon.util.card.*;
import com.sm713179.deckedoutdungeon.util.deck.*;
import com.sm713179.deckedoutdungeon.util.frame.Frame;
import java.util.ListIterator;

/**
 *
 * @author Samuel McClatchey
 */
public class Main {

    public static void main(String[] args) {
        DeckBuilder deckBuilder = new DeckBuilder();
        Deck deck = deckBuilder.buildDeck("crypt.xml");
        Frame frame = new Frame();
        String text = "<html>";
        
        ListIterator<Card> deckIterator = deck.getDeck().listIterator();
        int num = 1;
        while (deckIterator.hasNext()) {
            text += num + ". " + deckIterator.next().getName() + "<br/>";
            num++;
        }
        
        text += "</html>";
        frame.addTxt(text);
        frame.displayFrame();
    }
}