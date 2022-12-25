package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(Stage stage) {

		// Stage stage = new Stage() ----> Stage ekleme

		try {
			Parent root = FXMLLoader.load(getClass().getResource("generator.fxml"));
			// Group root = new Group();
			Scene scene = new Scene(root, 600, 450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			stage.setScene(scene);
			stage.show();
			stage.setTitle("Advanture RPG Game");


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {




		launch(args);

	}

}
