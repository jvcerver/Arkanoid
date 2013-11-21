/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Graphics;

/**
 *
 * @author josevicente
 */
public class Sprite{
    private int x, y;//posicion del sprite en pantalla
    private int width,height;
    private BitMap bitMap;
    
    /**
     *
     * @param bitMap
     */
    public Sprite(BitMap bitMap){        
        this.bitMap=bitMap;
        width = bitMap.getWidth();
        height = bitMap.getHeight();
    } 

    /**
     * dibuja la imagen asociada al sprite en la posicion x, y indicadas en el sprite
     * @param g
     */
    public void dibujar(Graphics g){
         g.drawImage(bitMap.getImage(), x, y, null);
    }
    
    /**
     * indica la posicion del sprite. Se utiliza para dibujar.
     * @param x
     * @param y
     */
    public void setPosition(int x, int y){
        this.x = x; this.y = y;  
    }
    
    /**
     *
     * @param x
     */
    public void setX(int x) { this.x = x;}

    /**
     *
     * @param y
     */
    public void setY(int y) { this.y = y;}

    /**
     *
     * @return
     */
    public int getX(){ return x;}

    /**
     *
     * @return
     */
    public int getY(){ return y;}

    /**
     *
     * @return
     */
    public int getWidth() { return width;}

    /**
     *
     * @return
     */
    public int getHeight() { return height;}
   
}
