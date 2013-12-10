/**
 *
 * @author josevicente
 * @author Carmen
 */
package arkanoid;

import FRAMEWORK.LOGICA.Actor;

public class Jugador {
    private String nombre;
    private int puntuacion;
    private Actor actor;

    public Jugador(Actor actor){
        this.actor=actor;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    public void setActor(Actor actor){
        this.actor=actor;
    }
    public Actor getActor(){
        return actor;
    }
}
