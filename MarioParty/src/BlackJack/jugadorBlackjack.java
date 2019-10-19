package BlackJack;

import mario_party.Jugador;

public class jugadorBlackjack {
	private Jugador player;
	private int score;
	public Jugador getPlayer() {
		return player;
	}
	public void setScore(Jugador player) {
		this.player = player;
	}
	public int getCantPuntos() {
		return score;
	}
	public void setScore(int cantPuntos) {
		this.score = cantPuntos;
	}

}
