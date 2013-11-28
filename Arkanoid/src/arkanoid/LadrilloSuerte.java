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
 * @author Carmen
 */
public class LadrilloSuerte extends Ladrillo{

    private final int PUNTOS = 25;
    
    public LadrilloSuerte(Game game) {
        super(game, Recursos.ladrilloSuerte);
    }

    @Override
    public void actualizar(long deltaTime) {
    }

    @Override
    public void recibirGolpe(Actor actor) {
        if(actor instanceof Bola){
            this.getGame().actorManager.del(this);
            Ladrillo.restarLadrillo();
            this.sumarPuntosBarra(PUNTOS);
            crearBono();
        }
    }
    
    public void crearBono(){
        //Creo una posible vida
        BloqueVida bloqueVida = new BloqueVida(this.getGame());
        //Lo añado a la lista de actores
        this.getGame().actorManager.add(bloqueVida);
        //Lo coloco en una posición determinada
        bloqueVida.setPosition(this.x + (this.getWidth()-bloqueVida.getWidth())/2, 
                this.y+this.getHeight());
    }
    
}
