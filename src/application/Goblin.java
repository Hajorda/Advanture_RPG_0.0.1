package application;

public class Goblin extends Battlefield {

	public Goblin(boolean location) {
		super(location);

	}

	private static String name="Goblin";
	private static int HP =100;
	private static int DMG = 10;
	private static int ARMR = 5;
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Goblin.name = name;
	}
	public static int getHP() {
		return HP;
	}
	public static void setHP(int hP) {
		HP = hP;
	}
	public static int getDMG() {
		return DMG;
	}
	public static void setDMG(int dMG) {
		DMG = dMG;
	}
	public static int getARMR() {
		return ARMR;
	}
	public static void setARMR(int aRMR) {
		ARMR = aRMR;
	}
	
	
	
}
