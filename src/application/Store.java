package application;

public class Store extends Location{

	private int W1M = 15;			// W 	 /A    /P			1 					M    /D
	private int W2M = 25;			// Weapon/Armor/Poison		kaçıncı olduğu		Money/Damage
	private int W3M = 35;
	private String W1S = "Demir Kılıç";				// !!!! ITEMLER ARRAY YA DAOBJE ILE KATALOGLANACAK !!!!
	private String W2S = "Altın Kılıç";
	private String W3S = "Elmas Kılıç";
	
	private int A1M = 10;
	private int P1M = 30;
	
	public Store(boolean location) {
		super(location);
	}
	public int getW1M() {
		return W1M;
	}
	public void setW1M(int w1m) {
		W1M = w1m;
	}
	public int getW2M() {
		return W2M;
	}
	public void setW2M(int w2m) {
		W2M = w2m;
	}
	public int getW3M() {
		return W3M;
	}
	public void setW3M(int w3m) {
		W3M = w3m;
	}
	public String getW1S() {
		return W1S;
	}
	public void setW1S(String w1s) {
		W1S = w1s;
	}
	public String getW2S() {
		return W2S;
	}
	public void setW2S(String w2s) {
		W2S = w2s;
	}
	public String getW3S() {
		return W3S;
	}
	public void setW3S(String w3s) {
		W3S = w3s;
	}
	public int getA1M() {
		return A1M;
	}
	public void setA1M(int a1m) {
		A1M = a1m;
	}
	public int getP1M() {
		return P1M;
	}
	public void setP1M(int p1m) {
		P1M = p1m;
	}

	
	public static void selamlama() {
		System.out.println("Hoş geldin: "+Controller.name);
	}
	
	
}
