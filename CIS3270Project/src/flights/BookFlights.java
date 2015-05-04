package flights;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import menus.AdminMenu;
import menus.CustomerMenu;
import classes.Admin;
import classes.Customer;
import classes.Flight;

public class BookFlights extends JFrame{
	private final JTable matchedFlights = new JTable();
	private final JButton book = new JButton("Book Flight");
	private final JButton menuB = new JButton("Menu");
	private  final JPanel matchingFlightsP = new JPanel(new BorderLayout());

	//book flights frame
	
	public void bookFlights(Customer customer, String origin, String destination, String departureDate){
		
		JFrame mframe = new JFrame();
		mframe.setTitle("Book Flight");
		mframe.setSize(1500, 600);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
		
		JPanel main = new JPanel(new BorderLayout());
	
		JPanel menu = new JPanel(new GridLayout(1,2));
		menu.add(book);
		menu.add(menuB);
		
		
		main.add(menu, BorderLayout.SOUTH);
		
		mframe.add(main);
		
		SearchFlightsSQL matchingFlights = new SearchFlightsSQL();
		
		//load matching flights into Jtable
		
				try {
				ResultSet rs = matchingFlights.showFlights
				(origin,destination,departureDate);
				//builds table model 
			matchedFlights.setModel(buildTableModel(rs));
			matchingFlightsP.add(new JScrollPane(matchedFlights), BorderLayout.CENTER);
			main.add(matchingFlightsP, BorderLayout.CENTER);
			
			book.addActionListener((ActionEvent ev) -> {
				
				// gets the index of the selected row
				int row = matchedFlights.getSelectedRow();

				try {
					// no row selected
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "No flight selected. Try Again");
					} else {
						// get flightnumber at selected row and column 0
					String flightNumber = matchedFlights.getModel().getValueAt(row, 0) + "";
					
					// build Flight object from flightNumber
					SearchFlightsSQL flightInfo = new SearchFlightsSQL();
					Flight flight = flightInfo.buildFlight(flightNumber);
					int passengers = flight.getPassengers();
					
					// checks to see if already booked
					 if (customer.isBooked(flightNumber) == true) {
						JOptionPane.showMessageDialog(null, "Flight is already booked");
					}
					 
					 //checks to see if full
					 else if (passengers >= 50) {
						JOptionPane.showMessageDialog(null, "Flight is full");
					}
					
					else {
						// book flight and increase passsenger count
						if (customer.getAdminKey() == 1) {
							customer.book(flightNumber);
							passengers++;
							flight.setPassengers(passengers);
							SearchFlightsSQL f = new SearchFlightsSQL();
							f.updatePassengers(flight);
							JOptionPane.showMessageDialog(null, "Flight Booked!");
							AdminMenu menus = new AdminMenu();
							menus.AdminMenu((Admin)customer);
							mframe.dispose();
								
						} else {
					customer.book(flightNumber);
					passengers++;
					flight.setPassengers(passengers);
					SearchFlightsSQL f = new SearchFlightsSQL();
					f.updatePassengers(flight);
					JOptionPane.showMessageDialog(null, "Flight Booked!");
					CustomerMenu menus = new CustomerMenu();
					menus.CustomerMenu(customer);
					mframe.dispose();
							}
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error Booking Flight");
					}
				
				});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error Loading Flights");
		}
		
				// returns to menu
				menuB.addActionListener((ActionEvent ev) -> {
					if (customer.getAdminKey() == 1) {
						AdminMenu a = new AdminMenu();
						a.AdminMenu((Admin)customer);
						mframe.dispose();
					} else {
					CustomerMenu a = new CustomerMenu();
					a.CustomerMenu(customer);
					mframe.dispose();
						}
					});
		
		
	}
	
	
	// method for building Table Modedl using a ResultSet
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    // return table model
	    return new DefaultTableModel(data, columnNames);

		}
}
