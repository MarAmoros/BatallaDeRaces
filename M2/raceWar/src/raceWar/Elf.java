package raceWar;

public class Elf extends Character{
	
	public Elf(String name, String image_path) {
		super();
		setName(name);
		setHp(40);
		setStrength(4);
		setDefense(2);
		setAgility(7);
		setSpeed(7);
		setImage_path(image_path);
		setRace("elf");
	}
	 
}
