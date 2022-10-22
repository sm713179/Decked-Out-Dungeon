/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.card;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Samuel McClatchey
 */
public class Item extends Card {
    ItemType itemType;
    int value;

    //Boilerplate
    public Item(ItemType itemType, int value, String name, String iconPath) {
        super(name, iconPath);
        this.itemType = itemType;
        this.value = value;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public int getValue() {
        return value;
    }
    
    @Override
    public String getCardType() {
        return "Item";
    }
        
    //Methods
    public void getRandomValue() {
        value = ThreadLocalRandom.current().nextInt(2, 5);
    }
}