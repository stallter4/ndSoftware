package application;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage stage;
	public static Stage getStage() { return stage; }
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("HQ.fxml"));

		primaryStage.setTitle("SSAnalysis");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		} 
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
