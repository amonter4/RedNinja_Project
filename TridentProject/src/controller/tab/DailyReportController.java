package controller.tab;

//import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DailyReportController {
	
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
	
	@FXML private TextArea descriptionTA;
	
	@FXML private Label MessageLB;
	@FXML private Label ErrorMessageLB1;
	
	//Credentials for the database
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
	
	

	@FXML private void InsertBTClicked(ActionEvent event){
		//Clears the Message Labels 
		MessageLB.setText("");
		ErrorMessageLB1.setText("");
		
		//String date = dateTF.getText();
		String badgeNumber = badgenumberTF.getText();
		String site = siteTF.getText();
		String shift = shiftTF.getText();
		String reportType = reporttypeTF.getText();
		
		String reportDescript = descriptionTA.getText();
		
		
		int badgeNum  = Integer.parseInt(badgeNumber);
		int siteNum = Integer.parseInt(site);
		
		
		

		// Changes Text type data to Int type data to follow database rules
		//int clientNum  = Integer.parseInt(clientNumText);
		//int contractTime = Integer.parseInt(contactTimeText);
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "Insert INTO DailyReport " +
						"(ReportDate, ReportType, BadgeNumber, SiteID, ShiftType, ReportDescription) " +
						"VALUES('5-12', '" + reportType + "', " + badgeNum + ", " + siteNum + ", '" + shift + "', '" + reportDescript + "')";
			// Commits to database		
		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
			MessageLB.setText("Insert Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			ErrorMessageLB1.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}
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

