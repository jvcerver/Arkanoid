/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import FRAMEWORK.GRAFICOS.Sprite;
import java.awt.Color;
import java.awt.Graphics;

public class StageManager {
    private Game game;   
    private Sprite spFondo;
    public StageManager(Game game){
        this.game=game;           
    }
    public void dibujar(Graphics g){
        Actor item;
        game.actorManager.rewind();
        if (spFondo==null){
            g.setColor(Color.black);
            //El rectángulo que rellena tiene que ser el escalado
            g.fillRect(0,0, game.SCREEN_WIDTH_ESCALADO, game.SCREEN_HEIGHT_ESCALADO);
        }
        else
            spFondo.dibujar(g);
        while((item=game.actorManager.current())!=null){
            item.dibujar(g);
            game.actorManager.next();
        }    
    }       
    public void setFondo(Sprite fondo){
        spFondo=fondo;
    }
}
