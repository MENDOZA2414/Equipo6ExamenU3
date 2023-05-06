import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carga extends JPanel {
	
	public Carga() {
		setBounds(0, 0, 1280, 832);
		setLayout(null);
		setBackground(Color.white);
		
		JLabel titulo = new JLabel("Loading", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 26));
		titulo.setForeground(Color.decode("#905453"));
		titulo.setBounds(560,460, 150, 50);
		add(titulo);
		
		JPanel fondo = new JPanel();
		fondo.setBounds(240, 50, 800, 600);
		fondo.setOpaque(false);
		add(fondo);
	
		repaint();
		Imagen splash = new Imagen("splash.gif", 800,600,fondo);
	}
}