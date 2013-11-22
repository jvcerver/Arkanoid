/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

/**
 *
 * @author josevicente
 */
public class Surface extends Canvas {   
    private Graphics grafico;
    public  BufferStrategy strategy;       

    /**
     * 
     * @param ancho
     * @param alto
     */
    public Surface(int ancho, int alto){
        setBounds(0,0,ancho,alto); 
        setIgnoreRepaint(true);
    }

    /**
     * Crea un strategy e inicializa la paleta de graficos
     * @return
     */
    public BufferStrategy crearBufferStrategy(){
        createBufferStrategy(2);
        do {
           strategy = getBufferStrategy();
        } while (strategy == null);     
              
        return strategy;
    }    
    @Override
    public Graphics getGraphics(){
        grafico=strategy.getDrawGraphics();  
        return grafico;
    }
} 