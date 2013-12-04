/**
 *
 * @author Rafael Pérez DESARROLLO DE APLICACIONES MULTIPLATAFORMAS COLEGIO STMA
 * TRINIDAD DE SALAMANCA
 */
package arkanoid;

import arkanoid.ladrillos.Ladrillo;
import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.CollisionManager;
import FRAMEWORK.SONIDO.Sonido;
import arkanoid.escenas.Escena1;

public class Bola extends Actor {

    private Mundo mundo;
    private CollisionManager gestorColisiones;
    private Sonido golpeBola;
    private Sonido perderBola;

    public int desplazamiento = Mundo.LENTO;

    public Bola(Mundo mundo, BitMap bitMap) {
        super(mundo, bitMap);
        this.mundo = mundo;
        reiniciar();
        golpeBola = Recursos.sonidoGolpeBola;
        perderBola = Recursos.sonidoPerderBola;

    }

    public void reiniciar() {
         x = mundo.getBarra().getX() + (mundo.getBarra().getWidth() / 2) - (this.getWidth() / 2);
         y = mundo.getBarra().getY() - this.getHeight();
         dx = desplazamiento;
         dy = -desplazamiento;
         mundo.pausarJuego();
    }

    //SE HEREDA GOLPEAR
    @Override
    public void recibirGolpe(Actor actor) {
        //reiniciar();
    }

    @Override
    public void mover() {
        int xa = x, ya = y;
        this.x += dx;
        this.y += dy;
        //this.addX(dx);
        //this.addY(dy);

//COMPROBAR SI CHOCA CON LOS BORDES DE LA PANTALLA
        if (this.x < 0) {//borde izdo
            x = xa;
            dx = dx*-1;
        }
        if (this.x + this.getWidth() > mundo.SCREEN_WIDTH) {//borde dcho
            x = xa;
            dx = dx*-1;
        }
        if (this.y + this.getHeight() > mundo.SCREEN_HEIGHT) {//borde inferior
            perderBola.play();
            mundo.getBarra().reiniciar();
            this.reiniciar();
            mundo.getBarra().setVida(mundo.getBarra().getVida() - 1);
            //((Escena1)mundo.getEscenaActual()).setTextoInformativo("Pulsa la barra espaciadora para comenzar");
            try{
                mundo.actorManager.del(mundo.getBarra().getVidas().remove(mundo.getBarra().getVidas().size()-1));
            }catch(IndexOutOfBoundsException e){
                //Cuando quedan 0 vidas
            }
        }
        if (this.y < 0) {//borde superior
            y = ya;
            dy = dy*-1;
        }
        //Comprobar si choca con algo y actuar en consecuencia
        Actor conQueChoco = this.golpear();
        if (conQueChoco instanceof Barra) {
            dx = dx + Math.round(mundo.getBarra().getDx()/4);
            dy = dy*-1;
            golpeBola.play();
        }
        if (conQueChoco instanceof Ladrillo) {
            golpeBola.play();
            int pinfLadrillo = conQueChoco.getY() + conQueChoco.getHeight(); //punto inferior del objeto que colisiona
            int psupLadrillo = conQueChoco.getY();//punto superior del objeto que colisiona
            int pderLadrillo = conQueChoco.getX() + conQueChoco.getWidth(); //punto derecho maximo del objeto que colisiona
            int pizqLadrillo = conQueChoco.getX(); //punto izquierdo maximo del objeto que colisiona
            int pinfBola = this.y + this.getWidth(); // punto inferior de la bola
            int pderBola = this.x + this.getWidth(); //punto derecho de la bola
            
            //colisiono por debajo
            if (pinfBola > pinfLadrillo) {
                y = ya;
                dy = dy*-1;
            }
            
            //colisiono por arriba
            if (y < psupLadrillo) {
                y = ya;
                dy = dy*-1;
            }

            //colisiono desde la izquierda
            if (x < pizqLadrillo) {
                x = xa;
                dx = dx*-1;
            }
            
            //colisiono desde la derecha
            if (pderBola > pderLadrillo) {
                x = xa;
                dx = dx*-1;
            }
            
            //colisiones especiales//
            //colision esquina superior izquierda
            if (pinfBola > psupLadrillo && pderBola > pizqLadrillo && this.x < pizqLadrillo) {
                x = xa;
                y = ya;
                
                int aux = dx;
                dx = dy*-1;
                dy = dx;        
            }
            //esquina superior derecha
            if (pinfBola > psupLadrillo && pderBola > pderLadrillo && this.x < pderLadrillo) {
                x = xa;
                y = ya;

                int aux = dx;
                dx = dy;
                dy = dx*-1;
            }

            //esquina inferior izquierda
            if (this.y < pinfLadrillo && pderBola > pizqLadrillo && this.x < pizqLadrillo) {
                x = xa;
                y = ya;

                int aux = dx;
                dx = dy*-1;
                dy = dx;
            }
            //esquina inferior derecha
            if (this.y < pinfLadrillo && pderBola > pderLadrillo && this.x < pderLadrillo) {
                x = xa;
                y = ya;

                int aux = dx;
                dx = dy;
                dy = dx*-1;
            }

        }
    }

    @Override
    public void actualizar(int deltaTime) {
        tickTime += deltaTime;
        if (tickTime > TICK) {
            tickTime -= TICK;
            this.mover();

        }
    }

    @Override
    public void destruir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void debilitar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
