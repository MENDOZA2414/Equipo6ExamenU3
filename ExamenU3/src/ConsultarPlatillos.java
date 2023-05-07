import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class ConsultarPlatillos {
	private ArrayList<JButton> botones = new ArrayList<>();
	private Dimension tamaño = new Dimension(50, 50);
    private int x = 30;
    private int y= 40;
    private JPanel panelPrincipal;
    private int separacion = 100;
    private JButton ultimoPlatillo;
    
	public ConsultarPlatillos(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
		platillos();
	}
	int contador =0;
	public void platillos() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				JButton platillo = new JButton(""+contador++);
				botones.add(platillo);
				platillo.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						eliminarPlatillo((JButton)e.getSource());
					}
					
				});
			
				platillo.setSize(tamaño);
				platillo.setLocation(x += separacion,y);
				
				if(j == 2) {
					x = 30;
					y += separacion;
				}
				panelPrincipal.add(platillo);
			}
		}
	}
	
	public void agregarPlatillo() {
		ultimoPlatillo = botones.get(botones.size()-1);
		JButton platilloNuevo = new JButton("" + contador++);
		platilloNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarPlatillo(platilloNuevo);
			}
			
		});
	
		platilloNuevo.setSize(tamaño);
		
		if(ultimoPlatillo.getX()==130) {
			System.out.println("Ultimo 1: " + ultimoPlatillo.getText());
			platilloNuevo.setLocation(ultimoPlatillo.getX()+separacion,ultimoPlatillo.getY());
		}
		if(botones.size() % 3 == 0) {
			System.out.println("Ultimo 2: " + ultimoPlatillo.getText());

			platilloNuevo.setLocation(130,ultimoPlatillo.getY()+ separacion);
		} 
	    if(ultimoPlatillo.getX()!=130 && botones.size() % 3 != 0){
			System.out.println("Ultimo 3: " + ultimoPlatillo.getText());
			platilloNuevo.setLocation(ultimoPlatillo.getX()+separacion,ultimoPlatillo.getY());
		}
		
		botones.add(platilloNuevo);
		ultimoPlatillo = botones.get(botones.size()-1);
		panelPrincipal.add(platilloNuevo);
		panelPrincipal.repaint();
	}
	
	public void eliminarPlatillo(JButton boton) {
		
		for(int i = botones.indexOf(boton); i < botones.size(); i++) {
			if(i != botones.size()-1){
				botones.get(i).setText(botones.get(i+1).getText());
			}
			panelPrincipal.repaint();
		}
		
		panelPrincipal.remove(botones.get(botones.size()-1));
		
		botones.remove(botones.get(botones.size()-1));
		ultimoPlatillo = botones.get(botones.size()-1);
		panelPrincipal.repaint();
	}
	
}
