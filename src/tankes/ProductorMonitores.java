package tankes;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductorMonitores extends Thread {
    private Y rc;
    private DibujaTanke panel;
    private JLabel porc;
    
    ProductorMonitores(DibujaTanke panel, Y rc,JLabel porc){
        this.panel=panel;
        this.rc=rc;
        this.porc= porc;
    }
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()<40){
                synchronized(panel){
                    try {
                        panel.notify();
                    
                    panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                    porc.setText(2.5*panel.agua.getAgua().size()+"%");
                    panel.repaint();
                    System.out.println("ProductorMonitores");
                    rc.setY(rc.getY()-5);
                    panel.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProductorMonitores.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            try{
                sleep((int)(500+Math.random()*200));//((int)(500*Math.random()*200));
            }catch(Exception e){}
        }
    }
}
