/**
 *
 * @author Rafael Pérez DESARROLLO DE APLICACIONES MULTIPLATAFORMAS COLEGIO STMA
 * TRINIDAD DE SALAMANCA
 */
package arkanoid;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.CollisionManager;

public class Bola extends Actor {

    private Mundo mundo;
    private CollisionManager gestorColisiones;
    private int tickTime = 0;
    private final float TICK = 20.0f;
    public int desplazamiento = 11;

    public Bola(Mundo mundo, BitMap bitMap) {
        super(mundo, bitMap);
        this.mundo = mundo;
        //this.gestorColisiones=mundo.collisionManager;
        reiniciar();

    }

    public void reiniciar() {
        x = (int) (Math.random() * mundo.SCREEN_WIDTH);
        //y = (int) (Math.random() * mundo.SCREEN_HEIGHT);
        y = 0;
        desplazamiento = (int) (Math.random() * 12) + 1;
        dx = desplazamiento;
        dy = desplazamiento;
    }

    //SE HEREDA GOLPEAR
    @Override
    public void recibirGolpe(Actor actor) {
        reiniciar();
    }

    private void mover() {
        int xa = x, ya = y;
        this.addX(dx);
        this.addY(dy);

//COMPROBAR SI CHOCA CON LOS BORDES DE LA PANTALLA
        if (this.x < 0) {//borde izdo
            x = xa;
            dx = desplazamiento;
        }
        if (this.x + this.getWidth() > mundo.SCREEN_WIDTH) {//borde dcho
            x = xa;
            dx = -desplazamiento;
        }
        if (this.y + this.getHeight() > mundo.SCREEN_HEIGHT) {//borde inferior
            this.reiniciar();
        }
        if (this.y < 0) {//borde superior
            y = ya;
            dy = desplazamiento;
        }
    }

    @Override
    public void actualizar(long deltaTime) {
        tickTime += deltaTime;
        if (tickTime > TICK) {
            tickTime -= TICK;
            this.mover();
            
            //Comprobar si choca con algo y actuar en consecuencia
            Actor conQueChoco = this.golpear();
            if(conQueChoco instanceof Barra)
                dy = -desplazamiento;
            
        }
    }
}
