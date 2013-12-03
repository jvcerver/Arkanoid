/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Surface extends Canvas {   
    private Graphics grafico;
    public  BufferStrategy strategy;       

    public Surface(int ancho, int alto){
        setBounds(0,0,ancho,alto); 
        setIgnoreRepaint(true);
    }
    public BufferStrategy crearBufferStrategy(){
        createBufferStrategy(2);
        do {
           strategy = getBufferStrategy();
        } while (strategy == null);   
        grafico=strategy.getDrawGraphics();
        return strategy;
    }    
    @Override
    public Graphics getGraphics(){
        grafico=strategy.getDrawGraphics();    
        return grafico;
    }
} 