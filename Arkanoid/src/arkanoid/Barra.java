/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;

import FRAMEWORK.GRAFICOS.Sprite;
import FRAMEWORK.INPUT.ObjetoControlable;
import FRAMEWORK.LOGICA.Actor;
import arkanoid.bloques.BloqueBarraMax;
import arkanoid.bloques.BloqueBarraMin;
import arkanoid.bloques.BloqueBarraPega;
import arkanoid.bloques.BloqueVida;
import java.util.ArrayList;

/**
 * @author josevicente
 * @author Carmen
 */
public class Barra extends Actor implements ObjetoControlable {

    private Mundo mundo;
    private Sombra sombra;
    public static final int VIDAS_INICIALES = 3;
    private ArrayList<Vida> vidas;
    private boolean cogerBola;
    private Bola bola;

    public Barra(Mundo mundo) {
        super(mundo, Recursos.barra);
        this.mundo = mundo;
        this.sombra = mundo.getSombra();
        vidas = new ArrayList<Vida>();
        for (int i = 0; i < VIDAS_INICIALES - 1; i++) {
            annadirDibujoVida(i);
        }
        vida++; //Una vida  más que dibujos hacemos
        reiniciar();
    }

    public void reiniciar() {
        x = (mundo.SCREEN_WIDTH - this.getWidth()) / 2;
        y = mundo.SCREEN_HEIGHT - this.getHeight() * 4;
        this.dx = (Mundo.NORMAL);

        sombra.setPosition(x, y);
        sombra.setDx(Mundo.NORMAL);
    }

    public void setBola(Bola bola) {
        this.bola = bola;
    }

    @Override
    public void recibirGolpe(Actor actor) {
        if (actor instanceof BloqueVida) {
            //Borramos el actor
            mundo.actorManager.del(actor);
            //Sumamos una vida
            annadirDibujoVida(vidas.size());
        } else if (actor instanceof BloqueBarraMax) {
            //Borramos el actor
            mundo.actorManager.del(actor);
            //Cambiamos el sprite a la barra y a la sombra
            this.setSpriteActual(new Sprite(Recursos.barraMax));
            sombra.setSpriteActual(new Sprite(Recursos.sombraMax));

        } else if (actor instanceof BloqueBarraMin) {
            //Borramos el actor
            mundo.actorManager.del(actor);
            //Cambiamos el sprite a la barra y a la sombra
            this.setSpriteActual(new Sprite(Recursos.barraMin));
            sombra.setSpriteActual(new Sprite(Recursos.sombraMin));

        }

        if (actor instanceof Bola && isCogerBola()) {
            bola = ((Bola) actor);
            bola.setEnEspera(true);
        }
        if (actor instanceof BloqueBarraPega) {
            mundo.actorManager.del(actor);
            setCogerBola(true);
        }
    }

    public void setCogerBola(boolean coger) {
        cogerBola = coger;
    }

    public boolean isCogerBola() {
        return cogerBola;
    }

    public void moverIzqda() {
        if (this.x > 0) { //si no rebasa el borde izquierdo
            if (dx > 0) {
                dx = dx * -1;
            }
            this.x += this.dx;
        } else {
            this.x = 0;
        }
    }

    public void moverDcha() {
        if (this.x + this.getWidth() < this.getGame().SCREEN_WIDTH) {
            if (dx < 0) {
                dx = dx * -1;
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
        vidas.get(indice).setPosition(mundo.SCREEN_WIDTH - (Recursos.vida.getWidth() + 10) * (indice + 1), mundo.SCREEN_HEIGHT - Recursos.vida.getHeight() * 2);
        mundo.actorManager.add(vidas.get(indice));
        vida++;
    }

    @Override
    public void destruir() {
   
    }

    @Override
    public void crear() {
   
    }

    @Override
    public void debilitar() {
   
    }

    public final static int DERECHA = 0;
    public final static int IZQUIERDA = 1;
    public final static int ARRIBA = 2;

    @Override
    public void doAccion(int accion) {
        switch (accion) {
            case DERECHA:
                moverDcha();
                sombra.setPosition(this.getX(), this.getY());
                break;
            case IZQUIERDA:
                moverIzqda();
                sombra.setPosition(this.getX(), this.getY());
                break;
            case ARRIBA:
                bola.setEnEspera(false);
                mundo.resetTextoInformativo();
                break;

        }//fin switch
    }
}
