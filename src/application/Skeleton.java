package application;

public class Skeleton extends Character {

	public Skeleton(int level) {
		super(100, 5+level, 5+level, level, "Skeleton lv. ");
	}
	
		//	OVERRIDE metod.
	public Skeleton(int level, String boss) {
		super(200, 5+(level*5), 5+(level*5), level, "Skeleton BOSS lv. ");
	}
}
