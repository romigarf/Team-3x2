package actividad4.ui;

import actividad4.process.JuegoController;
import javax.swing.*;
import java.awt.*;
/**
 * Ventana principal del juego Tres en Raya.
 * Muestra los diálogos iniciales de selección de idioma y modo de juego,
 * y contiene el tablero y el mensaje de estado.
 */
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        this(null);
    }

    public VentanaPrincipal(Language idioma) {

        if (idioma == null) {
            Object[] idiomas = {"Español", "English"};
            int eleccionIdioma = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona idioma / Select Language",
                    "Language",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    idiomas,
                    idiomas[0]
            );

            if (eleccionIdioma == 1) idioma = new Eng();
            else idioma = new Esp();
        }

        setTitle("Tic Tac Toe");
        setSize(600, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JuegoController controller = new JuegoController(idioma);

        Object[] opciones = {idioma.MODE_1P, idioma.MODE_2P};
        int respuesta = JOptionPane.showOptionDialog(
                null,
                idioma.MODE_QUESTION,
                idioma.MODE_TITLE,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (respuesta == 0) controller.setModoContraCPU(true);

        JLabel label = new JLabel(controller.getMensajeInicial());
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setOpaque(true);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.WHITE);

        PanelJuego panelJuego = new PanelJuego(controller, label, idioma);

        add(label, BorderLayout.NORTH);
        add(panelJuego, BorderLayout.CENTER);

        setVisible(true);
    }
}
