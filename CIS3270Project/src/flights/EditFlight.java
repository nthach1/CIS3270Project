package flights;

import java.sql.SQLException;


public interface EditFlight {

	void createFlight(Flight flight) throws ClassNotFoundException, SQLException;

	void editFlight(Flight flight);

	void deleteFlight(int flightNumber);

}
