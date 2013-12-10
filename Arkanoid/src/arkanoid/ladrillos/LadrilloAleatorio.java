/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid.ladrillos;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.GRAFICOS.Sprite;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;
import arkanoid.bloques.BloqueVida;
import arkanoid.Bola;
import arkanoid.Recursos;
import arkanoid.bloques.Bloque;
import arkanoid.bloques.BloqueBarraMax;
import arkanoid.bloques.BloqueBarraMin;
import arkanoid.bloques.BloqueBarraPega;

/**
 * @author josevicente
 * @author Carmen
 */
public class LadrilloAleatorio extends Ladrillo{

    private final int PUNTOS = 25;
    private BitMap bitMap;
    
    public LadrilloAleatorio(Game game, BitMap bitMap) {
        super(game, bitMap);
            setSpriteActual(new Sprite(Recursos.ladrilloAleatorio,4,40));
    }

    @Override
    public void actualizar(int deltaTime) {
        tickTime += deltaTime; 
        if (tickTime > TICK) {            
            tickTime -= TICK;
            this.actualizar(tickTime);
        }
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
        Bloque bloque = null;
       
            switch(this.getSpriteActual().getiFrame()){
            case 0:
                bloque = new BloqueBarraMin(this.getGame());
                break;
            case 1:
                bloque = new BloqueBarraPega(this.getGame());
                break;
            case 2:
                bloque = new BloqueBarraMax(this.getGame());
                break;
            case 3:
                bloque = new BloqueVida(this.getGame());
                break;
        }
        
        //Lo añado a la lista de actores
        this.getGame().actorManager.add(bloque);
        //Lo coloco en una posición determinada
        bloque.setPosition(this.x + (this.getWidth()-bloque.getWidth())/2, 
                this.y+this.getHeight());
        
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
