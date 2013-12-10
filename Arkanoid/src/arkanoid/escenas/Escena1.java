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
import static arkanoid.Mundo.LADRILLO_ROJO;
import arkanoid.Recursos;
import arkanoid.ladrillos.Ladrillo;
import java.awt.Color;
import java.awt.event.KeyEvent;


public class Escena1 extends Escena{

    private Sonido sonidoFondo;
    
    public Escena1(Game game){
        super(game);
        sonidoFondo = Recursos.sonidoFondo;
    }
    @Override
    public void iniciar() {  
        sonidoFondo.loopPlay();
        
        Sprite spFondo=new Sprite(Recursos.fondoNegro);
        game.stageManager.setFondo(spFondo);
        
        //Texto informativo
        ((Mundo)game).setTextoInformativo("Pulsa la flecha arriba para soltar la bola");
        
        //Pared de ladrillos
        ((Mundo)game).generarParedLadrillosHomogenea(LADRILLO_ROJO, 3, 10, 10, 10, game.SCREEN_HEIGHT/4, this);
           
        controlEscena=new Control(game,"ESCENA 1");
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
        ((Mundo)game).setTextoPuntosVidas("Puntos " + ((Mundo)game).getBarra().getPuntos());
        if (((Mundo)game).getBarra().getVida() == 0 || Ladrillo.getNumLadrillos()==0)
                finalizar();

    }

    @Override
    public void reanudar() {
        game.reanudarJuego();
    }

    @Override
    public void pausar() {
        game.pausarJuego();
    }

    @Override
    public Escena getSiguienteEscena() {
        return new Escena2(game);
    }
    

}
