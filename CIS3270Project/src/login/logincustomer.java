package login;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import customerMenus.AdminMenu;
import customerMenus.CustomerMenu;
import classes.Admin;
import classes.Customer;
import classes.Customerbook;
import classes.CustomerFromSQL;
import classes.MainMenu;


public class logincustomer extends JFrame {
	private final JTextField username = new JTextField(20);
	private final JTextField getUsername = new JTextField(20);
	private final JPasswordField password = new JPasswordField(30);
	private final JButton ok = new JButton("OK");
	private final JButton cancel = new JButton("Cancel");
	private final JButton Main = new JButton("Main");
	private final JTextField forgotpassword = new JTextField(20);
	private final JButton submit = new JButton("Submit");
	private final JComboBox squestion = new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
             "What is your first car?","Where were your mother born?"});

	public logincustomer() { // Create Jpanel for constructor
                //Create JPanel for Login
		final JPanel login = new JPanel(new GridLayout(13, 2, 0, 0));
		login.add(new JLabel("Log in"));
		login.add(new JLabel("Username"));
		login.add(username);
		login.add(new JLabel("Password"));
		login.add(password);
		((JPasswordField) password).setEchoChar('*');
		login.add(ok);
		login.add(cancel);
                //Create Jpanel for retrieved password
		final JPanel forgotpass = new JPanel(new GridLayout(13, 2, 0, 0));
		forgotpass.add(Main);
		forgotpass.add(new JLabel("Forgot Password?"));
		forgotpass.add(new JLabel("Username"));
		forgotpass.add(getUsername);
		forgotpass.add(new JLabel("Security Question"));
		forgotpass.add(squestion);
		forgotpass.add(new JLabel("Answer"));
		forgotpass.add(forgotpassword);
		forgotpass.add(submit);
                //Create Layout to add two panels
		setLayout(new GridLayout(2, 1, 5, 5));	
		add(login);
		add(forgotpass);
                //Assign main task to return to Main menu
		Main.addActionListener((ActionEvent ev) -> {
			JFrame frame = new MainMenu();
			frame.setTitle("Main Menu");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
		//Assign lister task to ok and submit
		Login login1 = new Login();
		ok.addActionListener(login1);
		Password p1= new Password();
		submit.addActionListener(p1);
	}
	
	private class Login implements ActionListener {

		private String username1;
		private String password1;

		@Override
		public void actionPerformed(ActionEvent e) {
			 
			username1 = username.getText();
			password1 = password.getText();
			
			CustomerFromSQL a = new CustomerFromSQL();
			try {
				Customer customer = a.createCustomer(username1);
				
				if (password1.compareTo(customer.getPassword()) == 0) { 
					JOptionPane.showMessageDialog(null, "Login Successful");

					if (customer.getAdminKey() == 1) {
						
						Admin admin = a.createAdmin(username1);
						
						AdminMenu login2 = new AdminMenu();
						login2.AdminMenu(admin);
					} else {
					CustomerMenu login2 = new CustomerMenu();
					login2.CustomerMenu(customer);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Login Failed");
				}
					
				}
		
			 catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Username does not exist/ Password incorrect");
			}
			
			
			}
			
		}
	
	

	private class Password implements ActionListener {

		private String username;
		private String question;
		private String answer;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			username = getUsername.getText();
			question = squestion.getSelectedItem().toString();
			answer = forgotpassword.getText();
			
			CustomerFromSQL a = new CustomerFromSQL();
			
				Customer customer;
				try {
					customer = a.createCustomer(username);
					if (customer.getSecurityQuestion().compareTo(question) == 0 && customer.getSecurityAnswer().compareToIgnoreCase(answer) ==0) {
						JOptionPane.showMessageDialog(null, "Password is: " + customer.getPassword());
					} else {
						JOptionPane.showMessageDialog(null, "Answer and Username do not match");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Username does not exist");
				}

			}
			
		}
	}
