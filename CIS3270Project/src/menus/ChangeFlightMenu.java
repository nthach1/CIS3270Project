package menus;

	import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import classes.Admin;
import classes.Flight;
import flights.SearchFlightsSQL;

			public class ChangeFlightMenu extends JFrame {
			private final JButton menuB = new JButton("Menu");
			private final JButton update = new JButton("Update");
			private final JButton delete = new JButton("Delete");
			
				//Create admin change flight menu frame
				public void ChangeFlightMenu(Admin admin, String flightNumber) throws ClassNotFoundException, SQLException {
					

					SearchFlightsSQL flight = new SearchFlightsSQL();
					Flight currentFlight = flight.buildFlight(flightNumber);
					
					final JLabel flightNumberL = new JLabel(flightNumber);
					final JTextField originL = new JTextField (currentFlight.getOrigin());
					final JTextField  destinationL = new JTextField (currentFlight.getDestination());
					final JTextField  departureDateL = new JTextField (currentFlight.getDepartureDate());
					final JTextField  departureTimeL = new JTextField (currentFlight.getDepartureTime());
					final JTextField  arrivalDateL = new JTextField (currentFlight.getArrivalDate());
					final JTextField  arrivalTimeL = new JTextField (currentFlight.getArrivalTime());
					final JTextField  airlinesL = new JTextField (currentFlight.getAirlines());
					final JLabel passengersL = new JLabel(currentFlight.getPassengers()+"");
					
					JFrame mframe = new JFrame();
					mframe.setTitle("Administrator Edit Flight");
					mframe.setSize(800, 600);
					mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mframe.setVisible(true);
					
					//Add admin change flight menu items
					final JPanel main= new JPanel(new BorderLayout());
					
					final JPanel flightInfo = new JPanel(new GridLayout(9,2));
					flightInfo.add(new JLabel("Flight Number"));
					flightInfo.add(flightNumberL);
					flightInfo.add(new JLabel("Origin"));
					flightInfo.add(originL);
					flightInfo.add(new JLabel("Destination"));
					flightInfo.add(destinationL);
					flightInfo.add(new JLabel("Departure Date (Month Day)"));
					flightInfo.add(departureDateL);
					flightInfo.add(new JLabel("Departure Time"));
					flightInfo.add(departureTimeL);
					flightInfo.add(new JLabel("Arrival Date (Month Day)"));
					flightInfo.add(arrivalDateL);
					flightInfo.add(new JLabel("Arrival Time"));
					flightInfo.add(arrivalTimeL);
					flightInfo.add(new JLabel("Airlines"));
					flightInfo.add(airlinesL);
					flightInfo.add(new JLabel("Passengers"));
					flightInfo.add(passengersL);
					
					main.add(flightInfo, BorderLayout.CENTER);
					
					JPanel bottomMenu = new JPanel(new GridLayout(1,3));
					bottomMenu.add(menuB);
					bottomMenu.add(update);
					bottomMenu.add(delete);
					
					
					main.add(bottomMenu, BorderLayout.SOUTH);
					main.setVisible(true);
					mframe.add(main);
					
					
					//updates flight
					update.addActionListener((ActionEvent ev) -> {
						
						//create flight object
						Flight updatedFlight = new Flight();
						updatedFlight.setFlightNumber(flightNumber);
						updatedFlight.setOrigin(originL.getText());
						updatedFlight.setDestination(destinationL.getText());
						updatedFlight.setDepartureDate(departureDateL.getText());
						updatedFlight.setDepartureTime(departureTimeL.getText());
						updatedFlight.setArrivalDate(arrivalDateL.getText());
						updatedFlight.setArrivalTime(arrivalTimeL.getText());
						updatedFlight.setAirlines(airlinesL.getText());
		
						
						try {
							
							//admin updates flight
							admin.editFlight(updatedFlight);
							JOptionPane.showMessageDialog(null, "Flight Updated");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Error Updating Flight");
						}
						EditFlightMenu edit = new EditFlightMenu();
						edit.EditFlightMenu(admin);
						mframe.dispose();
					
					});
					
					//delete flight
					delete.addActionListener((ActionEvent ev) -> {
						
						
						//create flight object
						Flight deleteFlight = new Flight();
						deleteFlight.setFlightNumber(flightNumber);
						deleteFlight.setOrigin(originL.getText());
						deleteFlight.setDestination(destinationL.getText());
						deleteFlight.setDepartureDate(departureDateL.getText());
						deleteFlight.setDepartureTime(departureTimeL.getText());
						deleteFlight.setArrivalDate(arrivalDateL.getText());
						deleteFlight.setArrivalTime(arrivalTimeL.getText());
						deleteFlight.setAirlines(airlinesL.getText());
						deleteFlight.setPassengers(Integer.parseInt(passengersL.getText()));
		
						
						try {
							
							//check to see if flight has passengers
							if (deleteFlight.getPassengers() > 0) {
								JOptionPane.showMessageDialog(null, "Cannot Delete Flight with Passengers");
							} else {
							admin.deleteFlight(deleteFlight);
							JOptionPane.showMessageDialog(null, "Flight Deleted");
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Error deleting flight");
						}
						EditFlightMenu edit = new EditFlightMenu();
						edit.EditFlightMenu(admin);
						mframe.dispose();
					
					});	
					
					//returns to menu
					menuB.addActionListener((ActionEvent ev) -> {
						AdminMenu a = new AdminMenu();
						a.AdminMenu(admin);
						mframe.dispose();
					
					});
					
				}
				
				
				
}
