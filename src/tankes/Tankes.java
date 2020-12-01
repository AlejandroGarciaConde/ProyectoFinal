package tankes;
import javax.swing.*;
import java.awt.*;

public class Tankes extends JFrame{
    
    private DibujaTanke panel,panelSem,panelVariableCondicion,panelMonitores;
    private Y rc,rcSem,rcVariable,rcMonitores;
    private Productor p;
    private ProductorSemaforo pSem;
    private ProductorMonitores pMonitores;
    private ProductorVariableCondicion pVarCond;
    private Consumidor c;
    private ConsumidorSemaforo cSem;
    private ConsumidorMonitores cMonitores;
    private ConsumidorVariableCondicion cVarCond;
    private Agua agua, aguaSem,aguaVariable,aguaMonitores;
    private JLabel etiqueta,etiquetaSem,etiquetaVariable,etiquetaMonitores;
    private JLabel porc, porcSem,porcVariable,porcMonitores;
    private VariableC vc;
    
    
    public Tankes(){
        setSize(800,400);
        setLocation(1000,400);     
        etiqueta = new JLabel("Mutex");
        etiquetaSem = new JLabel("Semaforo");
        etiquetaVariable = new JLabel("Variable C.");
        etiquetaMonitores = new JLabel("Monitores");
        porc = new JLabel("%");
        porcSem = new JLabel("%");
        porcVariable = new JLabel("%");
        porcMonitores = new JLabel("%");
        rc=new Y();
        rcSem=new Y();
        rcVariable=new Y();
        rcMonitores=new Y();
        aguaSem = new Agua();
        agua = new Agua();
        vc=new VariableC();
        aguaVariable = new Agua();
        aguaMonitores = new Agua();
        panel = new DibujaTanke(agua);
        panelSem = new DibujaTanke(aguaSem);
        panelVariableCondicion = new DibujaTanke(aguaVariable);
        panelMonitores = new DibujaTanke(aguaMonitores);
        p = new Productor(panel,rc,porc);
        c = new Consumidor(panel,rc,porc);
        pSem = new ProductorSemaforo(panelSem,rcSem,porcSem);
        cSem = new ConsumidorSemaforo(panelSem,rcSem,porcSem);
        pMonitores = new ProductorMonitores(panelMonitores,rcMonitores,porcMonitores);
        cMonitores = new ConsumidorMonitores(panelMonitores,rcMonitores,porcMonitores);
        pVarCond = new ProductorVariableCondicion(panelVariableCondicion,rcVariable,porcVariable,vc);
        cVarCond = new ConsumidorVariableCondicion(panelVariableCondicion,rcVariable,porcVariable,vc);
        
        
        setLayout(new GridLayout());
        ///Mutex
        panel.setLayout(null);
        etiqueta.setBounds(60,20,100,25);
        porc.setBounds(80, 270, 100, 25);
        panel.add(etiqueta);
        panel.add(porc);
        add(panel);
        
        ///Semaforo
        panelSem.setLayout(null);
        etiquetaSem.setBounds(60,20,100,25);
        porcSem.setBounds(80, 270, 100, 25);
        panelSem.add(etiquetaSem);
        panelSem.add(porcSem);
        add(panelSem);
        
        //VariableCondicion
        panelVariableCondicion.setLayout(null);
        etiquetaVariable.setBounds(60, 20, 100, 25);
        porcVariable.setBounds(80,270,100,25);
        panelVariableCondicion.add(etiquetaVariable);
        panelVariableCondicion.add(porcVariable);
        add(panelVariableCondicion);
        
        ///Monitores
        panelMonitores.setLayout(null);
        etiquetaMonitores.setBounds(60, 20, 100, 25);
        porcMonitores.setBounds(80,270,100,25);
        panelMonitores.add(etiquetaMonitores);
        panelMonitores.add(porcMonitores);
        add(panelMonitores);
        
        /////
        p.start();
        c.start();
        pSem.start();
        cSem.start();
        pMonitores.start();
        cMonitores.start();
        pVarCond.start();
        cVarCond.start();
        
        
        
    }
    public static void main(String[] args) {
        Tankes fr = new Tankes();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
