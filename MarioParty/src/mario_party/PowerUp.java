package mario_party;

public class PowerUp {
	private String nombrePowerUp;
	private int alcanceCasilleros;
	private int turnosCoolDown;
	
	public PowerUp (String name,int range, int coolDown){
		this.nombrePowerUp = name;
		this.alcanceCasilleros = range;
		this.turnosCoolDown = coolDown;
	}
	

	public String getNombrePowerUp() {
		return nombrePowerUp;
	}

	public void setNombrePowerUp(String nombrePowerUp) {
		this.nombrePowerUp = nombrePowerUp;
	}

	public int getAlcanceCasilleros() {
		return alcanceCasilleros;
	}

	public void setAlcanceCasilleros(int alcanceCasilleros) {
		this.alcanceCasilleros = alcanceCasilleros;
	}

	public int getTurnosCoolDown() {
		return turnosCoolDown;
	}

	public void setTurnosCoolDown(int turnosCoolDown) {
		this.turnosCoolDown = turnosCoolDown;
	}
	
	
	
}
