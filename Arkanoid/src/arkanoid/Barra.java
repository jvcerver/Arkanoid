/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import FRAMEWORK.GRAFICOS.Sprite;
import FRAMEWORK.INPUT.ObjetoControlable;
import arkanoid.bloques.BloqueVida;
import FRAMEWORK.LOGICA.Actor;
import arkanoid.bloques.Bloque;
import arkanoid.bloques.BloqueBarraMax;
import arkanoid.bloques.BloqueBarraMin;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author josevicente
 */
public class Barra extends Actor implements ObjetoControlable {

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
            annadirDibujoVida(i);
        }
        vida++; //Una vida  más que dibujos hacemos
        reiniciar();
    }
    
    public void reiniciar(){
        x = (mundo.SCREEN_WIDTH-this.getWidth())/ 2;
        y = mundo.SCREEN_HEIGHT - this.getHeight()*4;      
        this.dx=(Mundo.NORMAL);
        
        sombra.setPosition(x, y);
        sombra.setDx(Mundo.NORMAL);        
    }

    @Override
    public void recibirGolpe(Actor actor) {
        if(actor instanceof BloqueVida){
            //Borramos el actor
            mundo.actorManager.del(actor);
            //Sumamos una vida
            annadirDibujoVida(vidas.size());
        }
        else if(actor instanceof BloqueBarraMax){
            //Borramos el actor
            mundo.actorManager.del(actor);
            //Cambiamos el sprite a la barra y a la sombra
            this.setSpriteActual(new Sprite(Recursos.barraMax));
            sombra.setSpriteActual(new Sprite(Recursos.sombraMax));
            
        }
        else if(actor instanceof BloqueBarraMin){
            //Borramos el actor
            mundo.actorManager.del(actor);
            //Cambiamos el sprite a la barra y a la sombra
            this.setSpriteActual(new Sprite(Recursos.barraMin));
            sombra.setSpriteActual(new Sprite(Recursos.sombraMin));
            
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
    public void actualizar(int deltaTime) {
    }

    public ArrayList<Vida> getVidas() {
        return vidas;
    }

    private void annadirDibujoVida(int indice) {
            vidas.add(new Vida(mundo));
            vidas.get(indice).setPosition(mundo.SCREEN_WIDTH-(Recursos.vida.getWidth()+10)*(indice+1), mundo.SCREEN_HEIGHT-Recursos.vida.getHeight()*2);
            mundo.actorManager.add(vidas.get(indice));
            vida++;
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

    public final static int DERECHA=0;
    public final static int IZQUIERDA=1;
    
    @Override
    public void doAccion(int accion) {
        switch (accion){
            case DERECHA:
                moverDcha();
                sombra.setPosition(this.getX(), this.getY());
                break;
            case IZQUIERDA:
                moverIzqda();
                sombra.setPosition(this.getX(), this.getY());
                break;
        }//fin switch
    }
}
