import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class Ventana extends JFrame {
    JFrame frame = (this);
    Login login; 
    Inicio inicio;
    JButton logo;
    JPanel logoimg;
    ConsultarOrden consultarOrden;
    FormularioCrear formularioCrear;
    ConsultarPlatillos platillos;
    private int contador = 0;
    private JPanel panelPrincipal;
    private JLabel modulo = new JLabel("", JLabel.CENTER);
    private JPanel panelMenu = new JPanel();
    private JPanel panelBarra = new JPanel();
    JLabel mensaje;
	JButton exit;
	JLabel salir;
    private int y = 732;
    JPanel crearNuevoPlatillo;
    int aux;
   
    public boolean crear;
    
    public Ventana() {

        setBounds(0, 0, 1280, 832);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
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
        consultarOrden = new ConsultarOrden(frame);
        crearNuevoPlatillo = new JPanel();
        formularioCrear = new FormularioCrear(crearNuevoPlatillo);
     
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
                    consultarOrden.remover();
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
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        
        
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
					if (crearNuevoPlatillo.getParent() != null) {
						formularioCrear.remover();
					}
					if (panel.getParent() != null) {
			        	  platillos = new ConsultarPlatillos(panel);
					}
                    panelPrincipal.add(scrollPane);
                    panelPrincipal.revalidate();
                    panelPrincipal.repaint();

                    for(int i = 0; i < platillos.getBotones().size(); i++) {

                        JWindow window = new JWindow();
                        window.add(new JLabel("Contenido de la ventana emergente"));
                        window.setSize(300,300);
                        window.setBackground(Color.WHITE);

                        platillos.getBotones().get(i).addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                            	window.setLocationRelativeTo((JButton)e.getSource());
                            	window.setVisible(true);
                            	window.addMouseListener(new MouseAdapter() {
                                    public void mouseEntered(MouseEvent e) {
                                    	window.setVisible(true);
                                        //((JButton)(e.getSource())).setEnabled(false);
                                        panelPrincipal.repaint();
                                    }

                                    public void mouseExited(MouseEvent e) {
                                    	window.setVisible(false);
                                        panelPrincipal.repaint();
                                    }
                                });
                            }
                        });
                    }
                }
                else if(modulo.getText().equals("ORDENES")){
                    
                    System.out.println("Entro a panel de consultarordenes");
                    remove(panelPrincipal);       
                    consultarOrden.setTitleTxt("Consultar Orden");
                    consultarOrden.agregarPanel();
                    
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
      
        /*for(int i = 0; i < platillos.getBotones().size(); i++) {
        	platillos.getBotones().get(i).addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//platillos.eliminarPlatillo((JButton)e.getSource());
					if(platillos.isMasMenosScroll()) {
						panel.setPreferredSize(new Dimension(1180, y-=250));
					}
					scrollPane.revalidate();
				}
        		
        	});
		}
		*/ //ELIMINAR PLATILLOS
  
        botoncrear.addActionListener(new ActionListener() {

			@Override
			
			public void actionPerformed(ActionEvent e) {
				if(modulo.getText().equals("PLATILLOS")){
					removerPlatillos(scrollPane);
					formularioCrear.agregarPanel(panelPrincipal);
					formularioCrear.getPanel().repaint();
					formularioCrear.getPanel().revalidate();
					aux++;
					
					
				}
				else if(modulo.getText().equals("ORDENES")){	 
				}
			}
        });
        
       
        formularioCrear.getAceptar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nombrePlatillo = formularioCrear.getNombre().getText();   //Label.gettext
				String descripcion = ((JTextArea)formularioCrear.getScrollPaneJArea().getViewport().getView()).getText();   //Label.gettext
				String category = (String) formularioCrear.getCategoria().getSelectedItem(); //combobox.getSelectedItem
				String preci0 = formularioCrear.getPrecio().getText();
				String rutaImagen = formularioCrear.getNombreImagen();
                System.out.println(rutaImagen);
				
				FileWriter archivo = null;
                PrintWriter editor = null;
                String[] data;
				boolean encontrado = false;
				
				if(!nombrePlatillo.isEmpty()&&!descripcion.isEmpty()&&!category.isEmpty()&&!preci0.isEmpty()&&!rutaImagen.isEmpty()) {
					
					String renglon;

						try (BufferedReader BR = new BufferedReader(new FileReader("src/platillos.txt"))){
							
							while((renglon = BR.readLine()) != null ){

								data = renglon.split(",");

								if (data[0].equals(nombrePlatillo)){

									JOptionPane.showMessageDialog(null, "Platillo ya existente.","ERROR!", JOptionPane.ERROR_MESSAGE);
									encontrado = true;
								
								}
							}
						} catch (HeadlessException | IOException e1) {
							e1.printStackTrace();
						}
						
						if(!encontrado){
							
							crear = true;
							try {
								
								JOptionPane.showMessageDialog(null, "Platillo creado","Listo!", JOptionPane.INFORMATION_MESSAGE);
		                        archivo = new FileWriter("src/platillos.txt",true);
		                        editor = new PrintWriter(archivo);
		                        
		                        editor.print(nombrePlatillo + "," + descripcion + "," + category + "," + preci0 + "," + rutaImagen + "," + "\n");
		                        
		                        formularioCrear.getNombre().setText(null);
		                        ((JTextArea)formularioCrear.getScrollPaneJArea().getViewport().getView()).setText(null);
		        				//Emaildata.setText(null);
		                        formularioCrear.getPrecio().setText(null);
		                        formularioCrear.setNombreImagen(null);		            
		                        formularioCrear.setNombreImagen(null);
		        		
		                    } 
		                    catch (Exception e1) {
		                    	
		                        //System.err.println("Datos NO guardados");
		                    } finally{
		                        try {
		                            archivo.close();
		                        } catch (IOException e1) {
		                            System.err.println("ERROR");
		                        }
		                    }
						}
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Llene todos los campos.",null,JOptionPane.ERROR_MESSAGE);
				
                }
				
				System.out.println("valor crear " + crear);
				if(crear) {
					crear = false;
					//System.out.println("valor crear " + p.isCrear());
					platillos.agregarPlatillo();
					panelPrincipal.repaint();
					System.out.println("Crear");
					
					panelPrincipal.repaint();
					
					platillos.getPlatilloNuevo().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							scrollPane.revalidate();

							JWindow window = new JWindow();
	                        window.add(new JLabel("Contenido de la ventana emergente"));
	                        window.setSize(300,300);
	                        window.setBackground(Color.WHITE);

	                        window.setLocationRelativeTo((JButton)e.getSource());
	                        window.setVisible(true);
	                        window.addMouseListener(new MouseAdapter() {
	                            public void mouseEntered(MouseEvent e) {
	                                window.setVisible(true);
	                                panelPrincipal.repaint();
	                            }

	                            public void mouseExited(MouseEvent e) {
	                                window.setVisible(false);
	                                panelPrincipal.repaint();
	                            }
	                        });
	                     }

					});
					if(platillos.isMasMenosScroll()) {
						panel.setPreferredSize(new Dimension(1180, y+=250));
					}
					scrollPane.revalidate();
				}
				
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
					if (crearNuevoPlatillo.getParent() != null) {
						formularioCrear.remover();
					}
					System.out.println("Editar Platillo");
					removerPlatillos(scrollPane);
                    panelPrincipal.revalidate();
                    panelPrincipal.repaint();
                    //aqui entra el editar platillos
                }
                else if(modulo.getText().equals("ORDENES")){
                    remove(panelPrincipal);
                    consultarOrden.getTitleLabel().setText("Editar Orden");
                    consultarOrden.agregarPanel();
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
        repaint();
    	revalidate();
    }
    
    public void crearPlatillo() {
    	
    }
    
    public void removerPlatillos(JScrollPane scrollPane) {
    	panelPrincipal.remove(scrollPane);
    	panelPrincipal.repaint();
    }

}


