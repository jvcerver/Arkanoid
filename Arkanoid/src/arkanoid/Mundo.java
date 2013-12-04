/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template filae, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import ESCENAS.Escena;
import FRAMEWORK.INPUT.Control;
import arkanoid.ladrillos.Ladrillo;
import arkanoid.ladrillos.LadrilloSuerte;
import FRAMEWORK.LOGICA.Game;
import arkanoid.escenas.EscenaPresentacion;
import arkanoid.ladrillos.LadrilloIrrompible;
import arkanoid.ladrillos.LadrilloNormal;
import arkanoid.ladrillos.LadrilloResistente;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author josevicente
 */
public class Mundo extends Game{
        
    private Barra barra;
    private ArrayList<Bola> bolas;
    //private int mundo;
    private Sombra sombra;
    //private ActorTexto tituloPuntosVidas;
    //private ActorTexto textoInformativo;
    private Escena escenaActual;
    
    //ladrillos
    public static final int LADRILLO_ROJO = 1;
    public static final int LADRILLO_AZUL = 2;
    public static final int LADRILLO_VERDE = 3;
    public static final int LADRILLO_AMARILLO = 4;
    public static final int LADRILLO_AMARILLO_ROTO = 5;
    public static final int LADRILLO_AMARILLO_SUPER_ROTO = 6;
    public static final int LADRILLO_SUERTE = 7;
    public static final int LADRILLO_IRROMPIBLE = 8;
    
    //para futuras iteraciones en las que la velocidad pueda variar
    public static final int LENTO = 7;
    public static final int NORMAL = 10;
    public static final int MAXIMO = 30;
    public static final int RAPIDO = 15;
    public static final int EXTRARAPIDO = 20;
    public static final int EXTRALENTO = 3;

    public Barra getBarra(){
        return barra;
    }

    /**
     *
     */
    @Override
    public void principal() {
        this.setName("Arkanoid");
        
        iniciarPersonajes();
        
        EscenaPresentacion escenaPresentacion=new EscenaPresentacion(this);       
        escenaPresentacion.iniciar();
        
        escenaActual=escenaPresentacion;
        
        while(!this.isFin()){  
           if (escenaActual.isFin()){
               escenaActual=escenaActual.getSiguienteEscena();
               if (escenaActual==null)
                   this.terminarJuego();
               else 
                   escenaActual.iniciar();
           }        
           escenaActual.actualizar();
           this.actualizar();                      
        }
    }

    public Escena getEscenaActual() {
        return escenaActual;
    }
 
    public void iniciarPersonajes(){
        //Barra y sombra
        sombra = new Sombra(this);
        barra = new Barra(this);
        
        //Control para la barra
        Control controlBarra=new Control(this,"CONTROL DE LA BARRA");
        controlBarra.setAction(Barra.DERECHA, KeyEvent.VK_RIGHT, 0);
        controlBarra.setAction(Barra.IZQUIERDA, KeyEvent.VK_LEFT, 0);
        controlBarra.setOwner(barra);
        this.controlManager.addControl(controlBarra); 
                
        //Bola(s)
        bolas = new ArrayList<>();
        bolas.add(new Bola(this, Recursos.bola));   
       
        //Añadir personajes a actorManager
        this.actorManager.add(sombra);
        this.actorManager.add(barra);
        this.actorManager.add(bolas.get(0));
        
    }
    
    public Sombra getSombra() {
        return sombra;
    }
    
    public void generarParedLadrillosHomogenea (int tipoLadrillo, int numFilas, int numColumnas, int hgapLadrillo, int vgapLadrillo, Escena escena){
        //Creamos una matriz homogénea
        int[][] matriz = new int[numFilas][numColumnas];
        for(int fila=0; fila<matriz.length; fila++)
            for(int columna =0; columna<matriz[0].length; columna++)
                matriz[fila][columna] = tipoLadrillo;
        
        generarParedLadrillosAMedida(matriz, hgapLadrillo, vgapLadrillo, escena);
    }
    
    public void generarParedLadrillosAMedida (int[][] matrizLadrillos, int hgapLadrillo, int vgapLadrillo, Escena escena){
        Ladrillo ladrillo = null;
        int tamannoLadrillos = (Recursos.ladrilloAmarillo.getWidth()+hgapLadrillo)*matrizLadrillos[0].length;
        int posxInicial = (this.SCREEN_WIDTH-tamannoLadrillos)/2;
        int posyInicial = this.SCREEN_HEIGHT/4;
        int posx, posy;
        for (int fila=0;fila<matrizLadrillos.length;fila++){     
            for (int columna=0;columna<matrizLadrillos[0].length;columna++){
                int tipoLadrillo = matrizLadrillos[fila][columna];
                switch(tipoLadrillo){
                    case LADRILLO_ROJO: //Ladrillo normal rojo
                        ladrillo=new LadrilloNormal(this, Recursos.ladrilloRojo);
                        break;
                    case LADRILLO_AZUL: //Ladrillo normal azul
                        ladrillo=new LadrilloNormal(this, Recursos.ladrilloAzul);
                        break;
                    case LADRILLO_VERDE: //Ladrillo normal verde
                        ladrillo=new LadrilloNormal(this, Recursos.ladrilloVerde);
                        break;
                    case LADRILLO_AMARILLO: //Ladrillo resistente
                        ladrillo=new LadrilloResistente(this);
                        break;
                    case LADRILLO_SUERTE: //Ladrillo suerte
                        ladrillo=new LadrilloSuerte(this);
                        break;
                    case LADRILLO_IRROMPIBLE: //Ladrillo irrompible
                        ladrillo=new LadrilloIrrompible(this);
                        break;
                        
                }    
    
                if(tipoLadrillo!=0){
                    posx = posxInicial + columna*(ladrillo.getWidth() + hgapLadrillo);
                    posy = posyInicial + fila*(ladrillo.getHeight() + vgapLadrillo);
                    ladrillo.setPosition(posx,posy);
                    escena.addActor(ladrillo);
                    //this.actorManager.add(ladrillo);
                }
                                
            }          
        
        }
    }
}
