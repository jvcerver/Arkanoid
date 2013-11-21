/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */

package FRAMEWORK.INPUT;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author josevicente
 */
public class KeyBoardHandler  implements KeyListener{
    private int tecla;
    private boolean teclaPulsada;

    /**
     *
     */
    public KeyBoardHandler(){
        teclaPulsada=false;
    }

    /**
     *
     * @param e
     */
    @Override
    public synchronized void keyTyped(KeyEvent e) {
    }

    /**
     *
     * @param e
     */
    @Override
    public synchronized void keyPressed(KeyEvent e) {
        teclaPulsada=true;
        tecla=e.getKeyCode();
    }

    /**
     *
     * @param e
     */
    @Override
    public synchronized void keyReleased(KeyEvent e) {
        teclaPulsada=false; //añadido para añadir suavidad al movimiento de la barra.
    }

    /**
     *
     * @return
     */
    public synchronized int getTecla(){
        //teclaPulsada=false;
        return tecla;
    }

    /**
     *
     * @return
     */
    public synchronized boolean isPulsada(){
        return teclaPulsada;
    }
    
}
