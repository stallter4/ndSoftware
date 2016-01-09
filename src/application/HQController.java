package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class HQController {

	@FXML
	private MenuItem newHeatExchanger2;

	// Event Listener on Button[#newHeatExchanger].onAction
	@FXML
	public void newHeatExchanger2ButtonClicked(ActionEvent event) throws Exception {
		Parent hEWizard = FXMLLoader.load(getClass().getResource("HeatExchangerWizard.fxml"));
		Stage stage = new Stage(); stage.setScene(new Scene(hEWizard));
		stage.show();
		Main.getStage().setScene(new Scene(hEWizard));
		}
}
