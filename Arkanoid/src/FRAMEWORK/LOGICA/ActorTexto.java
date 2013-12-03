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

public class ActorTexto extends Actor{
    private String cadena;
    private Color color;
    private int tamanio;
    private Font fuente;

    public ActorTexto(Game game,String cadena){
        super(game);
        activo=false;
        this.cadena=cadena;
        tamanio=30;
    }

    public void setPosition(int x, int y){
        
        this.x = (int)(x*getGame().escalaX); 
        this.y = (int)(y*getGame().escalaY);  
    }
    public void setTamanio(int tamanio){
        float k=(getGame().escalaX+getGame().escalaY)/2;
        this.tamanio=(int)(tamanio*k);
    }
    public void setColor(Color color){
        this.color=color;
    }
    public void setTexto(String cadena){
        this.cadena=cadena;
    }
    @Override
    public void dibujar(Graphics g){
        g.setColor(color);
        fuente=new Font("Arial",Font.BOLD,tamanio);
        g.setFont(fuente);
        g.drawString(cadena, x, y);
    }

    @Override
    public void recibirGolpe(Actor actor) {
        
    }

    @Override
    public void actualizar(int deltaTime) {
        
    }

    @Override
    public void destruir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debilitar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
