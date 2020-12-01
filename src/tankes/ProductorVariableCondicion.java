
package tankes;

import java.util.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.concurrent.*;

public class ProductorVariableCondicion extends Thread {
    private Y rc;
    private DibujaTanke panel;
    private JLabel porc;
    private VariableC vc;
    
    ProductorVariableCondicion(DibujaTanke panel, Y rc,JLabel porc,VariableC vc){
        this.panel=panel;
        this.rc=rc;
        this.porc= porc;
        this.vc = vc;
    }
    
    public void run(){
        while(true){
            if(panel.agua.getAgua().size()<40){
            
            if(!vc.isVcerr()){
                    vc.cierra();
                    panel.agua.getAgua().add(new Rectangle2D.Double(50,rc.getY(), 100, 5));
                    porc.setText(2.5*panel.agua.getAgua().size()+"%");
                    panel.repaint();
                    System.out.println("ProductorVC");
                    rc.setY(rc.getY()-5);
                vc.abre();
            }
            }
            
            try{
            sleep((int)(500+Math.random()*200));
            }catch (Exception e){}
        }
    }
}
