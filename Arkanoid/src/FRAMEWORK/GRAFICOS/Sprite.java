/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {
    private int x, y;//posicion del sprite en pantalla
    private int width,height;
    private int widthEscalado,heightEscalado;
    private final BitMap bitMap;
    private int nFrames;
    private int iFrame;
    private int tick;
    private int tiempo;
    private boolean animacion;
    private BufferedImage frameActual;
    private BufferedImage frames[];
    
    /*crear sprite no animado*/
    public Sprite(BitMap bitMap){
        this.bitMap=bitMap;
        widthEscalado = bitMap.getWidthEscalado();
        heightEscalado = bitMap.getHeightEscalado();
        width = bitMap.getWidth();
        height = bitMap.getHeight();
        frameActual=bitMap.getImage();
        animacion=false;
    }
    /*crear sprite animado*/
    public Sprite(BitMap bitMap,int nFrames, int tick){        
        this.bitMap=bitMap;
        setAnimacion(nFrames,tick);
    } 
    public void setAnimacion(int nFrames,int tick){
        this.nFrames=nFrames;
        this.tick=tick;
        widthEscalado = bitMap.getWidthEscalado()/nFrames;//imagen tira horizontal de Frames
        heightEscalado = bitMap.getHeightEscalado();
        width = bitMap.getWidth()/nFrames;
        height = bitMap.getHeight();
        frames=new BufferedImage[nFrames];
        for (int i=0;i<frames.length;i++){    
            frames[i]=bitMap.getImage().getSubimage(i*widthEscalado,0 ,widthEscalado,heightEscalado);
        }
        frameActual=frames[0];
        animacion=true;                
    }
    public boolean isAnimado(){
        return animacion;
    }
    public void dibujar(Graphics g){     
        g.drawImage(frameActual, x, y, null);       
    }
       
    public void setPosition(int x, int y){
        this.x = x; this.y = y;  
    }

    public int getiFrame() {
        return iFrame;
    }

 //   public void setX(int x) { this.x = x;}
 //   public void setY(int y) { this.y = y;}
 //   public int getX(){ return x;}
 //  public int getY(){ return y;}
    public int getWidth() { return width;}
    public int getHeight() { return height;}
    
    public void actualizar(int deltaTime){
       tiempo+=deltaTime;
       while (tiempo>tick){
            tiempo-=tick;
            iFrame++;
            if( iFrame == nFrames) {
                iFrame = 0; 
            } 
       }
       frameActual=frames[iFrame];
    } 
   
   public void reIniciar(){
       iFrame = 0;
       frameActual=frames[iFrame];
   }
  
}
