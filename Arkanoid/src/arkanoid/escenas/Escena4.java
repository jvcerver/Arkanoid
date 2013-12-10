/**
 *
 * @author josevicente
 * @author Carmen
 */

package arkanoid.escenas;

import ESCENAS.Escena;
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
        
        /*FUTURO FONDO*/
        //Sprite spFondo=new Sprite(Recursos.fondoPresentacion);
        //game.stageManager.setFondo(spFondo);
        
         //Titulo vidas y puntos
        tituloPuntosVidas = new ActorTexto(game,"Puntos " + ((Mundo)game).getBarra().getPuntos());
        tituloPuntosVidas.setPosition(20, game.SCREEN_HEIGHT - ((Mundo)game).getBarra().getHeight());
        tituloPuntosVidas.setTamanio(20);
        tituloPuntosVidas.setColor(Color.BLUE); 
        this.addActor(tituloPuntosVidas);
        
        //Texto informativo para el usuario
        textoInformativo = new ActorTexto(game, "Pulsa la barra espaciadora para comenzar");
        textoInformativo.setPosition((game.SCREEN_WIDTH-textoInformativo.getWidth())/2, ((Mundo)game).getBarra().getY()- ((Mundo)game).getBarra().getHeight()*6);
        textoInformativo.setTamanio(14);
        textoInformativo.setColor(Color.WHITE);
        this.addActor(textoInformativo);  
        
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
        
        ((Mundo)game).generarParedLadrillosAMedida(matrizLadrillos, 5, 5, Recursos.ladrilloAmarillo.getHeight(), this);
           
        controlEscena=new Control(game,"ESCENA 2");
        controlEscena.setAction(this.SALIR, KeyEvent.VK_ESCAPE, 0);
        controlEscena.setAction(this.PAUSAR, KeyEvent.VK_P, 0);
        controlEscena.setAction(this.CONTINUAR, KeyEvent.VK_SPACE, 0);
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
        tituloPuntosVidas.setTexto("Puntos " + ((Mundo)game).getBarra().getPuntos());
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