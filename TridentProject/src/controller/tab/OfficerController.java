package controller.tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class OfficerController {
	@FXML private TextField OofficernunTF;
	@FXML private TextField OemployeeidTF;
	@FXML private TextField OofficertypeTF;

	@FXML private Label OerrormessageLB;
	@FXML private Label OsuccessmessageLB;

	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
	
	@FXML private void OInsertBTClicked(ActionEvent event){
		//Clears the Message Labels 
			OsuccessmessageLB.setText("");
			OerrormessageLB.setText("");
				
				String firstv = OofficernunTF.getText();
				String secondv = OemployeeidTF.getText();
				String thirdv = OofficertypeTF.getText();
				
				
				// Gets Text from TexFields and gives it to a String Variable
			

				// Changes Text type data to Int type data to follow database rules
				int badgeNum  = Integer.parseInt(firstv);
				int  employeeNum = Integer.parseInt(secondv);
				
			
				// Uses JDBC to establish connection
				String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
			
				
				try
				{
					Connection con = DriverManager.getConnection(connectionURL);
					
					Statement stmt = con.createStatement();
					// Statement inserts Information from Text Field into Database
					String sqlStatement = "Insert INTO Officer " +
							"(EmployeeId, BadgeNumber, OfficerType) " +
							"VALUES(" + employeeNum + ", " + badgeNum + ", '" + thirdv+ "')";

				stmt.execute(sqlStatement);
			         // Closes connection
					con.close();
			
					// Shows Message for Feedback
				OsuccessmessageLB.setText("Insert Succesful");
				} //Catches errors
				
				catch(Exception ex)
				{
					//Shows error message
					OerrormessageLB.setText("Error: " + ex.getMessage());
					// MessageLB.setText("Insert Failed");
				}

	}
	
	@FXML private void ODeleteBTClicked(ActionEvent event){
		//Clears the Message Labels 
	OsuccessmessageLB.setText("");
	OerrormessageLB.setText("");
		
		String employeeID = OofficernunTF.getText();
		
		// Gets Text from TexFields and gives it to a String Variable
	

		// Changes Text type data to Int type data to follow database rules
		int badgeNum  = Integer.parseInt(employeeID);
		
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "DELETE FROM Officer " +
					 "WHERE BadgeNumber = " + badgeNum + "";

		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
		OsuccessmessageLB.setText("Delete Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			OerrormessageLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}

	}
	
	@FXML private void OUpdateBTClicked(ActionEvent event){
	OsuccessmessageLB.setText("");
		OerrormessageLB.setText("");
		
		
		String firstv = OemployeeidTF.getText();
		String secondv = OofficernunTF.getText();
		String thirdv=  OofficertypeTF.getText();
		
		int badgeNum  = Integer.parseInt(firstv);
		int  employeeNum = Integer.parseInt(secondv);
		
		
		// Gets Text from TexFields and gives it to a String Variable
	

		// Changes Text type data to Int type data to follow database rules
		
		
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			//EmployeeId, BadgeNumber, OfficerType, enddate
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "UPDATE Officer " +
			"SET EmployeeId = "+employeeNum+", BadgeNumber = '"+badgeNum+"', OfficerType= '"+thirdv+"' " +
			"WHERE  BadgeNumber = " + badgeNum + " ";
			

		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
		OsuccessmessageLB.setText("Update Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			OerrormessageLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}
	}
	
	@FXML private void ONClearBTClicked(ActionEvent event){
		OsuccessmessageLB.setText("");
		OerrormessageLB.setText("");
		
		OofficernunTF.clear();
		OemployeeidTF.clear();
		OofficertypeTF.clear();
		
		
	OsuccessmessageLB.setText("Clear Successful");
	}

	@FXML private void OSearchBTClicked(ActionEvent event){
		
		OsuccessmessageLB.setText("");
		OerrormessageLB.setText("");
		String firstv = OofficernunTF.getText();

		
		int badgeNum  = Integer.parseInt(firstv);
	
			
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		
			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				Statement stmt = con.createStatement();
				
				String sqlStatement ="SELECT * FROM Officer WHERE BadgeNumber = " + badgeNum;
						
				ResultSet result = stmt.executeQuery(sqlStatement);
				
			 while (result.next())
			 {
				 
					OemployeeidTF.setText((result.getString("EmployeeId")));
					OofficertypeTF.setText((result.getString("OfficerType")));
				
				 
					
					OsuccessmessageLB.setText("Search Succesful");
				
			 }
				con.close();
		
			
			}
			catch(Exception ex)
			{
				OerrormessageLB.setText(("Error: " + ex.getMessage() ));
				// MessageLB.setText("Insert Failed");
			}
		
	}
	
}
