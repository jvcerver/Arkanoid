/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import java.util.ArrayList;

/**
 *
 * @author josevicente
 */
public class ActorManager {
    private ArrayList<Actor> actores;
    private int indice=0;
    private Actor actor=null;
    
    /**
     *
     */
    public ActorManager(){
        actores=new ArrayList();
    }

    /**
     *
     * @param actor
     */
    public void add(Actor actor){
        actores.add(actor);
    }

    /**
     *
     * @param actor
     */
    public void del(Actor actor){
        actores.remove(actor);
    }

    /**
     *
     */
    public void rewind(){
        if (!actores.isEmpty()){
            actor=actores.get(0);
            indice=0;
        }
        else actor=null;  
    }

    /**
     *
     * @return
     */
    public Actor next(){
        indice++;
        if (indice<actores.size()) actor=actores.get(indice);
        else actor=null;
        return actor;
    }

    /**
     *
     * @return
     */
    public Actor current(){
        return actor;
    }  

    /**
     *
     * @param deltaTime
     */
    public void actualizar(long deltaTime){
        Actor item;
        for(int i=0;i<actores.size();i++){
            item=actores.get(i);
            item.actualizar(deltaTime);   
        }
    }

    /**
     *
     * @return
     */
    public int numeroActores(){
        return actores.size();
    }

    /**
     *
     * @return
     */
    public ArrayList<Actor> getListaActores(){
        return actores;
    }      
}