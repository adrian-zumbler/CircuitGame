/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorelectronica.Piezas;

/**
 *
 * @author AdrianM
 */
public class Cable {
    
    private int initX;
    private int initY;
    
    public Cable() {
        
    }
    
    public void setInitX(int x) {
        this.initX = x;
    }
    
    public void setInitY(int y) {
        this.initY = y;
    }
    
    public int getInitX() {
        return this.initX;
    }
    
    public int getInitY() {
        return this.initY;
    }
}
