package menus;

import java.awt.FlowLayout;
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

	public MainMenu() {
		final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		panel.add(login);
		panel.add(register);
		add(panel);
		panel.setVisible(true);

		final JPanel log = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		log.add(logcustomer);
		log.add(Main1);
		log.setVisible(false);

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
		regcustomer.addActionListener((ActionEvent ev) -> {
			JFrame frame = new registcustomer();
			frame.setTitle("Customer Account Registration");
			frame.setSize(800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			dispose();
		});

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

		
//		  JWindow window = new JWindow(); try{ window.getContentPane().add( new
//		  JLabel("", new ImageIcon(new
//		  URL("http://cdn.makeagif.com/media/4-25-2015/LyuNvb.gif")),
//		  SwingConstants.CENTER)); window.setBounds(400, 150, 630, 290);
//		  window.setVisible(true);
//		  
//		  Thread.sleep(6000); } catch (InterruptedException |
//		  MalformedURLException e) { } window.setVisible(false);
		 
		JFrame mframe = new MainMenu();
		mframe.setTitle("Main Menu");
		mframe.setSize(800, 600);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
	}
}