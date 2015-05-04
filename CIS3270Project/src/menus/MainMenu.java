package menus;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

import login.logincustomer;
import registration.registad;
import registration.registcustomer;

public class MainMenu extends JFrame {
	private final JButton login = new JButton("Login");
	private final JButton register = new JButton("Register");
	private final JButton Main1 = new JButton("Main");
	private final JButton Main2 = new JButton("Main");
	private final JButton logcustomer = new JButton("Customer");
	private final JButton regcustomer = new JButton("Customer");
	private final JButton regad = new JButton("Administrator");

	// creates main menu
	public MainMenu() {
		final JPanel panel = new JPanel(new BorderLayout());
		final JPanel p2 = new JPanel(new GridLayout(1,2));
		p2.add(login);
		p2.add(register);
		panel.add(p2, BorderLayout.SOUTH);
		try {
			panel.add(new JLabel(new ImageIcon(new
					  URL("http://dingo.care2.com/pictures/greenliving/1256/1255494.large.jpg"))), BorderLayout.CENTER);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(panel);
		panel.setVisible(true);

		//log in panel
		final JPanel log = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		log.add(logcustomer);
		log.add(Main1);
		log.setVisible(false);
		

		
		// registration panel
		final JPanel regist = new JPanel(
		new FlowLayout(FlowLayout.CENTER, 2, 2));
		regist.add(regcustomer);
		regist.add(regad);
		regist.add(Main2);
		regist.setVisible(false);

		
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

		
		//creates log in frame
		login.addActionListener((ActionEvent ev) -> {
			JFrame frame = new logincustomer();
			frame.setTitle("Account Login");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});
		register.addActionListener((ActionEvent ev) -> {
			add(regist);
			panel.setVisible(false);
			log.setVisible(false);
			regist.setVisible(true);
		});
		
		// creates regular customer registration frame
		regcustomer.addActionListener((ActionEvent ev) -> {
			JFrame frame = new registcustomer();
			frame.setTitle("Customer Account Registration");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});

		// creates administration registration frame
		regad.addActionListener((ActionEvent ev) -> {
			JFrame frame = new registad();
			frame.setTitle("Administrator Account Registration");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});
	}
	

	public static void main(String[] agrs) {

		
		// splash screen
		 JWindow window = new JWindow(); try{ window.getContentPane().add( new
		  JLabel("", new ImageIcon(new
		  URL("http://cdn.makeagif.com/media/4-25-2015/LyuNvb.gif")),
		  SwingConstants.CENTER)); window.setBounds(400, 150, 630, 290);
		  window.setVisible(true);
		  
		  Thread.sleep(6000); } catch (InterruptedException |
				  MalformedURLException e) { } window.setVisible(false);
		 
		JFrame mframe = new MainMenu();
		mframe.setTitle("Main Menu");
		mframe.setSize(800, 600);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
	}
}