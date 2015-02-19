package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Main class
 *
 * @author Caroline Chabert
 */

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
			try {
					Parent root = FXMLLoader.load(getClass().getResource("SapForView.fxml"));
					//Scene scene = new Scene(root,400,400);
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.setTitle("SapFor : Formation pour pompiers");
					primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}