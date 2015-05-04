package menus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import classes.Admin;
import classes.Customer;
import flights.BookFlights;
import flights.SearchFlightsSQL;
import flights.ViewFlights;

	public class CustomerMenu extends JFrame{
		private final JButton searchFlightsB = new JButton("Search Flights");
		private final JButton viewAccount = new JButton("View Account");
		private final JButton viewFlights = new JButton("View Flights");
		private final JButton logOut = new JButton("Log Out");
		private final JButton menuB = new JButton("Menu");
		private final JButton searchB = new JButton("Search For Flights");
		private final JLabel welcome = new JLabel();
		private final JComboBox origin = new JComboBox();
		private final JComboBox destination = new JComboBox();
		private final JComboBox departureMonth = new JComboBox();
		private final JComboBox departureDay = new JComboBox();
		private final JPanel searchFlightsP = new JPanel(new GridLayout(7,2));
		
		//creates customer menu
		public void CustomerMenu(Customer customer) {
			
			JFrame mframe = new JFrame();
			mframe.setTitle("Customer Menu");
			mframe.setSize(800, 600);
			mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mframe.setVisible(true);
			
			final JPanel menu = new JPanel(new GridLayout(4,1));
			menu.add(viewAccount);
			menu.add(viewFlights);
			menu.add(searchFlightsB);
			menu.add(logOut);
			menu.setVisible(true);
			
			final JPanel main = new JPanel(new BorderLayout());
			main.add(welcome, BorderLayout.NORTH);
			main.add(menu, BorderLayout.CENTER);
			
			
			//search flights panel
			searchFlightsP.add(new JLabel("Origin"));
			searchFlightsP.add(origin);
			searchFlightsP.add(new JLabel("Destination"));
			searchFlightsP.add(destination);
			searchFlightsP.add(new JLabel("Departure Month"));
			searchFlightsP.add(departureMonth);
			searchFlightsP.add(new JLabel("Departure Day"));
			searchFlightsP.add(departureDay);
			searchFlightsP.add(searchB);
			searchFlightsP.add(menuB);
			
			//creates jcombo box with month and day
			String[] months = new String[] {"January", "February", "March", "April",
					"May", "June", "July", "August", "September", "October", "November", "December"};
			
			for (int i = 0; i < months.length; i ++) {
				departureMonth.addItem(months[i]);
				
			}
			
			int[] days = new int[31];
			int count = 1;
			for (int i = 0; i < 31; i ++) {
				days[i] = count;
				count++;
			}
			
			for (int i = 0; i < days.length; i ++) {
				departureDay.addItem(days[i]);
				
			}
			
			// populate jcombo box with origin and destinations
			try {
				SearchFlightsSQL flightsSQL = new SearchFlightsSQL();
				ArrayList<Object> flightCities = flightsSQL.getFlightCities();
				ArrayList<Object> originCities = (ArrayList<Object>) flightCities.get(0);
				ArrayList<Object> destinationCities = (ArrayList<Object>) flightCities.get(1);
				
				for (int i = 0; i < originCities.size(); i ++) {
				origin.addItem(originCities.get(i));
				}
				for (int i = 0; i < destinationCities.size(); i ++) {
					destination.addItem(destinationCities.get(i));
					}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error loading search menu");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error loading search menu");
			}
		

			//shows first and last name in frame
			welcome.setText("Welcome " + customer.getFirstName() + " " + customer.getLastName());
			
			
			mframe.add(main);
	
			//search flights  button
			searchFlightsB.addActionListener((ActionEvent ev) -> {
				
				main.setVisible(false);
				mframe.add(searchFlightsP);
				searchFlightsP.setVisible(true);
				
			});
			
			//return to menu
			menuB.addActionListener((ActionEvent ev) -> {
				main.setVisible(true);
				searchFlightsP.setVisible(false);
				
				
			});

			//button to search for flights based on departure date , origin, and destination 
			searchB.addActionListener((ActionEvent ev) -> {
				
				//get selected items in combo box
				String departureDate = departureMonth.getSelectedItem() + " " + departureDay.getSelectedItem();
				BookFlights book = new BookFlights();
				book.bookFlights(customer, origin.getSelectedItem().toString(), destination.getSelectedItem().toString(), departureDate);
				mframe.dispose();
			});
			
			viewFlights.addActionListener((ActionEvent ev) -> {
				
				ViewFlights viewFlights = new ViewFlights();
				try {
					viewFlights.viewFlights(customer);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Unable to Load Flights");
				}
				mframe.dispose();
			});
			
			//returns to login page
			logOut.addActionListener((ActionEvent ev) -> {
				
				 JFrame frame = new MainMenu();
		            frame.setTitle("Main Menu");
		            frame.setSize(800, 600);
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            frame.setVisible(true);
		            mframe.dispose();
				
			});
			
			// creates frame with account information
			viewAccount.addActionListener((ActionEvent ev) -> {
				
				JFrame view = new JFrame();
				view.setTitle(customer.getUsername() );
				view.setSize(300, 600);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.setVisible(true);
				
				JPanel panel = new JPanel(new BorderLayout());
				 JButton close = new JButton("Close");

					//displays account information
		
					JPanel flightInformation = new JPanel(new GridLayout(9,2));
					flightInformation.add(new JLabel("Username:"));
					flightInformation.add(new JLabel(customer.getUsername()));
					flightInformation.add(new JLabel("First Name:"));
					flightInformation.add(new JLabel(customer.getFirstName()));
					flightInformation.add(new JLabel("Last Name:"));
					flightInformation.add(new JLabel(customer.getLastName()));
					flightInformation.add(new JLabel("SSN:"));
					flightInformation.add(new JLabel(customer.getSsn()));
					flightInformation.add(new JLabel("Email:"));
					flightInformation.add(new JLabel(customer.getEmail()));
					flightInformation.add(new JLabel("Address:"));
					flightInformation.add(new JLabel(customer.getAddress()));
					flightInformation.add(new JLabel("City:"));
					flightInformation.add(new JLabel(customer.getCity()));
					flightInformation.add(new JLabel("State:"));
					flightInformation.add(new JLabel(customer.getState()));
					flightInformation.add(new JLabel("Zip Code"));
					flightInformation.add(new JLabel(customer.getZip()));

					
					panel.add(flightInformation, BorderLayout.CENTER);
					panel.add(close, BorderLayout.SOUTH);
					view.add(panel);
				
					//close acccount frame
					close.addActionListener((ActionEvent ) -> {
						view.dispose();
					
				});
				
			});
			
		}	
		
		
		
	}
		
	