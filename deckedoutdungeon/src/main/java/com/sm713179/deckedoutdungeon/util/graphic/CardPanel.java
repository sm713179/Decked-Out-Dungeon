/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.graphic;

import com.sm713179.deckedoutdungeon.resource.graphic.Heart;
import com.sm713179.deckedoutdungeon.resource.graphic.RoundRectangle;
import com.sm713179.deckedoutdungeon.util.card.*;
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
                
                int cardWidth = 180;
                int cardHeight = 240;
                int cardX = cardWidth / 8;
                int cardY = cardHeight / 8;
                setSize(cardWidth + cardWidth / 8, cardHeight + cardWidth / 8);
                setPreferredSize(new Dimension(cardWidth + cardWidth / 8, 
                        cardHeight + cardWidth / 8));
                RoundRectangle.paint(g, Color.LIGHT_GRAY, cardX, cardY, 
                        cardWidth, cardHeight, 10, 10);
                RoundRectangle.paint(g, Color.WHITE, cardX + 1, cardY + 1, 
                        cardWidth - 2, cardHeight - 2, 10, 10);
                
                String toolTipTxt = "<html>" + card.getName() + " (";
                //iconImg = new ImageIcon(card.getIconPath)
                
                if (card.isCardType("Mob") || card.isCardType("Player")) {
                    Heart.paint(g, Color.RED, cardWidth - cardX, 
                            cardX + cardX / 4 * 3, cardWidth / 6, cardHeight / 6);
                    
                    if (card.isCardType("Mob")) {
                        Mob mob = (Mob) card;
                        toolTipTxt += "Mob)<br />" + "HP: "
                                + mob.getHp() + "/" + mob.getMaxHp();
                    } else {
                        Player player = (Player) card;
                        Weapon weapon = player.getWeapon();
                        
                        toolTipTxt += "Player)<br />" + "HP: "
                                + player.getHp() + "/" + player.getMaxHp()
                                + "<br />Weapon ";
                        
                        if (weapon == null) {
                            toolTipTxt += "None";
                        } else {
                            toolTipTxt += weapon.getName() + " ("
                                    + weapon.getDurability() + "/"
                                    + weapon.getMaxDurability() + ")";
                        }
                    }
                }
                
                //Item
                //Misc
                //Weapon
                //Trap
                
                toolTipTxt += "</html>";
                setToolTipText(toolTipTxt);
            }
        };
        return pnl;
    }
}
