/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.model.card;

/**
 *
 * @author Samuel McClatchey
 */
public abstract class Card {
    String name, iconPath;

    //Boilerplate
    public Card(String name, String iconPath) {
        this.name = name;
        this.iconPath = iconPath;
    }

    public String getName() {
        return name;
    }

    public String getIconPath() {
        return "src/main/java/com/sm713179/deckedoutdungeon/content/icon/"
                + iconPath + ".png";
    }
    
    //Methods
    public boolean isType(String type) {
        type = "class com.sm713179.deckedoutdungeon.model.card." + type;
        return type.equals(this.getClass().toString());
    }
}