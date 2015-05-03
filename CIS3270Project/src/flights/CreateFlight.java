package flights;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.EditFlight;
import classes.Admin;
import classes.Flight;
import menus.MainMenu;
import menus.AdminMenu;


	public class CreateFlight extends JFrame {
		private final JTextField createOrigin = new JTextField();
		private final JTextField createDestination = new JTextField();
		private final JTextField createDepartureDate = new JTextField();
		private final JTextField createArrivalDate = new JTextField();
		private final JTextField createArrivalTime = new JTextField();
		private final JTextField createAirlines = new JTextField();
		private final JLabel origin = new JLabel ("Flight Origin");
		private final JLabel destination = new JLabel ("Flight Destination");
		private final JLabel departureDate = new JLabel ("Flight Departure Date");
		private final JLabel arrivalDate = new JLabel ("Flight Arrival Date");
		private final JLabel arrivalTime = new JLabel ("Flight Arrival Time");
		private final JLabel airlines = new JLabel ("Flight Airline Name");
		private final JButton createFlight = new JButton("Create Flight");
		private final JButton cancel = new JButton("Cancel");
		final JPanel createF = new JPanel();

	//Create flight creation frame
	public void CreateFlight(Admin admin) {
		JFrame mframe = new JFrame();
		mframe.setTitle("Administrative Flight Creation");
		mframe.setSize(800, 600);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
		
		//Add flight creation menu items
		final JPanel createF = new JPanel(new GridLayout(7,2));
		createF.add(origin);
		createF.add(createOrigin);
		createF.add(destination);
		createF.add(createDestination);
		createF.add(departureDate);
		createF.add(createDepartureDate);
		createF.add(arrivalDate);
		createF.add(createArrivalDate);
		createF.add(arrivalTime);
		createF.add(createArrivalTime);
		createF.add(airlines);
		createF.add(createAirlines);
		createF.add(createFlight);
		createF.add(cancel);

		mframe.add(createF);
		
		//Add create flight button action - save flight info
		createFlight.addActionListener((ActionEvent ev) -> {
			
			Flight newFlight = new Flight();
			newFlight.setOrigin(createOrigin.getText());
			newFlight.setDestination(createDestination.getText());
			newFlight.setDepartureDate(createDepartureDate.getText());
			newFlight.setArrivalDate(createArrivalDate.getText());
			newFlight.setArrivalTime(createArrivalTime.getText());
			newFlight.setAirlines(createAirlines.getText());
			
		
				
				JOptionPane.showMessageDialog(null, "Flight Created");
			
		
		});
		
		//Create cancel button action - cancel and go back to main menu
		cancel.addActionListener((ActionEvent ev) -> {
			
				AdminMenu a = new AdminMenu();
				a.AdminMenu(admin);
				mframe.dispose();
			
			});
			
	
	}

	
	}
