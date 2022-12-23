package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class settingsController implements Initializable {

	MediaPlayer mediaPlayer;
	@FXML
	private Stage stage;
	@FXML
	private Scene scene;
	@FXML
	private Parent root;

	@FXML
	private CheckBox mutebox;
	@FXML
	private Slider musicSlider;

	static double volume = 50;

	public void MuteBoxCheck(ActionEvent event) {
		if (!(mutebox.isSelected())) {
			System.out.println("Mute Devre Dışı");
			mediaPlayer.setMute(false);
		}

		if (mutebox.isSelected()) {
			System.out.println("Mute Aktif");
			mediaPlayer.setMute(true);
		}
	}

	/*
	 * public void goToGenerator(MouseEvent event) {
	 * 
	 * try { //Controller.startmusic(); root =
	 * FXMLLoader.load(getClass().getResource("generator.fxml")); stage =
	 * (Stage)((Node)event.getSource()).getScene().getWindow(); scene = new
	 * Scene(root); stage.setScene(scene); stage.show(); }catch (Exception e) {
	 * System.out.println(e);
	 * 
	 * }
	 * 
	 * }
	 */

	public void exit(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText("Karakteri oluşturmak üzeresin.");
		alert.setContentText("Karakter oluşturulduktan sonra bu işlem geri alınamaz.");

		if (alert.showAndWait().get() == ButtonType.OK) {
			System.out.println("Uygulamadan Cikis Yapildi!");
			System.exit(0);
		}
	}

	public void goToWar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("War.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setFullScreen(true);
		stage.show();
	}

	public void goToGenerator(ActionEvent event) throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("generator.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		/*
		 * try { String filePath =
		 * "C:\\Users\\hajor\\Documents\\GitHub\\zawardo\\RPG\\src\\application\\music.mp3";
		 * 
		 * Media media = new Media(new File(filePath).toURI().toString()); mediaPlayer =
		 * new MediaPlayer(media); mediaPlayer.setAutoPlay(true); mediaPlayer.play();
		 * 
		 * } catch (MediaException e) { e.printStackTrace(); }
		 */
		/*
		 * volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
		 * 
		 * 
		 * 
		 * @Override
		 * 
		 * public void changed(ObservableValue<? extends Number> arg0, Number arg1,
		 * Number arg2) {
		 * 
		 * 
		 * 
		 * mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
		 * 
		 * }
		 */
		musicSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {

				volume = musicSlider.getValue() * 0.01;
				//System.out.println("Volume " + volume);
				// mediaPlayer.setVolume(volume);

			}

		});

	}
}
