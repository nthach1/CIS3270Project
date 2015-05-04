package flights;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.EditFlight;
import classes.Admin;
import classes.Flight;
import menus.EditFlightMenu;
import menus.MainMenu;
import menus.AdminMenu;


	public class CreateFlight extends JFrame {
		private final JTextField createOrigin = new JTextField();
		private final JTextField createDestination = new JTextField();
		private final JTextField createDepartureTime = new JTextField();
		private final JTextField createArrivalTime = new JTextField();
		private final JTextField createAirlines = new JTextField();
		private final JLabel origin = new JLabel ("Flight Origin");
		private final JLabel destination = new JLabel ("Flight Destination");
		private final JLabel departureDate = new JLabel ("Flight Departure Date");
		private final JLabel departureTime = new JLabel ("Flight Departure Time");
		private final JLabel arrivalDate = new JLabel ("Flight Arrival Date");
		private final JLabel arrivalTime = new JLabel ("Flight Arrival Time");
		private final JLabel airlines = new JLabel ("Flight Airline Name");
		private final JButton createFlight = new JButton("Create Flight");
		private final JButton cancel = new JButton("Cancel");
		final JPanel createF = new JPanel();
		private final JComboBox departureMonth = new JComboBox();
		private final JComboBox departureDay = new JComboBox();
		private final JComboBox arrivalMonth = new JComboBox();
		private final JComboBox arrivalDay = new JComboBox();

	//Create flight creation frame
	public void CreateFlight(Admin admin) {
		JFrame mframe = new JFrame();
		mframe.setTitle("Administrative Flight Creation");
		mframe.setSize(800, 600);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
		
		//Add flight creation menu items
		final JPanel createF = new JPanel(new GridLayout(8,2));
		createF.add(origin);
		createF.add(createOrigin);
		createF.add(destination);
		createF.add(createDestination);
		createF.add(departureDate);
		
		//select departure month and day
		final JPanel departureDates = new JPanel(new GridLayout(1,2));
		departureDates.add(departureMonth);
		departureDates.add(departureDay);
		createF.add(departureDates);
		
		
		createF.add(departureTime);
		createF.add(createDepartureTime);
		createF.add(arrivalDate);
		
		//select arrival month and day
		final JPanel arrivalDates = new JPanel(new GridLayout(1,2));
		arrivalDates.add(arrivalMonth);
		arrivalDates.add(arrivalDay);
		createF.add(arrivalDates);
		
		createF.add(arrivalTime);
		createF.add(createArrivalTime);
		createF.add(airlines);
		createF.add(createAirlines);
		createF.add(createFlight);
		createF.add(cancel);

		mframe.add(createF);
		
		// string to hold months
		String[] months = new String[] {"January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December"};
		
		//populate jcombo box with the months
		for (int i = 0; i < months.length; i ++) {
			departureMonth.addItem(months[i]);
			arrivalMonth.addItem(months[i]);
		}
		
		// populate jcombo box with the days
		int[] days = new int[31];
		int count = 1;
		for (int i = 0; i < 31; i ++) {
			days[i] = count;
			count++;
		}
		
		for (int i = 0; i < days.length; i ++) {
			departureDay.addItem(days[i]);
			arrivalDay.addItem(days[i]);
			
		}
		
		//Add create flight button action - save flight info
		createFlight.addActionListener((ActionEvent ev) -> {
			
			// get selecte date and formats into "Month Day"
			String departureDate = departureMonth.getSelectedItem() + " " + departureDay.getSelectedItem();
			String arrivalDate = arrivalMonth.getSelectedItem() + " " + arrivalDay.getSelectedItem();
			
			//create flight Object
			Flight newFlight = new Flight();
			newFlight.setOrigin(createOrigin.getText());
			newFlight.setDestination(createDestination.getText());
			newFlight.setDepartureDate(departureDate);
			newFlight.setDepartureTime(createDepartureTime.getText());
			newFlight.setArrivalDate(arrivalDate);
			newFlight.setArrivalTime(createArrivalTime.getText());
			newFlight.setAirlines(createAirlines.getText());
			
			
			// admin creates flight by passing Flight object
			try {
				admin.createFlight(newFlight);
				JOptionPane.showMessageDialog(null, "Flight Created");
				EditFlightMenu edit = new EditFlightMenu();
				edit.EditFlightMenu(admin);
				mframe.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error Creating Flight");
			}
					
		});
		
		
		
		//Create cancel button action - cancel and go back to main menu
		cancel.addActionListener((ActionEvent ev) -> {
			
				AdminMenu a = new AdminMenu();
				a.AdminMenu(admin);
				mframe.dispose();
			
			});
			
	
		}

	
	}
