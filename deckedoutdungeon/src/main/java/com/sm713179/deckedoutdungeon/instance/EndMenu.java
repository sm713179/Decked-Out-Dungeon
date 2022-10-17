/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.instance;

import com.sm713179.deckedoutdungeon.util.frame.Frame;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JPanel;

/**
 *
 * @author Samuel McClatchey
 */
public class EndMenu {
    
    public static void createInstance(Frame frame, int latestScore) {
        frame.reset();
        
        int highscore = 69; //get from txt file
        
        frame.setMainPnl(new GridBagLayout());
        JPanel pnl = new JPanel(new FlowLayout());
        
        frame.addLbl("<html><h1 style='font-size:8em;'>Game Over&#9760;</hl></html>", 0, 0);
        frame.addBtn("<html><h2 style='font-size:4em;'>&#8617;Try Again</h2></html>", "Start a new game", pnl, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.createInstance(frame);
            }
        });
        pnl.add(Box.createHorizontalStrut(28));
        frame.addBtn("<html><h2 style='font-size:4em;'>&#10060;Quit Game</h2></html>", "Exit to desktop", pnl, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.addPnl(pnl, 0, 1);
        frame.addLbl("<html><h2 style='font-size:4em;'>Highscore: " + highscore + "</h2></html>", 0, 2);
        frame.addLbl("<html><h2 style='font-size:4em;'>Latest Score: " + latestScore + "</h2></html>", 0, 3);
        
        frame.display();
    }
}
