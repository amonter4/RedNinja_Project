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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClientViewController  { 
	ObservableList<Client> data=FXCollections.observableArrayList();
	
	PreparedStatement preparedStatement=null;
	ResultSet rs=null;
	
	@FXML private TextField VfindTF;
	@FXML private Button VfindBT;
	
	@FXML private TableView<Client> ClientTableview;
	
	@FXML private Button CrefreshBT;
	

	
	
    @FXML TableColumn<?, ?> CcolumnclientID;
    @FXML TableColumn<?, ?> Ccolumnname;
    @FXML TableColumn<?, ?> Ccolumnemail;
    @FXML TableColumn<?, ?> Ccolumnphonenumber;
    @FXML TableColumn<?, ?> Ccolumnstreetnumber;
    @FXML TableColumn<?, ?> Ccolumnstreetname;
    @FXML TableColumn<?, ?> Ccolumnstate;
    @FXML TableColumn<?, ?> CColumncompanyname;
    @FXML TableColumn<?, ?> Ccompanytype;
    @FXML TableColumn<?, ?> Ccolumncontractlength;
    @FXML TableColumn<?, ?> Ccolumncontractname;
    @FXML TableColumn<?, ?> Ccolumnzipcode;
    @FXML TableColumn<?, ?> Ccolumncity;
    
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
    

	public void initialize(URL location, ResourceBundle resources)
	{
		CcolumnclientID.setCellValueFactory(new PropertyValueFactory<>("ClientId"));
		Ccolumnname.setCellValueFactory(new PropertyValueFactory<>("Name"));
		Ccolumnemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		Ccolumnphonenumber.setCellValueFactory(new PropertyValueFactory<>("PhoneNumber"));
		Ccolumnstreetnumber.setCellValueFactory(new PropertyValueFactory<>("StreetNumber"));
		Ccolumnstreetname.setCellValueFactory(new PropertyValueFactory<>("StreetName"));
		Ccolumnstate.setCellValueFactory(new PropertyValueFactory<>("State"));
		CColumncompanyname.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
		Ccompanytype.setCellValueFactory(new PropertyValueFactory<>("CompanyType"));
		Ccolumncontractlength.setCellValueFactory(new PropertyValueFactory<>("ContractLength"));
		Ccolumncontractname.setCellValueFactory(new PropertyValueFactory<>("ContactName"));
		Ccolumnzipcode.setCellValueFactory(new PropertyValueFactory<>("ZipCode"));
		Ccolumncity.setCellValueFactory(new PropertyValueFactory<>("City"));
		loadDatabase();
	}
public void loadDatabase()
	{
		// Uses JDBC to establish connection
				String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
			
				
				try
				{
					Connection con = DriverManager.getConnection(connectionURL);
					
					//Statement stmt = con.createStatement();
					// Statement inserts Information from Text Field into Database
					
					String query = "SELECT * FROM CLIENT ";
					// Commits to database		
					
			preparedStatement=con.prepareStatement(query);
			rs =preparedStatement.executeQuery();
			
			while (rs.next())
			{ 
				data.add(new Client(
						rs.getString("ClientId"),
						rs.getString("Name"),
						rs.getString("Email"),
						rs.getString("PhoneNumber"),
						rs.getString("StreetNumber"),
						rs.getString("StreetName"),
						rs.getString("State"),
						rs.getString("CompanyName"),
						rs.getString("CompanyType"),
						rs.getString("ContractLength"),
						rs.getString("ContactName"),
						rs.getString("ZipCode"),					
						rs.getString("City")
						));
				
				ClientTableview.setItems(data);
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



@FXML private void CRefreshBTClicked(ActionEvent event){

	data.clear();
	VfindString(event);
	
}

@FXML private void VReturnFullDatabase(ActionEvent event){

	data.clear();
	loadDatabase();
}

@FXML private void VfindString(ActionEvent event){
	// Uses JDBC to establish connection
	
	data.clear();
	
	String findstring = VfindTF.getText();
	
	String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;

	
	try
	{
		Connection con = DriverManager.getConnection(connectionURL);
		
		//Statement stmt = con.createStatement();
		// Statement inserts Information from Text Field into Database
		
		String query = "SELECT * FROM CLIENT WHERE Name LIKE '%" + findstring + "%' "
				+ "OR ClientiD LIKE '%" + findstring + "%' "
				+ "OR Email LIKE'%" + findstring + "%' "
				+ "OR PhoneNumber LIKE'%" + findstring + "%' "
				+ "OR StreetNumber LIKE'%" + findstring + "%' "
				+ "OR StreetName LIKE'%" + findstring + "%' "
				+ "OR State LIKE'%" + findstring + "%' "
				+ "OR CompanyName LIKE'%" + findstring + "%' "
				+ "OR CompanyType LIKE'%" + findstring + "%' "
				+ "OR ContractLength LIKE'%" + findstring + "%' " 
				+ "OR ContactName LIKE'%" + findstring + "%' "
				+ "OR ZipCode LIKE'%" + findstring + "%' "
				+ "OR City LIKE'%" + findstring + "%' ";
		
				
				// Commits to database		
		
preparedStatement=con.prepareStatement(query);
rs =preparedStatement.executeQuery(); 

while (rs.next())
{ 
	data.add(new Client(
			rs.getString("ClientId"),
			rs.getString("Name"),
			rs.getString("Email"),
			rs.getString("PhoneNumber"),
			rs.getString("StreetNumber"),
			rs.getString("StreetName"),
			rs.getString("State"),
			rs.getString("CompanyName"),
			rs.getString("CompanyType"),
			rs.getString("ContractLength"),
			rs.getString("ContactName"),
			rs.getString("ZipCode"),					
			rs.getString("City")
			));
	
	ClientTableview.setItems(data);
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
