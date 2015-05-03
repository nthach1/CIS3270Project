package menus;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
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

	public class AdminMenu extends JFrame{
		private final JButton searchFlightsB = new JButton("Search Flights");
		private final JButton viewProfile = new JButton("View Profile");
		private final JButton viewFlights = new JButton("View Flights");
		private final JButton editFlightsB = new JButton("Edit Flights");
		private final JButton logOut = new JButton("Log Out");
		private final JTextArea welcome = new JTextArea();
		

		public void AdminMenu(Admin a) {
			
			JFrame mframe = new JFrame();
			mframe.setTitle("Administrator Menu");
			mframe.setSize(800, 600);
			mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mframe.setVisible(true);
			
			final JPanel menu = new JPanel(new GridLayout(5,1));
			menu.add(viewProfile);
			menu.add(viewFlights);
			menu.add(searchFlightsB);
			menu.add(editFlightsB);
			menu.add(logOut);
			menu.setVisible(true);
			
			final JPanel main = new JPanel(new BorderLayout());
			main.add(welcome, BorderLayout.NORTH);
			main.add(menu, BorderLayout.CENTER);
			
			final JPanel searchFlightsP = new JPanel();
			
			
			welcome.setText("Welcome " + a.getFirstName() + " " + a.getLastName());
			welcome.setEditable(false);
			
			mframe.add(main);
	
			searchFlightsB.addActionListener((ActionEvent ev) -> {
				main.setVisible(false);
				searchFlightsP.setVisible(true);
				
			});
			
		}
		
		
				
	
		
	}
		
	