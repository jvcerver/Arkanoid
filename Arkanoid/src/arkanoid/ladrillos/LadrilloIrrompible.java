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
 * @author josevicente
 * @author Carmen
 */
public class LadrilloIrrompible extends Ladrillo{
    
    public LadrilloIrrompible(Game game) {
        super(game, Recursos.ladrilloIrrompible);
        Ladrillo.restarLadrillo();
    }

    @Override
    public void actualizar(int deltaTime) {
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
