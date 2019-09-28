package pruebas;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;
import mario_party.Coordenada;
import mario_party.Jugador;
import mario_party.Mapa;
import mario_party.Partida;
import mario_party.Personaje;
import mario_party.PowerUp;

class testTurno {

	@Test
	void test() throws FileNotFoundException {
		Jugador player = new Jugador();
		Jugador arrayPlayers [] = new Jugador[1];
		PowerUp powa = new PowerUp ("Flechazo Gorgonita",10,4);
		 Personaje archer = new Personaje ("Archer","GORGONIA","Soltero",powa);
		 player.setCharacter(archer);
		 player.setTag("ElChablon");
		 player.setPosActual(new Coordenada(1,1));
		 player.setPosAnterior(new Coordenada(1,1));
		 arrayPlayers[0] = player;
			Mapa map = new Mapa();
			File pf = new File ("C:\\Users\\yyablons\\Documents\\Universidad\\Programación Avanzada\\Taller\\MarioPartuzaEntrega1\\MarioParty\\src\\Archivos\\seedsMapa.txt");
			map.seedMapa(pf);
			
		Partida part = new Partida (arrayPlayers,1,map);
		part.jugarPartida();
		System.out.println(arrayPlayers[0].getPosActual().getX()+" "+arrayPlayers[0].getPosActual().getY());
		
	}

}
