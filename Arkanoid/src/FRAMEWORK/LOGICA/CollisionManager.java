/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

public class CollisionManager {
    private Game game;   
    
    public CollisionManager(Game game){
        this.game=game;
    }    
    public static boolean colision(Actor sp1,Actor sp2) {
        int w1,h1,w2,h2,x1,y1,x2,y2;
        boolean hayColision=false;
        
        x1=sp1.getX(); // posicion X del sprite 1
        y1=sp1.getY(); // posicion Y del sprite 1
        w1=sp1.getWidth(); // ancho del sprite 1
        h1=sp1.getHeight(); // altura del sprite 1

        x2=sp2.getX(); // posicion X del sprite 2
        y2=sp2.getY(); // posicion Y del sprite 2
        w2=sp2.getWidth(); // ancho del sprite 2
        h2=sp2.getHeight(); // altura del sprite 2
        if (((x1+w1)>x2) && ((y1+h1)>y2) && ((x2+w2)>x1) && ((y2+h2)>y1)) 
            hayColision=true;
        return hayColision;
    }
}
