package application;

 
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javafx.event.*;


public class Store{
	
	static Player player;
	
	
	
	
	public static void method() {
		String info;
		File file = new File("//Users//abdullahakin//Desktop//Advanture_RPG_0.0.1//src//application//info.txt");
		try {
			Scanner scanner = new Scanner(file);	
			info = scanner.nextLine();
			String[] a = info.split(",");
			player = new Player(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]), a[3] , Integer.parseInt(a[4]));
			Files.writeString(file.toPath(), "", StandardCharsets.UTF_8);
		}
		catch(Exception a) {
			System.out.println("yokmuş scanner");
			
		}
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
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
		method();
		
		if(index*10 <= player.getGold()) {
			player.setDamage(player.getDamage()+(index*30));
			System.out.println(player.getDamage());
		}
		else {
			System.out.println("!! PARA YETERSİZ !!");
		}
	}

	
	public void buyArmor(int index) {
		if(index*20 <= player.getGold()) {
			player.setArmor(player.getArmor()+(index*10));
			player.setGold(player.getGold()-(index*20));
		}
		else {
			System.out.println("!! PARA YETERSİZ !!");
		}
	}

	

	public void buyMediumPotion(int index) {
		if(index*20 <= player.getGold()) {
			player.setGold(player.getGold()-(index*20));
			player.setHealth(player.getHealth()+30);
			Battlefield.setMediumPotionCounter(Battlefield.getMediumPotionCounter()+1);;
		}
	}


	public void buyBigPotion(int index) {
		if((index*40) <= player.getGold()) {
			player.setGold(player.getGold()-(index*40));
			player.setHealth(player.getHealth()+60);
			Battlefield.setBigPotionCounter(Battlefield.getBigPotionCounter()+1);;
		}
	}

	// Battlefield'a gitme metodu.
	public void goBattlefield(ActionEvent event) throws IOException {
		Location.location=false;
		Location.locationControl();
		
		String string =player.getHealth()+","+  player.getArmor()+","+ player.getDamage()+"," + player.getName() +","+  player.getGold();
		
		Path path = Paths.get("//Users//abdullahakin//Desktop//Advanture_RPG_0.0.1//src//application//info.txt");
		Files.writeString(path, string, StandardCharsets.UTF_8);
		
	}

}
