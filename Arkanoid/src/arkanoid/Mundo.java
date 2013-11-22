/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import FRAMEWORK.LOGICA.Game;
import java.util.ArrayList;

/**
 *
 * @author josevicente
 */
public class Mundo extends Game{
    
    private Barra barra;
    private ArrayList<Bola> bolas;
    private ArrayList<Ladrillo> ladrillos;
    private int mundo;
    private Sombra sombra;

    public Barra getBarra(){
        return barra;
    }
    /**
     *
     */
    @Override
    public void principal() {
        this.setName("Arkanoid");
        bolas = new ArrayList<>();
        bolas.add(new Bola(this, Recursos.bola));
         
        sombra = new Sombra(this);
        barra = new Barra(this, sombra);
        barra.setVida(3);
        this.actorManager.add(sombra);
        this.actorManager.add(barra);
        this.actorManager.add(bolas.get(0));
        
        while (!this.isFin()) {
            this.actualizar(); //ciclo logico de juego
            if (barra.getVida() == 0 /* || !ladrillos.isEmpty()*/) {
                this.terminarJuego();
            }
        }
    }
    
}
