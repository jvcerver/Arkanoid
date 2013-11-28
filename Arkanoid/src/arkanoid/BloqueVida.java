/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;

/**
 *
 * @author Carmen
 */
public class BloqueVida extends Actor{

    public BloqueVida(Game game) {
        super(game, Recursos.bloqueVida);
    }

    @Override
    public void actualizar(long deltaTime) {
        tickTime += deltaTime; 
        if (tickTime > TICK) {            
            tickTime -= TICK;
            this.mover();
            this.golpear();
        }
        
    }

    @Override
    public void recibirGolpe(Actor actor) {
    }
    
    public void mover(){
        //Si llega al borde inferior de la pantalla se elimina
        if (this.y+this.getHeight()>this.getGame().SCREEN_HEIGHT){
             this.getGame().actorManager.del(this);
        }
        //Si no se desplaza hacia abajo
        this.y+=3; //Estaría bien poner esto en función de la dificultad del nivel (velocidad barra, bola...)
    }
    
}
