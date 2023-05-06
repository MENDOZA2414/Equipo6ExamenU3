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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //mostrarInicio();
        pantallaCarga();
        
        repaint();
        setVisible(true);
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
  					mostrarLogin();
  					panelCarga.setVisible(false);
                    repaint();
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
       
        JLabel platillos = new JLabel("PLATILLOS", JLabel.CENTER);
        platillos.setFont(new Font("Inter", Font.PLAIN, 20));
        platillos.setForeground(Color.white);
        platillos.setBounds(0, 0, 242, 70);
        platillos.setBackground(Color.decode("#9F9F9F"));
        platillos.setOpaque(true);
        
        //Boton consultar//
        JButton botonconsultar = new JButton("   Consultar");
        
        botonconsultar.setBounds(0, 100, 200, 50);
        botonconsultar.setFont(new Font("Inter", Font.PLAIN, 20));
        botonconsultar.setForeground(Color.decode("#6D6D6D"));
        botonconsultar.setOpaque(false); 
        botonconsultar.setContentAreaFilled(false); 
        botonconsultar.setBorderPainted(false);
        botonconsultar.setFocusPainted(false);
      
        botonconsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Consultar");
			}
        	
        });
        
        ImageIcon icono = new ImageIcon("Resources/lupa.png");
        botonconsultar.setIcon(icono);
        
        //boton crear//
        JButton botoncrear = new JButton("   Crear");
        
        botoncrear.setBounds(0, 180, 170, 50);
        botoncrear.setFont(new Font("Inter", Font.PLAIN, 20));
        botoncrear.setForeground(Color.decode("#6D6D6D"));
        botoncrear.setOpaque(false); 
        botoncrear.setContentAreaFilled(false); 
        botoncrear.setBorderPainted(false);
        botoncrear.setFocusPainted(false);
      
        botoncrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Crear");
			}
        	
        });
        
        ImageIcon iconocrear = new ImageIcon("Resources/crear.png");
        botoncrear.setIcon(iconocrear);

        //boton editar//
        JButton botoneditar = new JButton("   Editar");
        
        botoneditar.setBounds(0, 260, 170, 50);
        botoneditar.setFont(new Font("Inter", Font.PLAIN, 20));
        botoneditar.setForeground(Color.decode("#6D6D6D"));
        botoneditar.setOpaque(false); 
        botoneditar.setContentAreaFilled(false); 
        botoneditar.setBorderPainted(false);
        botoneditar.setFocusPainted(false);
      
        botoneditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Editar");
			}
        	
        });
        
        ImageIcon iconoeditar = new ImageIcon("Resources/editar.png");
        botoneditar.setIcon(iconoeditar);
       
        panel.add(platillos);
        panel.add(botonconsultar);
        panel.add(botoncrear);
        panel.add(botoneditar);
        add(panel);
        repaint();
    }
}
