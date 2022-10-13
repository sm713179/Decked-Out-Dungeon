/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.deck;

import com.sm713179.deckedoutdungeon.util.card.*;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Samuel McClatchey
 */
public class DeckBuilder {
    
    public Deck buildDeck(String deckPath) {
        Deck deck = new Deck();
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("src/main/java/com/sm713179/deckedoutdungeon/resource/deck/" + deckPath));
            doc.getDocumentElement().normalize();
            
            String name, iconPath, inactiveIconPath, cardType;
            int value, hp, dmg, durability, count;
            ItemType itemType;
            
            NodeList cardList = doc.getElementsByTagName("card");
            for(int i = 0; i < cardList.getLength(); i++) {
                Node cardNode = cardList.item(i);
                
                if (cardNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) cardNode;
                    
                    cardType = element.getElementsByTagName("type").item(0).getTextContent();
                    count = parseInt(element.getElementsByTagName("count").item(0).getTextContent());
                    name = element.getElementsByTagName("name").item(0).getTextContent();
                    iconPath = element.getElementsByTagName("icon").item(0).getTextContent();
                    
                    if (cardType.equals("Mob")) {
                        hp = parseInt(element.getElementsByTagName("hp").item(0).getTextContent());
                        Mob mob = new Mob(hp, hp, name, iconPath);
                        
                        for(int y = 0; y < count; y++) {
                            deck.add(mob);
                        }
                    } else if (cardType.equals("Item")) {
                        itemType = ItemType.valueOf(element.getElementsByTagName("itemType").item(0).getTextContent());
                        value = parseInt(element.getElementsByTagName("value").item(0).getTextContent());
                        Item item = new Item(itemType, value, name, iconPath);
                        
                        for(int y = 0; y < count; y++) {
                            deck.add(item);
                        }
                    } else if (cardType.equals("Misc")) {
                        Misc misc = new Misc(name, iconPath);
                        
                        for(int y = 0; y < count; y++) {
                            deck.add(misc);
                        }
                    } else if (cardType.equals("Weapon")) {
                        durability = parseInt(element.getElementsByTagName("durability").item(0).getTextContent());
                        Weapon weapon = new Weapon(durability, durability, name, iconPath);
                        
                        for(int y = 0; y < count; y++) {
                            deck.add(weapon);
                        }
                    } else if (cardType.equals("Trap")) {
                        dmg = parseInt(element.getElementsByTagName("dmg").item(0).getTextContent());
                        inactiveIconPath = element.getElementsByTagName("inactiveIcon").item(0).getTextContent();
                        Trap trap = new Trap(dmg, false, inactiveIconPath, name, iconPath);
                        
                        for(int y = 0; y < count; y++) {
                            deck.add(trap);
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        
        deck.shuffle();
        return deck;
    }
}