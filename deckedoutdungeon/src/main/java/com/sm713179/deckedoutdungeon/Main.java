/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sm713179.deckedoutdungeon;

import com.sm713179.deckedoutdungeon.util.card.*;
import com.sm713179.deckedoutdungeon.util.deck.*;
import java.util.ListIterator;

/**
 *
 * @author Samuel McClatchey
 */
public class Main {

    public static void main(String[] args) {
        DeckBuilder deckBuilder = new DeckBuilder();
        Deck deck = deckBuilder.buildDeck("crypt.xml");
        
        Card card = deck.draw();
        System.out.println(card.getName());
        
        ListIterator<Card> deckIterator = deck.getDeck().listIterator();
        int num = 1;
        while (deckIterator.hasNext()) {
            System.out.println(num + ". " + deckIterator.next().getName());
            num++;
        }
    }
}