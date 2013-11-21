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


    /**
     *
     */
    @Override
    public void principal() {
        this.setName("Arkanoid");
        bolas = new ArrayList<>();
        bolas.add(new Bola(this, Recursos.bola));
        
        barra = new Barra(this);
        barra.setVida(3);
        this.actorManager.add(barra);
    }
    
}
