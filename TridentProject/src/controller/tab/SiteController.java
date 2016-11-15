package controller.tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SiteController {

	@FXML private Button SInsertBT;
	@FXML private Button SUpdateBT;
	@FXML private Button SDeleteBT;
	@FXML private Button SClearBT;
	@FXML private Button SSearchBT;
	
	@FXML private TextField SsiteIDTF;
	@FXML private TextField SsitenameTF;
	@FXML private TextField ScityTF;
	@FXML private TextField SstateTF;
	@FXML private TextField SzipcodeTF;
	@FXML private TextField SsitedescriptionTF;
	
	@FXML private Label SerrormessageLB;
	@FXML private Label SsuccessmessageLB;
	
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
	
	//Fully Functional
@FXML private void SInsertBTClicked(ActionEvent event){
	
		

		//Clears the Message Labels 
		SsuccessmessageLB.setText("");
		SerrormessageLB.setText("");
		
		String siteID = SsiteIDTF.getText();
		String siteName = SsitenameTF.getText();
		String city = ScityTF.getText();
		String state = SstateTF.getText();
		String zipcode = SzipcodeTF.getText();
		String siteDescription = SsitedescriptionTF.getText();
		
		// Gets Text from TexFields and gives it to a String Variable
		
	
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "Insert INTO Site " +
						"(SiteId, SiteName, City, State, ZipCode, SiteDescription) " +
						"VALUES('" + siteID + "', '" + siteName + "', '" + city + "', '" + state + "', '" + zipcode + "', '" + siteDescription + "' )";
			
			// Commits to database		
		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
			SsuccessmessageLB.setText("Insert Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			SerrormessageLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}
		
	}
	
@FXML private void SUpdateBTClicked(ActionEvent event){

	SsuccessmessageLB.setText("");
	SerrormessageLB.setText("");

	String siteID = SsiteIDTF.getText();
	String siteName = SsitenameTF.getText();
	String city = ScityTF.getText();
	String state = SstateTF.getText();
	String zipcode = SzipcodeTF.getText();
	String siteDescription = SsitedescriptionTF.getText();
	

	 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	//final String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=TridentDB;user=user;password=Pass123456";
	
	try
	{
		Connection con = DriverManager.getConnection(connectionURL);
		
		Statement stmt = con.createStatement();
		
		String sqlStatement = "UPDATE Site " +
                "SET SiteName = '" + siteName + "', City = '" + city + "', State = '" + state + "',  ZipCode = '" + zipcode + "', SiteDescription = '" + siteDescription + "'  "  +
                "WHERE  SiteId = '" + siteID  + "' ";
		 stmt.execute(sqlStatement);
		
	
		//System.out.println("Connected");
		con.close();
		 SsuccessmessageLB.setText("Update Succesful");
	}
	
	catch(Exception ex)
	{
		SerrormessageLB.setText(("Error: " + ex.getMessage() ));
	}
		
	}

@FXML private void SDeleteBTClicked(ActionEvent event){
	
	SsuccessmessageLB.setText("");
	SerrormessageLB.setText("");
	
	 String siteID = SsiteIDTF.getText();
	
	
	 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;

	
	try
	{
		Connection con = DriverManager.getConnection(connectionURL);
		
		Statement stmt = con.createStatement();
		
		String sqlStatement ="DELETE FROM Site " +
							 "WHERE SiteId = '" + siteID + "' ";
				
        stmt.execute(sqlStatement);
         
		con.close();
		
		 SsuccessmessageLB.setText("Delete Succesful"); 
	}
	
	catch(Exception ex)
	{
		SerrormessageLB.setText(("Error: " + ex.getMessage() ));
		// MessageLB.setText("Insert Failed");
	}
	
}

@FXML private void SClearBTClicked(ActionEvent event){
	SsuccessmessageLB.setText("");
	SerrormessageLB.setText("");
	
	SsiteIDTF.clear();
	SsitenameTF.clear();
	ScityTF.clear();
	SstateTF.clear();
	SzipcodeTF.clear();
	SsitedescriptionTF.clear();


	 SsuccessmessageLB.setText("Clear Succesful");
	
	
}

@FXML private void SSearchBTClicked(ActionEvent event){
	
	SsuccessmessageLB.setText("");
	SerrormessageLB.setText("");
	
	 String siteID = SsiteIDTF.getText();
		
		
	 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement ="SELECT * FROM Site WHERE SiteId = '" + siteID + "' ";
					
			ResultSet result = stmt.executeQuery(sqlStatement);
			
		 while (result.next())
		 {
			 
			 SsitenameTF.setText((result.getString("SiteName")));
			 ScityTF.setText((result.getString("City")));
			 SstateTF.setText((result.getString("State")));
			 SzipcodeTF.setText((result.getString("ZipCode")));
			 SsitedescriptionTF.setText((result.getString("SiteDescription"))); 
			
				
				SsuccessmessageLB.setText("Search Succesful");
			
		 }
			con.close();
	
		
		}
		catch(Exception ex)
		{
			SerrormessageLB.setText(("Error: " + ex.getMessage() ));
			// MessageLB.setText("Insert Failed");
		}
	
		
}
	
}

