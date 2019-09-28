package mario_party;

import java.util.ArrayList;

import jdk.nashorn.internal.parser.Scanner;

public class Partida {
	private Jugador[] players;
	private int cantRondas;
	private Mapa map;
	private int dado;
	
	public Partida(Jugador[] players, int cant, Mapa map){
		this.cantRondas= cant;
		this.map = map;
		this.players = players;
	}
	public void tirarDado () {
		//this.dado = (int) (Math.random() * 6) + 1;
		this.dado = 20;
	}
	
	public void jugarPartida () {
		int cantJugadores = this.players.length;
		for(int i=0; i<this.cantRondas ; i++) {
			for(int j=0; j<cantJugadores ; j++)
				jugarTurno(this.players[j]);
			//SALTAR EL MINIJUEGO
		}
	}
	
	public void jugarTurno(Jugador p) {
		this.tirarDado();
		moverJugador(p);
		//ESPACIO PARA EL POWERUP
	}
	
	
	public int elegirCamino( ArrayList<Coordenada> validos) {
		System.out.println("Elija su camino");
		int i;
		for(i=0;i<validos.size();i++) {
			System.out.println("Presione"+i+"para Coordenada"+validos.get(i).getX()+" "+validos.get(i).getY());
			//ACA VA A IR EL SCANNER
		}
		return i=0;
	}
	
	public void moverJugador(Jugador p) {
		int x,y;
		int siguienteIndex;
		
		for(int i=0;i<dado;i++) {
			ArrayList<Coordenada> validos = new ArrayList <Coordenada>();
			x = p.getPosActual().getX();
			y = p.getPosActual().getY();
			if(map.getMap()[x-1][y].isPathFlag())
				validos.add(new Coordenada(x-1,y));   //Arriba
			if(map.getMap()[x+1][y].isPathFlag())
				validos.add(new Coordenada(x+1,y));   //Abajo
			if(map.getMap()[x][y-1].isPathFlag())
				validos.add(new Coordenada(x,y-1));   //Izquierda
			if(map.getMap()[x][y+1].isPathFlag())
				validos.add(new Coordenada(x,y+1));   //Derecha
			
			validos.remove(p.getPosAnterior());
	
			if(validos.size()>1)
				siguienteIndex = elegirCamino(validos);
			else
				siguienteIndex = 0;
			p.Desplazarse(validos.get(siguienteIndex));
				
		}
		if(map.getMap()[p.getPosActual().getX()][p.getPosActual().getY()].isExplosionFlag())
			p.setStars(p.getStars()-2);
		
	}
	
	
	
	
}
