package mario_party;


public class Jugador {
	private String tag;
	private int coins;
	private int stars;
	private Personaje character;
	private Coordenada posActual;
	private Coordenada posAnterior;
	
	public Jugador (Coordenada inicial, Personaje character){
		this.coins = 50; //Elegir cantidad Inicial Monedas
		this.stars = 0;
		posActual = new Coordenada(inicial.getX(),inicial.getY());
		posAnterior = new Coordenada(inicial.getX(),inicial.getY());
		this.character = character;
	}
	
	public void setTag(String name) {
		this.tag = name;
	}
	/*
	public void setCharacter (String name) {
		//array con personajes, clave es el nombre, elijo por nombre
		
	}*/
	//Para realizar la prueba mando Character
	public void setCharacter (Personaje c) {
		this.character= c;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getStars() {
		return stars;
	}

	public void increaseStars(int stars) {
		this.stars += stars;
	}
	
	public void decreaseStars(int stars) {
		if(this.stars>0)
			this.stars -= stars;
	}

	public Coordenada getPosActual() {
		return posActual;
	}

	public void setPosActual(Coordenada posActual) {
		this.posActual = posActual;
	}

	public Coordenada getPosAnterior() {
		return posAnterior;
	}

	public void setPosAnterior(Coordenada posAnterior) {
		this.posAnterior = posAnterior;
	}

	public String getTag() {
		return tag;
	}

	public Personaje getCharacter() {
		return character;
	}
	public void Desplazarse(Coordenada sig) {
		this.posAnterior=this.posActual;
		this.posActual = sig;
	}
	

	
}
