package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerFromSQL {
	
	private PreparedStatement prep;

	public Customer createCustomer(String a) throws ClassNotFoundException, SQLException{
		
		Admin customer = new Admin();
		// Load the JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
	   
	    // Establish a connection
	    Connection connection = DriverManager.getConnection
	      ("jdbc:mysql://localhost/cis3270?"
              + "user=sqluser&password=sqluserpw");
	
	    
	    // Create a statement
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
	   
	   prep = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
	   prep.setString(1, a);
	   ResultSet rs = prep.executeQuery();
	   
	   

	   rs.next();
	  
	   
		  customer.setUsername(rs.getString(1));
		  customer.setPassword(rs.getString(2));
		  customer.setFirstName(rs.getString(3));
		  customer.setLastName(rs.getString(4));
		  customer.setAddress(rs.getString(5));
		  customer.setZip(rs.getString(6));
		  customer.setState(rs.getString(7));
		  customer.setCity(rs.getString(8));
		  customer.setEmail(rs.getString(9));
		  customer.setSsn(rs.getString(10));
		  customer.setSecurityQuestion(rs.getString(11));
		  customer.setSecurityAnswer(rs.getString(12));
		  customer.setAdminKey(Integer.parseInt(rs.getString(13)));
	   

	
	    // Close the connection
	    connection.close();
	  
	    return customer;
	    
	}
	
public Admin createAdmin(String a) throws ClassNotFoundException, SQLException{
		
		Admin admin = new Admin();
		// Load the JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
	   
	    // Establish a connection
	    Connection connection = DriverManager.getConnection
	      ("jdbc:mysql://localhost/cis3270?"
              + "user=sqluser&password=sqluserpw");
	
	    
	    // Create a statement
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
	   
	   prep = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
	   prep.setString(1, a);
	   ResultSet rs = prep.executeQuery();
	   
	   

	   rs.next();
	  
	   
		  admin.setUsername(rs.getString(1));
		  admin.setPassword(rs.getString(2));
		  admin.setFirstName(rs.getString(3));
		  admin.setLastName(rs.getString(4));
		  admin.setAddress(rs.getString(5));
		  admin.setZip(rs.getString(6));
		  admin.setState(rs.getString(7));
		  admin.setCity(rs.getString(8));
		  admin.setEmail(rs.getString(9));
		  admin.setSsn(rs.getString(10));
		  admin.setSecurityQuestion(rs.getString(11));
		  admin.setSecurityAnswer(rs.getString(12));
		  admin.setAdminKey(Integer.parseInt(rs.getString(13)));
	   

	
	    // Close the connection
	    connection.close();
	  
	    return admin;
	    
	}
}

