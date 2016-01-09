package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


import javafx.event.ActionEvent;

public class StartScreenController {
	@FXML
	private Button newHeatExchanger;

	// Event Listener on Button[#newHeatExchanger].onAction
	@FXML
	public void newHeatExchangerButtonClicked(ActionEvent event) throws Exception {
		Parent hEWizard = FXMLLoader.load(getClass().getResource("HeatExchangerWizard.fxml"));

		Main.getStage().setScene(new Scene(hEWizard));
		}
}

