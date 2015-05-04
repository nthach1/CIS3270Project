package registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classes.Admin;
import classes.Customer;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class RegisterSQL {
	
	private PreparedStatement prep;
	
	
	//method to register Admin into user table
	public void registerAdmin(Admin a) throws ClassNotFoundException, SQLException{
		
		// Load the JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
	   
	    // Establish a connection
	    Connection connection = DriverManager.getConnection
	      ("jdbc:mysql://localhost/cis3270?"
              + "user=sqluser&password=sqluserpw");
	    
	    //Create a statement
	    Statement statement = connection.createStatement();

	    // use prepared statement
	    
	    /*user table column indexes
		   username 1
		   password 2
		   first_name 3
		   last_name 4
		   address 5
		   zip 6
		   state 7
		   city 8
		   email 9
		   snn 10
		   security question 11
		   answer 12
		   admin 13*/
	   
	   prep = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	   prep.setString(1, a.getUsername());
	   prep.setString(2, a.getPassword());
	   prep.setString(3, a.getFirstName());
	   prep.setString(4, a.getLastName());
	   prep.setString(5, a.getAddress());
	   prep.setString(6, a.getZip());
	   prep.setString(7, a.getCity());
	   prep.setString(8, a.getState());
	   prep.setString(9, a.getEmail());
	   prep.setString(10, a.getSsn());
	   prep.setString(11, a.getSecurityQuestion());
	   prep.setString(12, a.getSecurityAnswer());
	   prep.setString(13, "1");
	   prep.executeUpdate();
	    

	    // Close the connection
	    connection.close();
	    
	}
	
	//method to register Customer into user table
	public void registerCustomer(Customer a) throws ClassNotFoundException, SQLException{
		
		// Load the JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
	   
	    // Establish a connection
	    Connection connection = DriverManager.getConnection
	      ("jdbc:mysql://localhost/cis3270?"
              + "user=sqluser&password=sqluserpw");
	    
	    //Create a statement
	    Statement statement = connection.createStatement();

	    // use prepared statement
	   
	   prep = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
	   prep.setString(1, a.getUsername());
	   prep.setString(2, a.getPassword());
	   prep.setString(3, a.getFirstName());
	   prep.setString(4, a.getLastName());
	   prep.setString(5, a.getAddress());
	   prep.setString(6, a.getZip());
	   prep.setString(7, a.getCity());
	   prep.setString(8, a.getState());
	   prep.setString(9, a.getEmail());
	   prep.setString(10, a.getSsn());
	   prep.setString(11, a.getSecurityQuestion());
	   prep.setString(12, a.getSecurityAnswer());
	   prep.setString(13, "0");
	   prep.executeUpdate();
	    

	    // Close the connection
	    connection.close();
	    
	}

}
