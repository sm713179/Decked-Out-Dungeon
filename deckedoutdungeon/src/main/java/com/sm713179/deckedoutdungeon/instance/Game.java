/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.instance;

import com.sm713179.deckedoutdungeon.util.card.*;
import com.sm713179.deckedoutdungeon.util.deck.*;
import com.sm713179.deckedoutdungeon.util.frame.Frame;
import com.sm713179.deckedoutdungeon.util.grid.CardGrid;
import com.sm713179.deckedoutdungeon.util.stat.Status;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Samuel McClatchey
 */
public class Game {
    
    public static void createInstance(Frame frame) {
        
        Deck deck = DeckBuilder.buildDeck("crypt.xml");
        //Create default weapon
        Player player = new Player(10, 12, null, "Player", "misc/emptyTile.png");
        Status stats = new Status(player);
        CardGrid cardGrid = new CardGrid(deck, player, 3, 4);
        
        frame.setMainPnl(new GridBagLayout());
        displayGame(frame, stats, cardGrid);
    }
    
    //Put display stuff in separate method?
    public static void displayGame(Frame frame, Status stats, CardGrid cardGrid) {
        frame.reset();
        
        displayStats(frame, stats);
        displayGrid(frame, cardGrid);
        displayLog(frame); //Nothing yet
        
        frame.display();
    }
    
    public static void displayStats(Frame frame, Status status) {
        JPanel pnl = new JPanel(new GridBagLayout());
        
        String stats = "<html><h3 style='font-size:2em;'>" + status.getLevel()
                + "<br />" + status.getHp() + "</h3></html>";
        frame.addLbl(stats, pnl, 0, 0);
        stats = "<html><h3 style='font-size:2em;'><pre>     </pre><h3></html>";
        frame.addLbl(stats, pnl, 1, 0);
        stats = "<html><h3 style='font-size:2em;'>" + status.getScore()
                + "<br />" + status.getWeapon() + "</h3></html>";
        frame.addLbl(stats, pnl, 2, 0);
        
        Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 4, true),
                "<html><h2 style='font-size:2.5em;'>Status</h2></html>");
        Border margin = new EmptyBorder(8, 8, 8, 8);
        pnl.setBorder(new CompoundBorder(border, margin));
        
        frame.addPnl(pnl, 0, 0);
    }
    
    public static void displayGrid(Frame frame, CardGrid cardGrid) {
        JPanel pnl = new JPanel(new FlowLayout());
        int rows = cardGrid.getRows();
        int cols = cardGrid.getCols();
        
        String msg = "<html>";
        for (Card[] row : cardGrid.getCardGrid()) {
            for (Card card : row) {
                msg += card.getName() + ", ";
            }
            msg += "<br />";
        }
        msg += "</html>";
        
        frame.addLbl(msg, pnl);
        frame.addPnl(pnl, 1, 0);
    }
    
    public static void displayLog(Frame frame) { //accept log later
        //WIP
    }
}
