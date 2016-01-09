package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class HQController {

	@FXML private MenuItem newHeatExchanger2;
	@FXML private TabPane tabPane;

	// Event Listener on Button[#newHeatExchanger].onAction
	@FXML
	public void newHeatExchanger2ButtonClicked(ActionEvent event) throws Exception {
		CreateWorkspace workspace = new CreateWorkspace(tabPane);
		Parent hEWizard = FXMLLoader.load(getClass().getResource("HeatExchangerWizard.fxml"));
		Stage stage = new Stage(); stage.setScene(new Scene(hEWizard));
		stage.show();
		Main.getStage().setScene(new Scene(hEWizard));
		}
}
