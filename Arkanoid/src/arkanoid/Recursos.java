/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.SONIDO.Sonido;

/**
 * @author josevicente
 * @author Carmen
 */
public class Recursos {
    /******IMÁGENES***********/
    public static BitMap barra = new BitMap("bars/bar.png");
    public static BitMap barraMin = new BitMap("bars/barMin.png");
    public static BitMap barraMax = new BitMap("bars/barMax.png");
    public static BitMap vida = new BitMap("bars/barLife.png");
    public static BitMap bola = new BitMap("bola.png"); 
    public static BitMap sombra = new BitMap("sombras/sombra.png");
    public static BitMap sombraMin = new BitMap("sombras/sombraMin.png");
    public static BitMap sombraMax = new BitMap("sombras/sombraMax.png");
    
    //Ladrillos
    public static BitMap ladrilloAleatorio = new BitMap("ladrillos/ladrilloAleatorio.png");
    public static BitMap ladrilloAzul = new BitMap("ladrillos/ladrilloAzul.png");
    public static BitMap ladrilloRojo = new BitMap("ladrillos/ladrilloRojo.png");
    public static BitMap ladrilloVerde = new BitMap("ladrillos/ladrilloVerde.png");
    public static BitMap ladrilloAmarillo = new BitMap("ladrillos/ladrilloAmarillo.png");
    public static BitMap ladrilloAmarilloRoto = new BitMap("ladrillos/ladrilloAmarilloRoto.png");
    public static BitMap ladrilloAmarilloSuperRoto = new BitMap("ladrillos/ladrilloAmarilloSuperRoto.png");
    public static BitMap ladrilloIrrompible = new BitMap("ladrillos/ladrilloIrrompible.png");
    public static BitMap ladrilloVida = new BitMap("ladrillos/ladrilloVida.png");
    public static BitMap ladrilloBarraMin = new BitMap("ladrillos/ladrilloBarraMin.png");
    public static BitMap ladrilloBarraMax = new BitMap("ladrillos/ladrilloBarraMax.png");
    public static BitMap ladrilloBarraPega = new BitMap("ladrillos/ladrilloBarraPega.png");
    
    //Bloques
    public static BitMap bloqueVida = new BitMap("bloques/bloqueVida.png");
    public static BitMap bloqueBarraMax = new BitMap("bloques/bloqueBarraMax.png");
    public static BitMap bloqueBarraMin = new BitMap("bloques/bloqueBarraMin.png");
    public static BitMap bloqueBaraPega = new BitMap("bloques/bloqueBarraPega.png");
    
    //Fondos
    public static BitMap fondoNegro = new BitMap("fondos/fondoNegro.jpg");
    public static BitMap fondoAzul = new BitMap("fondos/fondoAzul.jpg");
    public static BitMap fondoAzulGuay = new BitMap("fondos/fondoAzulGuay.jpg");
    public static BitMap fondoHojas = new BitMap("fondos/fondoHojas.jpg");
    public static BitMap fondoLineas = new BitMap("fondos/fondoLineas.jpg");
    public static BitMap fondoGameOver = new BitMap("fondos/fondoGameOver.jpg");
    public static BitMap intro = new BitMap("fondos/intro.jpg");
    
    /******SONIDOS***********/
    public static Sonido sonidoGolpeBola=new Sonido("golpeBola.WAV");
    public static Sonido sonidoFondo=new Sonido("sonidoFondo.wav");
    public static Sonido sonidoPerderBola=new Sonido("aplauso.wav");
}
