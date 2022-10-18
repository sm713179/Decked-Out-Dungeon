/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.grid;

import com.sm713179.deckedoutdungeon.util.card.Card;
import com.sm713179.deckedoutdungeon.util.deck.Deck;

/**
 *
 * @author Samuel McClatchey
 */
public class CardGrid {
    Card[][] cardGrid;

    public CardGrid(Deck deck, int rows, int cols) {
        cardGrid = new Card[rows][cols];
        
        for (int x = 0; x < rows; x++) { 
            for(int y = 0; y < cols; y++) {
                cardGrid[x][y] = deck.draw();
            }
        }
    }
    
    public Card getCard(int row, int col) {
        return cardGrid[row][col];
    }
}
