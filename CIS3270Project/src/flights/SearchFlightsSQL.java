package flights;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Admin;
import classes.Customer;
import classes.Flight;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class SearchFlightsSQL {
	
	PreparedStatement prep;
	
	//method that creates an Array List of flight cities. Index 0 holds arraylist of origins. Index 1 holds arraylist of destiantions
	
	public  ArrayList<Object> getFlightCities() throws ClassNotFoundException, SQLException{
		
		//arraylist of cities
		ArrayList<Object> flightCities = new ArrayList<Object>();
		
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
	    
	    //get Origins
	    ResultSet origin = statement.executeQuery
	      ("SELECT origin FROM flight GROUP BY origin");
	   
	    ArrayList<Object> originList = new ArrayList<Object>();
	    
	    while (origin.next()) 
	    {
	    originList.add(origin.getString(1));
	    }
	    
	  //get destinations
	    ResultSet destination = statement.executeQuery
	      ("SELECT destination FROM flight GROUP BY destination");
	   
	    ArrayList<Object> destinationList = new ArrayList<Object>();
	    
	    while (destination.next()) 
	    {
	    destinationList.add(destination.getString(1));
	    }
	    //close connection
	   connection.close();
	   
	   //adds origins array and destination arra to arraylist
	   flightCities.add(originList);
	   flightCities.add(destinationList);
	   
	   //return arraylist of cities
	  return flightCities;
	    
	
	}
	
	
	//method to pull flights that match the origin, destination, and departure date from flight table
public  ResultSet showFlights(String origin, String destination, String departureDate) throws ClassNotFoundException, SQLException{
		
		
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
	    
	   prep = connection.prepareStatement("SELECT * FROM flight where origin = ? AND destination = ? AND departure_date = ?");
	   prep.setString(1, origin);
	   prep.setString(2, destination);
	   prep.setString(3, departureDate);

	  ResultSet matchingFlights = prep.executeQuery();
	  

	   //return resultSet
	  return matchingFlights;
	    
	
	}

//method to book flight by insterting username and flightnumbe into ticket table

public void bookFlights(String username, String flightNumber ) throws ClassNotFoundException, SQLException{
	
	// Load the JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
   
    // Establish a connection
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/cis3270?"
          + "user=sqluser&password=sqluserpw");
    
    //Create a statement
    Statement statement = connection.createStatement();

    /*flight table column indexes
     ticket_number 1
     username 2
     flight_number 3
     seat_number 4
     
	  */
    // Execute a statement
    
   prep = connection.prepareStatement("INSERT INTO ticket VALUES (default, ?, ?, default)");
   prep.setString(1, username);
   prep.setString(2, flightNumber);
   prep.executeUpdate();
  

   //close connection
   connection.close();

	}

//method to pull ticket information for specific customer

public ResultSet viewFlights(Customer customer ) throws ClassNotFoundException, SQLException{
	
	// Load the JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
   
    // Establish a connection
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/cis3270?"
          + "user=sqluser&password=sqluserpw");
    
    //Create a statement
    Statement statement = connection.createStatement();

    /*flight table column indexes
     ticket_number 1
     username 2
     flight_number 3
     seat_number 4
	  */
    // Execute a statement
    
   prep = connection.prepareStatement("SELECT ticket_number, flight_number, seat_number FROM ticket WHERE username = ?");
   prep.setString(1, customer.getUsername());
   ResultSet rs =prep.executeQuery();
 

   return rs;
	}


// method to remove a flight from a customer
public void removeFlights(String ticketnumber ) throws ClassNotFoundException, SQLException{
	
	// Load the JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
   
    // Establish a connection
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/cis3270?"
          + "user=sqluser&password=sqluserpw");
    
    //Create a statement
    Statement statement = connection.createStatement();

    /*flight table column indexes
     ticket_number 1
     username 2
     flight_number 3
     seat_number 4
     
	  */
    // Execute a statement
    
   prep = connection.prepareStatement("DELETE FROM ticket WHERE ticket_number =?");
   prep.setString(1, ticketnumber);
   prep.executeUpdate();
  

   //close connection
   connection.close();

	}

//method to check if customer has already book a specific flight
public boolean checkBooked(String username, String flightnumber) throws SQLException, ClassNotFoundException{
	
	boolean isBooked = false;
	
	// Load the JDBC driver
    Class.forName("com.mysql.jdbc.Driver");
   
    // Establish a connection
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/cis3270?"
          + "user=sqluser&password=sqluserpw");
    
    //Create a statement
    Statement statement = connection.createStatement();

    /*flight table column indexes
     ticket_number 1
     username 2
     flight_number 3
     seat_number 4
     
	  */
    // Execute a statement
    
   prep = connection.prepareStatement("SELECT * FROM ticket WHERE username = ? AND flight_number= ? ");
   prep.setString(1, username);
   prep.setString(2, flightnumber);
   ResultSet rs =prep.executeQuery();
   rs.last();
   
   
   if (rs.getRow() > 0 ) {
	   isBooked = true;
   }  else {
	   isBooked = false;
   }
   
   
   //close connection
   connection.close();
   
   return isBooked;
	}

//method to build a Flight object

public  Flight buildFlight(String flightnumber) throws ClassNotFoundException, SQLException{
	
	Flight flight = new Flight();
	
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
    
   prep = connection.prepareStatement("SELECT * FROM flight where flight_number = ?");
   prep.setString(1, flightnumber);
   ResultSet flightInfo = prep.executeQuery();
   
   
   //build Flight object
   flightInfo.next();
	   flight.setFlightNumber(flightInfo.getString(1));
	   flight.setOrigin(flightInfo.getString(2));
	   flight.setDestination(flightInfo.getString(3));
	   flight.setDepartureDate(flightInfo.getString(4));
	   flight.setDepartureTime(flightInfo.getString(5));
	   flight.setArrivalDate(flightInfo.getString(6));
	   flight.setArrivalTime(flightInfo.getString(7));
	   flight.setAirlines(flightInfo.getString(8));
	   flight.setPassengers(Integer.parseInt(flightInfo.getString(9)));
   
  
   //close connection
   connection.close();
   
   //return resultSet
  	return flight;
    

	}


//method to update the amount of passenfers in a flight
public  void updatePassengers(Flight flight) throws ClassNotFoundException, SQLException{
	
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

    prep = connection.prepareStatement("UPDATE flight SET passengers = ? WHERE flight_number = ?");
    prep.setString(1, flight.getPassengers()+"");
    prep.setString(2, flight.getFlightNumber());
    prep.executeUpdate();
   //close connection
   connection.close();
   
   
	}

}
