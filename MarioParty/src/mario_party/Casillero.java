package mario_party;

public class Casillero {
	private boolean switchFlag;
	private boolean divideFlag;
	private boolean explosionFlag;
	private boolean pathFlag;
	
	public Casillero(){
		this.switchFlag= false;
		this.explosionFlag = false;
		this.divideFlag = false;
		this.pathFlag = false;
	}
	public Casillero(Casillero c){
		this.switchFlag= c.switchFlag;
		this.explosionFlag = c.explosionFlag;
		this.divideFlag = c.divideFlag;
		this.pathFlag = c.pathFlag;
	}
	
	public void setSwitch () {
		this.switchFlag=true;
	}
	public void setDivide () {
		this.divideFlag=true;
	}
	public void setExplosion () {
		this.explosionFlag=true;
	}
	public void setPath () {
		this.pathFlag=true;
	}

	public boolean isSwitchFlag() {
		return switchFlag;
	}

	public boolean isDivideFlag() {
		return divideFlag;
	}

	public boolean isExplosionFlag() {
		return explosionFlag;
	}
	public boolean isPathFlag() {
		return pathFlag;
	}
	
	
	
	
}
