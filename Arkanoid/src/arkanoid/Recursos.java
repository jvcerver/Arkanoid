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
    public static BitMap barra = new BitMap("bar.png");
    public static BitMap barraMin = new BitMap("barMin.png");
    public static BitMap barraMax = new BitMap("barMax.png");
    public static BitMap vida = new BitMap("barLife.png");
    public static BitMap bola = new BitMap("bola.png"); 
    public static BitMap sombra = new BitMap("sombra.png");
    public static BitMap sombraMin = new BitMap("sombraMin.png");
    public static BitMap sombraMax = new BitMap("sombraMax.png");
    
    //Ladrillos
    public static BitMap ladrilloAleatorio = new BitMap("ladrilloAleatorio.png");
    public static BitMap ladrilloAzul = new BitMap("ladrilloAzul.png");
    public static BitMap ladrilloRojo = new BitMap("ladrilloRojo.png");
    public static BitMap ladrilloVerde = new BitMap("ladrilloVerde.png");
    public static BitMap ladrilloAmarillo = new BitMap("ladrilloAmarillo.png");
    public static BitMap ladrilloAmarilloRoto = new BitMap("ladrilloAmarilloRoto.png");
    public static BitMap ladrilloAmarilloSuperRoto = new BitMap("ladrilloAmarilloSuperRoto.png");
    public static BitMap ladrilloIrrompible = new BitMap("ladrilloIrrompible.png");
    public static BitMap ladrilloVida = new BitMap("ladrilloVida.png");
    public static BitMap ladrilloBarraMin = new BitMap("ladrilloBarraMin.png");
    public static BitMap ladrilloBarraMax = new BitMap("ladrilloBarraMax.png");
    public static BitMap ladrilloBarraPega = new BitMap("ladrilloBarraPega.png");
    
    //Bloques
    public static BitMap bloqueVida = new BitMap("bloqueVida.png");
    public static BitMap bloqueBarraMax = new BitMap("bloqueBarraMax.png");
    public static BitMap bloqueBarraMin = new BitMap("bloqueBarraMin.png");
    public static BitMap bloqueBaraPega = new BitMap("bloqueBarraPega.png");
    
    /******SONIDOS***********/
    public static Sonido sonidoGolpeBola=new Sonido("golpeBola.WAV");
    public static Sonido sonidoFondo=new Sonido("sonidoFondo.wav");
    public static Sonido sonidoPerderBola=new Sonido("aplauso.wav");
}
