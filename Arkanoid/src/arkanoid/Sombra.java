/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import FRAMEWORK.LOGICA.Actor;

/**
 *
 * @author Carmen
 */
public class Sombra extends Actor{
    
    public Sombra(Mundo mundo) {
        super(mundo, Recursos.sombra);
        //this.dx=(Mundo.NORMAL); 
    }
    
    @Override
    public void recibirGolpe(Actor actor) {
    }

    @Override
    public void actualizar(int deltaTime) {
    }

    @Override
    public void destruir() {
    }

    @Override
    public void crear() {
    }

    @Override
    public void debilitar() {
    }
    
}
