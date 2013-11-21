/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import FRAMEWORK.GRAFICOS.Galeria;
import FRAMEWORK.GRAFICOS.Surface;
import FRAMEWORK.INPUT.KeyBoardHandler;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author josevicente
 */
public abstract class Game extends JFrame implements Runnable {

    /**
     *
     */
    public final ActorManager actorManager;

    /**
     *
     */
    public final StageManager stageManager;

    /**
     *
     */
    public final CollisionManager collisionManager;
    
    /**
     *
     */
    public final int SCREEN_WIDTH,

    /**
     *
     */
    SCREEN_HEIGHT;

    /**
     *
     */
    public float escalaX,

    /**
     *
     */
    escalaY;
    private final Surface surface;
    private final KeyBoardHandler keyBoardHandler;
    
    private long deltaTime;//tiempo transcurridos entre ... en milisegundos
    private long startTime;        

    /**
     *
     */
    public long TIMEFRAME=20000000L;//20ms-->50frames por segundo
        
    private Graphics2D g;
    private BufferStrategy strategy;
    
    private boolean fin;
    private boolean pausa;
    private Thread hilo;
    
    /**
     *
     */
    public Game(){
        GraphicsConfiguration gc = getGraphicsConfiguration();
        Rectangle screenRect = gc.getBounds();
        //SCREEN_WIDTH=screenRect.width;
        //SCREEN_HEIGHT=screenRect.height;
        SCREEN_WIDTH=800; //Pruebas con este tamaño hasta que Rafa arregle lo de pantalla completa
        SCREEN_HEIGHT=600;
        escalaX=SCREEN_WIDTH/1024F;   
        escalaY=SCREEN_HEIGHT/768F;
        setUndecorated(true);
        setResizable(false);
        
        JPanel panel = (JPanel) this.getContentPane();
        panel.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        panel.setLayout(null);

        surface=new Surface(SCREEN_WIDTH,SCREEN_HEIGHT);

        panel.add(surface);
        pack();                     
        setVisible(true);
        
        Galeria.crearGaleria(escalaX,escalaY);
        strategy=surface.crearBufferStrategy();
        g=(Graphics2D)strategy.getDrawGraphics();
       

        requestFocus();                
        keyBoardHandler=new KeyBoardHandler();
        this.addKeyListener(keyBoardHandler);

        actorManager=new ActorManager();
        stageManager=new StageManager(this);
        collisionManager=new CollisionManager(this);

        hilo=new Thread(this);         
    }
    
    /**
     *
     */
    public void iniciar(){
        fin=false;
        pausa=false;
        hilo.start();
    }
    
    /**
     *
     */
    public void run(){
        beforeTime=System.nanoTime();
        startTime=System.nanoTime();  
        principal();
        finalizarAplicacion();
    }

    /**
     *
     */
    public abstract void principal();
       // while(!fin);//LOOP GAME-->debe INCLUIR this.actualizar()
    
    private long beforeTime,afterTime, timeDiff, sleepTime;
    private long overSleepTime=0L;
    private int noDelays=0;
    private long totalTiempo;
    private int cont;
    private long inicio=System.nanoTime();

    /**
     *
     */
    protected void actualizar(){           
        deltaTime=System.nanoTime()-startTime;
        startTime=System.nanoTime();
        
        /********COMPROBACION DEL NUMERO DE FPS*********/
            totalTiempo=System.nanoTime()-inicio;    
            cont++;
            if (totalTiempo>1000000000L) {
                inicio=System.nanoTime();
                //System.out.println("FPS: "+cont);cont=0;
            }
         /********************************************/  
        if (!pausa) actorManager.actualizar(deltaTime);
        stageManager.dibujar();//ciclo gráfico            
        strategy.show();    
      
        afterTime=System.nanoTime();
        timeDiff=afterTime-beforeTime;  
 
        sleepTime=(TIMEFRAME-timeDiff)-overSleepTime;
   
        if (sleepTime>0) {
            try {
                Thread.sleep(sleepTime/1000000L);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
            overSleepTime =(System.nanoTime()- afterTime) - sleepTime;
        }
        else {
            overSleepTime=0L;
        }
        if (++noDelays>=16){
            Thread.yield(); //yield cede el control de la cpu
            noDelays=0;
        }    
        beforeTime =System.nanoTime();        
    }         

    private void finalizarAplicacion(){
        System.out.println("GRACIAS POR JUGAR");
        System.exit(0);
    }
    
    /**
     *
     * @return
     */
    public Graphics2D getGraficos(){
        return this.g;
    }
    
    /**
     *
     * @return
     */
    public KeyBoardHandler getKeyBoardHandler(){
        return keyBoardHandler;
    }

    /**
     *
     * @return
     */
    public boolean isFin(){
        return fin;        
    }

    /**
     *
     * @return
     */
    public boolean isPausa(){
        return pausa;
    }

    /**
     *
     */
    public  void pausarJuego(){
        pausa=true;
    }

    /**
     *
     */
    public void terminarJuego(){
        fin=true;   
    }

    /**
     *
     */
    public void reanudarJuego(){
        pausa=false;
    }    
}
