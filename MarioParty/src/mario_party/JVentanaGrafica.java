package mario_party;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class JVentanaGrafica extends JFrame {

	public JVentanaGrafica(JPanelGrafico panel) {

		this.getContentPane().add(panel);

		setBounds(250, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);// evita redimencionar la ventana

		
	}
}
