/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class BitMap {
    private BufferedImage img;
    private final int width,height;
    private final int widthEscalado,heightEscalado;
    private final static GaleriaImagenes galeria=GaleriaImagenes.getGaleria();
    public BitMap(String fichero){
         img=(BufferedImage)galeria.getImage(fichero);  
         widthEscalado=img.getWidth(null);
         heightEscalado=img.getHeight(null);
         width = (int)(widthEscalado/galeria.getEscalaX());
         height = (int)(heightEscalado/galeria.getEscalaY());
    }
    public int getWidth() { return width;}
    public int getHeight() { return height;}
    public int getWidthEscalado(){return widthEscalado;}
    public int getHeightEscalado(){return heightEscalado;}
    
    public BufferedImage getImage() { return img;}
}
