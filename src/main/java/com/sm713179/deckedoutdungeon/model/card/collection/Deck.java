/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.model.card.collection;

import com.sm713179.deckedoutdungeon.model.card.Card;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author Samuel McClatchey
 */
public class Deck {
    Stack<Card> deck = new Stack<>();
    
    //Methods
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