package users;

import java.sql.SQLException;

import flights.EditFlight;
import flights.EditFlightSQL;
import flights.Flight;

//This class allows administration users to complete all customer functions, in addition to adding, deleting, and updating flights

public class Admin extends Customer implements EditFlight {

	@Override
	public void createFlight(Flight flight) throws ClassNotFoundException, SQLException {
	
		EditFlightSQL newFlight = new EditFlightSQL();
		
			newFlight.createFlight(flight);
		
	}

	@Override
	public void editFlight(Flight flight) {

	}

	@Override
	public void deleteFlight(int flightNumber) {

	}

}
