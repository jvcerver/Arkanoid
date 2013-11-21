/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author josevicente
 */
public class Galeria {
   private final static String RUTA="./../../Assets/"; 
   private HashMap<String,Image> hashMap;
   private static Galeria galeria;   
   private float escalaX, escalaY;
   
   private Galeria(float escalaX, float escalaY){
       this.escalaX=escalaX;
       this.escalaY=escalaY;
       hashMap=new HashMap<String,Image>();
   }
       
    /**
     * crea una galeria con una escala x e y. de ese modo es posible generar mismos sprites de distintos tamaños
     * @param escalaX
     * @param escalaY
     * @return
     */
    public static Galeria crearGaleria(float escalaX, float escalaY){       
       if (galeria==null) galeria=new Galeria(escalaX, escalaY);
       return galeria;    
   }
       
    /**
     * devuelve la galeria, en caso de estar vacia, crea una galeria escala 1.1
     * @return
     */
    public static Galeria getGaleria(){       
       if (galeria==null) galeria=new Galeria(1,1);
       return galeria;    
   }
    /**
     * carga una imagen desde un fichero
     * @param fichero
     * @return img
     */
   private Image cargarFichero(String fichero) {      
        URL url;
        Image img=null;
        try {
            url=this.getClass().getResource(RUTA+fichero);
            img = ImageIO.read(url);
            img=redimensionarImg(img);
         } catch (Exception ex) {}
        return img;
    }
   /**
    * redimensiona la imagen a la escala dada de la galeria
    * @param img
    * @return 
    */
   private Image redimensionarImg(Image img){
       Image imagen;
       int width=(int)(img.getWidth(null)*escalaX);
       int height=(int)(img.getHeight(null)*escalaY);
       imagen=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
       return imagen;
   }
    /**
     * 
     */
   private void descargar(){           
   }

    /**
     *
     * @param nombre
     * @return
     */
    public Image getImage(String nombre){
       Image img;
       if (hashMap.containsKey(nombre)){
           img=hashMap.get(nombre);
       }   
       else{ 
           img=cargarFichero(nombre);
           hashMap.put(nombre, img);  
       }
       return img;
   }
}
