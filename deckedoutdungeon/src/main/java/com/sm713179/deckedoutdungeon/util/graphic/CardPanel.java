/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.graphic;

import com.sm713179.deckedoutdungeon.resource.graphic.RoundRectangle;
import com.sm713179.deckedoutdungeon.util.card.Card;
import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Samuel McClatchey
 */
public class CardPanel {
    
    public static JPanel paintCard(Card card) {
        JPanel pnl = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                setSize(180, 250);
                setPreferredSize(new Dimension(180, 250));
                setToolTipText(card.getName());
                RoundRectangle.paint(g, Color.LIGHT_GRAY, 0, 0, 180, 250, 10, 10);
                RoundRectangle.paint(g, Color.WHITE, 5, 5, 170, 240, 10, 10);
            }
        };
        return pnl;
    }
}
