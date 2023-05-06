import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
	private JTextField txtfUsuario ;
	private JPasswordField txtfContraseña;
	private Font fuente = new Font("Inter", Font.PLAIN, 16);
	private Color colorFuente = Color.decode("#666666");
	private Color colorFondo = Color.white;
	private Color colorBoton = Color.decode("#4B4F55");
	
	private JButton iniciar;
	
	public Login(JFrame frame) {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 832);
		new Imagen("fondoLogin2.png",1280 ,832 , panel);

        JPanel circulo = new JPanel();
        circulo.setBounds(516, 146, 250, 250);
        circulo.setOpaque(false);
		new Imagen("circulo.png",250,250, circulo);
		
		JPanel logo = new JPanel();
		logo.setBounds(525, 180, 230, 230);
		logo.setOpaque(false);
		new Imagen("logo1.png",180,180, logo);
		
		txtfUsuario = new JTextField("Usuario");
		txtfUsuario.setFont(fuente);
		txtfUsuario.setForeground(colorFuente);
		txtfUsuario.setBounds(458,410,358,49);
		txtfUsuario.setBackground(colorFondo);
		txtfUsuario.setBorder(BorderFactory.createLineBorder(colorFondo)); //Da color al borde
		
		txtfContraseña = new JPasswordField("********");
		txtfContraseña.setFont(fuente);
        txtfContraseña.setForeground(colorFuente);
        txtfContraseña.setBounds(458,495,358,48);
        txtfContraseña.setBackground(colorFondo);
        txtfContraseña.setBorder(BorderFactory.createLineBorder(colorFondo)); 
        
        iniciar = new JButton("Iniciar Sesion"); //Boton iniciar sesión
		iniciar.setFont(fuente);
		iniciar.setForeground(Color.WHITE);
		iniciar.setBounds(505,603,265,60);
		//iniciar.setBackground(colorBoton);
        iniciar.setContentAreaFilled(false); 
        iniciar.setBorderPainted(true);
        iniciar.setFocusPainted(false);

		iniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Iniciar Sesion");
			}
			
		});
       
		frame.add(txtfUsuario);
		frame.add(txtfContraseña);
		frame.add(iniciar);
		
		frame.getContentPane().add(logo);
		frame.getContentPane().add(circulo);
		frame.getContentPane().add(panel);
        
	}
}

