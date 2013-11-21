/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;

/**
 *
 * @author josevicente
 */
public class Ladrillo extends Actor {

    public Ladrillo(Game game, BitMap bitMap) {
        super(game, bitMap);
    }

    @Override
    public void actualizar(long deltaTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirGolpe(Actor actor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
