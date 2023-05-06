import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {
    Login login; 
    Inicio inicio;
    private int contador = 0;
    
    public Ventana() {
        setBounds(0, 0, 1280, 832);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        pantallaCarga();
    }
    public void pantallaCarga() {
    	Carga carga = new Carga();
	    add(carga);
	    Tiempo(carga);
	  
    }
    
  	public void Tiempo(JPanel panelCarga) {
  		Timer timer = new Timer();
  		TimerTask tarea = new TimerTask() {
  			@Override
  			public void run() {
  				contador++;
  				if(contador == 3) {
  					//mostrarLogin();
  					mostrarInicio();
  					panelCarga.setVisible(false);
  					timer.cancel();	
  				}
  				System.out.println(contador);
  			}

			
  		};
  		timer.schedule(tarea,0,1000);
  	}
  	
  	public void mostrarLogin() {
  		login = new Login(this);
	}
  	
  	public void mostrarInicio() {
  		 agregarMenu();
         agregarBarra();
  	}
    
    public void agregarBarra() {
    	JPanel panel = new JPanel();
    	panel.setLayout(null);
        panel.setBounds(0, 0, 1280, 100);
        panel.setBackground(Color.decode("#26282B"));
        add(panel);
        repaint();
    }
    
    public void agregarMenu() {
    	JPanel panel = new JPanel();
    	panel.setLayout(null);
        panel.setBounds(0, 100, 242, 732);
        panel.setBackground(Color.white);
       
        JLabel modulo = new JLabel("PLATILLOS", JLabel.CENTER);
        modulo.setFont(new Font("Inter", Font.PLAIN, 20));
        modulo.setForeground(Color.white);
        modulo.setBounds(0, 0, 242, 70);
        modulo.setBackground(Color.decode("#9F9F9F"));
        modulo.setOpaque(true);
        
        JButton boton = new JButton("  Consultar");
        
        boton.setBounds(0, 80, 200, 70);
        boton.setFont(new Font("Inter", Font.PLAIN, 20));
        boton.setForeground(Color.decode("#6D6D6D"));
        boton.setOpaque(false); 
        boton.setContentAreaFilled(false); 
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
      
        boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("a");
			}
        	
        });
        
        ImageIcon icono = new ImageIcon("Resources/lupa.png");
        boton.setIcon(icono);
       
        panel.add(modulo);
        panel.add(boton);
        add(panel);
        repaint();
    }
}
