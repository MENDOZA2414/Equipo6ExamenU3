import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FormularioCrear extends JFrame{
    
	private static final int NUM_IMAGENES = 1;
	JPanel pantalla;
	
    public FormularioCrear(){

        setBounds(0, 0, 1280, 832);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Color.decode("#EBEBEB"));

        pantalla = new JPanel();
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
        
        agFoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 // Abrir un cuadro de dialogo para seleccionar las imagenes
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setMultiSelectionEnabled(true);
	            fileChooser.showOpenDialog(pantalla);
	            File[] selectedFiles = fileChooser.getSelectedFiles();

	            if (selectedFiles.length != NUM_IMAGENES) {
	                JOptionPane.showMessageDialog(pantalla, "Debe seleccionar " + NUM_IMAGENES + " imagenes.");
	                return;
	            }

	            try {
	                for (int i = 0; i < selectedFiles.length; i++) {
	                    // Cargar la imagen seleccionada
	                    BufferedImage image = ImageIO.read(selectedFiles[i]);

	                    // Guardar la imagen en disco
	                    File outputfile = new File("C:\\Users\\USER\\Pictures\\Nueva carpeta" + i + ".png");
	                    ImageIO.write(image, "png", outputfile);

	                    // Mostrar la imagen en la interfaz de usuario
	                    ImageIcon icon = new ImageIcon(image);
	                    JLabel label = new JLabel(icon);
	                    pantalla.add(label);
	                }

	                JOptionPane.showMessageDialog(pantalla, "La imagenen se han guardado exitosamente en disco y se han mostrado en la interfaz de usuario.");
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
			}
        	
        });

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
