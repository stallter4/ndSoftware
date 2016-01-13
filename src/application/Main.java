package application;
	

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	public static Main _instance;
	private static Stage primaryStage;
	private VBox root;
        private HQController hqController;
        
    private ObservableList<HeatExchanger> HeatExchangerData = FXCollections.observableArrayList();

    public ObservableList<HeatExchanger> getHeatExchangerData() {
        return HeatExchangerData;
    }
    
    public HQController getHQController() {
        return this.hqController;
    }
    
    public static Stage getStage() { return primaryStage; }
	
	@Override
        public void start(Stage primaryStage) throws Exception {
            Main._instance = this;
            
		this.primaryStage = primaryStage;
		primaryStage.setTitle("SSAnalysis");
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HQ.fxml"));
        root = (VBox) loader.load();
        hqController = loader.getController();
        hqController.setMain(this);
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		} 
	
	public boolean showHeatExchangerWizard(HeatExchanger heatExchanger) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("HeatExchangerWizard.fxml"));
			VBox hEWizard = (VBox) loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Heat Exchanger Wizard");
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(hEWizard);
			dialogStage.setScene(scene);
		
			HeatExchangerWizardController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setHeatExchanger(heatExchanger);
		
			dialogStage.showAndWait();
		
			return controller.okClicked();
		}
		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
