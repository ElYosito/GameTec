
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


public class Auto {
    Juego JuegoTec;
    
    static boolean saltando=false;
    boolean sube=false;
    boolean baja=false;
    
    Area llantaDelantera,llantaTrasera,carroceria,tractor;
    int anchoPersonaje=70;
    int altoPersonaje=122;
    
    static int x_inicial=50;
    static int y_inicial=200;
    
    int x_auxiliar=0;
    int y_auxiliar=0;
    
    public Auto(Juego JuegoTec) {
        this.JuegoTec = JuegoTec;
    }
    
    public void mover(){
        if(x_inicial+x_auxiliar>0 && x_inicial+x_auxiliar<JuegoTec.getWidth()-anchoPersonaje){
            x_inicial+=x_auxiliar;
        }
        if(saltando){
            if(y_inicial==200){
                sube=true;
                y_auxiliar=-5;
                baja=false;
            }
            if(y_inicial==50){
                baja=true;
                y_auxiliar=5;
                sube=false;
            }
            
            if(sube){
                y_inicial+=y_auxiliar;
            }
            if(baja){
                y_inicial+=y_auxiliar;
                if(y_inicial==200){
                    saltando=false;
                }
            }
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon auto=new ImageIcon(getClass().getResource("/multimedia/Tractor.gif"));
        g.drawImage(auto.getImage(),x_inicial,y_inicial,anchoPersonaje,altoPersonaje,null);
    }
    
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            saltando=true;
        }
    }
    
    public Area getBounds(){
        Rectangle forma1=new Rectangle(x_inicial,y_inicial,5,62);
        carroceria=new Area(forma1);
        
        Ellipse2D forma2=new Ellipse2D.Double(x_inicial,y_inicial+28,48,48);
        llantaTrasera=new Area(forma2);
        
        Ellipse2D forma3=new Ellipse2D.Double(x_inicial+20,y_inicial+20,5,5);
        llantaDelantera=new Area(forma3);
        
        tractor=carroceria;
        tractor.add(carroceria);
        tractor.add(llantaTrasera);
        tractor.add(llantaDelantera);
        
        return tractor;
    }
}
