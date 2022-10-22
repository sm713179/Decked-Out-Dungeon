/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.card.collection;

import com.sm713179.deckedoutdungeon.util.card.Card;
import com.sm713179.deckedoutdungeon.util.card.Player;
import java.io.Serializable;

/**
 *
 * @author Samuel McClatchey
 */
public class CardGrid implements Serializable {
    Card[][] cardGrid;
    int rows, cols;

    //Boilerplate
    public CardGrid() {}
    
    public CardGrid(Deck deck, Player player, int rows, int cols) {
        cardGrid = new Card[rows][cols];
        this.rows = rows;
        this.cols = cols;
        
        spawnPlayer(player);
        populate(deck);
    }

    public Card[][] getCardGrid() {
        return cardGrid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCardGrid(Card[][] cardGrid) {
        this.cardGrid = cardGrid;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
    
    //Methods
    public final void spawnPlayer(Player player) {
        int row = rows / 2;
        int col = (cols - 1) / 2;
        
        cardGrid[row][col] = player;
    } 
    
    public final void populate(Deck deck) {
        for (int x = 0; x < rows; x++) { 
            for(int y = 0; y < cols; y++) {
                if (cardGrid[x][y] == null) {
                    cardGrid[x][y] = deck.draw();
                } else if (!cardGrid[x][y].getCardType().equals("Player")) { //repopulate
                    deck.bury(cardGrid[x][y]);
                    cardGrid[x][y] = deck.draw();
                }
            }
        }
    }
    
    public Card getCard(int row, int col) {
        return cardGrid[row][col];
    }
    
    public void setCard(int row, int col, Card card) {
        cardGrid[row][col] = card;
    }
}
