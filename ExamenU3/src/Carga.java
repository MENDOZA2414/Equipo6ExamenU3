import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carga extends JPanel {
	public Carga() {
		setBackground(Color.decode("#AEECDB"));
		setLayout(null);
		
		JLabel titulo = new JLabel("By Miguel Mendoza", JLabel.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 14));
		titulo.setForeground(Color.black);
		titulo.setSize(400, 35);
		titulo.setLocation(50,500);
		add(titulo);
		
		JPanel fondo = new JPanel();
		fondo.setBackground(Color.white);
		fondo.setSize(500, 300);
		fondo.setLocation(0,150);
		add(fondo);
		
		Imagen splash = new Imagen("Resources/intro.gif", 400,300,fondo);
	}
}