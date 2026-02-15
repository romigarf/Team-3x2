package actividad4.ui;
import actividad4.process.JuegoController;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        Object[] idiomas = {"Español", "English"};
        int eleccionIdioma = JOptionPane.showOptionDialog(null,
                "Selecciona idioma / Select Language",
                "Language",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                idiomas,
                idiomas[0]);

        if (eleccionIdioma == 1) {
            Language.setIdioma("EN");
        } else {
            Language.setIdioma("ES");
        }

        setTitle(Language.get("TITLE"));
        setSize(600,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        JuegoController controller = new JuegoController();

        Object[] opciones = {Language.get("MODE_1P"), Language.get("MODE_2P")};
        int respuesta = JOptionPane.showOptionDialog(null,
                Language.get("MODE_QUESTION"),
                Language.get("MODE_TITLE"),
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (respuesta == 0) {
            controller.setModoContraCPU(true);
        }

        JLabel label = new JLabel(controller.getMensajeInicial());
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setOpaque(true);
        label.setBackground(Color.black);
        label.setForeground(Color.white);

        PanelJuego panelJuego = new PanelJuego(controller, label);

        add(label, BorderLayout.NORTH);
        add(panelJuego, BorderLayout.CENTER);

        setVisible(true);
    }
}