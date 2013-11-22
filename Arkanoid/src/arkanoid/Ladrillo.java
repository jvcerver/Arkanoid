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
 * @author josevicente
 */
public class Ladrillo extends Actor {
    private static int numLadrillos;

    public Ladrillo(Game game) {
        super(game, Recursos.ladrillo);
        numLadrillos++;
    }

    @Override
    public void actualizar(long deltaTime) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirGolpe(Actor actor) {
        this.getGame().actorManager.del(this);
        numLadrillos--;
    }

    public static int getNumLadrillos() {
        return numLadrillos;
    }

}
