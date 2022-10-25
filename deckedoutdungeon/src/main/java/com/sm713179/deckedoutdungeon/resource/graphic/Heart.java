/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.resource.graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

/**
 *
 * @author Samuel McClatchey
 */
public class Heart {
    
    public static void paint(Graphics g, Color color, int x, int y, 
            int width, int height) {
        Graphics2D g2D = (Graphics2D) g;
        g.setColor(color);
        
        Path2D.Double path = new Path2D.Double();
        
        path.moveTo(x + width / 2, y + height / 4);
        path.curveTo(x + width / 8 * 7, y - height / 8, 
                x + width + width / 8 * 3, y + height / 8, 
                x + width, y + height / 2);
        path.lineTo(x + width /2, y + height);
        path.lineTo(x, y + height / 2);
        path.curveTo(x - width / 8 * 3, y + height / 8, 
                x + width / 8, y - height / 8, x + width / 2, y + height / 4);
        path.closePath();
        
        g2D.fill(path);
    }
}
