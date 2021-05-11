package raceWar;

public class Dwarf extends Character{
	
	public Dwarf(String name, String image_path) {
		super();
		setName(name);
		setHp(60);
		setStrength(6);
		setDefense(4);
		setAgility(5);
		setSpeed(3 );
		setImage_path(image_path);
		setRace("dwarf");
	}
}
