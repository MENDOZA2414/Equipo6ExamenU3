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
    JScrollPane scrollPane;
    String nombreImagen;
    JButton aceptar;
    boolean crear;
    
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

        JTextField nombre = new JTextField("Nombre del platillo");
        nombre.setBounds(107, 70, 285, 30);
        nombre.setForeground(Color.decode("#737373"));
        panel.add(nombre);

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        descripcion = new JTextArea(" Agrega descripcion del platillo");
        descripcion.setBounds(107, 110, 285, 90);
        descripcion.setForeground(Color.decode("#737373"));

        scrollPane.setBounds(107, 110, 285, 90);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.getViewport().add(descripcion);
        panel.add(scrollPane);

        JComboBox<String> categoria = new JComboBox<>();
        categoria.setBounds(107, 210, 285, 30);
        categoria.setForeground(Color.decode("#737373"));
        categoria.addItem("Bebidas");
        categoria.addItem("Alimentos");
        categoria.addItem("Postres");
        panel.add(categoria);

        JTextField precio = new JTextField("");
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

        aceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				String nombrePlatillo = nombre.getText();   //Label.gettext
				String descripcion = ((JTextArea)scrollPane.getViewport().getView()).getText();   //Label.gettext
				String category = (String) categoria.getSelectedItem(); //combobox.getSelectedItem
				String preci0 = precio.getText();
				String rutaImagen = nombreImagen;
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
									crear = false;
								}
							}
						} catch (HeadlessException | IOException e1) {
							e1.printStackTrace();
						}
						
						if(!encontrado){
							try {
								
								JOptionPane.showMessageDialog(null, "Platillo creado","Listo!", JOptionPane.INFORMATION_MESSAGE);
		                        archivo = new FileWriter("src/platillos.txt",true);
		                        editor = new PrintWriter(archivo);

		                        editor.print(nombrePlatillo + "," + descripcion + "," + category + "," + preci0 + "," + rutaImagen + "," + "\n");
		                        
		                        nombre.setText(null);
		                        ((JTextArea)scrollPane.getViewport().getView()).setText(null);
		        				//Emaildata.setText(null);
		        				precio.setText(null);
		        				nombreImagen = null;		                        
		        				
		                    } 
		                    catch (Exception e1) {
		                    	crear = true;
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
					crear = false;
                }
			}
        	
        });

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

	public boolean isCrear() {
		return crear;
	}
    
}
