package BlackJack;

import java.util.ArrayList;

public class PlayerBJ {
	
		private String player;
		private ArrayList<Card> cartas= new ArrayList<Card>();
		private boolean stayFlag;
		
		public PlayerBJ(String name,Card c1, Card c2) {
			this.player = name;
			cartas.add(c1);
			cartas.add(c2);
			stayFlag=false;
		}
		public PlayerBJ(PlayerBJ o) {
			this.player = o.player;
			this.cartas.add(o.cartas.get(0));
			this.cartas.add(o.cartas.get(1));
			stayFlag=false;
		}
		
		public String getPlayer() {
			return player;
		}
		public void setScore(String player) {
			this.player = player;
		}

		public ArrayList<Card> getCartas() {
			return cartas;
		}

		public void setCartas(ArrayList<Card> cartas) {
			this.cartas = cartas;
		}

		public void setPlayer(String player) {
			this.player = player;
		}
		public boolean isStayFlag() {
			return stayFlag;
		}
		public void setStayFlag(boolean stayFlag) {
			this.stayFlag = stayFlag;
		}
		public int calcularPuntaje() {
			int sum=0;
			for (Card card : cartas) {
				sum+=card.getRank();
			}
			return sum;
		}

	}


