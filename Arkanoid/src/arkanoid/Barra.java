/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;
import java.awt.event.KeyEvent;

/**
 *
 * @author josevicente
 */
public class Barra extends Actor {

    private Mundo mundo;
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
        x = mundo.SCREEN_WIDTH / 2;
        y = mundo.SCREEN_HEIGHT - this.getHeight();
        this.mundo = mundo;
        this.setDx(this.NORMAL);
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
        while (tickTime > TICK) {
            tickTime -= TICK;
            if (mundo.getKeyBoardHandler().isPulsada()) {
                tecla = mundo.getKeyBoardHandler().getTecla();
                if (tecla == KeyEvent.VK_LEFT) {
                       moverIzqda();
                } //fin if
                
                if (tecla == KeyEvent.VK_RIGHT) {
                        moverDcha();
                } //fin if
                if (tecla == KeyEvent.VK_ESCAPE) {
                    mundo.terminarJuego();
                }
            }//fin if
        }//fin while
    }
}
