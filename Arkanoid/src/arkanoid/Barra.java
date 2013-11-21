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

    public Barra(Mundo mundo) {
        super(mundo, Recursos.cesto);
        x = mundo.SCREEN_WIDTH / 2;
        y = mundo.SCREEN_HEIGHT - this.getHeight();
        this.mundo = mundo;
    }

    @Override
    public void recibirGolpe(Actor actor) {
        //do nothing
    }

    @Override
    public void actualizar(float deltaTime) {
        int tecla;
        if (mundo.getKeyBoardHandler().isTeclaPulsada()) {
            tecla = mundo.getKeyBoardHandler().getTecla();
            if (tecla == KeyEvent.VK_LEFT) {
                System.out.println("has pulsado ir a la izda");
                //dx=-3;
                moverIzqda();
            }
            if (tecla == KeyEvent.VK_RIGHT) {
                System.out.println("has pulsado ir a la DCHA");
                //dx=+3;
                moverDcha();
            }
            if (tecla == KeyEvent.VK_SPACE) {
                disparar();
            }
        }
        if (this.golpear() instanceof BolaAzul) {
            puntos++;
            System.out.println("puntos: " + puntos);
        }
        
        //this.golpear();
    }

    public void moverIzqda() {
        this.x -= 30;
    }

    public void moverDcha() {
        this.x += 30;
    }
    public void disparar(){
        Disparo disparo = new Disparo (mundo);
        mundo.actorManager.add(disparo);
        disparo.setPosicion(this.getX()+this.getWidth()/2, this.getY()+this.getHeight()/2);
    }

}
