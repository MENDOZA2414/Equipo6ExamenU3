import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
    private int x = 0;
    private int y= 30;

    private JPanel panel;
    private JPanel panelPrincipal;
    private int separacion_y = 230;
    private int separacion_x = 300;
    private int separacion_x2 = 50;
    private JButton ultimoPlatillo;
    private JButton platilloNuevo;
    private boolean masMenosScroll = false;
    JScrollPane scrollPane;
    
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
        
		
			for(int j = 0; j < cuantosPlatillos()+5; j++) {
				JButton platillo = new JButton();
				platillo.setSize(tamaño);
				platillo.setOpaque(false); 
			    platillo.setContentAreaFilled(false); 
			    platillo.setBorderPainted(false);
			    platillo.setFocusPainted(false);
			    
				ImageIcon icono = new ImageIcon("Resources/monster.png");
				Image imagen = icono.getImage().getScaledInstance(platillo.getWidth()-30, platillo.getHeight(), Image.SCALE_SMOOTH);
				icono = new ImageIcon(imagen);
				platillo.setIcon(icono);
				botones.add(platillo);
			
				if(j % 3 == 0) {
					platillo.setLocation(x += separacion_x2,y);
				}else {
					platillo.setLocation(x += separacion_x,y);
				}
				if(j % 5 == 0) {
					x = 0;
					y += separacion_y;
				}
				
				panel.add(platillo);
			}
		
		
	}
	
	public void agregarPanel(JPanel panelPrincipal) {
    	this.panelPrincipal = panelPrincipal;
    	panelPrincipal.add(scrollPane);
    	panelPrincipal.repaint();
    }
	
	public void agregarPlatillo(String ruta) {
		ultimoPlatillo = botones.get(botones.size()-1);
		platilloNuevo = new JButton();
		platilloNuevo.setSize(tamaño);
		platilloNuevo.setOpaque(false); 
		platilloNuevo.setContentAreaFilled(false); 
		platilloNuevo.setBorderPainted(false);
		platilloNuevo.setFocusPainted(false);
	    
		ImageIcon icono = new ImageIcon("Resources/" + ruta);
		Image imagen = icono.getImage().getScaledInstance(platilloNuevo.getWidth()-30, platilloNuevo.getHeight(), Image.SCALE_SMOOTH);
		icono = new ImageIcon(imagen);
		platilloNuevo.setIcon(icono);
		
		if(ultimoPlatillo.getX()==50) {
			
			platilloNuevo.setLocation(ultimoPlatillo.getX()+separacion_x,ultimoPlatillo.getY());
			masMenosScroll = false;
		}
		if(botones.size() % 3 == 0) {
			

			platilloNuevo.setLocation(50,ultimoPlatillo.getY()+ separacion_y);
			masMenosScroll = true;
		} 
	    if(ultimoPlatillo.getX()!=50 && botones.size() % 3 != 0){

			platilloNuevo.setLocation(ultimoPlatillo.getX()+separacion_x,ultimoPlatillo.getY());
			masMenosScroll = false;
	    }
		
		botones.add(platilloNuevo);
		ultimoPlatillo = botones.get(botones.size()-1);
		panel.add(platilloNuevo);
		panel.repaint();
	}
	
	public void eliminarPlatillo(JButton boton) {
		ultimoPlatillo = botones.get(botones.size()-1);
		JButton penultimoPlatillo = botones.get(botones.size()-2);
		
		if(penultimoPlatillo.getY()!=ultimoPlatillo.getY()) {
			masMenosScroll = true;
		}
		else{
			masMenosScroll = false;
		}
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

	
	public boolean isMasMenosScroll() {
		return masMenosScroll;
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
	
}
