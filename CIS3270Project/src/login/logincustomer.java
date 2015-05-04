package login;

import java.awt.BorderLayout;
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

import menus.AdminMenu;
import menus.CustomerMenu;
import menus.MainMenu;
import classes.Admin;
import classes.Customer;
import classes.CustomerFromSQL;


public class logincustomer extends JFrame {
	private final JTextField username = new JTextField(20);
	private final JTextField getUsername = new JTextField(20);
	private final JPasswordField password = new JPasswordField(30);
	private final JButton forgotPassword = new JButton("Forgot Password");
	private final JButton ok = new JButton("Log In");
	private final JButton close = new JButton("Close");
	private final JButton Main = new JButton("Main");
	private final JTextField forgotpassword = new JTextField(20);
	private final JButton submit = new JButton("Submit");
	private final JComboBox squestion = new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
             "What is your first car?","Where were your mother born?"});

	public logincustomer() { // Create Jpanel for constructor
                //Create JPanel for Login
		final JPanel login = new JPanel(new BorderLayout());
		final JPanel login2 = new JPanel(new GridLayout(8,1));
		login2.add(new JLabel("Username"));
		login2.add(username);
		login2.add(new JLabel("Password"));
		login2.add(password);
		((JPasswordField) password).setEchoChar('*');
		login2.add(ok);
		login2.add(forgotPassword);
		login2.add(Main);
		
		login.add(login2, BorderLayout.CENTER);
		add(login);
		
        //Create Jpanel for retrieved password
		
		forgotPassword.addActionListener((ActionEvent ev) -> {
			JFrame forgotP = new JFrame();
			forgotP.setTitle("Forgot Passwrd");
			forgotP.setSize(400, 400);
			forgotP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			forgotP.setVisible(true);
			
			final JPanel forgotpass = new JPanel(new GridLayout(13, 2, 0, 0));
			
			forgotpass.add(new JLabel("Forgot Password?"));
			forgotpass.add(new JLabel("Username"));
			forgotpass.add(getUsername);
			forgotpass.add(new JLabel("Security Question"));
			forgotpass.add(squestion);
			forgotpass.add(new JLabel("Answer"));
			forgotpass.add(forgotpassword);
			forgotpass.add(submit);
			forgotpass.add(close);
		
				
			forgotP.add(forgotpass);
			
			close.addActionListener((ActionEvent ) -> {
				forgotP.dispose();
			});
		});
	

		
	
	
                //Assign main task to return to Main menu
		
		Main.addActionListener((ActionEvent ev) -> {
			JFrame frame = new MainMenu();
			frame.setTitle("Main Menu");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
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
				
				//build customer object from database
				Customer customer = a.createCustomer(username1);
				
				
				// checks to see if username and password match
				if (password1.compareTo(customer.getPassword()) == 0) { 
					JOptionPane.showMessageDialog(null, "Login Successful");

					// check to see if admin
					if (customer.getAdminKey() == 1) {
						
						
						//create admin 
						Admin admin = a.createAdmin(username1);
						
						AdminMenu login2 = new AdminMenu();
						login2.AdminMenu(admin);
						dispose();
					} else {
					CustomerMenu login2 = new CustomerMenu();
					login2.CustomerMenu(customer);
					dispose();
					
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
	
	// get password from security question

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
					
					//checks to see if security answer and secuirity question match
					customer = a.createCustomer(username);
					if (customer.getSecurityQuestion().compareTo(question) == 0 && customer.getSecurityAnswer().compareToIgnoreCase(answer) ==0) {
						JOptionPane.showMessageDialog(null, "Password is: " + customer.getPassword());
						
					} else {
						
						//no match
						JOptionPane.showMessageDialog(null, "Answer and Username do not match");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Username does not exist");
				}

			}
			
		}
	}
