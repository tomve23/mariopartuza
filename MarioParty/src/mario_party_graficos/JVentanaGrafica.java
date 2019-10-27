package mario_party_graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JVentanaGrafica extends JFrame {

	public JVentanaGrafica(JPanelGrafico panel) {

		this.getContentPane().add(panel);

		setBounds(250, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);// evita redimencionar la ventana

	}
}