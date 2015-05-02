package customerMenus;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.Customer;
import classes.MainMenu;

	public class CustomerMenu extends JFrame{
		
		private final JTextField username = new JTextField(20);
		
		public void CustomerMenu(Customer a) {
			JFrame frame = new JFrame();
			frame.setTitle("Customer Menu");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
		}
		
	}
		
	