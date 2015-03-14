/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorelectronica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import simuladorelectronica.Piezas.Circle;

/**
 *
 * @author AdrianM
 */
public class Lienzo extends Canvas implements KeyListener{
    private int height;
    private int width;
    private int x = 10;
    private int y = 10;
    Graphics cuadro;
    Graphics cuadro2;
    
    
    public Lienzo(int height, int width) {
        this.height = height;
        this.width = width;
        addKeyListener(this);
    }
    
    
    public void paint(Graphics g) {
        cuadro = g;
        cuadro2 = g; 
        cuadro.setColor(Color.red);
        cuadro.fillRect(x, y, 10, 10);
        cuadro2.fillRect(x, y, 30, 30);
        Circle circle = new Circle(x, y, height, width);
        circle.fillOval(x, y, width, height);
        
    }
    
    public void moveCuadro() {
         
    }
    public void setPos(int x, int y){
        this.x=x;
        this.y=y;
        repaint();
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'a') {
            System.err.println("move");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        x++;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    
    
    
    
    
    
    
}


