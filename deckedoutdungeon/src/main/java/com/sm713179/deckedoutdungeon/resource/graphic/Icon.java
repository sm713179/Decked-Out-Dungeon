/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.resource.graphic;

import javax.swing.ImageIcon;

/**
 *
 * @author Samuel McClatchey
 */
public class Icon {
    
    public static ImageIcon resize(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        icon = new ImageIcon(icon.getImage().getScaledInstance(
                width, height, java.awt.Image.SCALE_SMOOTH));
        return icon;
    }
}