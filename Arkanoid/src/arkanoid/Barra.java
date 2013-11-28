/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import arkanoid.bloques.BloqueVida;
import FRAMEWORK.LOGICA.Actor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author josevicente
 */
public class Barra extends Actor {

    private Mundo mundo;
    private Sombra sombra;
    public static final int VIDAS_INICIALES = 3;
    private ArrayList<Vida> vidas;    

    public Barra(Mundo mundo) {
        super(mundo, Recursos.barra);
        this.mundo = mundo;
        this.sombra = mundo.getSombra();
        vidas = new ArrayList<Vida>();
        for(int i=0; i<VIDAS_INICIALES-1; i++){
            annadirVida(i);
        }
        reiniciar();
    }
    
    public void reiniciar(){
        x = (mundo.SCREEN_WIDTH-this.getWidth())/ 2;
        y = mundo.SCREEN_HEIGHT - this.getHeight()*4;      
        this.setDx(Mundo.NORMAL);
        
        sombra.setPosition(x, y);
        sombra.setDx(Mundo.NORMAL);        
    }

    @Override
    public void recibirGolpe(Actor actor) {
        //La vida se añade en cualquier choque con la barra, tanto superior como lateral. Esto puede dejarse así o mejorarse
        if(actor instanceof BloqueVida){
            //Borramos el actor
            mundo.actorManager.del(actor);
            //Sumamos una vida
            annadirVida(vidas.size());
            
            //SI SE PIERDE CUANDO ESTÁ BAJANDO DEBERÍA BORRARSE
        }
    }

    public void moverIzqda() {
        if (this.x>0) { //si no rebasa el borde izquierdo
            if (dx > 0) {
                dx = dx*-1;
            }
        this.x += this.dx;
        } else {
            this.x=0;
        }
    }

    public void moverDcha() {
        if (this.x + this.getWidth() < this.getGame().SCREEN_WIDTH) {
            if (dx < 0) {
                dx = dx*-1;
            }
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
                switch (tecla){
                    case KeyEvent.VK_LEFT:
                        moverIzqda();
                        sombra.setPosition(this.getX(), this.getY());
                        break;
                        
                    case KeyEvent.VK_RIGHT:
                        moverDcha();
                        sombra.setPosition(this.getX(), this.getY());
                        break;
                        
                    case KeyEvent.VK_ESCAPE:
                        mundo.terminarJuego();
                        break;
                }
            }//fin if
        }//fin while
    }

    public ArrayList<Vida> getVidas() {
        return vidas;
    }

    private void annadirVida(int indice) {
            vidas.add(new Vida(mundo));
            vidas.get(indice).setPosition(mundo.SCREEN_WIDTH-(Recursos.vida.getWidth()+10)*(indice+1), mundo.SCREEN_HEIGHT-Recursos.vida.getHeight()*2);
            mundo.actorManager.add(vidas.get(indice));
            vida++;
    }
}
