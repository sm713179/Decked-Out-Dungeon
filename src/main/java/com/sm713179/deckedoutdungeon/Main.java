/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.sm713179.deckedoutdungeon;

import com.sm713179.deckedoutdungeon.controller.GameController;

/**
 *
 * @author Samuel McClatchey
 */
public class Main {

    public static void main(String[] args) {
        GameController game = new GameController();
        game.displayMenu();
    }
}