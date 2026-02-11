package actividad4.ui;
import javax.swing.*;
import java.awt.*;


    public class Tablero {
        JPanel boardpanel = new JPanel();
        JButton[][] board = new JButton[3][3];

        public Tablero() {
            boardpanel.setLayout(new GridLayout(3, 3));
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    JButton tile = new JButton();
                    board[r][c] = tile;
                    boardpanel.add(tile);

                    tile.setFont(new Font("Arial", Font.BOLD, 80));
                    tile.setBackground(Color.WHITE);
                    tile.setFocusPainted(false);
                    tile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                }
            }
        }
        public JPanel getBoardPanel() {
            return boardpanel;
        }
    }

