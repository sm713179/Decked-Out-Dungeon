/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Samuel McClatchey
 */
public class Frame {
    JFrame frame = new JFrame("Decked Out Dungeon");
    
    public void addTxt(String txt) {
        frame.setLayout(new FlowLayout());
        
        JLabel item = new JLabel(txt);
        frame.add(item);
    }
    
    public void displayFrame() {
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(resolution.width, resolution.height);
        frame.setVisible(true);
    }
}
