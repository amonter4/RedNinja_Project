package controller.tab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class IncidentReportController {

	@FXML private Button insertBT;
	@FXML private Button deleteBT;
	@FXML private Button updateBT;
	@FXML private Button clearBT;
	@FXML private Button searchBT;
	
	@FXML private TextField dateTF;
	@FXML private TextField timestampTF;
	@FXML private TextField badgenumberTF;
	@FXML private TextField siteTF;
	@FXML private TextField shiftTF;
	@FXML private TextField reporttypeTF;
	@FXML private TextField nameTF;
	
	@FXML private TextArea descriptionTA;
	
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
