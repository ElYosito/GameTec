
import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class Fondo {

    Juego JuegoTec;
    
    int anchoFondo=1300;
    int altoFondo=400;
    
    int x1=1300;
    int y1=400;
    
    int x2=0;
    int y2=0;
    
    public Fondo(Juego JuegoTec) {
        this.JuegoTec = JuegoTec;
    }
    

    
    public void paint(Graphics2D g){
        ImageIcon imagenFondo=new ImageIcon(getClass().getResource("/multimedia/Fondo.jpg"));
        g.drawImage(imagenFondo.getImage(),x1,y1,anchoFondo,altoFondo,null);
        g.drawImage(imagenFondo.getImage(),x2,y2,anchoFondo,altoFondo,null);
    }
}
