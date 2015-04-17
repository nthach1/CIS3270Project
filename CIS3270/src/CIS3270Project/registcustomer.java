package CIS3270Project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;

public class registcustomer extends JFrame{
        private final  JButton save = new JButton("Save");
        private final JButton cancel = new JButton("Cancel");
        private final JButton Main= new JButton("Main");
        private final JTextField fname = new JTextField(30);
        private final JTextField lname = new JTextField(30);
        private final JTextField address = new JTextField(30);
        private final JTextField city = new JTextField(30);
        private final JTextField zip = new JTextField(6);
        private final JTextField ssn = new JTextField(8);
        private final JTextField state = new JTextField(2);
        private final JTextField email = new JTextField(30);
        private final JTextField username = new JTextField(30);
        private final JPasswordField password = new JPasswordField(30);
        private final JTextField answer = new JTextField(30);
        private PreparedStatement statement;
        
        public registcustomer() {  
        initializeDB();    
        final JPanel function = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        
        function.add(save);
        function.add(cancel);
        function.add(Main);
     
        Main.addActionListener((ActionEvent ev) -> {
            JFrame frame = new MainMenu();
            frame.setTitle("Main Menu");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
        
        final JPanel detail = new JPanel(new GridLayout(13,2,0,0));
        detail.add(new JLabel("First Name"));
        detail.add(fname);
        detail.add(new JLabel("Last Name"));
        detail.add(lname);
        detail.add(new JLabel("Address"));
        detail.add(address);
        detail.add(new JLabel("City"));
        detail.add(city);
        detail.add(new JLabel("Zip"));
        detail.add(zip);
        detail.add(new JLabel("State"));
        detail.add(state);
        detail.add(new JLabel("Username"));
        detail.add(username);
        detail.add(new JLabel("Password"));
        detail.add(password);
       ((JPasswordField)password).setEchoChar('*');
        detail.add(new JLabel("email"));
        detail.add(email);
        detail.add(new JLabel("SSN"));
        detail.add(ssn);
        detail.add(new JLabel("Security Question"));
        detail.add(new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
                                       "What is your first car?","Where were your mother born?"}) );
        detail.add(new JLabel("Answer"));
        detail.add(answer);
        
        setLayout(new GridLayout(2,1,0,0));
        add(function);
        add(detail);
 
       
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
             save_actionPerformed(ae);   
            }
        });
        }
    
    private void initializeDB(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/customer","root","8731120q");
        String queryString = "insert into customer(SSN,LastName,FirstName,Address,City,Zip,State,UserName,Password,Email,Answer) "
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
        statement = connection.prepareStatement(queryString);
        } 
    catch (ClassNotFoundException | SQLException ex) {
            }
    }
private void save_actionPerformed(ActionEvent ae){
    String fname = this.fname.getText();
    String lname = this.lname.getText();
    String address = this.address.getText();
    String city = this.city.getText();
    String zip = this.zip.getText();
    String state = this.state.getText();
    String ssn = this.ssn.getText();
    String email = this.email.getText();
    String username = this.username.getText();
    String password = this.password.getSelectedText();
    String answer = this.answer.getText();
    
    try{
        statement.setString(1, ssn);
        statement.setString(2, lname);
        statement.setString(3, fname);
        statement.setString(4, address);
        statement.setString(5, city);
        statement.setString(6, zip);
        statement.setString(7, state);
        statement.setString(8, username);
        statement.setString(9, password);
        statement.setString(10, email);
        statement.setString(11, answer);
        statement.executeUpdate();
    }
    catch(SQLException ex){
        }
    }    
}