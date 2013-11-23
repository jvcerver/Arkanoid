/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author josevicente
 */
public class ActorTexto extends Actor{
    private String cadena;
    private Color color;
    private int tamanio;
    private Font fuente;

    /**
     *
     * @param game
     * @param cadena
     */
    public ActorTexto(Game game,String cadena){
        super(game);
        activo=false;
        this.cadena=cadena;
        tamanio=30;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setPosition(int x, int y){
        this.x = x; this.y = y;  
    }

    /**
     *
     * @param tamanio
     */
    public void setTamanio(int tamanio){
        this.tamanio=tamanio;
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color){
        this.color=color;
    }

    /**
     *
     * @param cadena
     */
    public void setTexto(String cadena){
        this.cadena=cadena;
    }
   
    /**
     *
     * @param g
     */
    @Override
    public void dibujar(Graphics g){
        g.setColor(color);
        fuente=new Font("Arial",Font.BOLD,tamanio);
        g.setFont(fuente);
        g.drawString(cadena, x, y);
    }

    /**
     *
     * @param actor
     */
    @Override
    public void recibirGolpe(Actor actor) {
        
    }

    /**
     *
     * @param deltaTime
     */
    @Override
    public void actualizar(long deltaTime) {
        
    }
    
    public int getAncho(){
        return getGame().getGraficos().getFontMetrics().stringWidth(cadena);
    }

}
