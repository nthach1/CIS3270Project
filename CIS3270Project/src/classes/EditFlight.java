package classes;

import java.sql.SQLException;

public interface EditFlight {

	

	void createFlight(Flight flight) throws ClassNotFoundException, SQLException;

	void editFlight(Flight flight) throws ClassNotFoundException, SQLException;

	void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException;

	

}
