import java.awt.Color;
import javax.swing.JFrame;

public class Ventana {
    private JFrame frame;

    public Ventana() {
        inicializar();
    }

    private void inicializar() {
        frame = new JFrame();
        frame.setBounds(0, 0, 1280, 832);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true); 
        
    }
}
