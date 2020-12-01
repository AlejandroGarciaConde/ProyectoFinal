package tankes;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.awt.geom.*;


public class Productor extends Thread{
    private Y rc;
    private DibujaTanke panel;
    private Lock mutex;
    private JLabel porc;
    
    
    public Productor(DibujaTanke panel, Y rc,JLabel porc){
        this.panel=panel;
        this.rc=rc;
        this.porc=porc;
        mutex = new ReentrantLock();
       
    }
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()<40){ //rc.getY()>50
            if(mutex.tryLock()){
                mutex.lock();
                panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                porc.setText(2.5*panel.agua.getAgua().size()+"%");
                panel.repaint();
                System.out.println("Productor");
                rc.setY(rc.getY()-5);
                mutex.unlock();
                }
            }
            try{
                sleep((int)(500+Math.random()*200));//((int)(500*Math.random()*200));
            }catch(Exception e){}
            
            }
        }
    }

