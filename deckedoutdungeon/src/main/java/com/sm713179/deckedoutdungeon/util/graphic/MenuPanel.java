/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.graphic;

import com.sm713179.deckedoutdungeon.instance.Game;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Samuel McClatchey
 */
public class MenuPanel {
    
    public static void display(Frame frame, boolean isGameOver, int highScore, int latestScore) {
        frame.reset();
        frame.setMainPnl(new GridBagLayout());
        JPanel pnl = new JPanel(new FlowLayout());
        
        String head = "Decked Out Dungeon";
        String btnTxt = "&#9654;New Game";
        if (isGameOver) {
            head = "Game Over&#9760;";
            btnTxt = "&#8617;Try Again";
        }
        
        frame.addLbl("<html><h1 style='font-size:8em;'>" + head + "</hl></html>", 0, 0);
        frame.addBtn("<html><h2 style='font-size:4em;'>" + btnTxt + "</h2></html>", 
                "Start a new game", pnl, (ActionEvent e) -> {
                    Game.createInstance(frame);
        });
        frame.addLbl("<html><h2 style='font-size:4em;'>&nbsp;</h2></html>", pnl);
        frame.addBtn("<html><h2 style='font-size:4em;'>&#10060;Quit Game</h2></html>", 
                "Exit to desktop", pnl, (ActionEvent e) -> {
                    System.exit(0);
        });
        frame.addPnl(pnl, 0, 1);
        frame.addLbl("<html><h2 style='font-size:4em;'>High Score: " + highScore
                + "</h2></html>", 0, 2);
        
        if (isGameOver) {
            frame.addLbl("<html><h2 style='font-size:4em;'>Latest Score: "
                    + latestScore + "</h2></html>", 0, 3);
        }
        
        frame.display();
    }
}