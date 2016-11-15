package controller.tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CredentialController {
	@FXML private Button insertBT;
	@FXML private Button deleteBT;
	@FXML private Button updateBT;
	@FXML private Button clearBT;
	@FXML private Button searchBT;
	
	@FXML private TextField CRemployeeidTF;
	@FXML private TextField CRusernameTF;
	@FXML private TextField CRaccountypeTF;
	@FXML private TextField CRpasswordTF;
	
	@FXML private PasswordField CRpasswordPF;
	
	@FXML private CheckBox showpasswordCB;

	
	@FXML private TextArea descriptionTA;
	
	@FXML private Label CRsuccessmessageLB;
	@FXML private Label CRerrormessageLB;
	
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";

	@FXML private void CRInsertBTClicked(ActionEvent event){
		//Clears the Message Labels 
				CRsuccessmessageLB.setText("");
				CRerrormessageLB.setText("");
				
				String employeeID = CRemployeeidTF.getText();
				String userName = CRusernameTF.getText();
				String accountType = CRaccountypeTF.getText();
				String password1 =  CRpasswordPF.getText();
				
				// Gets Text from TexFields and gives it to a String Variable
			

				// Changes Text type data to Int type data to follow database rules
				int employeeNum  = Integer.parseInt(employeeID);
				
			
				// Uses JDBC to establish connection
				String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
			
				
				try
				{
					Connection con = DriverManager.getConnection(connectionURL);
					
					Statement stmt = con.createStatement();
					// Statement inserts Information from Text Field into Database
					String sqlStatement = "Insert INTO Credential " +
							"(EmployeeId, Username, Password, AccountType) " +
							"VALUES(" + employeeNum + ", '" + userName + "', '" + password1 + "', '" + accountType + "')";

				stmt.execute(sqlStatement);
			         // Closes connection
					con.close();
			
					// Shows Message for Feedback
					CRsuccessmessageLB.setText("Insert Succesful");
				} //Catches errors
				
				catch(Exception ex)
				{
					//Shows error message
					CRerrormessageLB.setText("Error: " + ex.getMessage());
					// MessageLB.setText("Insert Failed");
				}

	}
	
	@FXML private void CRDeleteBTClicked(ActionEvent event){
		//Clears the Message Labels 
		CRsuccessmessageLB.setText("");
		CRerrormessageLB.setText("");
		
		String employeeID = CRemployeeidTF.getText();
		
		// Gets Text from TexFields and gives it to a String Variable
	

		// Changes Text type data to Int type data to follow database rules
		int employeeNum  = Integer.parseInt(employeeID);
		
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "DELETE FROM Credential " +
					 "WHERE EmployeeId = " + employeeNum + "";

		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
			CRsuccessmessageLB.setText("Insert Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			CRerrormessageLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}

	}
	
	@FXML private void CRUpdateBTClicked(ActionEvent event){
		CRsuccessmessageLB.setText("");
		CRerrormessageLB.setText("");
		
		
		String userName = CRusernameTF.getText();
		String accountType = CRaccountypeTF.getText();
		String password1 =  CRpasswordTF.getText();
		
		 String CRemployeetext = CRemployeeidTF.getText();
			int CRemployeeNum  = Integer.parseInt(CRemployeetext);
		
		// Gets Text from TexFields and gives it to a String Variable
	

		// Changes Text type data to Int type data to follow database rules
		
		
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "UPDATE Credential " +
			"SET EmployeeId = "+CRemployeeNum+", Username = '"+userName+"', Password = '"+password1+"', AccountType = '"+accountType+"' " +
			"WHERE  EmployeeId = " + CRemployeeNum + " ";

		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
			CRsuccessmessageLB.setText("Update Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			CRerrormessageLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}
	}
	
	@FXML private void CRClearBTClicked(ActionEvent event){
		CRsuccessmessageLB.setText("");
		CRerrormessageLB.setText("");
		
		CRemployeeidTF.clear();
		CRusernameTF.clear();
		CRpasswordPF.clear();
		CRaccountypeTF.clear();
		
		CRsuccessmessageLB.setText("Clear Successfull");
	}
	
	@FXML private void CRSearchBTClicked(ActionEvent event){
		
		CRsuccessmessageLB.setText("");
		CRerrormessageLB.setText("");
		
		 String CRemployeetext = CRemployeeidTF.getText();
			int CRemployeeNum  = Integer.parseInt(CRemployeetext);
			
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		
			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				Statement stmt = con.createStatement();
				
				String sqlStatement ="SELECT * FROM Credential WHERE EmployeeId = " + CRemployeeNum;
						
				ResultSet result = stmt.executeQuery(sqlStatement);
				
			 while (result.next())
			 {
				 
					CRusernameTF.setText((result.getString("Username")));
					CRpasswordPF.setText((result.getString("Password")));
					CRaccountypeTF.setText((result.getString("AccountType")));
				 
					
					 CRsuccessmessageLB.setText("Search Succesful");
				
			 }
				con.close();
		
			
			}
			catch(Exception ex)
			{
				CRerrormessageLB.setText(("Error: " + ex.getMessage() ));
				// MessageLB.setText("Insert Failed");
			}
		
	}
	
	@FXML private void ShowPasswordcheckbox(ActionEvent event){
		 CRpasswordTF.managedProperty().bind(showpasswordCB.selectedProperty());
		 CRpasswordTF.visibleProperty().bind(showpasswordCB.selectedProperty());

		 CRpasswordPF.managedProperty().bind(showpasswordCB.selectedProperty().not());
		 CRpasswordPF.visibleProperty().bind(showpasswordCB.selectedProperty().not());

	    // Bind the textField and passwordField text values bidirectionally.
		 CRpasswordTF.textProperty().bindBidirectional(CRpasswordPF.textProperty());
		
	}
}
