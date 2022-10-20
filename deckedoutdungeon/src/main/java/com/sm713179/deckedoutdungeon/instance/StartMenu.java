/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.instance;

import com.sm713179.deckedoutdungeon.util.graphic.Frame;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Samuel McClatchey
 */
public class StartMenu {
    
    public static void createInstance(Frame frame) {
        frame.reset();
        
        int highScore = 69; //get from txt file
        
        frame.setMainPnl(new GridBagLayout());
        JPanel pnl = new JPanel(new FlowLayout());
        
        frame.addLbl("<html><h1 style='font-size:8em;'>Decked Out Dungeon</hl></html>", 0, 0);
        frame.addBtn("<html><h2 style='font-size:4em;'>&#9654;New Game</h2></html>", "Start a new game", pnl, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.createInstance(frame);
            }
        });
        frame.addLbl("<html><h2 style='font-size:4em;'>&nbsp;</h2></html>", pnl);
        frame.addBtn("<html><h2 style='font-size:4em;'>&#10060;Quit Game</h2></html>", "Exit to desktop", pnl, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.addPnl(pnl, 0, 1);
        frame.addLbl("<html><h2 style='font-size:6em;'>High Score: " + highScore + "</h2></html>", 0, 2);
        
        frame.display();
    }
}