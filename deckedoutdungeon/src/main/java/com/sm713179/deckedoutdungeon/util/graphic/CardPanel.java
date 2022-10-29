/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.graphic;

import com.sm713179.deckedoutdungeon.resource.graphic.Icon;
import com.sm713179.deckedoutdungeon.resource.graphic.RoundRectangle;
import com.sm713179.deckedoutdungeon.util.card.*;
import java.awt.*;
import javax.swing.ImageIcon;
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
                int cardX = cardWidth / 16;
                int cardY = cardHeight / 16;
                int pnlWidth = cardWidth + cardWidth / 8;
                int pnlHeight = cardHeight + cardWidth / 8;
                
                //Panel
                setSize(pnlWidth, pnlHeight);
                setPreferredSize(new Dimension(pnlWidth, pnlHeight));
                
                //Card
                RoundRectangle.paint(g, Color.DARK_GRAY, cardX, cardY, 
                        cardWidth, cardHeight, 25, 25);
                RoundRectangle.paint(g, Color.WHITE, cardX + 2, cardY + 2, 
                        cardWidth - 4, cardHeight - 4, 25, 25);
                
                //Icon
                int iconSize = cardWidth / 3 * 2;
                
                ImageIcon icon = Icon.resize(card.getIconPath(), 
                        iconSize, iconSize);
                icon.paintIcon(this, g, pnlWidth / 2 - iconSize / 2,
                        pnlHeight / 2 - iconSize / 2);
                
                //Attribute & Tooltips
                int attributeSize = cardWidth / 5;
                String attributePath =
                        "src/main/java/com/sm713179/deckedoutdungeon/resource/icon/attribute/";
                String toolTipTxt = "<html>" + card.getName() + " (";
                
                if (card.isCardType("Mob")) {
                    ImageIcon heart = Icon.resize(attributePath + "heart.png",
                            attributeSize, attributeSize);
                    heart.paintIcon(this, g, cardWidth - attributeSize,
                            cardY + cardX);
                    
                    Mob mob = (Mob) card;
                    
                    toolTipTxt += "Mob)<br />" + "HP: "
                            + mob.getHp() + "/" + mob.getMaxHp();
                    
                } else if (card.isCardType("Item")) {
                    
                } else if (card.isCardType("Weapon") || card.isCardType("Trap")) {
                    ImageIcon diamond = Icon.resize(attributePath + "diamond.png",
                            attributeSize, attributeSize);
                    diamond.paintIcon(this, g, cardX * 2,
                            cardHeight - cardX * 3);
                    
                } else if (card.isCardType("Misc")) {
                    toolTipTxt += "Misc)";
                    
                } else if (card.isCardType("Player")) {
                    ImageIcon heart = Icon.resize(attributePath + "heart.png",
                            attributeSize, attributeSize);
                    heart.paintIcon(this, g, cardWidth - attributeSize,
                            cardY + cardX);
                    
                    Player player = (Player) card;
                    Weapon weapon = player.getWeapon();
                        
                    toolTipTxt += "Player)<br />" + "HP: " + player.getHp()
                            + "/" + player.getMaxHp() + "<br />Weapon ";
                        
                    if (weapon == null) {
                        toolTipTxt += "None";
                    } else {
                        toolTipTxt += weapon.getName() + " ("
                                + weapon.getDurability() + "/"
                                + weapon.getMaxDurability() + ")";
                        
                        ImageIcon diamond = Icon.resize(attributePath + "diamond.png",
                            attributeSize, attributeSize);
                        diamond.paintIcon(this, g, cardX * 2,
                            cardHeight - cardX * 3);
                    }
                }
                
                toolTipTxt += "</html>";
                setToolTipText(toolTipTxt);
            }
        };
        return pnl;
    }
}