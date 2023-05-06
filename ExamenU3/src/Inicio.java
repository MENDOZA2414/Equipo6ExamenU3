import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class Inicio extends JFrame{
    
    public Inicio(){

        setLayout(new BorderLayout());
        setBounds(600, 150, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel arriba = new JPanel(new BorderLayout());
        arriba.setBackground(Color.decode("#26282B"));

        JLabel text = new JLabel("(IMAGEN)  BIENVENIDO A CHARLIE´S BURGER",JLabel.LEFT);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Inter", Font.ITALIC, 20));
        arriba.add(text,BorderLayout.WEST);

        JLabel user = new JLabel("admin (IMAGEN)",JLabel.RIGHT);
        user.setForeground(Color.WHITE);
        user.setFont(new Font("Inter", Font.ITALIC, 20));
        arriba.add(user,BorderLayout.EAST);

        JPanel centro = new JPanel(null);
        centro.setSize(getWidth(), getHeight());
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

        add(arriba,BorderLayout.NORTH);
        add(centro,BorderLayout.CENTER);
        setVisible(true);
    }

}
