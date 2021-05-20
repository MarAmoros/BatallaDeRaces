package raceWar;

public abstract class Weapon {
	private int speed;
	private int strength;
	
	public Weapon() {
		
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName()+"[speed= +" + speed + ", strength= +" + strength + "]";
	}
	
	
}
