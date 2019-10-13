package mario_party;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import javazoom.jl.decoder.JavaLayerException;

public class Partida {
	private Jugador[] players;
	private int cantRondas;
	private Mapa map;
	private int dado;
	
	
	// -------Parte para los graficos-------------------------

	Coordenada posMouse = new Coordenada(0, 0);

	// esto es todo de prueBa
	private JFrame f = new JFrame("Ventana con Contexto Grafico");
	private MouseEventDemo panelmouse;

	// ------------------------------------------------------

	public Partida(Jugador[] players, int cant, int[][] map) throws FileNotFoundException, JavaLayerException {
		this.cantRondas = cant;
		this.map = new Mapa(map);
		this.players = players;

		panelmouse = new MouseEventDemo(map, players, posMouse);

		f.add(panelmouse);

		f.setBounds(300, 300, 800, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);// evita redimencionar la ventana
		f.setVisible(true);

		
	}

	public void tirarDado() {
		this.dado = (int) (Math.random() * 7) + 1;
		System.out.println("Salio el dado: " + this.dado);
		//this.dado = 1;
	}

	private static String getGanador(Jugador[] players) {
		int estrellas = -1;
		String ganador = "";

		for (int i = 0; i < players.length; i++) {
			if (players[i].getStars() > estrellas) {
				estrellas = players[i].getStars();
				ganador = players[i].getTag();
			}
		}

		return ganador;
	}

	private void crearEstrellas() {

		if (this.map.getMap()[1][4].isPathFlag())
			this.map.getMap()[1][4].setStar(true);
	}

	public String jugarPartida() throws JavaLayerException {

		
		int cantJugadores = this.players.length;
		this.crearEstrellas();

		for (int i = 0; i < this.cantRondas; i++) {
			for (int j = 0; j < cantJugadores; j++)
				jugarTurno(this.players[j]);

			// SALTAR EL MINIJUEGO
		}

		return getGanador(this.players);
	}

	public void jugarTurno(Jugador p) {
		this.tirarDado();
		moverJugador(p);
		// ESPACIO PARA EL POWERUP
	}

	public int elegirCamino(ArrayList<Coordenada> validos) {
		System.out.println("Elija su camino");
		int eleccion = 0;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < validos.size(); i++) {
			System.out.println("Presione " + i + " para Coordenada " + "(" + validos.get(i).getX() + ","
					+ validos.get(i).getY() + ")");
		}
		eleccion = scanner.nextInt();
		scanner.close();
		return eleccion;
	}

	public void moverJugador(Jugador p) {
		int x, y;
		int siguienteIndex;

		// System.out.println("La posicion actual es " + "(" + p.getPosActual().getX() +
		// "," + p.getPosActual().getY() + ")");

		for (int i = 0; i < dado; i++) {
			ArrayList<Coordenada> validos = new ArrayList<Coordenada>();
			x = p.getPosActual().getX();
			y = p.getPosActual().getY();
			if (map.getMap()[x - 1][y].isPathFlag())
				validos.add(new Coordenada(x - 1, y)); // Arriba
			if (map.getMap()[x + 1][y].isPathFlag())
				validos.add(new Coordenada(x + 1, y)); // Abajo
			if (map.getMap()[x][y - 1].isPathFlag())
				validos.add(new Coordenada(x, y - 1)); // Izquierda
			if (map.getMap()[x][y + 1].isPathFlag())
				validos.add(new Coordenada(x, y + 1)); // Derecha

			validos.remove(p.getPosAnterior());
			panelmouse.paint(panelmouse.getGraphics());
			if (validos.size() > 1) {

				panelmouse.setOpciones(validos);
				panelmouse.dibujarOpciones(panelmouse.getGraphics());
				//panelmouse.paint(panelmouse.getGraphics());

				// siguienteIndex = elegirCamino(validos);

				int asd = 0;
				System.out.println(validos.contains(posMouse));
				while (!validos.contains(posMouse)) {

					if (asd == 0)
						System.out.print("");
					posMouse = posMouse;
				}

				siguienteIndex = validos.indexOf(posMouse);
				panelmouse.setOpciones(null);
			}
			else
				siguienteIndex = 0;

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			p.Desplazarse(validos.get(siguienteIndex));

			panelmouse.paint(panelmouse.getGraphics());
			posMouse.setX(-1);
			posMouse.setY(-1);

			if (map.getMap()[p.getPosActual().getX()][p.getPosActual().getY()].isStar()) {
				p.increaseStars(1);
				map.getMap()[p.getPosActual().getX()][p.getPosActual().getY()].setStar(false);
				crearEstrellas();
			}

			if (map.getMap()[p.getPosActual().getX()][p.getPosActual().getY()].isExplosionFlag())
				p.decreaseStars(1);

		}
	}

}
