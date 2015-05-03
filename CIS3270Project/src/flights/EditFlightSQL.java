package flights;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import users.Admin;
import users.Customer;

public class EditFlightSQL {
	
	PreparedStatement prep;
	
	public  void createFlight(Flight flight) throws ClassNotFoundException, SQLException{
		
		// Load the JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
	   
	    // Establish a connection
	    Connection connection = DriverManager.getConnection
	      ("jdbc:mysql://localhost/cis3270?"
              + "user=sqluser&password=sqluserpw");
	    
	    //Create a statement
	    Statement statement = connection.createStatement();

	    /*flight table column indexes
	     * flight_number 1
	     * origin 2
	     * destination 3
	     * departure_date 4
	     * departure_time 5
	     * arrival_date 6
	     * arrival_time 7
	     * airlines 8
	     * passengers 9 
		  */
	    // Execute a statement
	    
	    prep = connection.prepareStatement("INSERT INTO flight VALUES (default, ?, ?, ?, ? , ? , ? , ?, 0)");
	    prep.setString(1, flight.getOrigin());
	    prep.setString(2, flight.getDestination());
	    prep.setString(3, flight.getDepartureDate());
	    prep.setString(4, flight.getDepartureTime());
	    prep.setString(5, flight.getArrivalDate());
	    prep.setString(6, flight.getArrivalTime());
	    prep.setString(7, flight.getAirlines());
	    prep.executeUpdate();

	    //close connection
	   connection.close();
	  
	}

}
