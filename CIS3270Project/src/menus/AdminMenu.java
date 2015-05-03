package menus;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import login.logincustomer;
import registration.registad;
import registration.registcustomer;
import classes.Admin;
import classes.Customer;
import flights.BookFlights;
import flights.FlightsSQL;
import flights.ViewFlights;

	public class AdminMenu extends JFrame{
		private final JButton searchFlightsB = new JButton("Search Flights");
		private final JButton viewAccount = new JButton("View Account");
		private final JButton viewFlights = new JButton("View Flights");
		private final JButton logOut = new JButton("Log Out");
		private final JButton menuB = new JButton("Menu");
		private final JButton searchB = new JButton("Search For Flights");
		private final JLabel welcome = new JLabel();
		private final JComboBox origin = new JComboBox();
		private final JComboBox destination = new JComboBox();
		final JPanel searchFlightsP = new JPanel();
		private final JButton editFlightsB = new JButton("Edit Flights");
		

		public void AdminMenu(Admin admin) {
			
			JFrame mframe = new JFrame();
			mframe.setTitle("Administrator Menu");
			mframe.setSize(800, 600);
			mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mframe.setVisible(true);
			
			final JPanel menu = new JPanel(new GridLayout(5,1));
			menu.add(viewAccount);
			menu.add(viewFlights);
			menu.add(searchFlightsB);
			menu.add(editFlightsB);
			menu.add(logOut);
			menu.setVisible(true);
			
			final JPanel main = new JPanel(new BorderLayout());
			main.add(welcome, BorderLayout.NORTH);
			main.add(menu, BorderLayout.CENTER);
			
			final JPanel searchFlightsP = new JPanel();
			
			try {
				FlightsSQL flightsSQL = new FlightsSQL();
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
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			welcome.setText("Welcome " + admin.getFirstName() + " " + admin.getLastName());

			
			mframe.add(main);
	
			searchFlightsB.addActionListener((ActionEvent ev) -> {
				searchFlightsP.add(origin);
				searchFlightsP.add(destination);
				searchFlightsP.add(searchB);
				searchFlightsP.add(menuB);
				main.setVisible(false);
				mframe.add(searchFlightsP);
				searchFlightsP.setVisible(true);
				
			});
			
			menuB.addActionListener((ActionEvent ev) -> {
				main.setVisible(true);
				searchFlightsP.setVisible(false);
				
				
			});
			
				searchB.addActionListener((ActionEvent ev) -> {
				
				BookFlights book = new BookFlights();
				book.bookFlights(admin, origin.getSelectedItem().toString(), destination.getSelectedItem().toString());
				mframe.dispose();
			});
				
				viewFlights.addActionListener((ActionEvent ev) -> {
					
					ViewFlights viewFlights = new ViewFlights();
					try {
						viewFlights.viewFlights(admin);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mframe.dispose();
				});
				
				logOut.addActionListener((ActionEvent ev) -> {
					
					 JFrame frame = new MainMenu();
			            frame.setTitle("Main Menu");
			            frame.setSize(800, 600);
			            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			            frame.setVisible(true);
			            mframe.dispose();
					
				});
			
		}
		
		
				
	
		
	}
		
	