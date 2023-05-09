import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class FormularioEditar {
	
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
	
	public FormularioEditar(JPanel panel){
		
		this.panel = panel;
		panel.setLayout(null);
        panel.setBounds(250, 60, 500, 430);       //MEDIDA DEL PANEL PRINCIPAL
        panel.setBackground(Color.decode("#C7C7C7"));

        JLabel tP = new JLabel("Editar Platillo",JLabel.CENTER);
        tP.setBounds(150, 20, 120, 30);
        tP.setForeground(Color.decode("#4D4D4D"));
        tP.setFont(new Font(" ",Font.BOLD, 18));
        panel.add(tP);

        nombre = new JTextField("Nombre del platillo");
        nombre.setBounds(57, 70, 285, 30);
        nombre.setForeground(Color.decode("#737373"));
        panel.add(nombre);

        scrollPaneJArea = new JScrollPane();
        scrollPaneJArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        descripcion = new JTextArea(" Agrega descripcion del platillo");
        descripcion.setBounds(57, 110, 285, 90);
        descripcion.setForeground(Color.decode("#737373"));

        scrollPaneJArea.setBounds(57, 110, 285, 90);
        scrollPaneJArea.getViewport().setBackground(Color.WHITE);
        scrollPaneJArea.getViewport().add(descripcion);
        panel.add(scrollPaneJArea);

        categoria = new JComboBox<>();
        categoria.setBounds(57, 210, 285, 30);
        categoria.setForeground(Color.decode("#737373"));
        categoria.addItem("Bebidas");
        categoria.addItem("Alimentos");
        categoria.addItem("Postres");
        panel.add(categoria);

        precio = new JTextField("$");
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

        precio.setBounds(57, 260, 285, 30);
        precio.setForeground(Color.decode("#737373"));
        panel.add(precio);

        JButton agFoto = new JButton("Agregar foto");
        agFoto.setBounds(57, 310, 285, 30);
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
	                    nombreImagen =  selectedFiles[i].getName();
	                    
	                    // Guardar la imagen en disco
	                    File outputfile = new File("C:\\Users\\USER\\Pictures\\Nueva carpeta" + i + ".png");
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
        aceptar.setBounds(80, 360, 110, 30);
        aceptar.setOpaque(true);
        aceptar.setBackground(Color.green);
        panel.add(aceptar);

        JButton cancelar = new JButton("C A N C E L A R");
        cancelar.setBounds(205, 360, 117, 30);
        cancelar.setOpaque(true);
        cancelar.setBackground(Color.red);
        panel.add(cancelar);
        
        JButton eliminar = new JButton(null, new ImageIcon("Resources/borrar.png"));
        eliminar.setBounds(350, 120, 109, 109);
        eliminar.setOpaque(true);
        eliminar.setBackground(Color.decode("#C7C7C7"));
        eliminar.setBorderPainted(false);
        panel.add(eliminar);
        
        eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Agregar borrar platillo");
				
			}
        	
        });
        
        JLabel borrar = new JLabel("Eliminar platillo",JLabel.CENTER);
        borrar.setBounds(350, 225, 120, 30);
        borrar.setForeground(Color.decode("#737373"));
        borrar.setFont(new Font(" ",Font.BOLD, 16));
        panel.add(borrar);

        panel.repaint();
        listenerTxtf();
    }
	
	
	public void listenerTxtf() {
		nombre.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(nombre.getText().equals("Nombre del platillo")){
					nombre.setText(null);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(nombre.getText().equals("")) {
					nombre.setText("Nombre del platillo");					
				}
			}
		});
		
		descripcion.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(descripcion.getText().equals(" Agrega descripcion del platillo")){
					descripcion.setText(null);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(descripcion.getText().equals("")) {
					descripcion.setText(" Agrega descripcion del platillo");					
				}
			}
		});
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
