/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sm713179.deckedoutdungeon.util.deck;

import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author Samuel McClatchey
 */
public class DeckReader {
    
    public Deck build(File file) {
        Deck deck = new Deck();
        String name;
        ImageIcon icon;
        
        /*
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();

            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            
        }
        */
        
        return deck;
    }
}