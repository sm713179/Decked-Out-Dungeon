/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.card;

import javax.swing.ImageIcon;

/**
 *
 * @author Samuel McClatchey
 */
public abstract class Card {
    String name;
    ImageIcon icon;

    //Boilerplate
    public Card(String name, String iconPath) {
        this.name = name;
        this.icon = new ImageIcon(
                "src/main/java/com/sm713179/deckedoutdungeon/resource/icon/" + iconPath);
    }

    public String getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }
    
    //Methods
    public boolean isCardType(String cardType) {
        cardType = "class com.sm713179.deckedoutdungeon.util.card." + cardType;
        return cardType.equals(this.getClass().toString());
    }
}