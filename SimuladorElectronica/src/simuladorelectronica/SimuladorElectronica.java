/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorelectronica;

import com.leapmotion.leap.*;
import java.awt.Graphics;
import java.awt.AWTException;
import java.awt.Canvas;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author LuisFernando
 */
public class SimuladorElectronica {
     Lienzo lienzo = new Lienzo(300,300);
     Controller c;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SimuladorElectronica().main();
    }
    
    public void paint(Graphics g) {
        
    }
    
    public void main(){
        Eventos evt=new Eventos();
        c=new Controller(evt);
        c.enableGesture( Gesture.Type.TYPE_KEY_TAP );
        c.enableGesture(Gesture.Type.TYPE_SWIPE);
        lienzo = new Lienzo(100,100);
        lienzo.setPos(100, 100);
              
             JFrame jframe = new JFrame();
             jframe.setSize(1000,1000);
             jframe.add(lienzo);
             jframe.setVisible(true);
        
        System.out.println("Finalizar");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        c.removeListener(evt);
    }
    
    //jdsjdsadkasdja
    public class Eventos extends Listener{

         int lastPositionX = 0;
         int lastPositionY = 0;
         Frame frame;
        @Override
        public void onFrame(Controller cntrlr) {
            cntrlr.enableGesture(Gesture.Type.TYPE_CIRCLE);
            cntrlr.enableGesture(Gesture.Type.TYPE_SWIPE);
             Iterator<Finger> a ;
             Iterator<Gesture> b ;
            frame = cntrlr.frame();
           
            if (frame.hands().count()>0) {
                
                System.out.println("X:" + frame.hands().get(0).palmPosition().getX());
                System.out.println("Y:" + frame.fingers().get(0).tipPosition().getY());
                //mover(frame.fingers().get(0).tipPosition().getX(), frame.fingers().get(0).tipPosition().getY());
               // mover(frame.fingers().get(0).tipVelocity().getX(), frame.fingers().get(0).tipVelocity().getZ());
                GestureList gestureList = frame.gestures();
                
                b = gestureList.iterator();
                swipePositionMove(frame.fingers().get(0).tipPosition().getX());
                while(b.hasNext()) {
                    System.err.println(b.next().type());
                    if(b.next().type() == Gesture.Type.TYPE_CIRCLE){
                        Graphics g = lienzo.getGraphics();
                        g.fillOval(10, 10, 30, 50);
                        lienzo.repaint();
                        
                                
                        
                        
                    }
                }
                
                
                /*FingerList fingerList = frame.fingers();
                
                a = fingerList.iterator();
                while(a.hasNext()) {
                    System.out.println(a.next());
                }
                System.out.println(frame.gestures());*/
            }
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimuladorElectronica.class.getName()).log(Level.SEVERE, null, ex);
            }
            super.onFrame(cntrlr); 
        }

        @Override
        public void onInit(Controller cntrlr) {
            System.out.println("Inicializado");
            super.onInit(cntrlr); 
        }
        
        @Override
        public void onConnect(Controller cntrlr) {
            System.out.println("Conectado");
            super.onConnect(cntrlr); 
        }
        int posx, posy;
        public void mover(float x, float y){
            Robot rb;
            
            try {
                rb = new Robot();
                posx+=(int)x;
                posy+=(int)y;
                rb.mouseMove(posx, posy);
            } catch (AWTException ex) {
                Logger.getLogger(SimuladorElectronica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void swipePositionMove(double validNumber) {
            if(validNumber==0.0) {
            lienzo.setPos(lastPositionX + (int)frame.hands().get(0).palmPosition().getX(),lastPositionY + (int)frame.hands().get(0).palmPosition().getY());
                lastPositionX = (int)frame.hands().get(0).palmPosition().getX();
                lastPositionY =(int)frame.hands().get(0).palmPosition().getY();
            }
        }
        
    }
}
