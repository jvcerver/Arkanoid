/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;


import FRAMEWORK.INPUT.Control;
import java.util.ArrayList;

public class ControlManager {
    private Game game;
    private ArrayList<Control> controls;
    
    public ControlManager(Game game){
        this.game=game; 
        controls=new ArrayList();
    }
    public void addControl(Control control){
        controls.add(control);
    }
    public void removeControl(Control control){
        controls.remove(control);
    }
    public void actualizar(){     
        Control item;
        int tecla;
        if (game.getKeyBoardHandler().isPulsada()){
            tecla=game.getKeyBoardHandler().getTecla();
            for(int i=0;i<controls.size();i++){
                item=controls.get(i);                
                item.actualizar(tecla);
            }
        }   
    }
}
