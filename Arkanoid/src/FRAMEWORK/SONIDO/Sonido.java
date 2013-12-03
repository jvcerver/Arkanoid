/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.SONIDO;


import java.applet.AudioClip;

public class Sonido {
    private AudioClip clip;    
    private static GaleriaClips galeria=GaleriaClips.getGaleria();

    public Sonido (String nombre){
        clip=galeria.getClip(nombre);       
    }
    
    public void play (){  
        new Thread(new Runnable(){
            public void run(){
                clip.play();        
            }
        }).start();
                
    }
    public void stop(){
        clip.stop();
    }
    public void loopPlay(){
       new Thread(new Runnable(){
            public void run(){
                clip.loop();
            }
       }).start();         
    }
}

