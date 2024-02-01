
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


public class Obstaculo {

    Juego JuegoTec;
    
    Area cabeza,cuerpo,vaca;
    
    int anchoObstaculo=250;
    int altoObstaculo=70;
    
    static int x_inicial=1300;
    static int y_inicial=240;
    
    static int x_auxiliar=-4;
    
    public Obstaculo(Juego JuegoTec){
        this.JuegoTec=JuegoTec;
    }
    
    public void mover(){
        if(x_inicial<=-100){
            JuegoTec.puntos++;
            x_inicial=1300;
            if(JuegoTec.puntos==3 | JuegoTec.puntos==6 | JuegoTec.puntos==9 | JuegoTec.puntos==12){
                x_auxiliar+=-2;
                JuegoTec.nivel++;
            }
        }else{
            if(colision()){
                if(JuegoTec.vidas==0){
                    JuegoTec.finJuego();
                }else{
                    JuegoTec.pierdeVida();
                }
            }else{
                x_inicial+=x_auxiliar;
            }
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon animal=new ImageIcon(getClass().getResource("/multimedia/vaca.gif"));
        g.drawImage(animal.getImage(),x_inicial,y_inicial,anchoObstaculo,altoObstaculo,null);
    }
    
    public Area getBounds(){
        Ellipse2D forma1=new Ellipse2D.Double(x_inicial,y_inicial,40,40);
        Rectangle forma2=new Rectangle(x_inicial+12,y_inicial+16,50,53);
        
        cabeza=new Area(forma1);
        cuerpo=new Area(forma2);
        
        vaca=cabeza;
        vaca.add(cabeza);
        vaca.add(cuerpo);
        
        return vaca;
    }
    
    public boolean colision(){
        Area areaA=new Area(JuegoTec.auto.getBounds());
        areaA.intersect(getBounds());
        
        return !areaA.isEmpty();
    }
}
