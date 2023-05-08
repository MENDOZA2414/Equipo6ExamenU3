import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ticket extends JFrame{

	String archivo = "datos.csv";
	File file = new File("src/ordenes.txt");
	public String[] valores;
	
	public Ticket() {
		setBounds(242, 100, 1180, 732);
		setLayout(null);
		setVisible(true);
		
		try {
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter(",");
			
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				valores = linea.split(",");
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//ConsultarTicket();
		//TicketCrear();
		EditarTicket();
		
		JPanel panelBarra = new JPanel();
		panelBarra.setLayout(null);
        panelBarra.setBounds(0, 0, 1280, 100);
        panelBarra.setBackground(Color.decode("#26282B"));
        add(panelBarra);
        

        
	}
	
	public void ConsultarTicket() {
		JPanel panel = new JPanel();
		panel.setBounds(550, 110, 400, 584);
		panel.setOpaque(true);
		panel.setBackground(Color.decode("#ffffff"));
		panel.setLayout(null);
		add(panel);
		
		JLabel logo = new JLabel(new ImageIcon("Resources/ordenpequeño.png"));
		logo.setBounds(30, 10, 75, 75);
		panel.add(logo);
		
		JLabel orden = new JLabel("Orden #" + valores[0]);
		orden.setBounds(130, 20, 200, 60);
		orden.setFont(new Font("",Font.BOLD,20));
		panel.add(orden);
		
		JLabel linea = new JLabel("_________________________________");
		linea.setBounds(20, 50, 500, 60);
		linea.setFont(new Font("",Font.BOLD,20));
		panel.add(linea);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(30, 100,70, 20);
		nombre.setFont(new Font("",Font.BOLD,18));;
		panel.add(nombre);
		
		JLabel cantidad = new JLabel("Cantidad");
		cantidad.setBounds(165, 100,80, 20);
		cantidad.setFont(new Font("",Font.BOLD,18));
		panel.add(cantidad);
		
		JLabel total = new JLabel("Total");
		total.setBounds(315, 100,45, 20);
		total.setFont(new Font("",Font.BOLD,18));
		panel.add(total);
		
		JLabel cliente = new JLabel("Nombre del Cliente");
		cliente.setBounds(20, 495,170, 20);
		cliente.setFont(new Font("",Font.BOLD,18));
		panel.add(cliente);
		
		JButton nombreC = new JButton("Daniel");
		nombreC.setBounds(20, 515,270, 30);
		nombreC.setEnabled(false);
		nombreC.setFont(new Font("",Font.BOLD,15));
		nombreC.setBorderPainted(false);
		panel.add(nombreC);
		
		JPanel abajo = new JPanel();
		abajo.setBounds(0, 553, 400, 30);
		abajo.setOpaque(true);
		abajo.setBackground(Color.decode("#cecece"));
		abajo.setLayout(null);
		panel.add(abajo);
		
		JLabel totalDinero = new JLabel("Total");
		totalDinero.setBounds(30, 5,50, 30);
		totalDinero.setFont(new Font("",Font.BOLD,18));
		abajo.add(totalDinero);
		
		JLabel dinero = new JLabel("$1000.00");
		dinero.setBounds(300, 5,120, 30);
		dinero.setFont(new Font("",Font.BOLD,18));
		abajo.add(dinero);
		
		repaint();
	}
	
	public void TicketCrear() {
		
		JPanel panel = new JPanel();
		panel.setBounds(785, 0, 380, 700);
		panel.setOpaque(true);
		panel.setBackground(Color.decode("#ebebeb"));
		panel.setLayout(null);
		add(panel);
		
		JPanel paneldentro = new JPanel();
		paneldentro.setBounds(10, 30, 360, 650);
		paneldentro.setOpaque(true);
		paneldentro.setBackground(Color.decode("#ffffff"));
		paneldentro.setLayout(null);
		panel.add(paneldentro);
		
		JLabel logo = new JLabel(new ImageIcon("Resources/ordenpequeño.png"));
		logo.setBounds(30, 10, 75, 75);
		paneldentro.add(logo);
		
		JLabel orden = new JLabel("Orden #"  + valores[0]);
		orden.setBounds(130, 20, 200, 60);
		orden.setFont(new Font("",Font.BOLD,38));
		paneldentro.add(orden);
		
		JLabel linea = new JLabel("_________________________________");
		linea.setBounds(20, 50, 500, 60);
		linea.setFont(new Font("",Font.BOLD,20));
		paneldentro.add(linea);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(25, 100,70, 20);
		nombre.setFont(new Font("",Font.BOLD,18));;
		paneldentro.add(nombre);
		
		JLabel cantidad = new JLabel("Cantidad");
		cantidad.setBounds(155, 100,80, 20);
		cantidad.setFont(new Font("",Font.BOLD,18));
		paneldentro.add(cantidad);
		
		JLabel total = new JLabel("Total");
		total.setBounds(290, 100,45, 20);
		total.setFont(new Font("",Font.BOLD,18));
		paneldentro.add(total);
		
		JTextField cliente = new JTextField("Nombre del Cliente");
		cliente.setBounds(55, 490,250, 30);
		cliente.setFont(new Font("",Font.BOLD,15));
		cliente.setForeground(Color.decode("#737373"));
		paneldentro.add(cliente);
		
		
		JPanel abajo = new JPanel();
		abajo.setBounds(30, 535, 300, 30);
		abajo.setOpaque(true);
		abajo.setBackground(Color.decode("#cecece"));
		abajo.setLayout(null);
		paneldentro.add(abajo);
		
		JLabel totalDinero = new JLabel("Total");
		totalDinero.setBounds(25, 5,50, 30);
		totalDinero.setFont(new Font("",Font.BOLD,18));
		totalDinero.setForeground(Color.decode("#555555"));
		abajo.add(totalDinero);
		
		JLabel dinero = new JLabel("$1000.00");
		dinero.setBounds(200, 5,120, 30);
		dinero.setFont(new Font("",Font.BOLD,18));
		dinero.setForeground(Color.decode("#555555"));
		abajo.add(dinero);
		
		JButton confirmar = new JButton("C O N F I R M A R");
		confirmar.setBounds(100, 580, 170, 40);
		confirmar.setOpaque(true);
		confirmar.setBackground(Color.decode("#99ff99"));
		confirmar.setBorderPainted(false);
		paneldentro.add(confirmar);
		
		repaint();
		
	}
	
	public void EditarTicket() {
		JPanel panel = new JPanel();
		panel.setBounds(785, 0, 380, 700);
		panel.setOpaque(true);
		panel.setBackground(Color.decode("#ebebeb"));
		panel.setLayout(null);
		add(panel);
		
		JPanel paneldentro = new JPanel();
		paneldentro.setBounds(10, 30, 360, 650);
		paneldentro.setOpaque(true);
		paneldentro.setBackground(Color.decode("#ffffff"));
		paneldentro.setLayout(null);
		panel.add(paneldentro);
		
		JLabel logo = new JLabel(new ImageIcon("Resources/ordenpequeño.png"));
		logo.setBounds(30, 10, 75, 75);
		paneldentro.add(logo);
		
		JLabel orden = new JLabel("Orden #"  + valores[0]);
		orden.setBounds(130, 20, 200, 60);
		orden.setFont(new Font("",Font.BOLD,38));
		paneldentro.add(orden);
		
		JLabel linea = new JLabel("_________________________________");
		linea.setBounds(20, 50, 500, 60);
		linea.setFont(new Font("",Font.BOLD,20));
		paneldentro.add(linea);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(25, 100,70, 20);
		nombre.setFont(new Font("",Font.BOLD,18));;
		paneldentro.add(nombre);
		
		JLabel cantidad = new JLabel("Cantidad");
		cantidad.setBounds(155, 100,80, 20);
		cantidad.setFont(new Font("",Font.BOLD,18));
		paneldentro.add(cantidad);
		
		JLabel total = new JLabel("Total");
		total.setBounds(290, 100,45, 20);
		total.setFont(new Font("",Font.BOLD,18));
		paneldentro.add(total);
		
		JTextField cliente = new JTextField("Nombre del Cliente");
		cliente.setBounds(55, 400,250, 30);
		cliente.setFont(new Font("",Font.BOLD,15));
		cliente.setForeground(Color.decode("#737373"));
		paneldentro.add(cliente);
		
		
		JPanel abajo = new JPanel();
		abajo.setBounds(30, 450, 300, 30);
		abajo.setOpaque(true);
		abajo.setBackground(Color.decode("#cecece"));
		abajo.setLayout(null);
		paneldentro.add(abajo);
		
		JLabel totalDinero = new JLabel("Total");
		totalDinero.setBounds(25, 5,50, 30);
		totalDinero.setFont(new Font("",Font.BOLD,18));
		totalDinero.setForeground(Color.decode("#555555"));
		abajo.add(totalDinero);
		
		JLabel dinero = new JLabel("$1000.00");
		dinero.setBounds(200, 5,120, 30);
		dinero.setFont(new Font("",Font.BOLD,18));
		dinero.setForeground(Color.decode("#555555"));
		abajo.add(dinero);
		
		JButton confirmar = new JButton("C O N F I R M A R");
		confirmar.setBounds(15, 510, 150, 40);
		confirmar.setOpaque(true);
		confirmar.setBackground(Color.decode("#99ff99"));
		confirmar.setBorderPainted(false);
		paneldentro.add(confirmar);
		
		JButton cancelar = new JButton("C A N C E L A R");
		cancelar.setBounds(195, 510, 150, 40);
		cancelar.setOpaque(true);
		cancelar.setBackground(Color.decode("#FF270D"));
		cancelar.setBorderPainted(false);
		paneldentro.add(cancelar);
		
		JButton borrar = new JButton(null, new ImageIcon("Resources/borrarpequeño.png"));
		borrar.setBounds(150, 560, 60, 60);
		borrar.setOpaque(true);
		borrar.setBackground(Color.decode("#ffffff"));
		borrar.setBorderPainted(false);
		paneldentro.add(borrar);
		
		JLabel borrarT = new JLabel("Eliminar",JLabel.CENTER);
		borrarT.setBounds(131, 595,100, 60);
		borrarT.setFont(new Font("",Font.BOLD,12));
		borrarT.setForeground(Color.decode("#555555"));
		paneldentro.add(borrarT);
		
		 repaint();
	}

}
