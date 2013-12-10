/**
 *
 * @author josevicente
 * @author Carmen
 */

package arkanoid.escenas;

import ESCENAS.Escena;
import FRAMEWORK.GRAFICOS.Sprite;
import FRAMEWORK.INPUT.Control;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.ActorTexto;
import FRAMEWORK.LOGICA.Game;
import arkanoid.Mundo;
import arkanoid.Recursos;
import java.awt.event.KeyEvent;


public class EscenaPresentacion extends Escena{
    
    public EscenaPresentacion(Game game){
        super(game);
    }
    @Override
    public void iniciar() {         
        
        Sprite spFondo=new Sprite(Recursos.intro);
        game.stageManager.setFondo(spFondo);
           
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
        ((Mundo)game).reiniciarBola();
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
