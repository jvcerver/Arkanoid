/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid.ladrillos;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;
import arkanoid.Mundo;

/**
 *
 * @author josevicente
 */
public abstract class Ladrillo extends Actor {
    private static int numLadrillos;
    
    public Ladrillo(Game game, BitMap bitMap) {
        super(game, bitMap);
        numLadrillos++;
    }

    public static int getNumLadrillos() {
        return numLadrillos;
    }
    
    public static void restarLadrillo(){
        numLadrillos--;
    }
    
    public static void sumarLadrillo(){
        numLadrillos++;
    }
    
    public void sumarPuntosBarra(int puntos){
        ((Mundo)this.getGame()).getBarra().setPuntos(((Mundo)this.getGame()).getBarra().getPuntos()+puntos);
    }
    
    public static void reiniciarLadrillos(){
        numLadrillos=0;
    }

}
