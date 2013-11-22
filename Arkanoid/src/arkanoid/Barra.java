/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import FRAMEWORK.LOGICA.Actor;
import java.awt.event.KeyEvent;

/**
 *
 * @author josevicente
 */
public class Barra extends Actor {

    private Mundo mundo;
    private Sombra sombra;
//para futuras iteraciones en las que la velocidad pueda variar    
    private final int 
            MAXIMO = 30,
            EXTRARAPIDO = 20,
            RAPIDO = 15,
            NORMAL = 10,
            LENTO = 7,
            EXTRALENTO = 3;

    public Barra(Mundo mundo) {
        super(mundo, Recursos.barra);
        this.mundo = mundo;
        this.sombra = mundo.getSombra();
        x = mundo.SCREEN_WIDTH / 2;
        y = mundo.SCREEN_HEIGHT - this.getHeight()*2;      
        this.setDx(this.NORMAL);
        
        sombra.setPosition(x, y);
        sombra.setDx(this.NORMAL);
    }

    @Override
    public void recibirGolpe(Actor actor) {
        //do nothing
    }

    public void moverIzqda() {
        if (this.x>0) { //si no rebasa el borde izquierdo
            this.x -= this.dx;
        } else {
            this.x=0;
        }
    }

    public void moverDcha() {
        if (this.x + this.getWidth() < this.getGame().SCREEN_WIDTH) {
            this.x += this.dx;
        } else {
            this.x = this.getGame().SCREEN_WIDTH - this.getWidth();
        }
        
    }

    @Override
    public void actualizar(long deltaTime) {
        int tecla;
        tickTime += deltaTime;
        if (tickTime > TICK) {
            tickTime -= TICK;
            //tickTime = 0;
            if (mundo.getKeyBoardHandler().isPulsada()) {
                tecla = mundo.getKeyBoardHandler().getTecla();
                if (tecla == KeyEvent.VK_LEFT) {
                       moverIzqda();
                       sombra.setPosition(this.getX(), this.getY());
                } //fin if
                
                if (tecla == KeyEvent.VK_RIGHT) {
                        moverDcha();
                        sombra.setPosition(this.getX(), this.getY());
                } //fin if
                if (tecla == KeyEvent.VK_ESCAPE) {
                    mundo.terminarJuego();
                }
            }//fin if
        }//fin while
    }
}
