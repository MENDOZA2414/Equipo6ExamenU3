import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Inicio {
    JFrame frame;
    JPanel centro;
    public Inicio(JFrame frame){

    	this.frame = frame;
        centro = new JPanel(null);
        centro.setBounds(0, 100, 1280, 732);
        centro.setBackground(Color.decode("#F1F4FB"));

        JButton platillosboton = new JButton(null, new ImageIcon("src\\platillos.png"));
        platillosboton.setSize(200, 220);
        platillosboton.setLocation(140,120);
        centro.add(platillosboton);

        JLabel platillos = new JLabel("Platillos");
        platillos.setSize(200, 100);
        platillos.setLocation(200, 320);
        platillos.setForeground(Color.decode("#4B4F55"));
        platillos.setFont(new Font("Inter", Font.ITALIC, 20));
        centro.add(platillos);

        JButton platillosordenes = new JButton(null, new ImageIcon("src\\Ordenes.png"));
        platillosordenes.setSize(230, 220);
        platillosordenes.setLocation(435,120);
        centro.add(platillosordenes);

        JLabel ordenes = new JLabel("Ordenes");
        ordenes.setSize(200, 100);
        ordenes.setLocation(510, 320);
        ordenes.setForeground(Color.decode("#4B4F55"));
        ordenes.setFont(new Font("Inter", Font.ITALIC, 20));
        centro.add(ordenes);

        frame.getContentPane().add(centro);
        
    }
    
    public void remover() {
    	frame.remove(centro);
    }

}
