import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana {
	
	private JFrame frame;
	private Imagen imagenes;
	private String rutaRecursos = "Resources/";
	public Ventana() {
		inicializar();
	}

	private void inicializar() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(0, 0, 800, 500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		panel.setBackground(Color.black);
		frame.getContentPane().add(panel);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imagenes = new Imagen(rutaRecursos + "fondo.png",panel);
		
		panel.repaint();
		panel.revalidate();
	}
}
