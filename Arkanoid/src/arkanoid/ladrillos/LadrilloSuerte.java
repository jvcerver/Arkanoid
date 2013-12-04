/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid.ladrillos;

import FRAMEWORK.GRAFICOS.BitMap;
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
 *
 * @author Carmen
 */
public class LadrilloSuerte extends Ladrillo{

    private final int PUNTOS = 25;
    private BitMap bitMap;
    
    public LadrilloSuerte(Game game, BitMap bitMap) {
        super(game, bitMap);
        this.bitMap=bitMap;
    }

    @Override
    public void actualizar(int deltaTime) {
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
        
        if (bitMap.equals(Recursos.ladrilloVida)){
            //Creo una posible vida
            bloque = new BloqueVida(this.getGame());
        }
        else if (bitMap.equals(Recursos.ladrilloBarraMax)){
            //Creo una posible vida
            bloque = new BloqueBarraMax(this.getGame());
        }
        else if (bitMap.equals(Recursos.ladrilloBarraMin)){
            //Creo una posible vida
            bloque = new BloqueBarraMin(this.getGame());
        }
        else if (bitMap.equals(Recursos.ladrilloBarraPega)){
            //Creo una posible vida
            bloque = new BloqueBarraPega(this.getGame());
        }
        
        //Lo añado a la lista de actores
        this.getGame().actorManager.add(bloque);
        //Lo coloco en una posición determinada
        bloque.setPosition(this.x + (this.getWidth()-bloque.getWidth())/2, 
                this.y+this.getHeight());
        
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
