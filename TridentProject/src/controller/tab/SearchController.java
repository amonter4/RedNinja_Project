package controller.tab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;



public class SearchController {
	ObservableList<String> tableList = FXCollections.observableArrayList("Client", "Site");
	
	@FXML private Button SviewBT;
	
	@FXML private TextField SSearchTF;
	
	
	//@FXML private ChoiceBox  STableCB;
	
	@FXML private void SviewBTClicked(ActionEvent event){
		
		System.out.println("Working");
		
	}
	



}
