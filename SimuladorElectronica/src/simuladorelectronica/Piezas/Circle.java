/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorelectronica.Piezas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 *
 * @author AdrianM
 */
public class Circle{

    private int x;
    private int y;
    private int height;
    private int width;
    
   
     
    public Circle(int x, int y,int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    } 
    
    public int getY() {
        return y;
    }
    
    
            
    
    
    
}
