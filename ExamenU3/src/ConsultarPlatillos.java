import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ConsultarPlatillos {
	private ArrayList<JButton> botones = new ArrayList<>();
	private Dimension tamaño = new Dimension(300, 200);

    private JPanel panel;
    private int separacion_y = 230;
    private int separacion_x = 340;
    private JButton ultimoPlatillo;
    private JButton platilloNuevo;
    JScrollPane scrollPane;
    String[] fila = null;
    
	public ConsultarPlatillos() {
		platillos();
	}

	public void platillos() {
		panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1180, 732));
        scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(0, 0, 1000, 732);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        scrollPane.revalidate();
        scrollPane.setViewportView(panel);
        int x = 20;
        int y = 20;
        int buttonWidth = 300;
        int buttonHeight = 200;
        int columns = 3;
		int contador = 0;
		double numPlatillos = cuantosPlatillos();
		int y_Scroll = 732;
		
			for(int i = 0; i < cuantosPlatillos(); i++) {
				JButton platillo = new JButton(""+contador);
				platillo.setForeground(new Color(0, 0, 0, 0));
				contador++;
				platillo.setBounds(x, y, buttonWidth, buttonHeight);
				platillo.setOpaque(false); 
			    platillo.setContentAreaFilled(false); 
			    platillo.setBorderPainted(false);
			    platillo.setFocusPainted(false);
			    informacionPlatillos(i);
			    ImageIcon icono = new ImageIcon("Resources/"+fila[4]);
				Image imagen = icono.getImage().getScaledInstance(platillo.getWidth()-30, platillo.getHeight(), Image.SCALE_SMOOTH);
				icono = new ImageIcon(imagen);
				platillo.setIcon(icono);
				
				botones.add(platillo);
			    panel.add(platillo);
			    
			    if ((i + 1) % columns == 0) {
			        x = 20;
			        y += buttonHeight + 20;
			    } else {
			        x += buttonWidth + 20;
			    }   
			}
			if(numPlatillos >= 9) {
				numPlatillos -= 9;
			}
			else {
				numPlatillos = 0;
			}
			 panel.setPreferredSize(new Dimension(1180, y_Scroll + (int) Math.round(((numPlatillos/3)*300))));
			 scrollPane.revalidate();
				scrollPane.repaint();
	}
	
	public void agregarPanel(JPanel panelPrincipal) {
    	panelPrincipal.add(scrollPane);
    	scrollPane.revalidate();
		scrollPane.repaint();
    	panelPrincipal.repaint();
    }
	
	public void agregarPlatillo(String ruta) {
		ultimoPlatillo = botones.get(botones.size()-1);
		platilloNuevo = new JButton("" + (botones.size()));
		platilloNuevo.setForeground(new Color(0, 0, 0, 0));
		platilloNuevo.setSize(tamaño);
		platilloNuevo.setOpaque(false); 
		platilloNuevo.setContentAreaFilled(false); 
		platilloNuevo.setBorderPainted(false);
		platilloNuevo.setFocusPainted(false);
	    
		ImageIcon icono = new ImageIcon("Resources/" + ruta);
		Image imagen = icono.getImage().getScaledInstance(platilloNuevo.getWidth()-30, platilloNuevo.getHeight(), Image.SCALE_SMOOTH);
		icono = new ImageIcon(imagen);
		platilloNuevo.setIcon(icono);
		
		if(ultimoPlatillo.getX()==40) {
			
			platilloNuevo.setLocation(ultimoPlatillo.getX()+separacion_x,ultimoPlatillo.getY());
		
		}
		if(botones.size() % 3 == 0) {
			

			platilloNuevo.setLocation(40,ultimoPlatillo.getY()+ separacion_y);
			
		} 
	    if(ultimoPlatillo.getX()!=40 && botones.size() % 3 != 0){

			platilloNuevo.setLocation(ultimoPlatillo.getX()+separacion_x,ultimoPlatillo.getY());
			
	    }
		
		botones.add(platilloNuevo);
		ultimoPlatillo = botones.get(botones.size()-1);
		panel.add(platilloNuevo);
		panel.repaint();
		scrollPane.revalidate();
		scrollPane.repaint();
	}
	
	public void eliminarPlatillo(JButton boton) {
		ultimoPlatillo = botones.get(botones.size()-1);
		JButton penultimoPlatillo = botones.get(botones.size()-2);
		
		
		for(int i = botones.indexOf(boton); i < botones.size(); i++) {
			if(i != botones.size()-1){
				botones.get(i).setText(botones.get(i+1).getText());
			}
			panel.repaint();
		}
		
		panel.remove(botones.get(botones.size()-1));
		
		botones.remove(botones.get(botones.size()-1));
		ultimoPlatillo = botones.get(botones.size()-1);
		panel.repaint();
	}

	public JButton getPlatilloNuevo() {
		return platilloNuevo;
	}

	


	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	public int cuantosPlatillos(){
		int contador = 0;

        String platillos = "src/platillos.txt";

        try (BufferedReader lector = new BufferedReader(new FileReader(platillos))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

		return contador;
	}
	
	public String[] informacionPlatillos(int numPlatillo){
		int contador = -1;
        String platillos = "src/platillos.txt";
        
        try (BufferedReader lector = new BufferedReader(new FileReader(platillos))) {
            String linea;
           
            while ((linea = lector.readLine()) != null) {
                contador++;
                if (contador == numPlatillo) {
	                 fila = linea.split(",");  
	                 break;
	             }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

		return fila;
	}
	
	public String[] editarPlatillo(int numPlatillo,String nombre,String descripcion,String precio, String categoria,String rutaImagen){
		int contador = -1;
        String platillos = "src/platillos.txt";
        String[] data;

        try (BufferedReader lector = new BufferedReader(new FileReader(platillos))) {
            String linea;
           
            while ((linea = lector.readLine()) != null) {
                contador++;
                if (contador == numPlatillo) {
	                fila = linea.split(",");
					
					for (int i = 0; i < cuantosPlatillos(); i++) {
					
						informacionPlatillos(i);
						
						
						
	
					}
					
	                break;
	             }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

		return fila;
	}
}
