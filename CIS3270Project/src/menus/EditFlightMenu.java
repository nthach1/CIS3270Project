package menus;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

	public class EditFlightMenu extends JFrame {
		private final JButton searchFlightsC = new JButton("Search Flights");
		private final JTextField acceptFlight = new JTextField("Enter Flight Number Here");
		private final JButton menuB = new JButton("Menu");
		
		//Create admin frame
		public EditFlightMenu() {
			JFrame mframe = new JFrame();
			mframe.setTitle("Administrator Edit Flight");
			mframe.setSize(800, 600);
			mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mframe.setVisible(true);
			
			//Add admin edit menu items
			final JPanel menu = new JPanel(new GridLayout(3,1));
			menu.add(acceptFlight);
			menu.add(searchFlightsC);
			menu.add(menuB);
			menu.setVisible(true);
			
			add(menu);
			
			
		}

	

	}