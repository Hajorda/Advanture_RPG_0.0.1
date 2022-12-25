package application;

public class Goblin extends Character {

	public Goblin(int level) {
		super(100, 5+(level*5), 5+(level*5), level, "Goblin lv. ");
	}

		//	OVERRIDE metod.
	public Goblin(int level, String boss) {
		super(200, 5+(level*5), 5+(level*5), level, "Goblin BOSS lv. ");
	}
}
