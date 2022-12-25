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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WarController implements Initializable {

	static int level = 1;
	int konusma = 1;
	static int durum = 1;
	private static Goblin goblin = new Goblin(level);
	private static Skeleton skeleton = new Skeleton(level);
	private static Zombie zombie = new Zombie(level);
	private static int mediumPotionCounter = 0;
	private static int bigPotionCounter = 0;
	Player player;
	// private static Player player = new Player(100, 10, 10, "sa", 100);

		//	Battlefield ekranının başladığı ve hata ayıklama yapıldığı metod.
	public void method() {
		String info;
		File file = new File("info.txt");
		try {
			Scanner scanner = new Scanner(file);
			info = scanner.nextLine();
			String[] a = info.split(",");
			player = new Player(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]), a[3],
					Integer.parseInt(a[4]));
			Files.writeString(file.toPath(), "", StandardCharsets.UTF_8);
		} catch (Exception a) {
			System.out.println("yokmuş scanner");
		}
	}

		//	FXML komutlarının yazıldığı bölüm.
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;

	@FXML
	private Label nickname;
	@FXML
	private Label damageData;
	@FXML
	private Label armorData;
	@FXML
	private Label goldData;
	@FXML
	private Label consoleData;
	@FXML
	private Label bigpData;
	@FXML
	private Label smallpData;
	@FXML
	private ProgressBar healthBar;
	@FXML
	private ProgressBar healthBar1;// goblin
	@FXML
	private ProgressBar healthBar2;// skeleton
	@FXML
	private ProgressBar healthBar3;// zombie
	@FXML
	private ImageView pic;
	@FXML
	private Label goblinLabel;
	@FXML
	private Label skeletonLabel;
	@FXML
	private Label zombieLabel;
	@FXML
	private ImageView imgGoblin;
	@FXML
	private ImageView imgZombie;
	@FXML
	private ImageView imgSkeleton;


		//	Getter-Setter'lar.
	public static int getMediumPotionCounter() {
		return mediumPotionCounter;
	}
	public static void setMediumPotionCounter(int mediumPotionCounter) {
		WarController.mediumPotionCounter = mediumPotionCounter;
	}
	public static int getBigPotionCounter() {
		return bigPotionCounter;
	}
	public static void setBigPotionCounter(int bigPotionCounter) {
		WarController.bigPotionCounter = bigPotionCounter;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	
		//	Settings tuşuna basıldığı zaman çağrılan metod.	
	public void goAyar(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("ayarlar.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
		//	Yaratıkların oluşturulduğu metod.
	public void generateObstacle() {
		Goblin goblin = new Goblin(level);
		Skeleton skeleton = new Skeleton(level);
		Zombie zombie = new Zombie(level);
	}

	/*
	 * public void goDeath() { Parent root =
	 * FXMLLoader.load(getClass().getResource("death.fxml")); stage = (Stage)
	 * ((Node) event.getSource()).getScene().getWindow(); scene = new Scene(root);
	 * this.stage.setScene(scene); this.stage.show(); }
	 */

		//	Hit butonuna tıklandığı zaman çağrılan metod.
	public void Combat(ActionEvent event) throws IOException {

		consoleData.setText(speak());
		konusma++;
		fight(goblin, skeleton, zombie, player);
		player.setHealth(player.getHealth());
		// gunceleme
		 //healthBar,healthBar1,healthBar2,healthBar3
		 healthBar.setProgress((player.getHealth() / (double) 100));
		healthBar1.setProgress((goblin.getHealth() / (double) 100));
		healthBar2.setProgress((skeleton.getHealth() / (double) 100));
		healthBar3.setProgress((zombie.getHealth() / (double) 100));

		System.out.println(player.getHealth());
		Image adam0 = new Image(getClass().getResourceAsStream("adam0.png"));
		Image adam1 = new Image(getClass().getResourceAsStream("adam1.png"));
		Image adam2 = new Image(getClass().getResourceAsStream("adam2.png"));
		Image adam3 = new Image(getClass().getResourceAsStream("adam3.png"));
		Image adam4 = new Image(getClass().getResourceAsStream("adam4.png"));
		Image adamDead = new Image(getClass().getResourceAsStream("adamDead.png"));
		Image adamFull = new Image(getClass().getResourceAsStream("adamFull.png"));

		if (player.getHealth() < 100 && player.getHealth() >= 80) {
			pic.setImage(adam0);

		} else if (player.getHealth() < 80 && player.getHealth() >= 60) {
			pic.setImage(adam1);

		} else if (player.getHealth() < 60 && player.getHealth() >= 40) {
			pic.setImage(adam2);

		} else if (player.getHealth() < 40 && player.getHealth() >= 20) {
			pic.setImage(adam3);

		} else if (player.getHealth() < 20 && player.getHealth() > 0) {
			pic.setImage(adam4);

		} else if (player.getHealth() <= 0) {
			pic.setImage(adamDead);

		}

//goblin.getName() + level

		if (player.getHealth() < 0) {
			
			 Parent root = FXMLLoader.load(getClass().getResource("death.fxml")); stage =
			 (Stage) ((Node) event.getSource()).getScene().getWindow(); scene = new
			 Scene(root); stage.setScene(scene); stage.show();
			 
		} else if (!(goblin.getHealth() + skeleton.getHealth() + zombie.getHealth() > 0)) {

			getReward(player);
			increaseLevel();

			String string = player.getHealth() + "," + player.getArmor() + "," + player.getDamage() + "," + player.getName()
			+ "," + player.getGold();
			Path path = Paths.get("info.txt");
			Files.writeString(path, string, StandardCharsets.UTF_8);
	
			Parent root = FXMLLoader.load(getClass().getResource("store.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	
		// Dövüşme metodu.
	public static void fight(Goblin goblin, Skeleton skeleton, Zombie zombie, Player player) {
		
		if(durum==1) {
			goblin.setHealth((goblin.getHealth()+goblin.getArmor()) - player.getDamage());
			player.setHealth((player.getHealth() + player.getArmor()) - goblin.getDamage());
		}
		else if(durum==2) {
			skeleton.setHealth((skeleton.getHealth()+skeleton.getArmor()) - player.getDamage());
			player.setHealth((player.getHealth() + player.getArmor()) - skeleton.getDamage());
		}
		else if(durum==3) {
			zombie.setHealth((zombie.getHealth() + zombie.getArmor()) - player.getDamage());
			player.setHealth((player.getHealth() + player.getArmor()) - zombie.getDamage());
			durum=1;
		}
		durum++;
	}

		//	Tavern tuşuna basılma durumunda çağrılan metod.
	public void goStore(ActionEvent event) throws IOException {
		
		String string = player.getHealth() + "," + player.getArmor() + "," + player.getDamage() + "," + player.getName()
				+ "," + player.getGold();

		Path path = Paths.get("info.txt");
		Files.writeString(path, string, StandardCharsets.UTF_8);

			// Store'a Gitme Kodu.
		Parent root = FXMLLoader.load(getClass().getResource("store.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

		//	Dövüşü kazanma durumunda çağrılan ödül metodu.
	public static void getReward(Player player) {
		player.setGold(player.getGold() + (level * 10));
		System.out.println(player.getGold());
	}

		// Canavarlarla konuşulan metod.
	public String speak() {
		
		switch(konusma) {
			case 1:
				return player.getName()+": Karsıma cıkın pis yaratıklar";

			case 2:
				return player.getName()+": Soyunuzu kurutmaya geliyorum!";
					
			case 3:
				return player.getName()+": Hepiniz annenizin adını söylesin hemen bana";
			case 4:
				return player.getName()+": Annemin ruhu için savaşıyorum";
			default:
				return "Uykum geldi!";
		}
	}

		// Medium Pot kullanma durumunda çağrılan metod.
	public void useMediumPotion() {
		if(getMediumPotionCounter()>0) {
			setMediumPotionCounter(mediumPotionCounter - 1);
			player.setHealth(player.getHealth()+25);
			smallpData.setText(getMediumPotionCounter() + "");
			healthBar.setProgress((player.getHealth() / (double) 100));
		}
	}
		
		// Big Pot kullanma durumunda çağrılan metod.
	public void useBigPotion() {
		if(getBigPotionCounter()>0) {
			setBigPotionCounter(bigPotionCounter - 1);
			player.setHealth(100);
			bigpData.setText(getBigPotionCounter() + "");
			healthBar.setProgress((player.getHealth() / (double) 100));
		}
	}

		//	Dövüşü kazanma durumunda çağrılan level arttırma metodu.
	public static void increaseLevel() {
		level++;
		System.out.println(level);
	}
	
		//	Dövüşü kazanma durumunda çağrılan canavar geliştirme metodu.
	private void gelistir() {
		goblin = new Goblin(level);
		skeleton = new Skeleton(level);
		zombie = new Zombie(level);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		method();
		generateObstacle();
		zombieLabel.setText(zombie.getName()+level);
		skeletonLabel.setText(skeleton.getName()+level);
		goblinLabel.setText(goblin.getName()+level);

		healthBar.setStyle("-fx-accent: #00FF00;");
		nickname.setText(MainController.name);
		damageData.setText(player.getDamage() + "");
		armorData.setText(player.getArmor() + "");
		goldData.setText(player.getGold() + "");
		bigpData.setText(getBigPotionCounter() + "");
		smallpData.setText(getMediumPotionCounter() + "");

		consoleData.setText("Hoş geldin: " + MainController.name);
		
		 healthBar.setProgress((player.getHealth() / (double) 100));
		healthBar1.setProgress((goblin.getHealth() / (double) 100));
		healthBar2.setProgress((skeleton.getHealth() / (double) 100));
		healthBar3.setProgress((zombie.getHealth() / (double) 100));
		
		fight(goblin, skeleton, zombie, player);

	}
}
