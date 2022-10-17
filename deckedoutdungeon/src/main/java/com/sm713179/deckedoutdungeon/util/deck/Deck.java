/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.deck;

import com.sm713179.deckedoutdungeon.util.card.*;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author Samuel McClatchey
 */
public class Deck {
    Stack<Card> deck = new Stack<Card>();
    
    public Stack<Card> getDeck() {
        return deck;
    }

    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public Card draw() {
        Card card = deck.pop();
        return card;
    }
    
    public void add(Card card) {
        deck.push(card);
    }
    
    public void bury(Card card) {
        deck.push(card);
        shuffle();
    }
}