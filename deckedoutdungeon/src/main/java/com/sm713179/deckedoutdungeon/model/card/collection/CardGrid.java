/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.model.card.collection;

import com.sm713179.deckedoutdungeon.model.card.Card;
import com.sm713179.deckedoutdungeon.model.card.Player;

/**
 *
 * @author Samuel McClatchey
 */
public class CardGrid {
    Card[][] grid;
    int rows, cols;

    //Boilerplate
    public CardGrid(int rows, int cols) {
        grid = new Card[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public Card[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    
    //Methods
    public int[] spawnPlayer(Player player) {
        int row = rows / 2;
        int col = (cols - 1) / 2;
        
        grid[row][col] = player;
        
        return new int[] {row, col};
    } 
    
    public void populate(Deck deck) {
        for (int x = 0; x < rows; x++) { 
            for(int y = 0; y < cols; y++) {
                if (grid[x][y] == null) {
                    grid[x][y] = deck.draw();
                } else if (!grid[x][y].isType("Player")) { //repopulate
                    deck.bury(grid[x][y]);
                    grid[x][y] = deck.draw();
                }
            }
        }
    }
    
    public Card getCard(int row, int col) {
        return grid[row][col];
    }
    
    public void setCard(int row, int col, Card card) {
        grid[row][col] = card;
    }
}
