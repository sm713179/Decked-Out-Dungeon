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
    ImageIcon portrait;

    public Card(String name, ImageIcon portrait) {
        this.name = name;
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getPortrait() {
        return portrait;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPortrait(ImageIcon portrait) {
        this.portrait = portrait;
    }
}