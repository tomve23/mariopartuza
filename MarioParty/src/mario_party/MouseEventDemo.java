package mario_party;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JPanel;

public class MouseEventDemo extends JPanel implements MouseListener, ActionListener {

	private int alto = 50, ancho = 50;
	private int difx = 5, dify = 5;

	private Jugador jugador[];

	private Coordenada posMouse;

	int[][] map;

	List<Coordenada> opciones;

	public MouseEventDemo(int[][] map, Jugador jugador[], Coordenada pos) {

		this.jugador = jugador;
		this.map = map;
		posMouse = pos;

		addMouseListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("elejiste (" + e.getY() / 50 + ", " + e.getX() / 50 + ")");
		posMouse.setX(e.getY() / 50);
		posMouse.setY(e.getX() / 50);
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		this.PintarBorde(g);

		this.PintarPersonaje(g);

	}

	public void paint(Graphics g) {
		super.paint(g);

		this.PintarBorde(g);

		if (opciones != null && opciones.size() > 0)
			this.dibujarOpciones(g);

		this.PintarPersonaje(g);
	}

	public void PintarPersonaje(Graphics g) {

		for (int i = 0; i < jugador.length; i++) {
			g.setColor(Color.LIGHT_GRAY);

			g.fillRect(jugador[i].getPosActual().getY() * ancho, jugador[i].getPosActual().getX() * alto, ancho, alto);
			g.drawImage(jugador[i].getImagen().getImage(), jugador[i].getPosActual().getY() * ancho,
					jugador[i].getPosActual().getX() * alto, ancho, alto, null);

		}

	}

	public void PintarBorde(Graphics g) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

//				if (map[i][j] == 0) {
//					g.setColor(Color.orange);
//					g.fillRect(j * ancho, i * alto, ancho, alto);
//					g.setColor(Color.BLACK);
//					g.fillRect(j * ancho + difx, i * alto + dify, ancho - 2 * difx, alto - 2 * dify);
//				} else {
//					g.setColor(Color.LIGHT_GRAY);
//
//					g.fillRect(j * ancho, i * alto, ancho, alto);
//				}
				switch (map[i][j]) {

				case 1: // camino
					g.setColor(Color.LIGHT_GRAY);

					g.fillRect(j * ancho, i * alto, ancho, alto);
					break;
				case 2: // explosion
					g.setColor(Color.BLACK);
					g.fillRect(j * ancho, i * alto, ancho, alto);
					g.setColor(Color.red);
					g.fillRect(j * ancho + difx, i * alto + dify, ancho - 2 * difx, alto - 2 * dify);

					break;
				case 3: // teletransporte
					g.setColor(Color.BLACK);
					g.fillRect(j * ancho, i * alto, ancho, alto);
					g.setColor(Color.blue);
					g.fillRect(j * ancho + difx, i * alto + dify, ancho - 2 * difx, alto - 2 * dify);
					break;
				case 0: // bloque
					g.setColor(Color.orange);
					g.fillRect(j * ancho, i * alto, ancho, alto);
					g.setColor(Color.BLACK);
					g.fillRect(j * ancho + difx, i * alto + dify, ancho - 2 * difx, alto - 2 * dify);
					break;
				}

			}

		}

	}

	public void dibujarOpciones(Graphics g) {
		g.setColor(Color.GREEN);
		for (Coordenada i : opciones) {
			g.fillRect(i.getY() * ancho, i.getX() * alto, ancho, alto);
		}

	}

	public List<Coordenada> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Coordenada> opciones) {
		this.opciones = opciones;
	}

	// al pedo
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
