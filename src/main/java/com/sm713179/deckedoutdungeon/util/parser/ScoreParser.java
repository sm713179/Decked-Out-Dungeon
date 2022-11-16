/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author Samuel McClatchey
 */
public class ScoreParser {
    
    public static int read() {
        int score = 0;
        
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("res/highScore.txt"));
            String line = br.readLine();
            
            if (line == null) {
                write(0);
            } else {
                try {
                    score = Integer.parseInt(line);
                    
                } catch (NumberFormatException e) {
                    write(0);
                }
            }
            
        } catch (IOException e) {
           newFile();
        }
        return score;
    }
    
    public static void write(int score) {
        try (Writer w = new FileWriter("res/highScore.txt")) {
            w.write(Integer.toString(score));
            w.close();
            
        } catch (IOException e) {
            newFile();
        }
    }
    
    public static void newFile() {
         File highScore = new File("res/highScore.txt");
         
         try {
             highScore.createNewFile();
             write(0);
             
         } catch (IOException e) {
             System.out.println("Failed to create highScore.txt");
         }
    }
}