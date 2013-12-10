/**
 *
 * @author josevicente
 * @author Carmen
 */

package arkanoid.escenas;

import ESCENAS.Escena;
import FRAMEWORK.GRAFICOS.Sprite;
import FRAMEWORK.INPUT.Control;
import FRAMEWORK.LOGICA.ActorTexto;
import FRAMEWORK.LOGICA.Game;
import FRAMEWORK.SONIDO.Sonido;
import arkanoid.Mundo;
import static arkanoid.Mundo.LADRILLO_AMARILLO;
import static arkanoid.Mundo.LADRILLO_IRROMPIBLE;
import arkanoid.Recursos;
import arkanoid.ladrillos.Ladrillo;
import java.awt.Color;
import java.awt.event.KeyEvent;


public class Escena4 extends Escena{

    private ActorTexto textoInformativo; 
    private ActorTexto tituloPuntosVidas;
    private Sonido sonidoFondo;
    
    public Escena4(Game game){
        super(game);
        sonidoFondo = Recursos.sonidoFondo;
    }
    @Override
    public void iniciar() {  
        sonidoFondo.loopPlay();
        
        Sprite spFondo=new Sprite(Recursos.fondoHojas);
        game.stageManager.setFondo(spFondo);
        
        //Texto informativo
        ((Mundo)game).setTextoInformativo("Pulsa la flecha arriba para soltar la bola"); 
        
        //Pared de ladrillos
         //Ladrillos
        int matrizLadrillos[][]={ {                   0,                  0,                      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0,                      0},
                                  {                   0,                  LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0},
                                  {                   0,                  LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0},
                                  {                   LADRILLO_AMARILLO,  LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_AMARILLO},
                                  {                   LADRILLO_AMARILLO,  LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_AMARILLO},
                                  {LADRILLO_AMARILLO, LADRILLO_AMARILLO,  LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0},
                                  {LADRILLO_AMARILLO, LADRILLO_AMARILLO,  LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0},
                                  {LADRILLO_AMARILLO, LADRILLO_AMARILLO,  LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0},
                                  {                   LADRILLO_AMARILLO,  LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO},
                                  {                   LADRILLO_AMARILLO,  LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_AMARILLO},
                                  {                   0,                  LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_IRROMPIBLE,    LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0},
                                  {                   0,                  LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0},
                                  {                   0,                  0,                      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      LADRILLO_AMARILLO,      0,                      0},                      
        };
        
        ((Mundo)game).generarParedLadrillosAMedida(matrizLadrillos, 5, 5, Recursos.ladrilloAmarillo.getHeight()*2, this);
           
        controlEscena=new Control(game,"ESCENA 2");
        controlEscena.setAction(this.SALIR, KeyEvent.VK_ESCAPE, 0);
        //controlEscena.setAction(this.PAUSAR, KeyEvent.VK_P, 0);
        //controlEscena.setAction(this.CONTINUAR, KeyEvent.VK_SPACE, 0);
        controlEscena.setOwner(this);
        game.controlManager.addControl(controlEscena);  
    }

    @Override
    public void finalizar() {
         game.controlManager.removeControl(controlEscena);
         this.finEscena=true;
         quitarActoresEscena();
         Ladrillo.reiniciarLadrillos();
         ((Mundo)game).reiniciarBola();
    }

    @Override
    public void actualizar() {      
        ((Mundo)game).setTextoPuntosVidas("Puntos " + ((Mundo)game).getBarra().getPuntos());
        if (((Mundo)game).getBarra().getVida() == 0 || Ladrillo.getNumLadrillos()==0)
                finalizar();

    }

    @Override
    public void reanudar() {
        textoInformativo.setTexto("");
        game.reanudarJuego();
    }

    @Override
    public void pausar() {

    }

    @Override
    public Escena getSiguienteEscena() {
         return new EscenaFinal(game);
    }
    
    public void setTextoInformativo(String textoInformativo) {
        this.textoInformativo.setTexto(textoInformativo);
    }
}
