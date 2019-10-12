package mario_party;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
	private Jugador[] players;
	private int cantRondas;
	private Mapa map;
	private int dado;

	public Partida(Jugador[] players, int cant, Mapa map) {
		this.cantRondas = cant;
		this.map = map;
		this.players = players;
	}

	public void tirarDado() {
		// this.dado = (int) (Math.random() * 5) + 1;
		this.dado = 1;
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
		
		if(this.map.getMap()[1][4].isPathFlag())
			this.map.getMap()[1][4].setStar(true);
	}
	

	public String jugarPartida() {
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
		int eleccion = 0 ;
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < validos.size(); i++) {
			System.out.println("Presione " + i + " para Coordenada " + "("+ validos.get(i).getX() + "," + validos.get(i).getY()+")");
		}
		eleccion = scanner.nextInt();
		scanner.close();
		return eleccion;
	}

	public void moverJugador(Jugador p) {
		int x, y;
		int siguienteIndex;

		//System.out.println("La posicion actual es " + "(" +  p.getPosActual().getX() + "," + p.getPosActual().getY() + ")");
		
		
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

			if (validos.size() > 1)
				siguienteIndex = elegirCamino(validos);
			else
				siguienteIndex = 0;
			
			p.Desplazarse(validos.get(siguienteIndex));
			
			if(map.getMap()[p.getPosActual().getX()][p.getPosActual().getY()].isStar()) {
				p.increaseStars(1);
				map.getMap()[p.getPosActual().getX()][p.getPosActual().getY()].setStar(false);
				crearEstrellas();
			}
		
			if (map.getMap()[p.getPosActual().getX()][p.getPosActual().getY()].isExplosionFlag())
				p.decreaseStars(1);
			
		}
		}

}
