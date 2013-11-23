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

    public int desplazamiento = Mundo.NORMAL;

    public Bola(Mundo mundo, BitMap bitMap) {
        super(mundo, bitMap);
        this.mundo = mundo;
        reiniciar();

    }

    public void reiniciar() { 
        x = mundo.getBarra().getX()+(mundo.getBarra().getWidth()/2)-(this.getWidth()/2);
        y = mundo.getBarra().getY()-this.getHeight();
        dx = desplazamiento;
        dy = -desplazamiento;
        mundo.pausarJuego();
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
            mundo.getBarra().reiniciar();
            this.reiniciar();
            mundo.getBarra().setVida(mundo.getBarra().getVida()-1);
            mundo.setTextoInformativo("Pulsa la barra espaciadora para comenzar");
            try{
                mundo.actorManager.del(mundo.getBarra().vidas.remove(mundo.getBarra().vidas.size()-1));
            }catch(IndexOutOfBoundsException e){
                //Cuando quedan 0 vidas
            }
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
            if(conQueChoco instanceof Ladrillo){
                int pinf = conQueChoco.getY()+conQueChoco.getHeight(); //punto inferior del objeto que colisiona
                int psup = conQueChoco.getY();//punto superior del objeto que colisiona
                int pder = conQueChoco.getX()+conQueChoco.getWidth(); //punto derecho maximo del objeto que colisiona
                int pizq = conQueChoco.getX(); //punto izquierdo maximo del objeto que colisiona
                int xcentro = this.x - this.getWidth()/2; //coordenada x del centro de la bola
                int ycentro = this.y - this.getHeight()/2; //coordenada y del centro de la bola
                //colisiono por debajo
                if (ycentro > pinf && (xcentro < pder && xcentro > pizq)) {
                    dy = -desplazamiento;
                }
                //colisiono por arriba
                if (ycentro < pinf && (xcentro < pder && xcentro > pizq)) {
                    dy = -desplazamiento;
                }
                //colisiono desde la izquierda
                if ((ycentro > psup && ycentro < pinf) && xcentro < pizq) {
                    dx = -desplazamiento;
                }
                //colisiono desde la derecha
                if ((ycentro > psup && ycentro < pinf) && xcentro > pder) {
                    dx = -desplazamiento;
                }
                //colisiono desde una esquina
                if (!(xcentro > pder && xcentro < pizq) && 
                        !(ycentro > psup && ycentro < pinf)) {
                    dx = -desplazamiento;
                    dy = -desplazamiento;
                }
            }
            
        }
    }
}
