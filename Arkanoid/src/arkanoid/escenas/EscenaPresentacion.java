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
import arkanoid.Mundo;
import java.awt.Color;
import java.awt.event.KeyEvent;


public class EscenaPresentacion extends Escena{

    private ActorTexto titulo;
    private ActorTexto textoInformativo;
    
    public EscenaPresentacion(Game game){
        super(game);
    }
    @Override
    public void iniciar() {         
        
        /*FUTURO FONDO*/
        //Sprite spFondo=new Sprite(Recursos.fondoPresentacion);
        //game.stageManager.setFondo(spFondo);
        
        titulo=new ActorTexto(game,"TEXTO PRESENTACIÓN");
        titulo.setPosition((game.SCREEN_WIDTH-titulo.getWidth())/2, game.SCREEN_HEIGHT/2);
        titulo.setColor(Color.MAGENTA);
        this.addActor(titulo);
        
        //Texto informativo para el usuario
        textoInformativo = new ActorTexto(game, "Comienza el juego pulsando la barra espaciadora");
        textoInformativo.setPosition((game.SCREEN_WIDTH-textoInformativo.getWidth())/2, ((Mundo)game).getBarra().getY()- ((Mundo)game).getBarra().getHeight()*6);
        textoInformativo.setTamanio(14);
        textoInformativo.setColor(Color.WHITE);
        this.addActor(textoInformativo);
           
        controlEscena=new Control(game,"ESCENA PRESENTACION");
        controlEscena.setAction(this.SALIR, KeyEvent.VK_SPACE, 0);
        controlEscena.setAction(this.PAUSAR, KeyEvent.VK_P, 0);
        controlEscena.setAction(this.CONTINUAR, KeyEvent.VK_C, 0);
        controlEscena.setOwner(this);
        game.controlManager.addControl(controlEscena);  
    }

    @Override
    public void finalizar() {
        game.controlManager.removeControl(controlEscena);
        this.finEscena=true; 
        this.quitarActoresEscena();     
    }

    @Override
    public void actualizar() {
    }

    @Override
    public void reanudar() {
        
    }

    @Override
    public void pausar() {

    }

    @Override
    public Escena getSiguienteEscena() {
        return new Escena1(game);
    }
}
