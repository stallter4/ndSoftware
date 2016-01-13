package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HQController {

	//class variables
	//reference to Main class
	private Main main;
	@FXML private MenuItem newHeatExchanger2;
	@FXML private TabPane tabPane;
	@FXML private Button workspaceCreate;
	@FXML private TextField workspaceName;
	@FXML private HeatExchangerWizardController HEWiz;
	
	//constructor
	public HQController() {
	}
	
	//
	// Event Listener on Button[#newHeatExchanger].onAction
	@FXML
	public void newHeatExchanger2ButtonClicked(ActionEvent event) throws Exception {
		HeatExchanger tempHeatExchanger = new HeatExchanger();
		boolean okClicked = main.showHeatExchangerWizard(tempHeatExchanger);
		if (okClicked) {
			main.getHeatExchangerData().add(tempHeatExchanger);
		}
		}
	public void workspaceCreateButtonClicked(ActionEvent event) throws Exception {
	    Stage stage  = (Stage) workspaceCreate.getScene().getWindow();
	    stage.close();
	    Tab tab = new Tab();
	    tab.setId(workspaceName.getText());
        tab.setText(workspaceName.getText());
        //application.HQController.tabPane.getTabs().add(tab);
	}
	
	public void setMain(Main main) {
        this.main = main;
    }
}
