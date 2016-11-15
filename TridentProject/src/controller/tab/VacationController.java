package controller.tab;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class VacationController {

	@FXML private TextField V1employeeTF;
	@FXML private TextField V1vacationdaysTF;
	@FXML private TextField V1startdate;
	@FXML private TextField V1enddateTF;

	
	@FXML private Label V1errorLB;
	@FXML private Label V1successLabel;

	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
	
	@FXML private void V1InsertBTClicked(ActionEvent event){
		//Clears the Message Labels 
			V1successLabel.setText("");
				V1errorLB.setText("");
				
				String employeeID = V1employeeTF.getText();
				String daysaccrud = V1vacationdaysTF.getText();
				String startdate = V1startdate.getText();
				String enddate =  V1enddateTF.getText();
				
				// Gets Text from TexFields and gives it to a String Variable
			

				// Changes Text type data to Int type data to follow database rules
				int employeeNum  = Integer.parseInt(employeeID);
				int dayNum  = Integer.parseInt(daysaccrud);
				
			
				// Uses JDBC to establish connection
				String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
			
				
				try
				{
					Connection con = DriverManager.getConnection(connectionURL);
					
					Statement stmt = con.createStatement();
					// Statement inserts Information from Text Field into Database
					String sqlStatement = "Insert INTO Vacation " +
							"(EmployeeId, DaysAccrued, StartDate , enddate) " +
							"VALUES(" + employeeNum + ", " + dayNum + ", '" + startdate + "', '" + enddate + "')";

				stmt.execute(sqlStatement);
			         // Closes connection
					con.close();
			
					// Shows Message for Feedback
				V1successLabel.setText("Insert Succesful");
				} //Catches errors
				
				catch(Exception ex)
				{
					//Shows error message
					V1errorLB.setText("Error: " + ex.getMessage());
					// MessageLB.setText("Insert Failed");
				}

	}
	
	@FXML private void V1DeleteBTClicked(ActionEvent event){
		//Clears the Message Labels 
	V1successLabel.setText("");
		V1errorLB.setText("");
		
		String employeeID = V1employeeTF.getText();
		
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
			String sqlStatement = "DELETE FROM Vacation " +
					 "WHERE EmployeeId = " + employeeNum + "";

		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
		V1successLabel.setText("Delete Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			V1errorLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}

	}
	
	@FXML private void V1UpdateBTClicked(ActionEvent event){
	V1successLabel.setText("");
		V1errorLB.setText("");
		
		
		String daysaccrued = V1vacationdaysTF.getText();
		String enddate = V1startdate.getText();
		String startdate =  V1enddateTF.getText();
		
		 String CRemployeetext = V1employeeTF.getText();
			int CRemployeeNum  = Integer.parseInt(CRemployeetext);
		
		// Gets Text from TexFields and gives it to a String Variable
	

		// Changes Text type data to Int type data to follow database rules
		
		
	
		// Uses JDBC to establish connection
		String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			//EmployeeId, DaysAccrued, StartDate , enddate
			Statement stmt = con.createStatement();
			// Statement inserts Information from Text Field into Database
			String sqlStatement = "UPDATE Vacation " +
			"SET EmployeeId = "+CRemployeeNum+", DaysAccrued = '"+daysaccrued+"', StartDate = '"+startdate+"', EndDate = '"+enddate+"' " +
			"WHERE  EmployeeId = " + CRemployeeNum + " ";

		stmt.execute(sqlStatement);
	         // Closes connection
			con.close();
	
			// Shows Message for Feedback
		V1successLabel.setText("Update Succesful");
		} //Catches errors
		
		catch(Exception ex)
		{
			//Shows error message
			V1errorLB.setText("Error: " + ex.getMessage());
			// MessageLB.setText("Insert Failed");
		}
	}
	
	@FXML private void V1ClearBTClicked(ActionEvent event){
	V1successLabel.setText("");
		V1errorLB.setText("");
		
		V1employeeTF.clear();
		V1vacationdaysTF.clear();
		V1enddateTF.clear();
		V1startdate.clear();
		
	V1successLabel.setText("Clear Successful");
	}
	
	@FXML private void SearchBTClicked(ActionEvent event){
		
		V1successLabel.setText("");
		V1errorLB.setText("");
		
		 String CRemployeetext = V1employeeTF.getText();
			int CRemployeeNum  = Integer.parseInt(CRemployeetext);
			
		 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
		
			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				Statement stmt = con.createStatement();
				
				String sqlStatement ="SELECT * FROM Vacation WHERE EmployeeId = " + CRemployeeNum;
						
				ResultSet result = stmt.executeQuery(sqlStatement);
				
			 while (result.next())
			 {
				 
					V1vacationdaysTF.setText((result.getString("DaysAccrued")));
					V1enddateTF.setText((result.getString("EndDate")));
					V1startdate.setText((result.getString("StartDate")));
				 
					
					V1successLabel.setText("Search Succesful");
				
			 }
				con.close();
		
			
			}
			catch(Exception ex)
			{
				V1errorLB.setText(("Error: " + ex.getMessage() ));
				// MessageLB.setText("Insert Failed");
			}
		
	}
	

}
