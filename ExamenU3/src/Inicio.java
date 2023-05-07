import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.*;

public class Inicio {
    JFrame frame;
    JPanel centro;
    private Dimension tamaño = new Dimension(330, 320);
    private int x = 190;
    private int y= 180;
    private boolean removido = false;
    private Font fuente = new Font("Inter", Font.ITALIC, 25);
    private JButton platillosboton,ordenesBoton;
    
    public Inicio(JFrame frame){

    	this.frame = frame;
        centro = new JPanel(null);
        centro.setBounds(0, 100, 1280, 732);
        centro.setBackground(Color.decode("#EBEBEB"));

        platillosboton = new JButton(null, new ImageIcon("Resources/platillo.png"));
        platillosboton.setSize(tamaño);
        platillosboton.setLocation(x,y);
        platillosboton.setBackground(Color.WHITE);
        platillosboton.setFocusPainted(false);
        centro.add(platillosboton);

        JLabel platillos = new JLabel("Platillos");
        platillos.setSize(200, 100);
        platillos.setLocation(x+110, y+310);
        platillos.setForeground(Color.decode("#4B4F55"));
        platillos.setFont(fuente);
        centro.add(platillos);

        ordenesBoton = new JButton(null, new ImageIcon("Resources/orden.png"));
        ordenesBoton.setSize(tamaño);
        ordenesBoton.setLocation(x*4,y);
        ordenesBoton.setBackground(Color.WHITE);
        ordenesBoton.setFocusPainted(false);
        centro.add(ordenesBoton);

        JLabel ordenes = new JLabel("Ordenes");
        ordenes.setSize(200, 100);
        ordenes.setLocation(x*5-80, y+310);
        ordenes.setForeground(Color.decode("#4B4F55"));
        ordenes.setFont(fuente);
        centro.add(ordenes);
        
        JLabel titulo = new JLabel("ELIGE UN MODULO ");
        titulo.setSize(550, 100);
        titulo.setLocation(x*2, y-150);
        titulo.setForeground(Color.decode("#26282B"));
        titulo.setFont(new Font("Inter", Font.PLAIN, 55));
        centro.add(titulo);
       
        frame.getContentPane().add(centro);        
    }
    
    public void remover() {
    	frame.remove(centro);
        centro.repaint();
      
    }
    
    public JPanel getCentro() {
		return centro;
	}

	public JButton getordenesBoton(){
        return ordenesBoton;
    }

    public JButton getplatillosboton(){
        return platillosboton;
    }
}
