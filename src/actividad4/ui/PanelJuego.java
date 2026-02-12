package actividad4.ui;
import actividad4.process.JuegoController;
import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {

    private JButton[][] botones = new JButton[3][3];
    private JuegoController controller;
    private JLabel label;

    public PanelJuego(JuegoController controller, JLabel label) {

        this.controller = controller;
        this.label = label;

        setLayout(new GridLayout(3,3));
        setBackground(Color.BLACK);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                JButton boton = new JButton();
                boton.setFont(new Font("Arial", Font.BOLD, 100));
                boton.setBackground(Color.BLACK);
                boton.setForeground(Color.WHITE);
                boton.setOpaque(true);
                boton.setFocusable(false);
                boton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

                int fila = i;
                int columna = j;

                boton.addActionListener(e -> {

                    if (!boton.getText().equals("")) return;

                    boton.setText(controller.getMarcaActual());

                    String mensaje = controller.jugar(fila, columna);

                    if (mensaje != null) {
                        label.setText(mensaje);
                    }
                });

                botones[i][j] = boton;
                add(boton);
            }
        }
    }
}
