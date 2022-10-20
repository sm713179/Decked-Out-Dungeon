/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.graphic;

import com.sm713179.deckedoutdungeon.util.card.Card;
import com.sm713179.deckedoutdungeon.util.card.Player;
import com.sm713179.deckedoutdungeon.util.card.collection.CardGrid;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.*;

/**
 *
 * @author Samuel McClatchey
 */
public class GamePanel {
    
    public static void display(Frame frame, Player player, CardGrid cardGrid) {
        frame.reset();
        frame.setMainPnl(new GridBagLayout());
        
        displayStatus(frame, player);
        displayGrid(frame, cardGrid);
        displayLog(frame); //Nothing yet
        
        frame.display();
    }
    
    public static void displayStatus(Frame frame, Player player) {
        JPanel pnl = new JPanel(new GridBagLayout());
        String[] status = player.getStatus();
        
        String stats = "<html><h3 style='font-size:2em;'>" + status[0]
                + "<br />" + status[1] + "</h3></html>";
        frame.addLbl(stats, pnl, 0, 0);
        stats = "<html><h3 style='font-size:2em;'><pre>     </pre><h3></html>";
        frame.addLbl(stats, pnl, 1, 0);
        stats = "<html><h3 style='font-size:2em;'>" + status[2]
                + "<br />" + status[3] + "</h3></html>";
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