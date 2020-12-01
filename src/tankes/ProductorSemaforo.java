package tankes;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.awt.geom.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ProductorSemaforo extends Thread{
    private Y rc;
    private DibujaTanke panel;
    private Semaphore sem;
    private JLabel porc;
    
    public ProductorSemaforo(DibujaTanke panel, Y rc,JLabel porc){
        this.panel=panel;
        this.rc=rc;
        this.porc=porc;
        sem = new Semaphore(1);
        
       
    }
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()<40){ try {
                //rc.getY()>50
                    sem.acquire();
                    panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(),100,5));
                    porc.setText(2.5*panel.agua.getAgua().size()+" %");
                    panel.repaint();
                    System.out.println("ProductorSem");
                    rc.setY(rc.getY()-5);
                    sem.release();
            }
             catch (InterruptedException ex) {}
            
            
            }
            try{
                sleep((int)(500+Math.random()*200));//((int)(500*Math.random()*200));
            }catch(Exception e){}
        }
    }
}

