package raceWar;

public abstract class Character{
	private int id;
	private String name;
	private int hp;
	private int strength;
	private int defense;
	private int agility;
	private int speed;
	private String image_path;
	private String race;
	private Weapon object;
	
	public Character() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	
	public void setObject(Weapon object) {
		this.object=object;
	}
	
	
	public Weapon getWeapon() {
		return object;
	}

	
	@Override
	public String toString() {
		return	this.getClass().getName()+" [hp=" + hp + ", strength=" + strength + ", defense=" + defense + ", agility=" + agility
				+ ", speed=" + speed + "] "+object;
	}
	
	
	
	
}
