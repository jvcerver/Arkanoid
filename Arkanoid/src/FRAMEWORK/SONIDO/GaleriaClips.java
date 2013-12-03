/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.SONIDO;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.HashMap;

public class GaleriaClips {
   private final static String RUTA="./../../Assets/Sonidos/"; 
   private HashMap<String,AudioClip> hashMap;
   private static GaleriaClips galeria;   
   
   private GaleriaClips(){
       hashMap=new HashMap<String,AudioClip>();
   }
   public static GaleriaClips crearGaleria(){       
       if (galeria==null) galeria=new GaleriaClips();
       return galeria;    
   }
   public static GaleriaClips getGaleria(){       
       if (galeria==null) galeria=new GaleriaClips();
       return galeria;    
   }

   private AudioClip cargarClip(String fichero){      
        URL url=this.getClass().getResource(RUTA+fichero);
        AudioClip clip = Applet.newAudioClip(url);
	return clip;		
   }
    
   public AudioClip getClip(String nombre){
       AudioClip clip;
       if (hashMap.containsKey(nombre)){
           clip=hashMap.get(nombre);
       }   
       else{ 
           clip=cargarClip(nombre);
           hashMap.put(nombre, clip);  
       }
       return clip;
   }
}
