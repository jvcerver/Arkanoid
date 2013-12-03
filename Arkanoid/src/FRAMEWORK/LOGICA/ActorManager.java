/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import java.util.ArrayList;

public class ActorManager {
    private ArrayList<Actor> actores;
    private int indice=0;
    private Actor actor=null;
    
    public ActorManager(){
        actores=new ArrayList();
    }
    public void add(Actor actor){
        actores.add(actor);
    }
    public void del(Actor actor){
        actores.remove(actor);
    }
    public void rewind(){
        if (!actores.isEmpty()){
            actor=actores.get(0);
            indice=0;
        }
        else actor=null;  
    }
    public Actor next(){
        indice++;
        if (indice<actores.size()) actor=actores.get(indice);
        else actor=null;
        return actor;
    }
    public Actor current(){
        return actor;
    }  
    public void actualizar(int deltaTime){
        Actor item;
        for(int i=0;i<actores.size();i++){
            item=actores.get(i);
            item.actualizar(deltaTime);   
        }
    }
    public int numeroActores(){
        return actores.size();
    }
    public ArrayList<Actor> getListaActores(){
        return actores;
    }     
    public void vaciarListaActores(){
        while (!actores.isEmpty()){
            actor=actores.remove(0);            
        }
    }
}