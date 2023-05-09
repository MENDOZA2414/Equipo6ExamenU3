import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicketEditar {

	JPanel panel;
	JPanel panelPrincipal;
	
	public TicketEditar(JPanel panel) {
		this.panel = panel;
		panel.setBounds(785, 0, 380, 700);
		panel.setOpaque(true);
		panel.setBackground(Color.decode("#ebebeb"));
		panel.setLayout(null);
		
		JPanel paneldentro = new JPanel();
		paneldentro.setBounds(10, 30, 360, 650);
		paneldentro.setOpaque(true);
		paneldentro.setBackground(Color.decode("#ffffff"));
		paneldentro.setLayout(null);
		panel.add(paneldentro);
		
		JLabel logo = new JLabel(new ImageIcon("Resources/ordenpequeño.png"));
		logo.setBounds(30, 10, 75, 75);
		paneldentro.add(logo);
		
		JLabel orden = new JLabel("Orden #");
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
		
		 panel.repaint();
	}
	
	public void agregarPanel(JPanel panelPrincipal) {
    	this.panelPrincipal = panelPrincipal;
    	panelPrincipal.add(panel);
    	panelPrincipal.repaint();
        panel.repaint();
    }
    
    public void remover() {
    	panelPrincipal.remove(panel);
    	panelPrincipal.repaint();
    }

    public JPanel getPanel(){
        return panel;
    }
}
