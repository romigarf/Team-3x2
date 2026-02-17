package actividad4.ui;

import actividad4.process.JuegoController;
import javax.swing.*;
import java.awt.*;
/**
 * Panel gráfico que muestra el tablero 3x3 del juego Tres en Raya y maneja las interacciones del usuario.
 */
public class PanelJuego extends JPanel {

    private JButton[][] botones = new JButton[3][3];
    private JuegoController controller;
    private JLabel label;
    private Language idioma;

    public PanelJuego(JuegoController controller, JLabel label, Language idioma) {
        this.controller = controller;
        this.label = label;
        this.idioma = idioma;
        setLayout(new GridLayout(3, 3));
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
                    if (!boton.getText().equals("") || controller.estaTerminado()) return;
                    boton.setText(controller.getMarcaActual());
                    String mensaje = controller.jugar(fila, columna);
                    actualizarEstado(mensaje);
                    if (controller.esModoContraCPU() && !controller.estaTerminado()) realizarMovimientoCPU();
                });

                botones[i][j] = boton;
                add(boton);
            }
        }
    }

    private void realizarMovimientoCPU() {
        int[] coord = controller.obtenerMovimientoCPU();
        if (coord != null) {
            botones[coord[0]][coord[1]].setText(controller.getMarcaActual());
            String mensaje = controller.jugar(coord[0], coord[1]);
            actualizarEstado(mensaje);
        }
    }

    private void actualizarEstado(String mensaje) {
        if (mensaje != null) {
            label.setText(mensaje);
            if (mensaje.startsWith(idioma.GANADOR)) {
                resaltarGanador(controller.obtenerLineaGanadora());
                mostrarDialogoReinicio();
            }
            if (mensaje.equals(idioma.EMPATE)) mostrarDialogoReinicio();
        }
    }

    private void resaltarGanador(int[][] coordenadas) {
        if (coordenadas != null) {
            for (int[] pos : coordenadas) {
                botones[pos[0]][pos[1]].setBackground(Color.GREEN);
                botones[pos[0]][pos[1]].setForeground(Color.BLACK);
            }
        }
    }

    private void mostrarDialogoReinicio() {
        int respuesta = JOptionPane.showConfirmDialog(
                this,
                idioma.PREGUNTA_REINICIO,
                idioma.REINICIAR,
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            Window ventana = SwingUtilities.getWindowAncestor(this);
            ventana.dispose();
            new VentanaPrincipal(); // vuelve a inicio para elegir idioma y modo
        } else {
            System.exit(0);
        }
    }
}
