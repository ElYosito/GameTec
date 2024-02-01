
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class Juego extends JPanel {
    
    Auto auto=new Auto(this);
    Obstaculo obstaculo=new Obstaculo(this);
    Fondo fondo=new Fondo(this);
    
    public static boolean juegoFinalizado=false;
    public static boolean pierdeVida=false;
    public static int vidas=1;
    public static int puntos=0;
    public static int nivel=1;
    
    public Juego(){
        
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
            }
            
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    auto.keyPressed(e);
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e){
                
            }
        });
        setFocusable(true);
    }
    
    public void mover(){
        obstaculo.mover();
        auto.mover();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        dibujar(g2);
        dibujarPuntaje(g2);
    }
    
    public void dibujar(Graphics2D g){
        fondo.paint(g);
        auto.paint(g);
        obstaculo.paint(g);
        mover();
    }
    
    public void dibujarPuntaje(Graphics2D g){
        Graphics2D g1=g,g2=g;
        Font Score=new Font("Arial",Font.BOLD,30);
        g.setFont(Score);
        g.setColor(Color.blue);
        g1.drawString("Puntaje: "+puntos,1100,30);
        g1.drawString("Vidas: "+vidas,20,30);
        g1.drawString("Nivel: "+nivel,570,30);
        
        if(juegoFinalizado){
            g2.setColor(Color.yellow);
            g2.drawString("¡¡¡ Haz Perdido !!!",((float)getBounds().getCenterX()/2)+170,70);
        }
    }
        
        public void finJuego(){
            juegoFinalizado=true;
        }
        
        public void pierdeVida(){
            pierdeVida=true;
        }
        
    }
