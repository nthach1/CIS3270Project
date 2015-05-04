package menus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Admin;
import classes.EditFlight;
import flights.CreateFlight;

	public class EditFlightMenu extends JFrame {
		private final JButton menuB = new JButton("Menu");
		private final JButton createFlight = new JButton("Create Flight");
		private final JButton editFlight = new JButton("Edit Flight");

		//Create admin frame
		public  void EditFlightMenu(Admin admin) {
			JFrame mframe = new JFrame();
			mframe.setTitle("Administrator Edit Flight");
			mframe.setSize(800, 600);
			mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mframe.setVisible(true);
			
			//Create create flight button action - take user to the create flight window
			createFlight.addActionListener((ActionEvent ev) -> {
				
				CreateFlight newFlight = new CreateFlight();
				newFlight.CreateFlight(admin);
				mframe.dispose();
				
			});
			 
			//Create edit flight button action - take user to the edit flight window
			editFlight.addActionListener((ActionEvent ev) -> {
				
				// accepts flight number
				String flightNumber = JOptionPane.showInputDialog("Enter flight number");
				ChangeFlightMenu changeFlight = new ChangeFlightMenu();
				try {
					// load change flight menu
					changeFlight.ChangeFlightMenu(admin, flightNumber);
				} catch (Exception e) {
					//incorrect flight number
					
					JOptionPane.showMessageDialog(null, "Incorrect Flight Number");
					EditFlightMenu edit = new EditFlightMenu();
					edit.EditFlightMenu(admin);
					mframe.dispose();
				}
				mframe.dispose();
			});
			
			//Add admin edit menu items
			final JPanel menu = new JPanel(new GridLayout(3,1));
			menu.add(createFlight);
			menu.add(editFlight);
			menu.add(menuB);
			menu.setVisible(true);
			
			mframe.add(menu);
			
			menuB.addActionListener((ActionEvent ev) -> {
				
				
				AdminMenu a = new AdminMenu();
				a.AdminMenu(admin);
				mframe.dispose();
			
			});
			
			
		}

	

	}