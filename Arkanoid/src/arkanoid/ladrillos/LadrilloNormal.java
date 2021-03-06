/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid.ladrillos;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;
import arkanoid.Recursos;

/**
 *
 * @author Carmen
 */
public class LadrilloNormal extends Ladrillo{

    private final int PUNTOS = 100;
    
    public LadrilloNormal(Game game, BitMap bitMap) {
        super(game, bitMap);
    }

    @Override
    public void actualizar(long deltaTime) {
    }

    @Override
    public void recibirGolpe(Actor actor) {
        this.getGame().actorManager.del(this);
        Ladrillo.restarLadrillo();
        this.sumarPuntosBarra(PUNTOS);
    }
    
}
