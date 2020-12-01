package tankes;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.awt.geom.*;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumidorSemaforo extends Thread{
    private Y rc;
    private DibujaTanke panel;
    private Semaphore sem;
    private JLabel porc;
    
    public ConsumidorSemaforo(DibujaTanke panel, Y rc,JLabel porc){
        this.panel=panel;
        this.rc=rc;
        this.porc=porc;
        sem = new Semaphore(1);
    }

    public void run(){
        while(true){
            if(panel.agua.getAgua().size()>0){ try {
                //rc.getY()<250
                sem.acquire();
                
                panel.agua.getAgua().remove(panel.agua.getAgua().size()-1);
                panel.repaint();
                System.out.println("ConsumidorSem");
                rc.setY(rc.getY()+5);
                sem.release();
                } catch (InterruptedException ex) {}
            }
               try{
                sleep((int)(500+Math.random()*200));//((int)(500*Math.random()*200));
            }catch(Exception e){}
            
            }
        
    }
}
