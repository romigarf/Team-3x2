package actividad4.ui;
import actividad4.process.JuegoController;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        setTitle("Tic Tac Toe");
        setSize(600,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JLabel label = new JLabel("Turno de Jugador 1");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setOpaque(true);
        label.setBackground(Color.black);
        label.setForeground(Color.white);

        JuegoController controller = new JuegoController();
        PanelJuego panelJuego = new PanelJuego(controller, label);

        add(label, BorderLayout.NORTH);
        add(panelJuego, BorderLayout.CENTER);

        setVisible(true);
    }
}
