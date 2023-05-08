import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Ventana extends JFrame {
    Login login; 
    Inicio inicio;
    JButton logo;
    JPanel logoimg;
    ConsultarOrden consultarOrden;
    private int contador = 0;
    private JPanel panelPrincipal;
    private JLabel modulo = new JLabel("", JLabel.CENTER);
    private JPanel panelMenu = new JPanel();
    private JPanel panelBarra = new JPanel();
    JLabel mensaje ;
	JButton exit;
	JLabel salir;
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
  		login.agregar();
        login.getIniciarSesion();
        login.iniciar.addActionListener(new ActionListener() {

            @Override
			public void actionPerformed(ActionEvent e) {

                String Username = login.txtfUsuario.getText();
                String password = String.valueOf(login.txtfContraseña.getPassword());
                String[] data;

                try{

                    BufferedReader BR = new BufferedReader(new FileReader("src/users.txt"));
                    String renglon;
                    boolean validacion = false;

                    while((renglon = BR.readLine()) != null ){

                        data = renglon.split(",");

                        if (data[0].equals(Username) && data[1].equals(password)) {
                        	
                            Username = data[0];
                            password = data[1];

                            JOptionPane.showMessageDialog(null, "Bienvenido "+ Username,"INGRESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);
                            login.remover();
                            mostrarInicio();
                            repaint();
                            
                            validacion = true;

                        }
                    }
                    if (validacion == false){
                        JOptionPane.showMessageDialog(null, "El usuario y contraseña no coindicen","Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }catch(Exception f){
                	System.err.println("No se encontro archivo");
                }
			}
            
        });
	}

    public void mostrarConsultarOrdenes() {
        consultarOrden = new ConsultarOrden(panelPrincipal);
        repaint();
    }

  	
  	public void mostrarInicio() {
  		inicio = new Inicio(this);
  		agregarBarra();
  		logo.setVisible(false);
        exit.setVisible(true);
        salir.setVisible(true);
        mensaje.setVisible(true);
        inicio.getplatillosboton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                inicio.remover();
                modulo.setText("PLATILLOS");
                agregarMenu();
                logo.setVisible(true);
                exit.setVisible(false);
                salir.setVisible(false);
            	mensaje.setVisible(false);
            	panelBarra.repaint();
            }
            
        });

        inicio.getordenesBoton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                inicio.remover();
                modulo.setText("ORDENES");
                agregarMenu();
                logo.setVisible(true);
                exit.setVisible(false);
                salir.setVisible(false);
                mensaje.setVisible(false);
            	remove(mensaje);
            	panelBarra.repaint();
            }
        });

        repaint();
  	}
    
    public void agregarBarra() {

    	panelBarra.setLayout(null);
        panelBarra.setBounds(0, 0, 1280, 100);
        panelBarra.setBackground(Color.decode("#26282B"));
        
        mensaje = new JLabel("Bienvenido a Burguer Daily fresh " + login.txtfUsuario.getText(), JLabel.LEFT);
	    mensaje.setFont(new Font("Inter", Font.PLAIN, 18));
	    mensaje.setBounds(20, 35, 550, 50);
	    mensaje.setForeground(Color.white);
	    mensaje.setOpaque(false);
        
	
	    	logo = new JButton(null, new ImageIcon("Resources/iconoInicio.png"));
			logo.setBounds(10,10, 80, 80);
			logo.setContentAreaFilled(false); 
			logo.setBorderPainted(false);
			logo.setFocusPainted(false);
		
			
			
				logo.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent arg0) {

		                remove(panelMenu);
		                remove(panelPrincipal);
		            	logo.setVisible(false);
		                mostrarInicio();
		                repaint();

		            }
		            
		        });
				
				
		exit = new JButton(null, new ImageIcon("Resources/exit.png"));
		exit.setBounds(1200, 10, 60, 60);
		exit.setOpaque(true);
		exit.setContentAreaFilled(false); 
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
           
            	remove(panelBarra);
            	
            	if(panelMenu.getComponentCount() != 0) {
            		remove(panelMenu);
            	}
                exit.setVisible(false);
                salir.setVisible(false);
                mensaje.setVisible(false);
            	inicio.remover();
                mostrarLogin();
                repaint();
            }
            
        });

        
        salir = new JLabel("Salir", JLabel.LEFT);
        salir.setFont(new Font("Inter", Font.PLAIN, 18));
        salir.setBounds(1208, 55, 550, 50);
        salir.setForeground(Color.white);
        salir.setOpaque(false);

        panelBarra.add(logo);
	    panelBarra.add(exit);
	    panelBarra.add(mensaje);
	    panelBarra.add(salir);
        add(panelBarra);
        repaint();
		
    }
    
    public void agregarMenu() {
    	
    	//panelMenu = new JPanel();
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

        panelPrincipal.setBackground(Color.decode("#EBEBEB"));	

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

				if(modulo.getText().equals("PLATILLOS")){
                    panelPrincipal.add(scrollPane);
                    panelPrincipal.revalidate();
                    panelPrincipal.repaint();
                    System.out.println("Entro a panel de consultar platillos");
                }
                else if(modulo.getText().equals("ORDENES")){
                    System.out.println("Entro a panel de consultarordenes");
                    mostrarConsultarOrdenes();
                }

                repaint();
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
      
        for(int i = 0; i < platillos.getBotones().size(); i++) {
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
				if(modulo.getText().equals("PLATILLOS")){
                    //aqui entra el editar platillos
                }
                else if(modulo.getText().equals("ORDENES")){
                    consultarOrden.getTitleTxt().setText("Editar Orden");
                    mostrarConsultarOrdenes();
                }
                
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


