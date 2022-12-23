package application;

public class Skeleton extends Battlefield {

	public Skeleton(boolean location) {
		super(location);
		// TODO Auto-generated constructor stub
	}

	private static String name="Skeleton";
	private static int HP =100;
	private static int DMG = 10;
	private static int ARMR = 5;
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		Skeleton.name = name;
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
