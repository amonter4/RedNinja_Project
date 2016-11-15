package controller.tab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TimeReportingController {

	@FXML private Button insertBT;
	@FXML private Button deleteBT;
	@FXML private Button updateBT;
	@FXML private Button clearBT;
	@FXML private Button searchBT;
	
	@FXML private TextField employeeidTF;
	@FXML private TextField timeinTF;
	@FXML private TextField timeoutTF;
	@FXML private TextField lunchinTF;
	@FXML private TextField lunchoutTF;


	
	@FXML private Label MessageLB;
	@FXML private Label ErrorMessageLB1;

	@FXML private void InsertBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void DeleteBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void UpdateBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void ClearBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
	@FXML private void SearchBTClicked(ActionEvent event){
		System.out.println("Working");
	}
	
}
