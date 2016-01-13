package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
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
	
	public void setHeatExchanger(HeatExchanger heatExchanger) throws IOException {
		this.heatExchanger = heatExchanger;
		Name.setText(heatExchanger.getName());
		Tab tab = new Tab();
                
                /*
                    
                */
                
                
        //tab.setText("Tab" + i);
        //TreeItem<String> duckRoot = new TreeItem<String>("Della Duck - Donald Duck");
	}
	
	public boolean okClicked(){
		return okClicked;
	}
        
        public boolean isInitOkay() {
            if (Name.getText() == null || Name.getText().equals("")) {
                Name.requestFocus();
                return false;
            }
            
            
            
            return true;
        }
	
	@FXML
	public void workspaceCreateButtonClicked(ActionEvent event) throws Exception {
            String wsName = Name.getText();
            
            if (!isInitOkay()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Heat exchanger wizard");
                alert.setHeaderText("Input error.");
                alert.setContentText("Hey. you have missed one to input.");

                alert.showAndWait();
                
                return;
            }

            heatExchanger.setName(wsName);
            okClicked = true;
            dialogStage.close();

            HQController controller = Main._instance.getHQController();
            controller.tabPane.getTabs().add(new Tab(wsName));

            TreeView tree = controller.treeView;

            TreeItem<String> item = item = tree.getRoot();

            if (item == null) {
                return;
            }

            TreeItem<String> newItem = new TreeItem<>(wsName);
            newItem.setExpanded(true);
            item.getChildren().add(newItem);
        }
}
