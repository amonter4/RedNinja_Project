package controller.tab;

// All needed libraries 
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;


public class clientController {
	

	// Lets us use our buttons from our client tab in GUI
	@FXML private Button CInsertBT;
	@FXML private Button CUpdateBT;
	@FXML private Button CDeleteBT;
	@FXML private Button CClearBT;
	@FXML private Button CSearchBT;
	@FXML private Button CtableviewBT;
	
	// Lets us use our TextFields from our client tab in GUI
	@FXML private TextField CClientNumTF;
	@FXML private TextField CPhoneNumTF;
	@FXML private TextField CemailTF;
	@FXML private TextField CCompanyNTF;
	@FXML private TextField CCompanyTTF;
	@FXML private TextField CContactTTF;
	@FXML private TextField CCityTF;
	@FXML private TextField CZipCodeTF;
	@FXML private TextField CStateTF;
	@FXML private TextField CNameTF;
	@FXML private TextField CStreetNumTF;
	@FXML private TextField CStreetNameTF;
	@FXML private TextField CConNameTF;
	
	// Allows Label to be used, Label will give the user feedback whether the button worked.
	@FXML private Label MessageLB;
	@FXML private Label ErrorMessageLB1;
	
	//Credentials for the database
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
	
	//Insert Client Information to database
	@FXML private void CInsertBTClicked(ActionEvent event){
		
		//Clears the Message Labels 
		MessageLB.setText("");
		ErrorMessageLB1.setText("");
		
		// Gets Text from TexFields and gives it to a String Variable
		String clientNumText = CClientNumTF.getText();
		String phoneNumber =  CPhoneNumTF.getText();
		String email = CemailTF.getText();
		String companyName = CCompanyNTF.getText();
		String companyType = CCompanyTTF.getText();
		String contactTimeText = CContactTTF.getText();
		String city =  CCityTF.getText();
		String zipCode = CZipCodeTF.getText();
		String state = CStateTF.getText();
		String name = CNameTF.getText();
		String streetNum =  CStreetNumTF.getText();
		String streetName = CStreetNameTF.getText();
		String contactName= CConNameTF.getText();

		// Changes Text type data to Int type data to follow database rules
		int clientNum  = Integer.parseInt(clientNumText);
		int contractTime = Integer.parseInt(contactTimeText);
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "Insert INTO Client " +
						"(ClientId, CompanyName, Name, Email, CompanyType, ContractLength, StreetNumber, StreetName, City, State, ZipCode, PhoneNumber, ContactName) " +
						"VALUES(" + clientNum + ",'" + companyName + "', '" + name +  "', '" + email + "', '" + companyType + "', " +  contractTime + ", '" + streetNum + "', '" + streetName + "','" + city + "', '" + state +  "', '" + zipCode + "','" + phoneNumber + "', '" + contactName + "')";
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
	// Update Client Information to database
	@FXML private void CUpdateBTTClicked(ActionEvent event){
		
		MessageLB.setText("");
		ErrorMessageLB1.setText("");
		
		String clientNumText = CClientNumTF.getText();
		String phoneNumber =  CPhoneNumTF.getText();
		String email = CemailTF.getText();
		String companyName = CCompanyNTF.getText();
		String companyType = CCompanyTTF.getText();
		String contactTimeText = CContactTTF.getText();
		String city =  CCityTF.getText();
		String zipCode = CZipCodeTF.getText();
		String state = CStateTF.getText();
		String name = CNameTF.getText();
		String streetNum =  CStreetNumTF.getText();
		String streetName = CStreetNameTF.getText();
		String contactName= CConNameTF.getText();


		int clientNum  = Integer.parseInt(clientNumText);
		int contractTime = Integer.parseInt(contactTimeText);

		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		//final String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=TridentDB;user=user;password=Pass123456";
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement = "UPDATE Client " +
                    "SET CompanyName = '" + companyName + "', Name = '" + name + "', Email = '" + email +  "', CompanyType = '" + companyType + "',"
                    + " ContractLength = " + contractTime +  ", StreetNumber = '" + streetNum + "', StreetName = '" + streetName + "',"
                    + " City = '" + city + "', State = '" + state + "', ZipCode = '" + zipCode + "', PhoneNumber = '" + phoneNumber + "', "
                    + "ContactName = '" + contactName + "'   "  +
                    "WHERE  ClientId = " + clientNum + " ";
			 stmt.execute(sqlStatement);
			
		
			//System.out.println("Connected");
			con.close();
			 MessageLB.setText("Update Succesful");
		}
		
		catch(Exception ex)
		{
			ErrorMessageLB1.setText(("Error: " + ex.getMessage() ));
		}
		
	}
	//Delete Client Information from database
	@FXML private void  CDeleteBTClicked(ActionEvent event){
		
		MessageLB.setText("");
		ErrorMessageLB1.setText("");
		
		String clientNumText = CClientNumTF.getText();
		int clientNum  = Integer.parseInt(clientNumText);
		
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement ="DELETE FROM Client " +
								 "WHERE ClientId = " + clientNum + "";
					
	        stmt.execute(sqlStatement);
	         
			con.close();
			
			 MessageLB.setText("Delete Succesful"); 
		}
		
		catch(Exception ex)
		{
			ErrorMessageLB1.setText(("Error: " + ex.getMessage() ));
			// MessageLB.setText("Insert Failed");
		}
		


	}
	//Clears everything in client GUI
	@FXML private void CClearBTClicked(ActionEvent event){
		MessageLB.setText("");
		ErrorMessageLB1.setText("");
		
		CClientNumTF.clear();
		CPhoneNumTF.clear();
		CemailTF.clear();
		CCompanyNTF.clear();
		CCompanyTTF.clear();
		CContactTTF.clear();
		CCityTF.clear();
		CZipCodeTF.clear();
		CStateTF.clear();
		CNameTF.clear();
		CStreetNumTF.clear();
		CStreetNameTF.clear();
		CConNameTF.clear(); 
	
		 MessageLB.setText("Clear Succesful");
		
		
	}
	//Search for Client information using their CClientNunTF
	@FXML private void CSearchBTClicked(ActionEvent event){

		
		MessageLB.setText("");
		ErrorMessageLB1.setText("");
		
		 String clientNumText = CClientNumTF.getText();
			int clientNum  = Integer.parseInt(clientNumText);
			
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		
			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				Statement stmt = con.createStatement();
				
				String sqlStatement ="SELECT * FROM Client WHERE ClientId = " + clientNum;
						
				ResultSet result = stmt.executeQuery(sqlStatement);
				
			 while (result.next())
			 {
				 
					CCompanyNTF.setText((result.getString("CompanyName")));
					CPhoneNumTF.setText((result.getString("PhoneNumber")));
					CemailTF.setText((result.getString("Email")));
					CCompanyTTF.setText((result.getString("CompanyType")));
					CContactTTF.setText((result.getString("ContractLength"))); // may have to change to int
					CCityTF.setText((result.getString("City")));
					CZipCodeTF.setText((result.getString("ZipCode")));
					CStateTF.setText((result.getString("State")));
					CNameTF.setText((result.getString("Name")));
					CStreetNumTF.setText((result.getString("StreetNumber")));
					CStreetNameTF.setText((result.getString("StreetName")));
					CConNameTF.setText((result.getString("ContactName"))); 
					
					 MessageLB.setText("Search Succesful");
				
			 }
				con.close();
		
			
			}
			catch(Exception ex)
			{
				ErrorMessageLB1.setText(("Error: " + ex.getMessage() ));
				// MessageLB.setText("Insert Failed");
			}
		
			
	}
	
	@FXML private void CtableviewClicked(ActionEvent event) throws IOException{
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ClientViewWindow.fxml"));
		Parent root2 = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("View");
		stage.setScene(new Scene(root2)); 
		stage.show();
		
	}
}
	
	
