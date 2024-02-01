
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.applet.Main;

public class Principal {

    public static int reiniciarJuego = -1;

    public static void main(String[] args) {
        ImageIcon icono = new ImageIcon(Principal.class.getResource("/multimedia/tec.png"));

        JFrame Ventana = new JFrame("GameTec");
        Ventana.setIconImage(icono.getImage());
        Juego JuegoTec = new Juego();
        Ventana.add(JuegoTec);
        Ventana.setSize(1300, 400);
        Ventana.setLocationRelativeTo(null);
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            if (JuegoTec.juegoFinalizado) {
                reiniciarJuego = JOptionPane.showConfirmDialog(null, "Haz perdido, ¿Quieres Jugar de Nuevo?", "Has Perdido", JOptionPane.YES_NO_OPTION);
                if (reiniciarJuego == 0) {
                    reiniciarValores();
                } else if (reiniciarJuego == 1) {
                    System.exit(0);
                }
            } else {
                JuegoTec.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (Juego.pierdeVida == true) {
                    ImageIcon iconoPersonalizado = new ImageIcon(Main.class.getResource("/multimedia/tec.png"));
                    JOptionPane.showMessageDialog(null, "Cuidado, Te ah alcanzado el correcaminos", "Alerta", JOptionPane.WARNING_MESSAGE, iconoPersonalizado);
                    Juego.pierdeVida = false;
                    Juego.vidas--;
                    Auto.y_inicial = 200;
                    Auto.saltando = false;
                    Obstaculo.x_inicial = 1300;
                }
            }
        }
    }

    public static void reiniciarValores() {
        Juego.juegoFinalizado = false;
        Obstaculo.x_auxiliar = -4;
        Juego.puntos = 0;
        Juego.nivel = 1;
        Juego.vidas = 1;
        reiniciarJuego = -1;
        Obstaculo.x_inicial = 1300;
    }
}
