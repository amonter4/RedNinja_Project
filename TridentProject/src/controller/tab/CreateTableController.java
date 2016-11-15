package controller.tab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CreateTableController {
	@FXML private Button CTcreatetableBT;
	@FXML private Button CTClearBT;
	
	@FXML private TextArea CTsqlstatementTA;
	
	@FXML private Label CTerrorlabel;
	@FXML private Label CTsuccessLabel;
	
	String DBName = "TridentDB";
	String user = "user";
	String password= "Pass123456";
	
@FXML private void CTcreatetableBTClicked(ActionEvent event){
	String TAsqlstatement = CTsqlstatementTA.getText();
	
	CTerrorlabel.setText("");
	CTsuccessLabel.setText("");
	
	 String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=" + DBName + ";user=" + user + ";password=" + password;
	
		
		try
		{
			Connection con = DriverManager.getConnection(connectionURL);
			
			Statement stmt = con.createStatement();
			
			String sqlStatement = TAsqlstatement;
					
			 stmt.execute(sqlStatement);
			
		
			con.close();
			
			CTsuccessLabel.setText("Table Created");
	
		
		}
		catch(Exception ex)
		{
			CTerrorlabel.setText(("Error: " + ex.getMessage() ));
			// MessageLB.setText("Insert Failed");
		}
	
		
}
	
		
	
	
@FXML private void CTClearBTClicked(ActionEvent event){
		
	CTerrorlabel.setText("");
	CTsuccessLabel.setText("");
	CTsqlstatementTA.clear();
	
	CTsuccessLabel.setText("Clear Succesful");
	
	}
}
