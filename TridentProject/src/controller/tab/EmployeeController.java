package controller.tab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmployeeController {
	
	@FXML private TextField EemployeeIDTF;
	@FXML private TextField EbadgenumberTF;
	@FXML private TextField EfirstnameTF;
	@FXML private TextField ElastnameTF;
	@FXML private TextField EbirthdateTF;
	@FXML private TextField EstreetnumTF;
	@FXML private TextField EstreetnameTF;
	@FXML private TextField EcityTF;
	@FXML private TextField EstateTF;
	@FXML private TextField EzipcodeTF;
	@FXML private TextField EphonenumberTF;
	@FXML private TextField EemailTF;
	
	@FXML private Label EerrormessageLB;
	@FXML private Label EsuccessmessageLB;
	
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";

	@FXML private void EinsertButtonClicked(ActionEvent event){
		//Clears the Message Labels 
				EerrormessageLB.setText("");
				EsuccessmessageLB.setText("");
				
				// Gets Text from TexFields and gives it to a String Variable
				String EemployeeID = EemployeeIDTF.getText();
				String Ebadgenumber =  EbadgenumberTF.getText();
				String Efirstname = EfirstnameTF.getText();
				String Elastname = ElastnameTF.getText();
				String Ebirthdate = EbirthdateTF.getText();
				String Estreetnumber = EstreetnumTF.getText();
				String Estreetname =  EstreetnameTF.getText();
				String Ecity = EcityTF.getText();
				String Estate =  EstateTF.getText();
				String Ezipcode= EzipcodeTF.getText();
				String Ephonenumber =  EphonenumberTF.getText();
				String Eemail = EemailTF.getText();
				

				// Changes Text type data to Int type data to follow database rules
				int EemployeeNum  = Integer.parseInt(EemployeeID);
				int EbadgeNum = Integer.parseInt( Ebadgenumber);
			
				// Uses JDBC to establish connection
				String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
			
				
				try
				{
					Connection con = DriverManager.getConnection(connectionURL);
					
					Statement stmt = con.createStatement();
					// Statement inserts Information from Text Field into Database
					String sqlStatement = "Insert INTO Employee " +
								"(EmployeeId, FirstName, LastName, BirthDate, BadgeNumber, StreetNumber, StreetName, City, State, ZipCode, PhoneNumber, Email) " +
								"VALUES(" + EemployeeNum + ", '" + Efirstname + "', '" + Elastname + "', '" + Ebirthdate + "', " + EbadgeNum + ", '" + Estreetnumber + "', '" + Estreetname + "', '" + Ecity + "', '" + Estate + "', '" + Ezipcode + "', '" + Ephonenumber + "', '" + Eemail + "')";
					// Commits to database		
				stmt.execute(sqlStatement);
			         // Closes connection
					con.close();
			
					// Shows Message for Feedback
					EsuccessmessageLB.setText("Insert Succesful");
				} //Catches errors
				
				catch(Exception ex)
				{
					//Shows error message
					EerrormessageLB.setText("Error: " + ex.getMessage());
					// MessageLB.setText("Insert Failed");
				}
	
}

	@FXML private void EupdateButtonClicked(ActionEvent event){

		//Clears the Message Labels 
		EerrormessageLB.setText("");
		EsuccessmessageLB.setText("");
		
		// Gets Text from TexFields and gives it to a String Variable
		String EemployeeID = EemployeeIDTF.getText();
		String Ebadgenumber =  EbadgenumberTF.getText();
		String Efirstname = EfirstnameTF.getText();
		String Elastname = ElastnameTF.getText();
		String Ebirthdate = EbirthdateTF.getText();
		String Estreetnumber = EstreetnumTF.getText();
		String Estreetname =  EstreetnameTF.getText();
		String Ecity = EcityTF.getText();
		String Estate =  EstateTF.getText();
		String Ezipcode= EzipcodeTF.getText();
		String Ephonenumber =  EphonenumberTF.getText();
		String Eemail = EemailTF.getText();
		

		// Changes Text type data to Int type data to follow database rules
		int EemployeeNum  = Integer.parseInt(EemployeeID);
		int EbadgeNum = Integer.parseInt( Ebadgenumber);
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
		
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "UPDATE Employee " +
						"SET EmployeeId = "+EemployeeNum+", FirstName = '"+Efirstname+"', LastName ='"+Elastname+"', BirthDate ='"+Ebirthdate+"', "
								+ "BadgeNumber = "+EbadgeNum+", StreetNumber = '"+Estreetnumber+"', StreetName = '"+Estreetname+"',"
										+ " City = '"+Ecity+"', State = '"+Estate+"', ZipCode = '"+Ezipcode+"', PhoneNumber = '"+Ephonenumber+"', Email = '"+Eemail+"' " +
										"WHERE   EmployeeId = " + EemployeeNum + " ";
			// Commits to database		
		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
			EsuccessmessageLB.setText("Update Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			EerrormessageLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}

		
		
	}
	@FXML private void EDeleteButtonClicked(ActionEvent event){
		
		EerrormessageLB.setText("");
		EsuccessmessageLB.setText("");
		
		 String Eemployeenumtext = EemployeeIDTF.getText();
		int Eemployeenum  = Integer.parseInt(Eemployeenumtext);
			
		
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement ="DELETE FROM Employee " +
								 "WHERE   EmployeeId = " + Eemployeenum + "";
					
	        stmt.execute(sqlStatement);
	         
			con.close();
			
			EsuccessmessageLB.setText("Delete Succesful"); 
		}
		
		catch(Exception ex)
		{
			EerrormessageLB.setText(("Error: " + ex.getMessage() ));
			// MessageLB.setText("Insert Failed");
		}
	}
	@FXML private void EsearchButtonClicked(ActionEvent event){

		
		EerrormessageLB.setText("");
		EsuccessmessageLB.setText("");
		
		 String Eemployeenumtext = EemployeeIDTF.getText();
			int Eemployeenum  = Integer.parseInt(Eemployeenumtext);
			
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		
			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				Statement stmt = con.createStatement();
				
				String sqlStatement ="SELECT * FROM Employee WHERE EmployeeId = " +Eemployeenum ;
						
				ResultSet result = stmt.executeQuery(sqlStatement);
				
				//EmployeeId, FirstName, LastName, BirthDate, BadgeNumber, StreetNumber, StreetName, City, State, ZipCode, PhoneNumber, Email
				
			 while (result.next())
			 {
				 
					EfirstnameTF.setText((result.getString("FirstName")));
					ElastnameTF.setText((result.getString("LastName")));
					EbirthdateTF.setText((result.getString("BirthDate")));
					EbadgenumberTF.setText((result.getString("BadgeNumber")));
					EstreetnumTF.setText((result.getString("StreetNumber"))); // may have to change to int
					EstreetnameTF.setText((result.getString("StreetName")));
					EcityTF.setText((result.getString("City")));
					EstateTF.setText((result.getString("State")));
					EzipcodeTF.setText((result.getString("ZipCode")));
					EphonenumberTF.setText((result.getString("PhoneNumber")));
					EemailTF.setText((result.getString("Email")));
				
					
					EsuccessmessageLB.setText("Search Succesful");
				
			 }
				con.close();
		
			
			}
			catch(Exception ex)
			{
				EerrormessageLB.setText(("Error: " + ex.getMessage() ));
				// MessageLB.setText("Insert Failed");
			}
			
	}
	@FXML private void EclearButtonClicked(ActionEvent event){
		
		EerrormessageLB.setText("");
		EsuccessmessageLB.setText("");
		
		EemployeeIDTF.clear();
		EbadgenumberTF.clear();
		EfirstnameTF.clear();
		ElastnameTF.clear();
		EbirthdateTF.clear();
		EstreetnumTF.clear();
		EstreetnameTF.clear();
		EcityTF.clear();
		EstateTF.clear();
		EzipcodeTF.clear();
		EphonenumberTF.clear();
		EemailTF.clear();
		
	
		EsuccessmessageLB.setText("Clear Succesful");
	}
	@FXML private void CredentialsClicked(ActionEvent event) throws IOException{
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CredentialWindow.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Credential Form");
		stage.setScene(new Scene(root1)); 
		stage.show();
		
	}
	
	@FXML private void payButtonClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/EmployeePayWindow.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Pay Form");
		stage.setScene(new Scene(root1)); 
		stage.show();
	}
	
	@FXML private void vacationButtonClicked(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/VacationWindow.fxml"));
		Parent root1 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Vacation Form");
		stage.setScene(new Scene(root1)); 
		stage.show();
		
	}
	@FXML private void EtableviewClicked(ActionEvent event) throws IOException{
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/EmployeeView.fxml"));
		Parent root2 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("View");
		stage.setScene(new Scene(root2)); 
		stage.show();
		
	}
}
