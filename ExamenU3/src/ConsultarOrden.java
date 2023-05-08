import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import java.awt.Color;
import java.awt.Font;

public class ConsultarOrden {
    
    JFrame frame;
    JPanel panel;
    JLabel consultarOrden;
    JTextField ordenConsultada;
    JButton btnBuscar;
    
    public ConsultarOrden(JFrame frame){

        this.frame = frame;
        panel = new JPanel(null);
        panel.setBounds(242, 100, 1180, 732);       //MEDIDA DEL PANEL PRINCIPAL
        panel.setBackground(Color.decode("#EBEBEB"));
        
        consultarOrden = new JLabel("Consultar Orden");
        consultarOrden.setSize(450, 100);
        consultarOrden.setLocation(300,40);
        consultarOrden.setForeground(Color.decode("#26282B"));
        consultarOrden.setFont(new Font("Inter", Font.PLAIN, 55));
        panel.add(consultarOrden);

        ordenConsultada = new JTextField();
        ordenConsultada.setFont(new Font("Inter", Font.PLAIN, 16));
        ordenConsultada.setForeground(Color.decode("#26282B"));
        ordenConsultada.setBounds(250,150, 450 , 50);
        // setLocation //   setSize   //
        //    x,y     // ancho,largo //
        AbstractDocument doc = (AbstractDocument) ordenConsultada.getDocument();

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

        btnBuscar = new JButton(null, new ImageIcon("Resources/lupa.png"));
        btnBuscar.setBounds(700, 150, 50, 50);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setBackground(Color.decode("#EBEBEB"));

        JLabel imagen = new JLabel(new ImageIcon("Resources/orden.png"));
        imagen.setBounds(410, 300, 250, 200);
        
        panel.add(btnBuscar);
        panel.add(ordenConsultada);
        panel.add(imagen);
        frame.getContentPane().add(panel);
    }

    public void remover() {
    	frame.remove(panel);
        panel.repaint();
      
    }

    public JButton getButtonBuscar(){
        return btnBuscar;
    }

    public String getTitleTxt(){
        return consultarOrden.getText();
    }

    public JLabel getTitleLabel(){
        return consultarOrden;
    }

    public void setTitleTxt(String xd) {
        consultarOrden.setText(xd);
    }

    public String getOrdenConsultada(){
        return ordenConsultada.getText();
    }

    public JPanel getPanel(){
        return panel;
    }

}
