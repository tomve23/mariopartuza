package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mario_party.Jugador;
import mario_party.Personaje;
import mario_party.PowerUp;

class testJugador {

	@Test
	void test() {
	 Jugador player = new Jugador();
	 PowerUp powa = new PowerUp ("Flechazo Gorgonita",10,4);
	 Personaje archer = new Personaje ("Archer","GORGONIA","Soltero",powa);
	 player.setCharacter(archer);
	 player.setTag("ElChablon");
	 
	}

}
