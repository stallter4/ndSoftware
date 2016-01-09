package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class HeatExchangerWizardController  implements Initializable {

	@FXML private Button workspacePrevious;
	@FXML private Button workspaceCreate;
	@FXML private ChoiceBox<String> tubePattern;

	@FXML
	// Event Listener on Button[#newHeatExchanger].onAction
	public void workspacePreviousButtonClicked(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));

		Main.getStage().setScene(new Scene(root, 300, 275));
		}
	public void workspaceCreateButtonClicked(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));

		Main.getStage().setScene(new Scene(root, 300, 275));
		}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tubePattern.getItems().addAll("Square","Rotated Square","Triangular", "Rotated Triagular");
		tubePattern.setValue("Square");
	}
}
