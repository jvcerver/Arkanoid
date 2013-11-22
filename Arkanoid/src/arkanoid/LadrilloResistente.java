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
public class LadrilloResistente extends Ladrillo{

    public LadrilloResistente(Game game) {
        super(game, Recursos.ladrillo);
        vida=3;
    }

    @Override
    public void actualizar(long deltaTime) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirGolpe(Actor actor) {
        //this.getGame().actorManager.del(this);
        //numLadrillos--;
        vida--;
        switch(vida){
            case 2:
                this.changeSprite(Recursos.barra);
                break;
            case 1:
                this.changeSprite(Recursos.sombra);
                break;
            case 0:
                this.getGame().actorManager.del(this);
                Ladrillo.restarLadrillo();
                break;
        }
    }

}
