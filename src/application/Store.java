package application;

 
import java.io.File; 
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Store implements Initializable{
	
	 Player player;
	
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;

	@FXML
	private Label nameLabel;
	@FXML
	private Label healthLabel;
	@FXML
	private Label armorLabel;
	@FXML
	private Label damageLabel;
	
	
	
	
	public  void readMethod() {
		String info;
		File file = new File("info.txt");
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
		if(index*50 <= player.getGold()) {
			player.setGold(player.getGold()-index*50);
			player.setDamage(player.getDamage()+(index*30));
		}
		else {
			System.out.println("!! PARA YETERSİZ !!");
		}
	}

	
	public void buyArmor(int index) {
		if(index*50 <= player.getGold()) {
			player.setGold(player.getGold()-index*50);
			player.setArmor(player.getArmor()+(index*20));
		}
		else {
			System.out.println("!! PARA YETERSİZ !!");
		}
	}

	

	public void buyMediumPotion(int index) {
		if(index*30 <= player.getGold()) {
			player.setGold(player.getGold()-(index*30));
			player.setHealth(player.getHealth()+25);
			Battlefield.setMediumPotionCounter(Battlefield.getMediumPotionCounter()+1);;
		}
	}


	public void buyBigPotion(int index) {
		if(index*60 <= player.getGold()) {
			player.setGold(player.getGold()-(index*60));
			player.setHealth(player.getHealth()+100);
			Battlefield.setBigPotionCounter(Battlefield.getBigPotionCounter()+1);;
		}
	}
	
	
	public void bilmem() throws IOException{
		
		String string2 =player.getHealth()+","+  player.getArmor()+","+ player.getDamage()+"," + player.getName() +","+  player.getGold();
		Path path2 = Paths.get("info.txt");
		Files.writeString(path2, string2, StandardCharsets.UTF_8);
		
	}

	// Battlefield'a gitme metodu.
	public void goBattlefield(ActionEvent event) throws IOException {
//		Location.location=false;
//		Location.locationControl();
		
		bilmem();
		
		Parent root = FXMLLoader.load(getClass().getResource("war.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
		
	}

	public void setStats() {
		armorLabel.setText(player.getArmor()+"");
		damageLabel.setText(player.getDamage()+"");
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		readMethod();

		nameLabel.setText(player.getName());
		healthLabel.setText(player.getHealth()+"");
		setStats();
	}

}
