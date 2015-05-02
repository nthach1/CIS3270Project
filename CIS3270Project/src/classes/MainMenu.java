package classes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import login.logincustomer;
import registration.registad;
import registration.registcustomer;

public class MainMenu extends JFrame {
        //Declare neccessary variable
	private final JButton login = new JButton("Login");
	private final JButton register = new JButton("Register");
	private final JButton Main1 = new JButton("Main");
	private final JButton Main2 = new JButton("Main");
	private final JButton logcustomer = new JButton("Customer");
	private final JButton regcustomer = new JButton("Customer");
	private final JButton regad = new JButton("Administrator");

	public MainMenu() {
                //Create panel for choice between register and login 
		final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		panel.add(login);
		panel.add(register);
		add(panel);
		panel.setVisible(true);
                //Create panel for login
		final JPanel log = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		log.add(logcustomer);
		log.add(Main1);
		log.setVisible(false);
                //Create panel for choice register ad and register customer
		final JPanel regist = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		regist.add(regcustomer);
		regist.add(regad);
		regist.add(Main2);
		regist.setVisible(false);
                // Add main button to register panel
		Main1.addActionListener((ActionEvent ev) -> {
			panel.setVisible(true);
			log.setVisible(false);
			regist.setVisible(false);
		});
		Main2.addActionListener((ActionEvent ev) -> {
			panel.setVisible(true);
			log.setVisible(false);
			regist.setVisible(false);
		});
                //Open new frame for log in of user
		login.addActionListener((ActionEvent ev) -> {
			JFrame frame = new logincustomer();
			frame.setTitle("Account Login");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
                //Assign task to register button for register 
		register.addActionListener((ActionEvent ev) -> {
			add(regist);
			panel.setVisible(false);
			log.setVisible(false);
			regist.setVisible(true);
		});
                //Open new frame for register of customer 
		regcustomer.addActionListener((ActionEvent ev) -> {
			JFrame frame = new registcustomer();
			frame.setTitle("Customer Account Registration");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
                //Open new frame for register of administrator
		regad.addActionListener((ActionEvent ev) -> {
			JFrame frame = new registad();
			frame.setTitle("Administrator Account Registration");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

	public static void main(String[] agrs) {
                  //Open new Jwindow
		  JWindow window = new JWindow(); 
                  try
                  { window.getContentPane().add( new //add Jlabel to window
		  JLabel("", new ImageIcon(new 
		  URL("http://cdn.makeagif.com/media/4-25-2015/LyuNvb.gif")),//add image to Image Icon
		  SwingConstants.CENTER)); 
                  window.setBounds(400, 150, 630, 290);//set bound for image
		  window.setVisible(true);// let Jwindow visible
		  // let task sleep
		  Thread.sleep(6000); 
                  } 
                  catch (InterruptedException |
		  MalformedURLException e) { } 
                  window.setVisible(false);// let JWindow invisible 
                  //Open new J frame for Main Menu
                  JFrame frame = new MainMenu();
                  frame.setTitle("Main Menu");
		  frame.setSize(800, 600);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setVisible(true);
	}
}