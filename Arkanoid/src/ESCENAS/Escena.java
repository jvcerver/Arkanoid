/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */

package ESCENAS;

import FRAMEWORK.INPUT.Control;
import FRAMEWORK.INPUT.ObjetoControlable;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;
import java.util.ArrayList;

public abstract  class Escena implements ObjetoControlable {
    protected Game game;
    protected boolean finEscena;
    protected Control controlEscena;
    private ArrayList<Actor> actoresEscena;
    
    public final static int SALIR=0;
    public final static int PAUSAR=1;
    public final static int CONTINUAR=2;
    public Escena(Game game){
        this.game=game;
        finEscena=false;    
        actoresEscena=new ArrayList<Actor>();
    }
    public void addActor(Actor actor){
        actoresEscena.add(actor);
        game.actorManager.add(actor);
    }
    public abstract void iniciar();
    public abstract void finalizar();
    public abstract void actualizar();
    public abstract void reanudar();
    public abstract void pausar();   
    public boolean isFin(){return finEscena;}
    public abstract Escena getSiguienteEscena();
    public void quitarActoresEscena(){
        for (int i=0;i<actoresEscena.size();i++){
            game.actorManager.del(actoresEscena.get(i));
        }
    }
    @Override
    public void doAccion(int accion) {
         switch (accion){
            case Escena.SALIR:
                finalizar();
                break;
            case Escena.PAUSAR:
                pausar();
                break;
            case Escena.CONTINUAR:
                reanudar();
                break;
        }//fin switch
    }
}
