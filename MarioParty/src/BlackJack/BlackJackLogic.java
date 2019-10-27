package BlackJack;

import java.util.ArrayList;

public class BlackJackLogic {
	
	Deck deck = new Deck();
	int jugadorActual = 0;
	ArrayList<PlayerBJ> players= new ArrayList<PlayerBJ>();
	ArrayList<Integer>ganadorIndex = new ArrayList<Integer>();
	int banGanador=0;
	
	BlackJackLogic(ArrayList<String> jugadores){
		for(int i=0;i<jugadores.size();i++) {
			players.add(new PlayerBJ(jugadores.get(i),deck.dealCard(),deck.dealCard()));
		}
	}
	
	public void saltearTurno() {
		if(players.get(jugadorActual).calcularPuntaje()>21 ||players.get(jugadorActual).isStayFlag()) {
			if(jugadorActual==players.size()-1)
				jugadorActual=0;
			else
				jugadorActual++;
		}
	}
	public boolean hayGanador() {
		for(int i=0;i<players.size();i++) {
			if(players.get(jugadorActual).calcularPuntaje()<21 && !players.get(jugadorActual).isStayFlag()) {
				return false;
			}
		}
		return true;	
	}
	
	public void getGanador() {
		int menor=0;
		for(int i=1;i<players.size();i++) {
			if(players.get(i).calcularPuntaje()<players.get(menor).calcularPuntaje()) {
				menor=i;				
			}
		}
		for(int i=0;i<players.size();i++) {
			if(i==menor) {
				ganadorIndex.add(i);
			}
		}
	}
	public boolean terminoTurno(){
		for(int i=1;i<players.size();i++) {
			if(!players.get(i).isHitFlag() || !players.get(i).isStayFlag()) {
				return false;				
			}
		}
		return true;
	}
	
	public void setHitFlag() {
		players.get(jugadorActual).setHitFlag(true);
	}
	public void setStayFlag() {
		players.get(jugadorActual).setStayFlag(true);
	}
}
