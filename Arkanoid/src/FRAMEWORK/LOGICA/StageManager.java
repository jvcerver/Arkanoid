/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import FRAMEWORK.GRAFICOS.Sprite;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author josevicente
 */
public class StageManager {
    private Game game;   
    private Graphics2D g;
    private Sprite spFondo;

    /**
     *
     * @param game
     */
    public StageManager(Game game){
        this.game=game;
        this.g=game.getGraficos();           
    }

    /**
     *
     */
    public void dibujar(){
        Actor item;
        game.actorManager.rewind();
        if (spFondo==null){
            g.setColor(Color.WHITE); //Para poder probar lo de la sombra negra
            g.fillRect(0,0, game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
        }
        else
            spFondo.dibujar(g);
        while((item=game.actorManager.current())!=null){
            item.dibujar(g);//en el buffer
            game.actorManager.next();
        }    
    }   

    /**
     *
     * @param fondo
     */
    public void setFondo(Sprite fondo){
        spFondo=fondo;
    }
}
