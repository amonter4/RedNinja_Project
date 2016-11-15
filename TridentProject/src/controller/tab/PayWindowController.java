package controller.tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PayWindowController {

	@FXML private TextField PemployeeIDTF;
	@FXML private TextField PpayDateTF;
	@FXML private TextField PhourlyrateTF;
	@FXML private TextField PsalaryrateTF;
		
	@FXML private Label PsuccessmessageLB;
	@FXML private Label PerrormessageLB;
	
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";

	@FXML private void PInsertBTClicked(ActionEvent event){
		//Clears the Message Labels 
				PsuccessmessageLB.setText("");
				PerrormessageLB.setText("");
				
				String PemployeeID = PemployeeIDTF.getText();
				String Ppaydate = PpayDateTF.getText();
				String Phourlyrate = PhourlyrateTF.getText();
				String Psalaryrate =  PsalaryrateTF.getText();
				
				// Gets Text from TexFields and gives it to a String Variable
			

				// Changes Text type data to Int type data to follow database rules
				int employeeNum  = Integer.parseInt(PemployeeID);
				
			
				// Uses JDBC to establish connection
				String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
			
				
				try
				{
					Connection con = DriverManager.getConnection(connectionURL);
					
					Statement stmt = con.createStatement();
					// Statement inserts Information from Text Field into Database
					String sqlStatement = "Insert INTO PayRate " +
							"(EmployeeId,  EffectivePayDate, HourlyRate, SalaryRate) " +
							"VALUES(" + employeeNum + ", '" +  Ppaydate + "', '" + Psalaryrate + "', '" + Phourlyrate + "')";

				stmt.execute(sqlStatement);
			         // Closes connection
					con.close();
			
					// Shows Message for Feedback
					PsuccessmessageLB.setText("Insert Succesful");
				} //Catches errors
				
				catch(Exception ex)
				{
					//Shows error message
					PerrormessageLB.setText("Error: " + ex.getMessage());
					// MessageLB.setText("Insert Failed");
				}

	}
	
	@FXML private void PDeleteBTClicked(ActionEvent event){
		//Clears the Message Labels 
		PsuccessmessageLB.setText("");
		PerrormessageLB.setText("");
		
		String PemployeeID = PemployeeIDTF.getText();
		
		// Gets Text from TexFields and gives it to a String Variable
	

		// Changes Text type data to Int type data to follow database rules
		int employeeNum  = Integer.parseInt(PemployeeID);
		
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "DELETE FROM PayRate " +
					 "WHERE EmployeeId = " + employeeNum + "";

		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
			PsuccessmessageLB.setText("Delete Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			PerrormessageLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}

	}
	
	@FXML private void PUpdateBTClicked(ActionEvent event){
		PsuccessmessageLB.setText("");
		PerrormessageLB.setText("");
		
		
		String  Ppaydate = PpayDateTF.getText();
		String Phourlyrate = PhourlyrateTF.getText();
		String Psalaryrate =  PsalaryrateTF.getText();
		
		 String CRemployeetext = PemployeeIDTF.getText();
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
			String sqlStatement = "UPDATE PayRate " +
			"SET EmployeeId= "+CRemployeeNum+",  EffectivePayDate = '"+ Ppaydate+"', SalaryRate = '"+Psalaryrate+"', HourlyRate = '"+Phourlyrate+"' " +
			"WHERE  EmployeeId = " + CRemployeeNum + " ";

		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
			PsuccessmessageLB.setText("Update Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			PerrormessageLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}
	}
	
	@FXML private void PClearBTClicked(ActionEvent event){
		PsuccessmessageLB.setText("");
		PerrormessageLB.setText("");
		
		PemployeeIDTF.clear();
		PpayDateTF.clear();
		PsalaryrateTF.clear();
		PhourlyrateTF.clear();
		
		PsuccessmessageLB.setText("Clear Successful");
	}
	
	@FXML private void PSearchBTClicked(ActionEvent event){
		
		PsuccessmessageLB.setText("");
		PerrormessageLB.setText("");
		
		 String CRemployeetext = PemployeeIDTF.getText();
			int CRemployeeNum  = Integer.parseInt(CRemployeetext);
			
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		
			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				Statement stmt = con.createStatement();
				
				String sqlStatement ="SELECT * FROM PayRate WHERE EmployeeId = " + CRemployeeNum;
						
				ResultSet result = stmt.executeQuery(sqlStatement);
				
			 while (result.next())
			 {
				 
					PpayDateTF.setText((result.getString("EffectivePayDate")));
					PsalaryrateTF.setText((result.getString("SalaryRate")));
					PhourlyrateTF.setText((result.getString("HourlyRate")));
				 
					
					 PsuccessmessageLB.setText("Search Succesful");
				
			 }
				con.close();
		
			
			}
			catch(Exception ex)
			{
				PerrormessageLB.setText(("Error: " + ex.getMessage() ));
				// MessageLB.setText("Insert Failed");
			}
		
	}
	
	
		
	
}
