/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template filae, choose Tools | Templates
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
    //private ArrayList<Ladrillo> ladrillos;
    private int mundo;
    private Sombra sombra;


    /**
     *
     */
    @Override
    public void principal() {
        this.setName("Arkanoid");
        
        iniciarPersonajes();
        
        while (!this.isFin()) {
            this.actualizar(); //ciclo logico de juego
            if (barra.getVida() == 0 || Ladrillo.getNumLadrillos()==0) {
                this.terminarJuego();
            }
        }
    }

    public void iniciarPersonajes(){
        //Bola(s)
        bolas = new ArrayList<>();
        bolas.add(new Bola(this, Recursos.bola));
         
        //Barra y sombra
        sombra = new Sombra(this);
        barra = new Barra(this);
        barra.setVida(3);
        this.actorManager.add(sombra);
        this.actorManager.add(barra);
        this.actorManager.add(bolas.get(0));
        
        //Ladrillos
        generarParedLadrillos(3, 15, 10, 20);
        
    }
    
    public Sombra getSombra() {
        return sombra;
    }
    
    public void generarParedLadrillos (int numFilas, int numColumnas, int hgapLadrillo, int vgapLadrillo){
        ArrayList<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
        Ladrillo ladrillo;
        int tamannoLadrillos = (Recursos.ladrillo.getWidth()+hgapLadrillo)*numColumnas;
        int posxInicial = (this.SCREEN_WIDTH-tamannoLadrillos)/2;
        int posyInicial = this.SCREEN_HEIGHT/4;
        int posx, posy;
        for (int fila=0;fila<numFilas;fila++){     
            for (int columna=0;columna<numColumnas;columna++){
                ladrillo=new Ladrillo(this);
                posx = posxInicial + columna*(ladrillo.getWidth() + hgapLadrillo);
                posy = posyInicial + fila*(ladrillo.getHeight() + vgapLadrillo);
                ladrillo.setPosition(posx,posy);
                this.actorManager.add(ladrillo);                
            }          
        
        }
    }
}
