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


public class Escena1 extends Escena{

    private ActorTexto textoInformativo; 
    
    public Escena1(Game game){
        super(game);
    }
    @Override
    public void iniciar() {        
        ActorTexto tituloPuntosVidas;
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
        textoInformativo.setColor(Color.BLACK);
        this.addActor(textoInformativo);  
           
        controlEscena=new Control(game,"ESCENA PRESENTACION");
        controlEscena.setAction(this.SALIR, KeyEvent.VK_ESCAPE, 0);
        controlEscena.setAction(this.PAUSAR, KeyEvent.VK_P, 0);
        controlEscena.setAction(this.CONTINUAR, KeyEvent.VK_SPACE, 0);
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
        /*if (game.getKeyBoardHandler().isPulsada()){
           this.finEscena=true;
           finalizar();
        }*/
    }

    @Override
    public void reanudar() {
        game.reanudarJuego();
    }

    @Override
    public void pausar() {

    }

    @Override
    public Escena getSiguienteEscena() {
        return null;
        //return new Escena1(game);
    }
    
    public void setTextoInformativo(String textoInformativo) {
        this.textoInformativo.setTexto(textoInformativo);
    }
}
