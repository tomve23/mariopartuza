package mario_party_graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import mario_party.Casillero;
import mario_party.Coordenada;
import mario_party.Jugador;
import mario_party.Partida;

public class JPanelGrafico extends JPanel {

	private int alto = 50, ancho = 50;
	private int difx = 5, dify = 5;

	private Jugador jugador[];

	int[][] map;
	
	List<Coordenada> opciones;
	static int increpersonaje = 0;
	Coordenada estrella;
	Casillero cas;
	AnimacionPersonaje hilo;

	public JPanelGrafico(int[][] map, Jugador jugador[], Coordenada posMouse) {

		this.jugador = jugador;
		this.map = map;
		hilo = new AnimacionPersonaje();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("elejiste (" + e.getY() / 50 + ", " + e.getX() / 50 + ")");
				posMouse.setX(e.getY() / 50);
				posMouse.setY(e.getX() / 50);

			};
		});
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		hilo.start();

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		 this.PintarBorde(g);

		if (opciones != null && opciones.size() > 0)
			this.dibujarOpciones(g);

		if(estrella != null && Partida.hayEstrella)
			this.dibujarEstrellas(g);

		this.PintarPersonaje(g);
		
		
		

	}

	public void paint(Graphics g) {
		super.paint(g);

		this.PintarBorde(g);

		if (opciones != null && opciones.size() > 0)
			this.dibujarOpciones(g);

		if(estrella != null && Partida.hayEstrella)
			this.dibujarEstrellas(g);
		
		this.PintarPersonaje(g);
	}

	public void PintarPersonaje(Graphics g) {
		for (int i = 0; i < jugador.length; i++) {

		
			int mx = (increpersonaje % 6) * 32;
			int my = (increpersonaje / 6) * 32;

			g.drawImage(jugador[i].getCharacter().getImg(), jugador[i].getPosActual().getY() * ancho,
					jugador[i].getPosActual().getX() * alto, (jugador[i].getPosActual().getY() * ancho) + 32,
					(jugador[i].getPosActual().getX() * alto) + 48, mx, my, mx + 32, my + 48, null);
		}
		repaint();

	}

	public void PintarBorde(Graphics g) {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {

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
		repaint();
	}

	public void dibujarOpciones(Graphics g) {
		g.setColor(Color.GREEN);
		for (Coordenada i : opciones) {
			g.fillRect(i.getY() * ancho, i.getX() * alto, ancho, alto);
		}
		repaint();

	}

	public List<Coordenada> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Coordenada> opciones) {
		this.opciones = opciones;
	}

	

	public void dibujarEstrellas(Graphics g) {

		/*

		
			int mx = (increestrella % 6) * 32;
			int my = (increestrella / 6) * 32;

			g.drawImage(cas.getImg(), estrella.getY() * ancho,
					estrella.getX() * alto, (estrella.getY()  * ancho) + 32,
					(estrella.getX() * alto) + 48, mx, my, mx + 32, my + 48, null);
		repaint();
		 */
		g.setColor(Color.YELLOW);
		g.fillRect(estrella.getY() * ancho, estrella.getX() * alto, ancho, alto);
		g.setColor(Color.YELLOW);
		g.fillRect(estrella.getY() * ancho + difx, estrella.getX() * alto + dify, ancho - 2 * difx, alto - 2 * dify);
		repaint();
	}

	public Coordenada getEstrella() {
		return estrella;
	}

	public void setEstrella(Coordenada estrella) {
		this.estrella = estrella;
	}

}
