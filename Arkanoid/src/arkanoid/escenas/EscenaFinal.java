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
import arkanoid.Mundo;
import arkanoid.Recursos;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class EscenaFinal extends Escena{
 
    private ActorTexto puntosFinales;
    
    public EscenaFinal(Game game){
        super(game);
    }
    @Override
    public void iniciar() {
        Sprite spFondo=new Sprite(Recursos.fondoGameOver);
        game.stageManager.setFondo(spFondo);
        
        ((Mundo)game).resetTextoInformativo();
        
        //Texto informativo para el usuario
        puntosFinales = new ActorTexto(game, "PUNTOS: " + ((Mundo)game).getBarra().getPuntos());
        puntosFinales.setPosition((game.SCREEN_WIDTH-puntosFinales.getWidth())/2, ((Mundo)game).getBarra().getY()- ((Mundo)game).getBarra().getHeight()*6);
        puntosFinales.setTamanio(24);
        puntosFinales.setColor(Color.WHITE);
        this.addActor(puntosFinales); 
        
        controlEscena=new Control(game,"ESCENA FINAL");
        controlEscena.setAction(this.SALIR, KeyEvent.VK_ESCAPE, 0);
        controlEscena.setOwner(this);
        game.controlManager.addControl(controlEscena);  
    }

    @Override
    public void finalizar() {
        game.controlManager.removeControl(controlEscena);
        game.actorManager.vaciarListaActores();
        game.terminarJuego();
    }

    @Override
    public void actualizar() {
        if (game.getKeyBoardHandler().isPulsada()){
           this.finEscena=true;
           finalizar();
        }
    }

    @Override
    public void reanudar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pausar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Escena getSiguienteEscena() {
        
       return null;
    }

}
