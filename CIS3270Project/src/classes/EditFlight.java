package classes;

import java.sql.SQLException;

//interface that allows the creation/ editing/ and deleting of a flight

public interface EditFlight {

	

	void createFlight(Flight flight) throws ClassNotFoundException, SQLException;

	void editFlight(Flight flight) throws ClassNotFoundException, SQLException;

	void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException;

	

}
