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
    
    public static int readScore() {
        int score = 0;
        
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("res/highScore.txt"));
            String line = br.readLine();
            
            if (line == null) {
                writeScore(0);
            } else {
                try {
                    score = Integer.parseInt(line);
                    
                } catch (NumberFormatException e) {
                    writeScore(0);
                }
            }
            
        } catch (IOException e) {
           createFile();
        }
        return score;
    }
    
    public static void writeScore(int score) {
        try (Writer wr = new FileWriter("res/highScore.txt")) {
            wr.write(score);
            wr.close();
            
        } catch (IOException e) {
            createFile();
        }
    }
    
    public static void createFile() {
         File highScore = new File("res/highScore.txt");
         
         try {
             highScore.createNewFile();
             writeScore(0);
             
         } catch (IOException e) {
             System.out.println("Failed to create highScore.txt");
         }
    }
}