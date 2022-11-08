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
                int iconSize = cardWidth / 3 * 2;
                int attributeSize = cardWidth / 5;
                int attributeX, attributeY;
                
                //Panel
                setSize(pnlWidth, pnlHeight);
                setPreferredSize(new Dimension(pnlWidth, pnlHeight));
                
                //Card
                RoundRect.paint(g, Color.DARK_GRAY, cardX, cardY, 
                        cardWidth, cardHeight, 25, 25);
                RoundRect.paint(g, Color.WHITE, cardX + 2, cardY + 2, 
                        cardWidth - 4, cardHeight - 4, 25, 25);
                
                //Icon
                ImageIcon icon = Icon.scale(card.getIconPath(), 
                        iconSize, iconSize);
                icon.paintIcon(this, g, pnlWidth / 2 - iconSize / 2,
                        pnlHeight / 2 - iconSize / 2);
                
                //Tooltips & Attributes
                String toolTipTxt = "<html>" + card.getName() + " (";
                ImageIcon attribute;
                String attributePath = "content/asset/attribute/";
                Font font = new Font("TimesRoman", 
                        Font.PLAIN, attributeSize / 3 * 2);
                FontMetrics metrics = g.getFontMetrics(font);
                g.setColor(Color.WHITE);
                g.setFont(font);
                
                if (card.isType("Mob")) {
                    Mob mob = (Mob) card;
                    String hp = Integer.toString(mob.getHp());
                    
                    toolTipTxt += "Mob)<br />" + "HP: "
                            + hp + "/" + mob.getMaxHp();
                    
                    attributeX = cardWidth - attributeSize;
                    attributeY = cardY + cardX;
                    attribute = Icon.scale(attributePath + "heart.png",
                            attributeSize, attributeSize);
                    attribute.paintIcon(this, g, attributeX, attributeY);  
                    Icon.addLbl(g, attribute, metrics, hp,
                            attributeX, attributeY);
                    
                } else if (card.isType("Item")) {
                    Item item = (Item) card;
                    String value = Integer.toString(item.getValue());
                    
                    toolTipTxt += "Item)";
                    
                    if (!item.getItemType().equals("EXIT")) {
                        toolTipTxt += "<br />" + item.getItemType()
                                + ": " + value;
                        
                        attributeX = cardWidth - attributeSize;
                        attributeY = cardHeight - cardX * 3;
                        attribute = Icon.scale(attributePath + "star.png",
                            attributeSize, attributeSize);
                        attribute.paintIcon(this, g, attributeX, attributeY);
                        Icon.addLbl(g, attribute, metrics, value,
                                attributeX, attributeY);
                    }
                } else if (card.isType("Weapon")) {
                    Weapon weapon = (Weapon) card;
                    String durability = Integer.toString(weapon.getDurability());
                    
                    toolTipTxt += "Weapon)<br />Durability: " + durability;
                    
                    attributeX = cardX * 2;
                    attributeY = cardHeight - cardX * 3;
                    attribute= Icon.scale(attributePath + "diamond.png",
                            attributeSize, attributeSize);
                    attribute.paintIcon(this, g, attributeX, attributeY);
                    Icon.addLbl(g, attribute, metrics, durability,
                            attributeX, attributeY);
                    
                } else if (card.isType("Misc")) {
                    toolTipTxt += "Misc)";
                
                } else if (card.isType("Trap")) {
                    Trap trap = (Trap) card;
                    String dmg = Integer.toString(trap.getDmg());
                    
                    toolTipTxt += "Trap)<br />Damage: " + dmg
                            + "<br />Active: " + trap.isActive();
                    
                    if (trap.isActive()) {
                        attributeX = cardX * 2;
                        attributeY = cardHeight - cardX * 3;
                        attribute = Icon.scale(attributePath + "diamond.png",
                            attributeSize, attributeSize);
                        attribute.paintIcon(this, g, attributeX,attributeY);
                        Icon.addLbl(g, attribute, metrics, dmg,
                                attributeX, attributeY);
                    }
                } else if (card.isType("Player")) {
                    Player player = (Player) card;
                    Weapon weapon = player.getWeapon();
                    String hp = Integer.toString(player.getHp());
                    
                    toolTipTxt += "Player)<br />" + "HP: " + hp + "/"
                            + player.getMaxHp() + "<br />Weapon: ";
                    
                    attributeX = cardWidth - attributeSize;
                    attributeY = cardY + cardX;
                    attribute = Icon.scale(attributePath + "heart.png",
                            attributeSize, attributeSize);
                    attribute.paintIcon(this, g, attributeX, attributeY);  
                    Icon.addLbl(g, attribute, metrics, hp,
                            attributeX, attributeY);
                    
                    if (weapon == null) {
                        toolTipTxt += "None";
                        
                    } else {
                        String durability = Integer.toString(weapon.getDurability());
                        
                        toolTipTxt += weapon.getName() + " (" + durability + "/"
                                + weapon.getMaxDurability() + ")";
                        
                        attributeX = cardX * 2;
                        attributeY = cardHeight - cardX * 3;
                        attribute = Icon.scale(attributePath + "diamond.png",
                            attributeSize, attributeSize);
                        attribute.paintIcon(this, g, attributeX,attributeY);
                        Icon.addLbl(g, attribute, metrics, durability,
                                attributeX, attributeY);
                    }
                }
                toolTipTxt += "</html>";
                setToolTipText(toolTipTxt);
            }
        };
        return pnl;
    }
}