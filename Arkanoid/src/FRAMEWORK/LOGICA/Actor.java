/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.GRAFICOS.Sprite;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Actor{ 
    protected int tickTime=0;
    protected int TICK;
    protected int x,y;
    protected int dx,dy;
    private Sprite spriteActual;
    
    protected boolean activo=true;
    protected boolean visible=true; 
    
    protected int vida;
    protected int puntos;
    protected int fortaleza;
    private Game game;
  
    public Actor(Game game){
        this.game=game;
        TICK=40;
    }
    
    public Actor(Game game, BitMap bitMap){
        this(game);
        spriteActual=new Sprite(bitMap);
    }
 
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    public int getPuntos(){
        return puntos;
    }
    public void setVida(int vida){
        this.vida=vida;
    }
    public int getVida(){
        return vida;
    }
    public int getFortaleza(){
        return fortaleza;
    }
    public void setFortaleza(int fortaleza){
        this.fortaleza=fortaleza;
    }
    public void setActivo(boolean activo){
        this.activo=activo;
    }
    public boolean isActivo(){
        return activo;
    }
    public void setVisible(boolean visible){
        this.visible=visible;
    }
    public boolean isVisible(){
        return visible;
    }
    public void setSpriteActual(Sprite sprite){
        this.spriteActual=sprite;
    }
    public Sprite getSpriteActual(){
        return spriteActual;
    }
    public void setPosition(int x, int y) {
        this.x=x; 
        this.y=y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    
    public int getX() {return x;}
    public int getY() {return y;}
      
    public void mover(){
        x+=dx;
        y+=dy;
    }
            
    public abstract void actualizar(int deltaTime);
    public  void dibujar(Graphics g){
        if (spriteActual==null) return;//caso cadena de texto
        if (visible){
            if (spriteActual.isAnimado()) spriteActual.actualizar(tickTime);
            spriteActual.setPosition((int)(x*game.escalaX), (int)(y*game.escalaY));
            spriteActual.dibujar(g);
        }    
    }
    
    public int getWidth() {
        return spriteActual.getWidth();
    }
    public int getHeight() {
        return spriteActual.getHeight();
    }
    
    public abstract void recibirGolpe(Actor actor);//el que golpea
    public Actor golpear(){
        //actor-->el que choca; return-->con el que choca
        Actor actorGolpeado=null,otroActor;
        Actor actorQueGopea=this;
        int n=game.actorManager.numeroActores();
        ArrayList<Actor> lista=game.actorManager.getListaActores();
        //0 es el escenario
        for (int i=0;i<lista.size();i++){          
            otroActor=lista.get(i);
            if (actorQueGopea==otroActor) continue;
            if (actorQueGopea.activo && otroActor.activo){
                if (CollisionManager.colision(actorQueGopea,otroActor)) {
                    actorGolpeado=otroActor;
                    actorGolpeado.recibirGolpe(actorQueGopea);
                }
            }
        }//fin fori  
        return actorGolpeado;//devuelve referencia con el que choca
    }
    public Game getGame(){
        return game;
    }
    public abstract void destruir();
    public abstract void crear();
    public abstract void debilitar();

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
    
}