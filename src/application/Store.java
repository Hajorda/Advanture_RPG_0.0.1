package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Store {
	
	
	private Player temp;
	
	public void setTemp(Player player) {
		this.temp = player;
		System.out.println(player+"deniz");
	}
	
	
	
	


//	public Store(boolean location) {
//		super(location);
//		// TODO Auto-generated constructor stub
//	}

	
	
	//Button methodları
	public void buySword1Button() {
		buySword(1);	
	}
	public void buySword2Button() {
		buySword(2);
	}
	public void buySword3Button() {
		buySword(3);
	}
	public void buySword4Button() {
		buySword(4);
	}
	public void buyArmor1Button() {
		buyArmor(1);
	}
	public void buyArmor2Button() {
		buyArmor(2);
	}
	public void buyArmor3Button() {
		buyArmor(3);
	}
	public void buyArmor4Button() {
		buyArmor(4);
	}
	public void buyPotion1Button() {
		buyMediumPotion(1);
	}
	public void buyPotion2Button() {
		buyBigPotion(2);
	}


	
	public void buySword(int index) {
		if(index*10 <= temp.getGold()) {
			temp.setDamage(temp.getDamage()+(index*30));
			System.out.println(temp.getDamage());
		}
		else {
			System.out.println("!! PARA YETERSİZ !!");
		}
	}

	
	public void buyArmor(int index) {
		if(index*20 <= temp.getGold()) {
			temp.setArmor(temp.getArmor()+(index*10));
			temp.setGold(temp.getGold()-(index*20));
		}
		else {
			System.out.println("!! PARA YETERSİZ !!");
		}
	}

	

	public void buyMediumPotion(int index) {
		if(index*20 <= temp.getGold()) {
			temp.setGold(temp.getGold()-(index*20));
			temp.setHealth(temp.getHealth()+30);
			Battlefield.setMediumPotionCounter(Battlefield.getMediumPotionCounter()+1);;
		}
	}


	public void buyBigPotion(int index) {
		if((index*40) <= temp.getGold()) {
			temp.setGold(temp.getGold()-(index*40));
			temp.setHealth(temp.getHealth()+60);
			Battlefield.setBigPotionCounter(Battlefield.getBigPotionCounter()+1);;
		}
	}

	// Battlefield'a gitme metodu.
	public void goBattlefield(ActionEvent event) throws IOException {
		Location.location=false;
		Location.locationControl();
		
	}

	

//	public static void selamlama() {
//		// TODO Auto-generated method stub
//		
//	}
	
	


}
