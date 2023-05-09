import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FormularioCrear{
    
	private static final int NUM_IMAGENES = 1;

	JPanel panel;
	JPanel panelPrincipal;
    JTextArea descripcion;
    JScrollPane scrollPaneJArea;
    String nombreImagen;
    JButton aceptar;
    JTextField nombre;
    JTextField precio;
    JComboBox<String> categoria;
	public FormularioCrear(JPanel panel){

        this.panel = panel;
        panel.setLayout(null);
        panel.setBounds(242, 40, 500, 500);//MEDIDA DEL PANEL PRINCIPAL
        panel.setBackground(Color.decode("#C7C7C7"));

        JLabel tP = new JLabel("Crear Platillo",JLabel.CENTER);
        tP.setBounds(190, 20, 120, 30);
        tP.setForeground(Color.decode("#4D4D4D"));
        tP.setFont(new Font(" ",Font.BOLD, 18));
        panel.add(tP);

        nombre= new JTextField("Nombre del platillo");
        nombre.setBounds(107, 70, 285, 30);
        nombre.setForeground(Color.decode("#737373"));
        panel.add(nombre);

        scrollPaneJArea = new JScrollPane();
        scrollPaneJArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        descripcion = new JTextArea(" Agrega descripcion del platillo");
        descripcion.setBounds(107, 110, 285, 90);
        descripcion.setForeground(Color.decode("#737373"));

        scrollPaneJArea.setBounds(107, 110, 285, 90);
        scrollPaneJArea.getViewport().setBackground(Color.WHITE);
        scrollPaneJArea.getViewport().add(descripcion);
        panel.add(scrollPaneJArea);

        categoria = new JComboBox<>();
        categoria.setBounds(107, 210, 285, 30);
        categoria.setForeground(Color.decode("#737373"));
        categoria.addItem("Bebidas");
        categoria.addItem("Alimentos");
        categoria.addItem("Postres");
        panel.add(categoria);

        precio = new JTextField("");
        AbstractDocument doc = (AbstractDocument) precio.getDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string.matches("[0-9]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }
        
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text.matches("[0-9]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

        });

        precio.setBounds(107, 260, 285, 30);
        precio.setForeground(Color.decode("#737373"));
        panel.add(precio);

        JButton agFoto = new JButton("Agregar foto");
        agFoto.setBounds(107, 310, 285, 30);
        panel.add(agFoto);
        
        agFoto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 // Abrir un cuadro de dialogo para seleccionar las imagenes
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setMultiSelectionEnabled(true);
	            fileChooser.showOpenDialog(panel);
	            File[] selectedFiles = fileChooser.getSelectedFiles();

	            if (selectedFiles.length != NUM_IMAGENES) {
	                JOptionPane.showMessageDialog(panel, "Debe seleccionar " + NUM_IMAGENES + " imagenes.");
	                return;
	            }

	            try {
	                for (int i = 0; i < selectedFiles.length; i++) {
	                    // Cargar la imagen seleccionada
	                    BufferedImage image = ImageIO.read(selectedFiles[i]);
                        nombreImagen = selectedFiles[i].getName();

	                    // Guardar la imagen en disco
	                    File outputfile = new File("Resources/" + i + ".png");
	                    ImageIO.write(image, "png", outputfile);


	                    // Mostrar la imagen en la interfaz de usuario
	                    ImageIcon icon = new ImageIcon(image);
	                    JLabel label = new JLabel(icon);
	                    panel.add(label);
	                }

	                JOptionPane.showMessageDialog(panel, "La imagenen se han guardado exitosamente en disco y se han mostrado en la interfaz de usuario.");
	                
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
			}
        	
        });

        aceptar = new JButton("A C E P T A R");
        aceptar.setBounds(107, 360, 135, 30);
        aceptar.setOpaque(true);
        aceptar.setBackground(Color.green);

        panel.add(aceptar);

        JButton cancelar = new JButton("C A N C E L A R");
        cancelar.setBounds(257, 360, 135, 30);
        cancelar.setOpaque(true);
        cancelar.setBackground(Color.red);
        panel.add(cancelar);
        
        panel.repaint();
    }

	public JButton getAceptar() {
		return aceptar;
	}
	

	public void agregarPanel(JPanel panelPrincipal) {
    	this.panelPrincipal = panelPrincipal;
    	panelPrincipal.add(panel);
    	panelPrincipal.repaint();
        panel.repaint();
    }
    
    public void remover() {
    	panelPrincipal.remove(panel);
    	panelPrincipal.repaint();
    }

    public JPanel getPanel(){
        return panel;
    }

	public JTextArea getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(JTextArea descripcion) {
		this.descripcion = descripcion;
	}

	public JScrollPane getScrollPaneJArea() {
		return scrollPaneJArea;
	}

	public void setScrollPaneJArea(JScrollPane scrollPaneJArea) {
		this.scrollPaneJArea = scrollPaneJArea;
	}

	public String getNombreImagen() {
		return nombreImagen;
	}

	public void setNombreImagen(String nombreImagen) {
		this.nombreImagen = nombreImagen;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getPrecio() {
		return precio;
	}

	public void setPrecio(JTextField precio) {
		this.precio = precio;
	}

	public JComboBox<String> getCategoria() {
		return categoria;
	}

	public void setCategoria(JComboBox<String> categoria) {
		this.categoria = categoria;
	}
	

}
