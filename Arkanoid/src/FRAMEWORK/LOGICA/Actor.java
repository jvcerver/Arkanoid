/**
 *
 * @author Rafael Pérez DESARROLLO DE APLICACIONES MULTIPLATAFORMAS COLEGIO STMA
 * TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.GRAFICOS.Sprite;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author josevicente
 */
public abstract class Actor {

    protected static long AMILISEGUNDOS = 1000000L;
    protected long tickTime = 0;
    protected long TICK = 10 * AMILISEGUNDOS;
    protected int 
            x,
            y,

    /**
     * valor de desplazamiento horizontal
     */
    dx,

    /**
     * valor de desplazamiento vertical
     */
    dy; 
    private Sprite sprite;
    protected boolean activo = true;
    protected boolean visible = true;
    protected int vida;
    protected int puntos;
    private Game game;

    /**
     *
     * @param game
     */
    public Actor(Game game) {//Para cadenas de texto
        this.game = game;
    }

    /**
     *
     * @param game
     * @param bitMap
     */
    public Actor(Game game, BitMap bitMap) {
        this.game = game;
        sprite = new Sprite(bitMap);
    }

    /**
     *
     * @param puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     *
     * @return
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     *
     * @param vida
     */
    public void setVida(int vida) {
        this.vida = vida;
    }

    /**
     *
     * @return
     */
    public int getVida() {
        return vida;
    }

    /**
     *
     * @param activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     *
     * @return
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     *
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     *
     * @return
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @param c
     */
    public void addX(int c) {
        this.x += c;
    }

    /**
     *
     * @param c
     */
    public void addY(int c) {
        this.y += c;
    }

    /**
     * designa un nuevo valor de desplazamiento horizontal
     * @param valor
     */
    public void setDx(int valor) {
        dx = valor;
    }

    /**
     * designa un nuevo valor para desplazamiento vertical
     * @param valor
     */
    public void setDy(int valor) {
        dy = valor;
    }

    /**
     *
     * @return
     */
    public int getDx() {
        return dx;
    }

    /**
     *
     * @return
     */
    public int getDy() {
        return dy;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param deltaTime
     */
    public abstract void actualizar(long deltaTime);

    /**
     *
     * @param g
     */
    public void dibujar(Graphics g) {
        if (sprite == null) {
            return;//caso cadena de texto
        }
        if (visible) {
            sprite.setPosition(x, y);
            sprite.dibujar(g);
        }
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return sprite.getWidth();
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return sprite.getHeight();
    }

    /**
     *
     * @param actor
     */
    public abstract void recibirGolpe(Actor actor);//el que golpea

    /**
     *
     * @return
     */
    public Actor golpear() {
        //actor-->el que choca; return-->con el que choca
        Actor actorGolpeado = null, otroActor;
        Actor actorQueGopea = this;
        int n = game.actorManager.numeroActores();
        ArrayList<Actor> lista = game.actorManager.getListaActores();
        //0 es el escenario
        for (int i = 0; i < lista.size(); i++) {
            otroActor = lista.get(i);
            if (actorQueGopea == otroActor) {
                continue;
            }
            if (actorQueGopea.activo && otroActor.activo) {
                if (CollisionManager.colision(actorQueGopea, otroActor)) {
                    actorGolpeado = otroActor;
                    actorGolpeado.recibirGolpe(actorQueGopea);
                }
            }
        }//fin for 
        return actorGolpeado;//devuelve referencia con el que choca
    }

    /**
     *
     * @return
     */
    public Game getGame() {
        return game;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void changeSprite(BitMap bitMap) {
        sprite.setBitMap(bitMap);
        sprite.setHeight(bitMap.getHeight());
        sprite.setWidth(bitMap.getWidth());
    }
}
