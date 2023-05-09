import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicketConsultar {

	JPanel panel;
	JPanel panelPrincipal;
	
	public TicketConsultar(JPanel panel){
		this.panel = panel;
		panel.setBounds(550, 110, 400, 584);
		panel.setOpaque(true);
		panel.setBackground(Color.decode("#ffffff"));
		panel.setLayout(null);
		
		JLabel logo = new JLabel(new ImageIcon("Resources/ordenpequeño.png"));
		logo.setBounds(30, 10, 75, 75);
		panel.add(logo);
		
		JLabel orden = new JLabel("Orden #");
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
