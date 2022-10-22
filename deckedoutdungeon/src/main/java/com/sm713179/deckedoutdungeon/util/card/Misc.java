/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.card;

/**
 *
 * @author Samuel McClatchey
 */
public class Misc extends Card {

    //Boilerplate
    public Misc() {}
    
    public Misc(String name, String iconPath) {
        super(name, iconPath);
    }
    
    @Override
    public String getCardType() {
        return "Misc";
    }
}