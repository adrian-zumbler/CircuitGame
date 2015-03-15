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
import simuladorelectronica.Piezas.Cable;

/**
 *
 * @author AdrianM
 */
public class Lienzo extends Canvas implements KeyListener{
    private int height;
    private int width;
    private int x = 10;
    private int y = 10;
    Circle circle = new Circle(10, 10,10, 10);
    Cable cable = new Cable();
    
    
    public Lienzo(int height, int width) {
        this.height = height;
        this.width = width;
        addKeyListener(this);
    }
    
    
    public void paint(Graphics g) {
       
        g.fillRect(x, y, 30, 30);
        g.fillOval(circle.getX(), circle.getY(), 30, 30);
        g.drawLine(10, 10, 40, 60);
        
        
    }
    
    
    
    public void moveCuadro() {
         
    }
    public void setPos(int x, int y){
        
        circle.setX(x);
        circle.setY(y);
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
        //repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {   
        
    }

    
    
    
    
    
    
    
}


