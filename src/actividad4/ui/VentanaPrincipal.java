package actividad4.ui;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal{
    JFrame frame = new JFrame("Tic Tac Toe");
    JLabel textlabel = new JLabel();
    JPanel textpanel= new JPanel();
    JPanel boardpanel = new JPanel();

    public VentanaPrincipal(){
        frame.setTitle("Tic Tac Toe");
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        textlabel.setBackground(Color.black);
        textlabel.setForeground(Color.white);
        textlabel.setFont(new Font("Arial", Font.BOLD, 50 ));
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setText("Tic Tac Toe");
        textpanel.setPreferredSize(new Dimension(500, 100));
        textlabel.setOpaque(true);
        textpanel.setLayout(new BorderLayout());
        textpanel.add(textlabel);
        frame.add(textpanel, BorderLayout.NORTH);
        frame.setVisible(true);

        boardpanel.setLayout(new GridLayout(3,3));
        boardpanel.setBackground(Color.black);
        frame.add(boardpanel);

        Tablero tablero = new Tablero();

        frame.add(tablero.getBoardPanel(), BorderLayout.CENTER);

        frame.setVisible(true);
    }

}