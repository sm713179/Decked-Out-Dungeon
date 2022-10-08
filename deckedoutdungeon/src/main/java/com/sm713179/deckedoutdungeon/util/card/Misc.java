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
public class Misc extends Card {
    boolean isExit;

    public Misc(boolean isExit, String name, ImageIcon portrait) {
        super(name, portrait);
        this.isExit = isExit;
    }

    public boolean getIsExit() {
        return isExit;
    }

    public void setIsExit(boolean isExit) {
        this.isExit = isExit;
    }
}