package application;

public class storeController {

	public storeController(boolean location) {
		//super(location);
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
	public void buySword() {
		buySword1(0, 0, null);
	}
	public void buySword1(int addDamage, int price, Player player) {
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
	public void buyMediumPotion(int price, Player player) {
		if(price <= player.getGold()) {
			player.setGold(player.getGold()-price);
			Battlefield.setMediumPotionCounter(Battlefield.getMediumPotionCounter()+1);;
		}
	}

	//	Big Pot satın alma metodu.
	public void buyBigPotion(int price, Player player) {
		if(price <= player.getGold()) {
			player.setGold(player.getGold()-price);
			Battlefield.setBigPotionCounter(Battlefield.getBigPotionCounter()+1);;
		}
	}
}
