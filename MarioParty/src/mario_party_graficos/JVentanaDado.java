package mario_party_graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mario_party.Partida;

public class JVentanaDado extends JFrame {

	private JPanel panel;
	private JLabel titulo;
	private JButton boton;

	public JVentanaDado() {

		iniciar_componentes();
		setBounds(1100, 150, 150, 150);
		this.setUndecorated(true);
		setResizable(false);// evita redimencionar la ventana
	}

	private void iniciar_componentes() {

		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);

		colocarEtiqueta();

		colocarBoton();
	}

	private void colocarEtiqueta() {
		
		titulo = new JLabel("Tire el dado",SwingConstants.CENTER);
		titulo.setBounds(-25, 20, 200, 50);
		panel.add(titulo);
		
	}
	
	private void colocarBoton() {
		boton = new JButton("Tirar");
		boton.setBounds(35, 80, 80, 40);
		panel.add(boton);
		
		clickEnBoton();
		
	}
	
	private void clickEnBoton() {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Partida.dado =(int) (Math.random() * 6) + 1;
				
		};
		});
	}
}
