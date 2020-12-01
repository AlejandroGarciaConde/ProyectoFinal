package tankes;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class DibujaTankeSem extends JPanel{
    
    public Agua agua1; 
 
   
    public DibujaTankeSem(Agua agua1){
        setBackground(Color.GREEN);
        this.agua1=agua1;

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.draw(new Rectangle2D.Double(50,50,100,200));
        g2.setColor(Color.BLUE);
        for(int i=0;i<agua1.getAgua().size();i++){
            g2.fill((Rectangle2D)agua1.getAgua().get(i));
        }
    }
}
