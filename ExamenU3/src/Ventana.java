import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.FlowLayout;


public class Ventana extends JFrame {
    Login login; 
    Inicio inicio;
    JButton logo;
    JPanel logoimg;
    private int contador = 0;
    private JPanel panelPrincipal;
    private JLabel modulo = new JLabel("", JLabel.CENTER);
    private JPanel panelMenu;
    private JPanel panelbarra = new JPanel();
    private int y = 732;
    
    
    public Ventana() {

        setBounds(0, 0, 1280, 832);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        
        pantallaCarga();
        
        actualizar();
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
        login.getIniciarSesion().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                login.remover();
                mostrarInicio();
            }
            
        });
	}
  	
  	public void mostrarInicio() {
  		agregarBarra();
  		inicio = new Inicio(this);
        inicio.getplatillosboton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                logo.setEnabled(true);
                inicio.remover();
                modulo.setText("PLATILLOS");
                agregarMenu();
                agregarBarra();
                
            }
            
        });

        inicio.getordenesBoton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                logo.setEnabled(true);
                inicio.remover();
                modulo.setText("ORDENES");
                agregarMenu();
                agregarBarra();
        
            }
            
        });

        repaint();
  	}
    
    public void agregarBarra() {

        panelbarra.setLayout(null);
        panelbarra.setBounds(0, 0, 1280, 100);
        panelbarra.setBackground(Color.decode("#26282B"));
        
	    JLabel mensaje = new JLabel("BIENVENIDO ADMIN", JLabel.LEFT);
	    mensaje.setFont(new Font("Inter", Font.PLAIN, 18));
	    mensaje.setBounds(110, 35, 550, 50);
	    mensaje.setForeground(Color.white);
	    mensaje.setOpaque(false);
        
		logo = new JButton(null, new ImageIcon("Resources/iconoInicio.png"));
		logo.setBounds(10,10, 80, 80);
		logo.setOpaque(true);
		logo.setContentAreaFilled(false); 
		logo.setBorderPainted(false);
		logo.setFocusPainted(false);
        logo.setEnabled(false);
        logo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                remove(panelMenu);
                remove(panelPrincipal);
                mostrarInicio();
                repaint();

            }
            
        });
        
		panelbarra.add(logo);
		
		JButton exit = new JButton(null, new ImageIcon("Resources/exit.png"));
		exit.setBounds(1200, 10, 60, 60);
		exit.setOpaque(true);
		exit.setContentAreaFilled(false); 
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                /*remove(panelPrincipal);
                remove(panelMenu);
                remove(panelbarra);
                mostrarLogin();
                repaint();*/

                
                remove(panelPrincipal);
                remove(panelMenu);
                remove(panelbarra);
                
                repaint();
            }
            
        });

        
        JLabel Salir = new JLabel("Salir", JLabel.LEFT);
	    Salir.setFont(new Font("Inter", Font.PLAIN, 18));
	    Salir.setBounds(1208, 55, 550, 50);
	    Salir.setForeground(Color.white);
	    Salir.setOpaque(false);
		
		panelbarra.add(exit);
        panelbarra.add(mensaje);
        panelbarra.add(Salir);
        add(panelbarra);
        repaint();
        
    }
    int i;
    public void agregarMenu() {

    	panelMenu = new JPanel();
    	panelMenu.setLayout(null);
        panelMenu.setBounds(0, 100, 242, 732);
        panelMenu.setBackground(Color.white);
       
        modulo.setFont(new Font("Inter", Font.PLAIN, 25));
        modulo.setForeground(Color.white);
        modulo.setBounds(0, 0, 242, 80);
        modulo.setBackground(Color.decode("#9F9F9F"));
        modulo.setOpaque(true);
        
        panelPrincipal = new JPanel(null);
        panelPrincipal.setBounds(242, 100, 1180, 732);	

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1180, y));

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 1000, 732);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

       
        ConsultarPlatillos platillos = new ConsultarPlatillos(panel);
        scrollPane.revalidate();
        scrollPane.setViewportView(panel);

        panelPrincipal.add(scrollPane);

        panelPrincipal.setBackground(Color.decode("#EBEBEB"));
        
        panelPrincipal.repaint();	

        //Boton consultar
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
      
        for(i = 0; i < platillos.getBotones().size(); i++) {
        	platillos.getBotones().get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					platillos.eliminarPlatillo((JButton)e.getSource());
					if(platillos.isMasMenosScroll()) {
						panel.setPreferredSize(new Dimension(1180, y-=250));
					}
					scrollPane.revalidate();
				}
        		
        	});
		}
		
        
        botoncrear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Crear");
				platillos.agregarPlatillo();
				platillos.getPlatilloNuevo().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						platillos.eliminarPlatillo((JButton)e.getSource());
						if(platillos.isMasMenosScroll()) {
							panel.setPreferredSize(new Dimension(1180, y-=250));
						}
						scrollPane.revalidate();
					}
					
				});
				if(platillos.isMasMenosScroll()) {
					panel.setPreferredSize(new Dimension(1180, y+=250));
				}
				scrollPane.revalidate();
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

        panelMenu.add(modulo);
        panelMenu.add(botonconsultar);
        panelMenu.add(botoncrear);
        panelMenu.add(botoneditar);
        
        
        
        logoimg = new JPanel();
		logoimg.setBounds(220, 60, 630, 630);
		logoimg.setOpaque(false);
		new Imagen("logo.png", logoimg);
		
		//panelPrincipal.add(logoimg); LOGO DE FONDO
		add(panelPrincipal);
        add(panelMenu);
        actualizar();
    }
    
    public void actualizar(){
    	repaint();
    	revalidate();
    }

}


