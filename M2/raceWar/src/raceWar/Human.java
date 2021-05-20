package raceWar;

public class Human extends Character{

	public Human(String name, String image_path) {
		super();
		setName(name);
		setHp(50);
		setStrength(5);
		setDefense(3);
		setAgility(6);
		setSpeed(5);
		setImage_path(image_path);
		setRace("human");
	}
}
