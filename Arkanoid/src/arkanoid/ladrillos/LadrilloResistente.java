/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid.ladrillos;

import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;
import arkanoid.Recursos;

/**
 *
 * @author Carmen
 */
public class LadrilloResistente extends Ladrillo{

    private final int PUNTOS_ROTO1 = 50;
    private final int PUNTOS_ROTO2 = 50;
    private final int PUNTOS_ROTO3 = 50;
    
    
    public LadrilloResistente(Game game) {
        super(game, Recursos.ladrilloAmarillo);
        vida=3;
    }

    @Override
    public void actualizar(long deltaTime) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recibirGolpe(Actor actor) {
        vida--;
        switch(vida){
            case 2:
                this.changeSprite(Recursos.ladrilloAmarilloRoto);
                this.sumarPuntosBarra(PUNTOS_ROTO1);
                break;
            case 1:
                this.changeSprite(Recursos.ladrilloAmarilloSuperRoto);
                this.sumarPuntosBarra(PUNTOS_ROTO2);
                break;
            case 0:
                this.getGame().actorManager.del(this);
                Ladrillo.restarLadrillo();
                this.sumarPuntosBarra(PUNTOS_ROTO3);
                break;
        }
    }

}
