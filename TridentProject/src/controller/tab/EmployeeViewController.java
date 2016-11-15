package controller.tab;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


	public class EmployeeViewController {
		ObservableList<Workers> data=FXCollections.observableArrayList();
			
			PreparedStatement preparedStatement=null;
			ResultSet rs=null;
			
			@FXML private TextField EfindTF;
			
			@FXML private TableView<Workers> Eemployeetableview;
			
			
		    @FXML TableColumn<?, ?> EemployeeIdCOL;
		    @FXML TableColumn<?, ?> EfirstFirstNameCOL;
		    @FXML TableColumn<?, ?> ElastFirstNameCOL;
		    @FXML TableColumn<?, ?> EbadgenumberCOL;
		    @FXML TableColumn<?, ?> EbirthdateCOL;
		    @FXML TableColumn<?, ?> EBirthDateCOL;
		    @FXML TableColumn<?, ?> EStreetNumberCOL;
		    @FXML TableColumn<?, ?> EcityCOL;
		    @FXML TableColumn<?, ?> EStreetNameCOL;
		    @FXML TableColumn<?, ?> EzipcodeCOL;
		    @FXML TableColumn<?, ?> EBadgeNumberCOL;
		    @FXML TableColumn<?, ?> ELastNameCOL;
		    
		    
			String DBFirstName = "TridentDB";
			String user = "user";
			String password= "Pass123456";
		    
			public void initialize(URL location, ResourceBundle resources)
			{
				EemployeeIdCOL.setCellValueFactory(new PropertyValueFactory<>("EmployeeId"));
				EfirstFirstNameCOL.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
				ElastFirstNameCOL.setCellValueFactory(new PropertyValueFactory<>("LastName"));
				EbadgenumberCOL.setCellValueFactory(new PropertyValueFactory<>("BadgeNumber"));
				EbirthdateCOL.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
				EBirthDateCOL.setCellValueFactory(new PropertyValueFactory<>("StreetNumber"));
				EStreetNumberCOL.setCellValueFactory(new PropertyValueFactory<>("StreetName"));
				EcityCOL.setCellValueFactory(new PropertyValueFactory<>("City"));
				EStreetNameCOL.setCellValueFactory(new PropertyValueFactory<>("State"));
				EzipcodeCOL.setCellValueFactory(new PropertyValueFactory<>("ZipCode"));
				EBadgeNumberCOL.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
				ELastNameCOL.setCellValueFactory(new PropertyValueFactory<>("Email"));
				EloadDatabase();
			}
		public void EloadDatabase()
			{
				// Uses JDBC to establish connection
						String connectionURL = "jdbc:sqlserver://localhost:1433;databaseFirstName=" + DBFirstName + ";user=" + user + ";password=" + password;
					
						
						try
						{
							Connection con = DriverManager.getConnection(connectionURL);
							
							//StreetNamement stmt = con.createStreetNamement();
							// StreetNamement inserts Information from Text Field into Database
							
							String query = "SELECT * FROM Employee ";
							// Commits to database		
							
							preparedStatement=con.prepareStatement(query);
							rs =preparedStatement.executeQuery(); 

					while (rs.next())
					{ 
						data.add(new Workers(
								rs.getString("EmployeeId"),
								rs.getString("FirstName"),
								rs.getString("LastName"),
								rs.getString("BadgeNumber"),
								rs.getString("BirthDate"),
								rs.getString("StreetNumber"),
								rs.getString("StreetName"),
								rs.getString("City"),
								rs.getString("State"),
								rs.getString("ZipCode"),
								rs.getString("PhoneNumber"),
								rs.getString("Email")				
								));
						
						Eemployeetableview.setItems(data);
					}
					
					
					 
					         // Closes connection
					preparedStatement.close();
					rs.close();
							con.close();
					
							// Shows Message for Feedback
							
						} //Catches errors
						
						catch(Exception ex)
						{
							//Shows error message
							System.err.println(ex);
							// MessageLB.setText("Insert Failed");
						}
						 
			}



		@FXML private void ERefreshBTClicked(ActionEvent event){

			data.clear();
			EfindString(event);
			
		}

		@FXML private void EReturnFullDatabase(ActionEvent event){

			data.clear();
			EloadDatabase();
		}

		@FXML private void EfindString(ActionEvent event){
			// Uses JDBC to establish connection
			
			data.clear();
			
			String findstring = EfindTF.getText();
			
			String connectionURL = "jdbc:sqlserver://localhost:1433;databaseFirstName=" + DBFirstName + ";user=" + user + ";password=" + password;

			
			try
			{
				Connection con = DriverManager.getConnection(connectionURL);
				
				//StreetNamement stmt = con.createStreetNamement();
				// StreetNamement inserts Information from Text Field into Database
				
				String query = "SELECT * FROM Employee WHERE FirstName LIKE '%" + findstring + "%' "
						+ "OR EmployeeId LIKE '%" + findstring + "%' "
						+ "OR LastName LIKE'%" + findstring + "%' "
						+ "OR BadgeNumber LIKE'%" + findstring + "%' "
						+ "OR BirthDate LIKE'%" + findstring + "%' "
						+ "OR StreetNumber LIKE'%" + findstring + "%' "
						+ "OR StreetName LIKE'%" + findstring + "%' "
						+ "OR City LIKE'%" + findstring + "%' "
						+ "OR State LIKE'%" + findstring + "%' "
						+ "OR ZipCode LIKE'%" + findstring + "%' " 
						+ "OR PhoneNumber LIKE'%" + findstring + "%' "
						+ "OR Email LIKE'%" + findstring + "%' ";
					
				
						
						// Commits to database		
				
				preparedStatement=con.prepareStatement(query);
				rs =preparedStatement.executeQuery(); 


		while (rs.next())
		{ 
			data.add(new Workers(
					rs.getString("EmployeeId"),
					rs.getString("FirstName"),
					rs.getString("LastName"),
					rs.getString("BadgeNumber"),
					rs.getString("BirthDate"),
					rs.getString("StreetNumber"),
					rs.getString("StreetName"),
					rs.getString("City"),
					rs.getString("State"),
					rs.getString("ZipCode"),
					rs.getString("PhoneNumber"),
					rs.getString("Email")					
					
					));
			
			Eemployeetableview.setItems(data);
		}


		 
		         // Closes connection
		preparedStatement.close();
		rs.close();
				con.close();

				// Shows Message for Feedback
				
			} //Catches errors
			
			catch(Exception ex)
			{
				//Shows error message
				System.err.println(ex);
				// MessageLB.setText("Insert Failed");
			}
			
	
}
	}

