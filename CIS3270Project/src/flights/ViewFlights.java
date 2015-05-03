package flights;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
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

public class ViewFlights extends JFrame{

		private final JTable flightsView = new JTable();
		private final JButton menuB = new JButton("Menu");
		private final JButton remove = new JButton("Remove Flight");
		private final JButton view= new JButton("View Flight");
		
		public void viewFlights(Customer customer) throws ClassNotFoundException, SQLException{
			
			JFrame mframe = new JFrame();
			mframe.setTitle("Flights");
			mframe.setSize(800, 600);
			mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mframe.setVisible(true);
			
			FlightsSQL flights = new FlightsSQL();
			ResultSet rs = flights.viewFlights(customer);
			
			JPanel main = new JPanel(new BorderLayout());
			
			flightsView.setModel(buildTableModel(rs));
			JScrollPane p = new JScrollPane(flightsView);
			main.add(p, BorderLayout.CENTER);
			
			JPanel menus = new JPanel(new GridLayout(1,3));
			menus.add(view);
			menus.add(remove);
			menus.add(menuB);
			main.add(menus, BorderLayout.SOUTH);
			
			mframe.add(main);
			
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
			
			remove.addActionListener((ActionEvent ev) -> {
				FlightsSQL remove = new FlightsSQL();
				
				int row =flightsView.getSelectedRow();
				
				try {
					if (row == -1) {
						JOptionPane.showMessageDialog(null, "No ticket selected. Try Again");
					} else {
					String ticketnumber = flightsView.getModel().getValueAt(row, 0) + "";
					String flightNumber = flightsView.getModel().getValueAt(row, 1) + "";
					remove.removeFlights(ticketnumber);
					
					FlightsSQL flightInfo = new FlightsSQL();
					Flight flight = flightInfo.buildFlight(flightNumber);
					int passengers = flight.getPassengers();
					passengers--;
					flight.setPassengers(passengers);
					
					FlightsSQL f = new FlightsSQL();
					f.updatePassengers(flight);
					JOptionPane.showMessageDialog(null, "Flight Removed");
					ViewFlights menu = new ViewFlights();
					menu.viewFlights(customer);
					mframe.dispose();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
					}
				});
			
			view.addActionListener((ActionEvent ev) -> {
				
				FlightsSQL view = new FlightsSQL();
				
				int row =flightsView.getSelectedRow();
				
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "No ticket selected. Try Again");
					
				} else {
					
				String flightnumber = flightsView.getModel().getValueAt(row, 1) + "";
				String ticketnumber = flightsView.getModel().getValueAt(row, 0) + "";
				try {
					Flight flight = view.buildFlight(flightnumber);
					
					JFrame customerViewFlight= new JFrame();
					customerViewFlight.setTitle("Ticket#" + ticketnumber );
					customerViewFlight.setSize(300, 600);
					customerViewFlight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					customerViewFlight.setVisible(true);
					
					 JPanel panel = new JPanel(new BorderLayout());
					 JButton close = new JButton("Close");
					 
					

					JPanel flightInformation = new JPanel(new GridLayout(9,2));
					flightInformation.add(new JLabel("Flight Number:"));
					flightInformation.add(new JLabel(flight.getFlightNumber()));
					flightInformation.add(new JLabel("Origin:"));
					flightInformation.add(new JLabel(flight.getOrigin()));
					flightInformation.add(new JLabel("Destination:"));
					flightInformation.add(new JLabel(flight.getDestination()));
					flightInformation.add(new JLabel("Departure Date:"));
					flightInformation.add(new JLabel(flight.getDepartureDate()));
					flightInformation.add(new JLabel("Departure Time:"));
					flightInformation.add(new JLabel(flight.getDepartureTime()));
					flightInformation.add(new JLabel("Arrival Date:"));
					flightInformation.add(new JLabel(flight.getArrivalDate()));
					flightInformation.add(new JLabel("Arrival Time:"));
					flightInformation.add(new JLabel(flight.getArrivalTime()));
					flightInformation.add(new JLabel("Airlines:"));
					flightInformation.add(new JLabel(flight.getAirlines()));
					flightInformation.add(new JLabel("Passengers:"));
					flightInformation.add(new JLabel(flight.getPassengers()+""));
	
					
					panel.add(flightInformation, BorderLayout.CENTER);
					panel.add(close, BorderLayout.SOUTH);
					customerViewFlight.add(panel);
					
					 close.addActionListener((ActionEvent ) -> {
							customerViewFlight.dispose();
						});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					}
				});
			
		}
	
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

		    return new DefaultTableModel(data, columnNames);

			}
}


