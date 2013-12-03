/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */

package FRAMEWORK.INPUT;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardHandler  implements KeyListener{
    private int tecla;
    private boolean teclaPulsada;
    public KeyBoardHandler(){
        teclaPulsada=false;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclaPulsada=true;
        tecla=e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclaPulsada=false; //añadido para añadir suavidad al movimiento de la barra.
    }
    public int getTecla(){
        //teclaPulsada=false;
        return tecla;
    }
    public boolean isPulsada(){
        return teclaPulsada;
    }
    
}
