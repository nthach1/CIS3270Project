package customerMenus;


import javax.swing.JFrame;

import classes.Admin;

	public class AdminMenu extends JFrame{
	
		public void AdminMenu(Admin a) {
			JFrame frame = new JFrame();
			frame.setTitle("Administrator Menu");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
		}
		
	}
		
	