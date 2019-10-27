package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javazoom.jl.decoder.JavaLayerException;
import mario_party.Coordenada;
import mario_party.Jugador;
import mario_party.MapasDisponibles;
import mario_party.Partida;
import mario_party.Personaje;
import mario_party.PowerUp;

class testCircular {

	@Test
	void test() throws FileNotFoundException, JavaLayerException, InterruptedException {
		Jugador arrayPlayers[] = new Jugador[1];
		Personaje fito = new Personaje("Pepe", "El Conurbano Bonaerense", "Viudo", new PowerUp("Autodestruccion", 15, 3), "src\\Archivos\\test.png");
		
		arrayPlayers[0] = new Jugador(MapasDisponibles.Mapa5_inicio1, fito);
		arrayPlayers[0].setTag("YAHIR");
		
		int[][] map = MapasDisponibles.Mapa5;
		Partida part = new Partida(arrayPlayers, 1, map);
		part.Dado.n=38;
		arrayPlayers[0].increaseStars(2);
		part.jugarPartida();//la explosion quita 1 estrella
	
	}

}
