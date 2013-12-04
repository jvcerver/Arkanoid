/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */

package arkanoid.escenas;

import ESCENAS.Escena;
import FRAMEWORK.GRAFICOS.Sprite;
import FRAMEWORK.INPUT.Control;
import FRAMEWORK.LOGICA.ActorTexto;
import FRAMEWORK.LOGICA.Game;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class EscenaFinal extends Escena{
 
    private ActorTexto tituloFin;
    
    public EscenaFinal(Game game){
        super(game);
    }
    @Override
    public void iniciar() {
        /*FUTURO FONDO*/
        //Sprite spFondo=new Sprite(Recursos.fondoPresentacion);
        //game.stageManager.setFondo(spFondo);
        
        tituloFin=new ActorTexto(game,"GAME OVER.");
        tituloFin.setPosition(game.SCREEN_WIDTH/2-150,350);
        tituloFin.setTamanio(30);
        tituloFin.setColor(Color.WHITE); 
        game.actorManager.add(tituloFin);
        
        controlEscena=new Control(game,"ESCENA FINAL");
        controlEscena.setAction(this.SALIR, KeyEvent.VK_ESCAPE, 0);
        controlEscena.setAction(this.PAUSAR, KeyEvent.VK_P, 0);
        controlEscena.setAction(this.CONTINUAR, KeyEvent.VK_C, 0);
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
