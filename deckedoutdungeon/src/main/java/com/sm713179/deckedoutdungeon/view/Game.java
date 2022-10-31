/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.view;

import com.sm713179.deckedoutdungeon.view.Frame;
import com.sm713179.deckedoutdungeon.view._Card;
import com.sm713179.deckedoutdungeon.model.card.*;
import com.sm713179.deckedoutdungeon.model.card.collection.CardGrid;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.*;

/**
 *
 * @author Samuel McClatchey
 */
public class Game {
    
    public static void display(Frame frame, Player player, CardGrid cardGrid) {
        frame.reset();
        frame.setMainPnlLayout(new GridBagLayout());
        
        displayStatus(frame, player);
        displayGrid(frame, cardGrid);
        displayLog(frame);
        
        frame.display();
    }
    
    public static void displayStatus(Frame frame, Player player) {
        JPanel pnl = new JPanel(new GridBagLayout());
        Weapon weapon = player.getWeapon();
        String status;
        
        status = "<html><h3 style='font-size:2em;'><span style='color:Green'>&#11014;</span>Level: "
                + player.getLevel() + "<br />" + "<span style='color:Red'>&#9829;</span>HP: "
                + player.getHp() + "/" + player.getMaxHp() + "</h3></html>";
        frame.addLbl(status, pnl, 0, 0);
        status = "<html><h3 style='font-size:2em;'><pre>     </pre><h3></html>";
        frame.addLbl(status, pnl, 1, 0);
        status = "<html><h3 style='font-size:2em;'><span style='color:#FFD700'>&#9899;</span>Score: "
                + player.getScore() + "<br />" + "<span style='color:#708090'>&#9876;</span>Weapon: ";
        
        if (weapon == null) {
            status += "None";
        } else {
            status += weapon.getName() + " (" + weapon.getDurability() + "/"
                    + weapon.getMaxDurability() + ")";
        }
        
        status += "</h3></html>";
        frame.addLbl(status, pnl, 2, 0);
        status = "<html><h2 style='font-size:2.5em;'>Status</h2></html>";
        
        Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Color.black, 4, true), status);
        Border margin = new EmptyBorder(8, 8, 8, 8);
        pnl.setBorder(new CompoundBorder(border, margin));
        frame.addPnl(pnl, 0, 0);
    }
    
    public static void displayGrid(Frame frame, CardGrid cardGrid) {
        JPanel gridPnl = new JPanel(new GridBagLayout());
        int x = 0;
        int y = 0;
        
        for (Card[] row : cardGrid.getCardGrid()) {
            for (Card card : row) {
                JPanel cardPnl = _Card.display(card);
                frame.addPnl(cardPnl, gridPnl, x, y);
                x++;
            }
            x = 0;
            y++;
        }
        
        frame.addPnl(gridPnl, 2, 0);
    }

    
    public static void displayLog(Frame frame) { //accept log later
        JPanel pnl = new JPanel();
        
        //WIP
        
        frame.addPnl(pnl, 4, 0);
    }
}