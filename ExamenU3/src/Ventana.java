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
    private JPanel panelPrincipal;
    private JLabel modulo;
    
    public Ventana() {
        setBounds(0, 0, 1280, 832);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        //mostrarInicio();
        pantallaCarga();

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
  				if(contador == 1) {
  					mostrarMenu();
  					//mostrarLogin();
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
  	
  	public void mostrarMenu() {
  		agregarMenu();
  		agregarBarra();
  	}
  	
  	public void mostrarInicio() {
  		agregarBarra();
  		inicio = new Inicio(this);
  	}
    
    public void agregarBarra() {
    	JPanel panel = new JPanel();
    	panel.setLayout(null);
        panel.setBounds(0, 0, 1280, 100);
        panel.setBackground(Color.decode("#26282B"));
        
	    JLabel mensaje= new JLabel("BIENVENIDO ADMIN", JLabel.LEFT);
	    mensaje.setFont(new Font("Inter", Font.PLAIN, 18));
	    mensaje.setBounds(110, 35, 550, 50);
	    mensaje.setForeground(Color.white);
	    mensaje.setOpaque(false);
        
		
		JButton logo = new JButton(null, new ImageIcon("Resources/iconoInicio.png"));
		logo.setBounds(10,10, 80, 80);
		logo.setOpaque(true);
		logo.setContentAreaFilled(false); 
		logo.setBorderPainted(false);
		logo.setFocusPainted(false);
		panel.add(logo);
		
		JButton exit = new JButton(null, new ImageIcon("Resources/exit.png"));
		exit.setBounds(1200, 20, 60, 60);
		exit.setOpaque(true);
		exit.setContentAreaFilled(false); 
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		panel.add(exit);
		
        panel.add(mensaje);
        add(panel);
        repaint();
    }
    
    public void agregarMenu() {
    	JPanel panel = new JPanel();
    	panel.setLayout(null);
        panel.setBounds(0, 100, 242, 732);
        panel.setBackground(Color.white);
       
        modulo= new JLabel("PLATILLOS", JLabel.CENTER);
        modulo.setFont(new Font("Inter", Font.PLAIN, 25));
        modulo.setForeground(Color.white);
        modulo.setBounds(0, 0, 242, 80);
        modulo.setBackground(Color.decode("#9F9F9F"));
        modulo.setOpaque(true);
        
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

        panel.add(modulo);
        panel.add(botonconsultar);
        panel.add(botoncrear);
        panel.add(botoneditar);
        add(panel);
        repaint();
        
        panelPrincipal = new JPanel(null);
        panelPrincipal.setBounds(100, 100, 1180, 732);
        panelPrincipal.setBackground(Color.decode("#EBEBEB"));

        JPanel logo = new JPanel();
		logo.setBounds(360, 100, 630, 630);
		logo.setOpaque(false);
		new Imagen("logo.png", logo);
		
		panelPrincipal.add(logo);
        add(panelPrincipal);
    }
    
    public void actualizar(){
    	repaint();
    	revalidate();
    	
    }
}


