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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classes.Customer;
import classes.CustomerFromSQL;
import classes.Customerbook;
import classes.MainMenu;

public class loginad extends JFrame {
	private final JTextField username = new JTextField(20);
	private final JTextField getUsername = new JTextField(20);
	private final Component password = new JPasswordField(30);
	private final JButton ok = new JButton("OK");
	private final JButton cancel = new JButton("Cancel");
	private final JButton Main = new JButton("Main");
	private final JTextField forgotpassword = new JTextField(20);
	private final JButton submit = new JButton("Submit");
	private final JComboBox squestion = new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
            "What is your first car?","Where were your mother born?"});

	public loginad() {// Create Jpanel for constructor
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
                // Set Layout to add two Jpanels
		setLayout(new GridLayout(2, 1, 5, 5));
		add(login);
		add(forgotpass);

		Password pass = new Password();
		submit.addActionListener(pass);
                //Assign main task to return to Main menu
		Main.addActionListener((ActionEvent ev) -> {
			JFrame frame = new MainMenu();
			frame.setTitle("Main Menu");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
                //Assign main task to ok button and go to book flight
		ok.addActionListener((ActionEvent ev) -> {
			JFrame frame = new Customerbook();
			frame.setTitle("Book Flight");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
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
