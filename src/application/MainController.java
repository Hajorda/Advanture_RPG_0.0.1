package application;

import java.io.File;
import java.io.IOException; 
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class MainController extends Main implements Initializable {

	

	static String name;
	static String gender;
	static int age = 0;
	static int appearance = -1;
	static String race;
	static String classlar;
	static String job;

	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;

	@FXML
	private TextField namefield;
	@FXML
	private RadioButton male, female, ap1, ap2, ap3;
	@FXML
	private DatePicker datefield;
	@FXML
	private Label warning;
	@FXML
	private ImageView apimage;
	@FXML
	private ChoiceBox<String> boxrace, boxclass, boxjob;
	

	public void backToSettings(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("ayarlar.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void goToStore(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("store.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}
	/*
	 * public void switchToScene1(ActionEvent event) throws IOException { root =
	 * FXMLLoader.load(getClass().getResource("Scene1.fxml")); stage =
	 * (Stage)((Node)event.getSource()).getScene().getWindow(); scene = new
	 * Scene(root); stage.setScene(scene); stage.show(); }
	 */

	public void radio(ActionEvent event) {
		if (male.isSelected()) {
			gender = "Male";
			System.out.println("Male gender is selected");
		} else if (female.isSelected()) {
			gender = "Female";
			System.out.println("Female gender is selected");
		}
	}

	public void getDate(ActionEvent event) {
		LocalDate Date = datefield.getValue();

		age = 2022 - Date.getYear();
	}

	public void setAppearance(ActionEvent event) {

		Image imageap1 = new Image(getClass().getResourceAsStream("ap1.png"));
		Image imageap2 = new Image(getClass().getResourceAsStream("ap2.jpg"));
		Image imageap3 = new Image(getClass().getResourceAsStream("ap3.png"));

		if (ap1.isSelected()) {
			appearance = 1;
			System.out.println("Appearance 1 selected");
			apimage.setImage(imageap1);
		} else if (ap2.isSelected()) {
			appearance = 2;
			System.out.println("Appearance 2 selected");
			apimage.setImage(imageap2);
		} else if (ap3.isSelected()) {
			appearance = 3;
			System.out.println("Appearance 3 selected");
			apimage.setImage(imageap3);
		}
	}

	public void saveTheCharacter(ActionEvent event) throws IOException {

		if (namefield.getText().equals("")) {
			System.out.println("İsim girilmemis!");
			warning.setText("Karakterin ismini belirlemelisin!");
		} else if (gender == null) {
			System.out.println("Gender girilmemis!");
			warning.setText("Karakterin cinsiyetini belirlemelisin");
		} else if (age == 0) {
			System.out.println("Age girilmemis!");
			warning.setText("Karakterin yasini belirlemelisin");
		} else if (boxrace.getValue() == null) {
			System.out.println("Race girilmemis!");
			warning.setText("Karakterin ırkını belirlemelisin");
		} else if (boxclass.getValue() == null) {
			System.out.println("Class girilmemis!");
			warning.setText("Karakterin ırkını belirlemelisin");
		} else if (boxjob.getValue() == null) {
			System.out.println("Job girilmemis!");
			warning.setText("Karakterin meslegini belirlemelisin");
		}

		//else {
			System.out.println("----------------------------");
			System.out.println("Name: " + namefield.getText());
			System.out.println("Gender: " + gender);
			System.out.println("Age: " + age);
			System.out.println("Race: " + boxrace.getValue());
			System.out.println("Class: " + boxclass.getValue());
			System.out.println("Job: " + boxjob.getValue());
			System.out.println("----------------------------");
			System.out.println("");
			System.out.println("Karakter olusturuldu oyun baslatılıyor!");

			name = namefield.getText();
			race = boxrace.getValue();
			classlar = boxclass.getValue();
			job = boxjob.getValue();
			
			Player player = new Player(100, 10, 10, name, 100);
			
			String string =player.getHealth()+","+  player.getArmor()+","+ player.getDamage()+"," + player.getName() +","+  player.getGold();
			
			Path path = Paths.get("//Users//abdullahakin//Desktop//Advanture_RPG_0.0.1//src//application//info.txt");
			Files.writeString(path, string, StandardCharsets.UTF_8);
			
			

			// Store Sahnesine gitme kodu
			
			Parent root = FXMLLoader.load(getClass().getResource("store.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		
			Location.locationControl();
		
		//}
	}

	private String[] races = { "Human", "Elf", "Ork", "Urk-Hai", "Dwarf" };
	private String[] claslar = { "Swordman", "Mage", "Healer", "Wise" };
	private String[] jobs = { "Madenci", "Oduncu", "Koylu", "Is adami", "Asci" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Kutuların icini dolduruyoruz

		boxrace.getItems().addAll(races);
		boxclass.getItems().addAll(claslar);
		boxjob.getItems().addAll(jobs);

	}

}

/*
 * <3 <3 <3 <3 Eren seni seviyorum utanıyorum o yüzden aşkımı burdan ilan
 * ediyorum <3 <3 <3
 * ben de seni sevyiorum ama söylemeue utanıyordum ^^
 */