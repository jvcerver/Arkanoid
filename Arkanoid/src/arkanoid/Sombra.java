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
public class Sombra extends Actor{
    
    public Sombra(Mundo mundo) {
        super(mundo, Recursos.sombra);
        /*x = mundo.SCREEN_WIDTH / 2;
        y = mundo.SCREEN_HEIGHT - barra.getHeight()*2;
        this.dx=barra.getDx(); 
        this.mundo = mundo;*/
    }

    @Override
    public void actualizar(long deltaTime) {
    }
    
    public void moverIzqda() {
        if (this.x>0) { //si no rebasa el borde izquierdo
            this.x -= this.dx;
        } else {
            this.x=0;
        }
    }

    public void moverDcha() { //Esto hay que cambiarlo
        if (this.x + this.getWidth() < this.getGame().SCREEN_WIDTH) {
            this.x += this.dx;
        } else {
            this.x = this.getGame().SCREEN_WIDTH - this.getWidth();
        }
        
    }

    @Override
    public void recibirGolpe(Actor actor) {
    }
    
}
