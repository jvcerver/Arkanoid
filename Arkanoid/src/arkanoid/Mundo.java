/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template filae, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import arkanoid.ladrillos.Ladrillo;
import arkanoid.ladrillos.LadrilloSuerte;
import FRAMEWORK.LOGICA.ActorTexto;
import FRAMEWORK.LOGICA.Game;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josevicente
 */
public class Mundo extends Game{
        
    private Barra barra;
    private ArrayList<Bola> bolas;
    //private ArrayList<Vida> vidas;
    //private ArrayList<Ladrillo> ladrillos;
    private int mundo;
    private Sombra sombra;
    private ActorTexto tituloPuntosVidas;
    private ActorTexto textoInformativo;
    
    //para futuras iteraciones en las que la velocidad pueda variar
    public static int LENTO = 7;
    public static final int NORMAL = 10;
    public static int MAXIMO = 30;
    public static int RAPIDO = 15;
    public static int EXTRARAPIDO = 20;
    public static int EXTRALENTO = 3;

    public Barra getBarra(){
        return barra;
    }

    public void setTextoInformativo(String textoInformativo) {
        this.textoInformativo.setTexto(textoInformativo);
    }

    /**
     *
     */
    @Override
    public void principal() {
        this.setName("Arkanoid");
        
        iniciarPersonajes();
        
        while (!this.isFin()) {
            if (this.getKeyBoardHandler().getTecla() == KeyEvent.VK_SPACE){
               this.reanudarJuego();
               textoInformativo.setTexto("");
            }
       
            tituloPuntosVidas.setTexto("Puntos " + barra.getPuntos());
            this.actualizar(); //ciclo logico de juego
            
            if (barra.getVida() == 0 || Ladrillo.getNumLadrillos()==0) {
                textoInformativo.setTexto("GAME OVER");
                textoInformativo.setPosition((this.SCREEN_WIDTH-textoInformativo.getAncho())/2, textoInformativo.getY());
                this.actualizar(); //ciclo logico de juego
                try {
                    Thread.sleep(3000); //¿Dar la opción de volver a empezar?
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mundo.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.terminarJuego();
            }
            
        }
    }

    public void iniciarPersonajes(){
        //Barra y sombra
        sombra = new Sombra(this);
        barra = new Barra(this);
        //barra.setVida(Barra.VIDAS_INICIALES);
                
        //Bola(s)
        bolas = new ArrayList<>();
        bolas.add(new Bola(this, Recursos.bola));

        //Ladrillos
        generarParedLadrillos(3, 10, 10, 20);
        
        //Titulo vidas y puntos
        tituloPuntosVidas = new ActorTexto(this,"Puntos " + barra.getPuntos());
        tituloPuntosVidas.setPosition(20, this.SCREEN_HEIGHT - barra.getHeight());
        tituloPuntosVidas.setTamanio(20);
        tituloPuntosVidas.setColor(Color.BLUE); 
        
        //Texto informativo para el usuario
        textoInformativo = new ActorTexto(this, "Pulsa la barra espaciadora para comenzar");
        textoInformativo.setPosition((this.SCREEN_WIDTH-textoInformativo.getAncho())/2, barra.getY()- barra.getHeight()*6);
        textoInformativo.setTamanio(14);
        textoInformativo.setColor(Color.BLACK);
        
        //Añadir personajes a actorManager
        this.actorManager.add(sombra);
        this.actorManager.add(barra);
        this.actorManager.add(bolas.get(0));
        this.actorManager.add(tituloPuntosVidas); 
        this.actorManager.add(textoInformativo); 
        
    }
    
    public Sombra getSombra() {
        return sombra;
    }
    
    public void generarParedLadrillos (int numFilas, int numColumnas, int hgapLadrillo, int vgapLadrillo){
        Ladrillo ladrillo;
        int tamannoLadrillos = (Recursos.ladrilloAmarillo.getWidth()+hgapLadrillo)*numColumnas;
        int posxInicial = (this.SCREEN_WIDTH-tamannoLadrillos)/2;
        int posyInicial = this.SCREEN_HEIGHT/4;
        int posx, posy;
        for (int fila=0;fila<numFilas;fila++){     
            for (int columna=0;columna<numColumnas;columna++){
                ladrillo=new LadrilloSuerte(this);
                posx = posxInicial + columna*(ladrillo.getWidth() + hgapLadrillo);
                posy = posyInicial + fila*(ladrillo.getHeight() + vgapLadrillo);
                ladrillo.setPosition(posx,posy);
                this.actorManager.add(ladrillo);                
            }          
        
        }
    }
}
