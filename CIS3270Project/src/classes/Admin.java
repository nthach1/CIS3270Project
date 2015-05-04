package classes;

import java.sql.SQLException;

import flights.EditFlightsSQL;

//This class allows administration users to complete all customer functions, in addition to adding, deleting, and updating flights

public class Admin extends Customer implements EditFlight {



	@Override
	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {

		EditFlightsSQL newFlight = new EditFlightsSQL();
		newFlight.deleteFlight(flight);
	}

	@Override
	public void createFlight(Flight flight) throws ClassNotFoundException, SQLException {
		
		EditFlightsSQL newFlight = new EditFlightsSQL();
		newFlight.createFlight(flight);
		
	}

	@Override
	public void editFlight(Flight flight) throws ClassNotFoundException, SQLException {
		
		EditFlightsSQL newFlight = new EditFlightsSQL();
		newFlight.updateFlight(flight);
		
	}

	
}
