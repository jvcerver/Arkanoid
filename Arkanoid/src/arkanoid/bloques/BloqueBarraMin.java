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
public class BloqueBarraMin extends Bloque{

    public BloqueBarraMin(Game game) {
        super(game, Recursos.bloqueBarraMin);
    }

    @Override
    public void recibirGolpe(Actor actor) {
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
