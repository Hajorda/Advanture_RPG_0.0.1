package application;

public class Store extends Location{

	public Store(boolean location) {
		super(location);
		// TODO Auto-generated constructor stub
	}

	//	Store ekranı gelir.
	public static void selamlama() {
		System.out.println("Hoş geldin: "+MainController.name);
	}
	
	//	İşlemler yapılır
	//
	//
	//
	//
	
	
	
	//	Kılıç satın alma metodu.
	public void buySword(int addDamage, int price, Player player) {
		if(price <= player.getGold()) {
			player.setDamage(player.getDamage()+addDamage);
			player.setGold(player.getGold()-price);
		}
		else {
			System.out.println("!! PARA YETERSİZ !!");
		}
	}
	
	//	Zırh satın alma metodu.
	public void buyArmor(int addArmor, int price, Player player) {
		if(price <= player.getGold()) {
			player.setArmor(player.getArmor()+addArmor);
			player.setGold(player.getGold()-price);
		}
		else {
			System.out.println("!! PARA YETERSİZ !!");
		}
	}
	
	// Medium Pot satın alma metodu.
	public void buyPotion1(int price, Player player) {
		if(price <= player.getGold()) {
			player.setGold(player.getGold()-price);
			battlefield.mediumPotionCounter++;
		}
	}
	
	// Big Pot satın alma metodu.
	public void buyPotion2(int price, Player player) {
		if(price <= player.getGold()) {
			player.setGold(player.getGold()-price);
			battlefield.bigPotionCounter++;
		}
	}
	
	// Battlefield'a gitme metodu.
	public static void goBattlefield() {
		Location.location=false;
		Location.locationControl();
	}
	
	
}
