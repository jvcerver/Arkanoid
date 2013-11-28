/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid.bloques;

import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;
import arkanoid.Recursos;

/**
 *
 * @author Carmen
 */
public class BloqueVida extends Bloque{

    public BloqueVida(Game game) {
        super(game, Recursos.bloqueVida);
    }

    @Override
    public void recibirGolpe(Actor actor) {
    }

    
    
}
