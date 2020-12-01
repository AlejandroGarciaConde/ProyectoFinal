package tankes;
import java.awt.geom.Rectangle2D;
import javax.swing.JLabel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumidorMonitores extends Thread {
    private Y rc;
    private DibujaTanke panel;
    private JLabel porc;
    
    ConsumidorMonitores(DibujaTanke panel, Y rc,JLabel porc){
        this.panel=panel;
        this.rc=rc;
        this.porc= porc;
    }
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()> 0){
                synchronized(panel){
                    try {
                        panel.notify();
                        panel.agua.getAgua().remove(panel.agua.getAgua().size()-1);
                        porc.setText(2.5*panel.agua.getAgua().size()+" %");
                        panel.repaint();
                        System.out.println("ConsumidorMonitores");
                        rc.setY(rc.getY()+5);
                        panel.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ConsumidorMonitores.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            try{
                sleep((int)(500+Math.random()*200));//((int)(500*Math.random()*200));
            }catch(Exception e){}
        }
    }
}
