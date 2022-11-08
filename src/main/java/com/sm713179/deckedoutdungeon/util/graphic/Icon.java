/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.graphic;

import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Samuel McClatchey
 */
public class Icon {
    
    public static ImageIcon scale(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        icon = new ImageIcon(icon.getImage().getScaledInstance(
                width, height, java.awt.Image.SCALE_SMOOTH));
        return icon;
    }
    
    public static void addLbl(Graphics g, ImageIcon icon, FontMetrics metrics,
            String txt, int iconX, int iconY) {
        
        g.drawString(txt, iconX + (icon.getIconWidth() - metrics.stringWidth(txt)) / 2,
                iconY + ((icon.getIconHeight() - metrics.getHeight()) / 2) + metrics.getAscent());
    }
}