/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.graphic;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Samuel McClatchey
 */
public class RoundRect {
    
    public static void paint(Graphics g, Color color, int x, int y,
            int width, int height, int arcWidth, int arcHeight) {
        
        g.setColor(color);
        g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
}