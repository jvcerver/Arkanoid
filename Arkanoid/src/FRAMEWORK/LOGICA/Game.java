/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import FRAMEWORK.GRAFICOS.GaleriaImagenes;
import FRAMEWORK.GRAFICOS.Surface;
import FRAMEWORK.INPUT.KeyBoardHandler;
import FRAMEWORK.SONIDO.GaleriaClips;
import arkanoid.Jugador;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Game extends Frame implements Runnable {
    public final ActorManager actorManager;
    public final StageManager stageManager;
    public final CollisionManager collisionManager;
    public final ControlManager controlManager;
    
    
    public int SCREEN_WIDTH, SCREEN_HEIGHT;
    public int SCREEN_WIDTH_ESCALADO, SCREEN_HEIGHT_ESCALADO;
    public float escalaX,escalaY;
    public static long AMILISEGUNDOS=1000000L;
    public static int STEPX=2,STEPY=2;

    private KeyBoardHandler keyBoardHandler;
    
    private long deltaTime;//tiempo transcurridos entre ... en milisegundos
    private long startTime;        
    private long TIMEFRAME=10000000L;//20ms-->50frames por segundo
    private int fps;    
    private Graphics g;
    private BufferStrategy strategy;
    
    private boolean fin;
    private boolean pausa;
    private final Thread hilo;
    
    public Jugador jugador1,jugador2;
    public Game(){
        iniciarFullScreen();
        SCREEN_WIDTH=1024;
        SCREEN_HEIGHT=768;
        escalaX=(float)SCREEN_WIDTH_ESCALADO/SCREEN_WIDTH;   
        escalaY=(float)SCREEN_HEIGHT_ESCALADO/SCREEN_HEIGHT;                   
        
        GaleriaImagenes.crearGaleria(escalaX,escalaY);
        GaleriaClips.crearGaleria();
                 
        actorManager=new ActorManager();
        stageManager=new StageManager(this);
        collisionManager=new CollisionManager(this);
        controlManager=new ControlManager(this);
        
        crearJugadores();
        
        hilo=new Thread(this);         
    }
    public void crearJugadores(){
        this.jugador1=new Jugador(null);
        this.jugador1.setNombre("Rafa");
        
        this.jugador2=new Jugador(null);
        this.jugador2.setNombre("Angel");
       
    }
    private void iniciarFullScreen(){
        setUndecorated(true);
        setIgnoreRepaint(true);
        setResizable(false);
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd=ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(this); 
        GraphicsConfiguration gc = getGraphicsConfiguration();
        Rectangle screenRect = gc.getBounds();
        SCREEN_WIDTH_ESCALADO=screenRect.width;
        SCREEN_HEIGHT_ESCALADO=screenRect.height;         
        Surface surface=new Surface(SCREEN_WIDTH_ESCALADO,SCREEN_HEIGHT_ESCALADO);  
        add(surface);
        pack();      
        keyBoardHandler=new KeyBoardHandler();
        surface.addKeyListener(keyBoardHandler);
        surface.setFocusable(true);
        surface.requestFocus();
        setVisible(true);
        strategy=surface.crearBufferStrategy();      
        g=surface.getGraphics(); 
    }
    
    public void iniciar(){
        fin=false;
        pausa=false;
          
        hilo.start();
    }
    
    public void run(){
        beforeTime=System.nanoTime();
        startTime=System.nanoTime();  
        principal();
        finalizarAplicacion();
    }
    public abstract void principal();
       // while(!fin);//LOOP GAME-->debe INCLUIR this.actualizar()
    
    private long beforeTime,afterTime, timeDiff, sleepTime;
    private long overSleepTime=0L;
    private int noDelays=0;
    private long totalTiempo;
    private int cont;
    private long inicio=System.nanoTime();
    protected void actualizar(){      

        deltaTime=System.nanoTime()-startTime;
        startTime=System.nanoTime();
        
        /********COMPROBACION DEL NUMERO DE FPS*********/
            totalTiempo=System.nanoTime()-inicio;    
            cont++;
            if (totalTiempo>1000000000L) {
                inicio=System.nanoTime();
                fps=cont;
                System.out.println("FPS: "+cont);cont=0;
            }
         /********************************************/  
        if (!pausa) actorManager.actualizar((int)(deltaTime/1000000));//paso msg
        
        controlManager.actualizar();
        
        g=strategy.getDrawGraphics();
        stageManager.dibujar(g);//ciclo gráfico              
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
            Thread.yield();//-->no parece funcionar en los MAC
            noDelays=0;
        }    
        beforeTime =System.nanoTime();        
    }         
    public int getFps(){
        return fps;
    }
    private void finalizarAplicacion(){
        System.out.println("GRACIAS POR JUGAR");
        System.exit(0);
    }
    
    public Graphics getGraficos(){
        return this.g;
    }
    
    public KeyBoardHandler getKeyBoardHandler(){
        return keyBoardHandler;
    }

    public boolean isFin(){
        return fin;        
    }
    public boolean isPausa(){
        return pausa;
    }
    public  void pausarJuego(){
        pausa=true;
    }
    public void terminarJuego(){
        fin=true;   
    }
    public void reanudarJuego(){
        pausa=false;
    }    
}
