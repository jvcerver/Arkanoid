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
 * @author josevicente
 * @author Carmen
 */
public class BloqueBarraMin extends Bloque{

    public BloqueBarraMin(Game game) {
        super(game, Recursos.bloqueBarraMin);
    }

    @Override
    public void recibirGolpe(Actor actor) {
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