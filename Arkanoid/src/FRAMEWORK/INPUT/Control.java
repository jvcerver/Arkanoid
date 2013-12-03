/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.INPUT;

import FRAMEWORK.LOGICA.Game;
import java.util.ArrayList;

public class Control {
    private String name;
    class Association{
        int accion;
        int componente;//en principio es una tecla
        int evento;    //si up down    
    }
    private Game game;
    private ObjetoControlable propietario;
    private ArrayList<Association> asociaciones;
    public Control(Game game,String name){
        this.game=game;
        this.name=name;
        asociaciones=new ArrayList();
    }
    //el componente es de momento una tecla
    public void setAction(int accion, int componente, int evento){
        Association association=new Association();
        association.accion=accion;
        association.componente=componente;
        association.evento=evento;
        asociaciones.add(association);
    }
    
    public void setOwner(ObjetoControlable propietario){
        this.propietario=propietario;
    }
    
    public void actualizar(int tecla){       
            for (int a=0;a<asociaciones.size();a++){               
                if (tecla==asociaciones.get(a).componente)                  
                    propietario.doAccion(asociaciones.get(a).accion);                    
            }
        
    }
    public String getName(){return name;}
    
}
