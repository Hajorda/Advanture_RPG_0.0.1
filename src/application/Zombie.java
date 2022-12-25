package application;

public class Zombie extends Character {

	public Zombie(int level) {
		super(100, 5+(level*5), 5+(level*5), level, "Zombie lv. ");
	}

	public Zombie(int level, String boss) {
		super(200, 5+(level*5), 5+(level*5), level, "Zombie BOSS lv. ");
	}
	
	
}
