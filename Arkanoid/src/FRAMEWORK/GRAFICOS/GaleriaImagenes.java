/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class GaleriaImagenes {
   private final static String RUTA="./../../Assets/Imagenes/"; 
   private HashMap<String,BufferedImage> hashMap;
   private static GaleriaImagenes galeria;   
   private float escalaX, escalaY;
   
   private GaleriaImagenes(float escalaX, float escalaY){
       this.escalaX=escalaX;
       this.escalaY=escalaY;
       hashMap=new HashMap<String,BufferedImage>();
   }
   public static GaleriaImagenes crearGaleria(float escalaX, float escalaY){       
       if (galeria==null) galeria=new GaleriaImagenes(escalaX, escalaY);
       return galeria;    
   }
   public static GaleriaImagenes getGaleria(){       
       if (galeria==null) galeria=new GaleriaImagenes(1,1);
       return galeria;    
   }

   private BufferedImage cargarFichero(String fichero) {      
        URL url;
        Image img=null;
        BufferedImage bImg=null;
        try {
            url=this.getClass().getResource(RUTA+fichero);
            img = ImageIO.read(url);
            img=redimensionarImg(img);
            bImg=imageToBufferedImage(img);
         } catch (Exception ex) {}
        return bImg;
    }
   private Image redimensionarImg(Image img){
       Image imagen;
       int width=(int)(img.getWidth(null)*escalaX);
       int height=(int)(img.getHeight(null)*escalaY);
       
       imagen=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
       return imagen;
   }
   public static BufferedImage imageToBufferedImage(Image im) {
     BufferedImage bi = new BufferedImage
        (im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_4BYTE_ABGR);
     Graphics bg = bi.getGraphics();
     bg.drawImage(im, 0, 0, null);
     bg.dispose();
     return bi;
  }
   private void descargar(){           
   }
   public BufferedImage getImage(String nombre){
       BufferedImage img;
       if (hashMap.containsKey(nombre)){
           img=hashMap.get(nombre);
       }   
       else{ 
           img=cargarFichero(nombre);
           hashMap.put(nombre, img);  
       }
       return img;
   }
   public float getEscalaX(){
       return escalaX;
   }
   public float getEscalaY(){
       return escalaY;
   }
}

