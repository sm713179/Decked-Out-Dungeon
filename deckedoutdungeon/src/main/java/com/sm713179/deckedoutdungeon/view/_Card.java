/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.view;

import com.sm713179.deckedoutdungeon.util.graphic.*;
import com.sm713179.deckedoutdungeon.model.card.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Samuel McClatchey
 */
public class _Card {
    
    public static JPanel display(Card card) {
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
                RoundRect.paint(g, Color.DARK_GRAY, cardX, cardY, 
                        cardWidth, cardHeight, 25, 25);
                RoundRect.paint(g, Color.WHITE, cardX + 2, cardY + 2, 
                        cardWidth - 4, cardHeight - 4, 25, 25);
                
                //Icon
                int iconSize = cardWidth / 3 * 2;
                
                ImageIcon icon = Icon.scale(card.getIconPath(), 
                        iconSize, iconSize);
                icon.paintIcon(this, g, pnlWidth / 2 - iconSize / 2,
                        pnlHeight / 2 - iconSize / 2);
                
                //Attribute & Tooltips
                int attributeSize = cardWidth / 5;
                String attributePath =
                        "src/main/java/com/sm713179/deckedoutdungeon/content/icon/attribute/";
                String toolTipTxt = "<html>" + card.getName() + " (";
                
                if (card.isType("Mob")) {
                    ImageIcon heart = Icon.scale(attributePath + "heart.png",
                            attributeSize, attributeSize);
                    heart.paintIcon(this, g, cardWidth - attributeSize,
                            cardY + cardX);
                    
                    Mob mob = (Mob) card;
                    
                    //Add txt to heart
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, attributeSize / 4 * 3)); 
                    g.drawString(Integer.toString(mob.getHp()),  cardWidth - attributeSize / 3 * 2,  cardY + cardX + attributeSize / 3 * 2);
                    
                    toolTipTxt += "Mob)<br />" + "HP: "
                            + mob.getHp() + "/" + mob.getMaxHp();
                    
                } else if (card.isType("Item")) {
                    Item item = (Item) card;
                    
                    toolTipTxt += "Item)";
                    
                    if (!item.isType("EXIT")) {
                        //Display attribute
                        
                        //Display txt on attribute
                        
                        toolTipTxt += "<br />" + item.getItemType()
                                + ": " + item.getValue();
                    }
                } else if (card.isType("Weapon") || card.isType("Trap")) {
                    ImageIcon diamond = Icon.scale(attributePath + "diamond.png",
                            attributeSize, attributeSize);
                    diamond.paintIcon(this, g, cardX * 2,
                            cardHeight - cardX * 3);
                    
                    if (card.isType("Weapon")) {
                        Weapon weapon = (Weapon) card;
                        
                        //Add txt to diamond
                        
                        toolTipTxt += "Weapon)<br />Durability: "
                                + weapon.getDurability();
                    } else {
                        Trap trap = (Trap) card;
                        
                        //Add txt to diamoond
                        
                        toolTipTxt += "Trap)";
                    }
                } else if (card.isType("Misc")) {
                    toolTipTxt += "Misc)";
                    
                } else if (card.isType("Player")) {
                    ImageIcon heart = Icon.scale(attributePath + "heart.png",
                            attributeSize, attributeSize);
                    heart.paintIcon(this, g, cardWidth - attributeSize,
                            cardY + cardX);
                    
                    Player player = (Player) card;
                    Weapon weapon = player.getWeapon();
                    
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, attributeSize / 4 * 3)); 
                    g.drawString(Integer.toString(player.getHp()),  cardWidth - attributeSize / 3 * 2,  cardY + cardX + attributeSize / 3 * 2);
                        
                    toolTipTxt += "Player)<br />" + "HP: " + player.getHp()
                            + "/" + player.getMaxHp() + "<br />Weapon: ";
                        
                    if (weapon == null) {
                        toolTipTxt += "None";
                    } else {
                        toolTipTxt += weapon.getName() + " ("
                                + weapon.getDurability() + "/"
                                + weapon.getMaxDurability() + ")";
                        
                        ImageIcon diamond = Icon.scale(attributePath + "diamond.png",
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