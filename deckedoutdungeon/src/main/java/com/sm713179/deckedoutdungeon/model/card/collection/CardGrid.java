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
        return rows - 1;
    }

    public int getCols() {
        return cols - 1;
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
        try {
            return grid[row][col];
        } catch (Exception e) {
            return null;
        }
    }
    
    public void setCard(int row, int col, Card card) {
        grid[row][col] = card;
    }
    
    public void shiftCards(char direction, int displacerRow, int displacerCol) {
        switch (direction) {
            case 'U':
                grid[displacerRow - 1][displacerCol] = grid[displacerRow][displacerCol];
                
                for (int row = displacerRow; row < rows - 1; row++) {
                    grid[row][displacerCol] = grid[row + 1][displacerCol];
                }
                break;
            case 'L':
                grid[displacerRow][displacerCol - 1] = grid[displacerRow][displacerCol];
                
                for (int col = displacerCol; col < cols - 1; col++) {
                    grid[displacerRow][col] = grid[displacerRow][col + 1];
                }
                break;
            case 'D':
                grid[displacerRow + 1][displacerCol] = grid[displacerRow][displacerCol];
                
                for (int row = displacerRow; row > 0; row--) {
                    grid[row][displacerCol] = grid[row - 1][displacerCol];
                }
                break;
            case 'R':
                grid[displacerRow][displacerCol + 1] = grid[displacerRow][displacerCol];
                
                for (int col = displacerCol; col > 0; col--) {
                    grid[displacerRow][col] = grid[displacerRow][col - 1];
                }
                break;
        }
    }
}
