/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.view;

import com.sm713179.deckedoutdungeon.controller.GameController;
import com.sm713179.deckedoutdungeon.model.card.Player;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 * @author Samuel McClatchey
 */
public class Menu {
    
    public static void display(GameController gameState) {
        Frame frame = gameState.getFrame();
        int latestScore = gameState.getScore();
        int highScore = gameState.getHighScore();
        
        frame.reset();
        frame.setMainPnlLayout(new GridBagLayout());
        JPanel pnl = new JPanel(new FlowLayout());
        
        boolean isGameOver = false;
        Player player = gameState.getPlayer();
        if(player != null) {
            isGameOver = player.isDead();
        }
        
        String head = "Decked Out Dungeon";
        String btnTxt = "&#9654;New Game";
        if (isGameOver) {
            head = "Game Over&#9760;";
            btnTxt = "&#8617;Try Again";
        }
        
        frame.addLbl("<html><h1 style='font-size:8em;'>" + head + "</hl></html>", 0, 0);
        frame.addBtn("<html><h2 style='font-size:4em;'>" + btnTxt + "</h2></html>", 
                "Start a new game", pnl, (ActionEvent e) -> {
                    gameState.start();
        });
        frame.addLbl("<html><h2 style='font-size:4em;'>&nbsp;</h2></html>", pnl);
        frame.addBtn("<html><h2 style='font-size:4em;'>&#10060;Quit Game</h2></html>", 
                "Exit to desktop", pnl, (ActionEvent e) -> {
                    System.exit(0);
        });
        frame.addPnl(pnl, 0, 1);
        frame.addLbl("<html><h2 style='font-size:4em;'>High Score: " + highScore
                + "</h2></html>", 0, 2);
        
        if (latestScore != 0) {
            frame.addLbl("<html><h2 style='font-size:4em;'>Latest Score: "
                    + latestScore + "</h2></html>", 0, 3);
        }
        
        frame.display();
    }
}