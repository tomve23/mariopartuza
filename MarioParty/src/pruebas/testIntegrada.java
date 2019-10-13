package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import mario_party.Coordenada;
import mario_party.Jugador;
import mario_party.Mapa;
import mario_party.MapasDisponibles;
import mario_party.Partida;
import mario_party.Personaje;
import mario_party.PowerUp;

@SuppressWarnings("deprecation")

class testIntegrada {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	void ganador() throws FileNotFoundException {
//		Jugador player = new Jugador();
//		Jugador arrayPlayers[] = new Jugador[1];
//		PowerUp powa = new PowerUp("Flechazo Gorgonita", 10, 4);
//		Personaje archer = new Personaje("Archer", "GORGONIA", "Soltero", powa);
//		player.setCharacter(archer);
//		player.setTag("El Arquero");
//		player.setPosActual(new Coordenada(1, 1));
//		player.setPosAnterior(new Coordenada(1, 1));
//		player.increaseStars(1);
//		arrayPlayers[0] = player;
//		Mapa map = new Mapa();
//		File pf = new File("C:\\Users\\laboratorios\\Desktop\\MarioParty\\src\\Archivos\\seedsMapa.txt");
//		map.seedMapa(pf);
//
//		Partida part = new Partida(arrayPlayers, 10, map);
//		Assert.assertEquals("El Arquero", part.jugarPartida());
		
//		Jugador arrayPlayers[] = new Jugador[2];
//		
//		Personaje fito = new Personaje("Pepe", "El Conurbano Bonaerense", "Viudo", new PowerUp("Autodestruccion", 15, 3), "..//Archivos//peon.png");
//		
//		arrayPlayers[0] = new Jugador(MapasDisponibles.Mapa4_inicio1, fito);
//		arrayPlayers[1] = new Jugador(MapasDisponibles.Mapa4_inicio2, fito);
//
//		int[][] map = MapasDisponibles.Mapa4;
//		
//		Partida part = new Partida(arrayPlayers, 10, map);
//		part.jugarPartida();
	}

	/*
	 * public static void main(String[] args) throws FileNotFoundException { Jugador
	 * player = new Jugador(); Jugador arrayPlayers [] = new Jugador[1]; PowerUp
	 * powa = new PowerUp ("Flechazo Gorgonita",10,4); Personaje archer = new
	 * Personaje ("Archer","GORGONIA","Soltero",powa); player.setCharacter(archer);
	 * player.setTag("El Arquero"); player.setPosActual(new Coordenada(1,1));
	 * player.setPosAnterior(new Coordenada(1,1)); player.increaseStars(1);
	 * arrayPlayers[0] = player; Mapa map = new Mapa(); File pf = new File
	 * ("C:\\Users\\laboratorios\\Desktop\\MarioParty\\src\\Archivos\\seedsMapa.txt"
	 * ); map.seedMapa(pf);
	 * 
	 * 
	 * Partida part = new Partida (arrayPlayers,10,map); part.jugarPartida();
	 * System.out.println("La cantidad de estrellas es " +
	 * arrayPlayers[0].getStars());
	 * //System.out.println(arrayPlayers[0].getPosActual().getX()+" "+arrayPlayers[0
	 * ].getPosActual().getY());
	 * 
	 * }
	 */
}
