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
public class Item extends Card {
    String type;
    int value;

    public Item(String type, int value, String name, ImageIcon portrait) {
        super(name, portrait);
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(int value) {
        this.value = value;
    }
}