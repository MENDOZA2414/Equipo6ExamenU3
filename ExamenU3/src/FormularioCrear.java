import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormularioCrear extends JFrame{
    
    public FormularioCrear(){

        setBounds(0, 0, 1280, 832);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Color.decode("#EBEBEB"));

        JPanel pantalla = new JPanel();
        pantalla.setSize(300, 400);
        pantalla.setBackground(Color.decode("#DBDBDB"));
        pantalla.setLocation(470,170);
        pantalla.setLayout(null);
        add(pantalla);

        JLabel tP = new JLabel("Crear Platillo",JLabel.CENTER);
        tP.setBounds(90, 20, 120, 30);
        tP.setForeground(Color.decode("#737373"));
        tP.setFont(new Font(" ",Font.BOLD, 18));
        pantalla.add(tP);

        JTextField nombre = new JTextField("Nombre del platillo");
        nombre.setBounds(57, 70, 185, 30);
        nombre.setForeground(Color.decode("#737373"));
        pantalla.add(nombre);

        JTextArea des = new JTextArea(" Agrega descripcion del platillo");
        des.setBounds(57, 120, 185, 70);
        des.setForeground(Color.decode("#737373"));
        pantalla.add(des);

        JComboBox<String> categoria = new JComboBox<>();
        categoria.setBounds(57, 210, 185, 30);
        categoria.setForeground(Color.decode("#737373"));
        categoria.addItem("Bebidas");
        categoria.addItem("Alimentos");
        categoria.addItem("Postres");
        pantalla.add(categoria);

        JTextField precio = new JTextField("Precio");
        precio.setBounds(57, 260, 185, 30);
        precio.setForeground(Color.decode("#737373"));
        pantalla.add(precio);

        JButton agFoto = new JButton("Agregar foto");
        agFoto.setBounds(57, 310, 185, 30);
        pantalla.add(agFoto);

        JButton aceptar = new JButton("A C E P T A R");
        aceptar.setBounds(30, 360, 110, 30);
        aceptar.setOpaque(true);
        aceptar.setBackground(Color.green);
        pantalla.add(aceptar);

        JButton cancelar = new JButton("C A N C E L A R");
        cancelar.setBounds(157, 360, 117, 30);
        cancelar.setOpaque(true);
        cancelar.setBackground(Color.red);
        pantalla.add(cancelar);

        setVisible(true);
        
    }
}