/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.instance;

import com.sm713179.deckedoutdungeon.util.graphic.Frame;
import com.sm713179.deckedoutdungeon.util.graphic.MenuPanel;

/**
 *
 * @author Samuel McClatchey
 */
public class Menu {
    
    public static void createInstance(Frame frame, boolean isGameOver, int latesScore) {
        
        int highScore = 69; //read frp, txt
        
        MenuPanel.display(frame, isGameOver, highScore, latesScore);
    }
}