package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HeatExchangerWizardController  implements Initializable {

	@FXML private Button workspacePrevious;
	@FXML private Button workspaceCreate;
	@FXML private ChoiceBox<String> tubePattern;
	@FXML private TextField Name;
	
	private Stage dialogStage;
	private HeatExchanger heatExchanger;
	private boolean okClicked = false;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tubePattern.getItems().addAll("Square","Rotated Square","Triangular", "Rotated Triagular");
		tubePattern.setValue("Square");
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setHeatExchanger(HeatExchanger heatExchanger) {
		this.heatExchanger = heatExchanger;
		Name.setText(heatExchanger.getName());
		Tab tab = new Tab();
        tab.setText("Tab" + i);
        TreeItem<String> duckRoot = new TreeItem<String>("Della Duck - Donald Duck");
	}
	
	public boolean okClicked(){
		return okClicked;
	}
	
	@FXML
	public void workspaceCreateButtonClicked(ActionEvent event) throws Exception {
		heatExchanger.setName(Name.getText());
		okClicked = true;
		dialogStage.close();
		}
}
