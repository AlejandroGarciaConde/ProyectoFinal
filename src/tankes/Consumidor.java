package tankes;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.awt.geom.*;
import static java.lang.Thread.sleep;

public class Consumidor extends Thread{
    private Y rc;
    private DibujaTanke panel;
    private Lock mutex;
    private JLabel porc;
    
    public Consumidor(DibujaTanke panel, Y rc,JLabel porc){
        this.panel=panel;
        this.rc=rc;
        this.porc= porc;
        mutex = new ReentrantLock();
    }
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()>0){ //rc.getY()<250
            if(mutex.tryLock()){
                mutex.lock();
                panel.agua.getAgua().remove(panel.agua.getAgua().size()-1);
                porc.setText(2.5*panel.agua.getAgua().size()+" %");
                panel.repaint();
                System.out.println("Consumidor");
                rc.setY(rc.getY()+5);
                mutex.unlock();
                }
            }
           try{
                sleep((int)(500+Math.random()*200));//((int)(500*Math.random()*200));
            }catch(Exception e){}
            
        }
    }
}
