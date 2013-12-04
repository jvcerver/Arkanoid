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
public class Vida extends Actor{

    public Vida(Game game) {
        super(game, Recursos.vida);
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
