/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Image;

/**
 *
 * @author josevicente
 */
public class BitMap {
    private Image img;
    private int width,height;
    private static Galeria galeria=Galeria.getGaleria();

    /**
     *
     * @param fichero
     */
    public BitMap(String fichero){
         img=galeria.getImage(fichero);  
         width = img.getWidth(null);
         height = img.getHeight(null);
    }

    /**
     *
     * @return
     */
    public int getWidth() { return width;}

    /**
     *
     * @return
     */
    public int getHeight() { return height;}

    /**
     *
     * @return
     */
    public Image getImage() { return img;}
}
