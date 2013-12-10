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
 
    private ActorTexto textoInformativo;
    
    public EscenaFinal(Game game){
        super(game);
    }
    @Override
    public void iniciar() {
        Sprite spFondo=new Sprite(Recursos.fondoGameOver);
        game.stageManager.setFondo(spFondo);
        
        //Texto informativo para el usuario
        textoInformativo = new ActorTexto(game, "PUNTOS: " + ((Mundo)game).getBarra().getPuntos());
        textoInformativo.setPosition((game.SCREEN_WIDTH-textoInformativo.getWidth())/2, ((Mundo)game).getBarra().getY()- ((Mundo)game).getBarra().getHeight()*6);
        textoInformativo.setTamanio(24);
        textoInformativo.setColor(Color.WHITE);
        this.addActor(textoInformativo); 
        
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
