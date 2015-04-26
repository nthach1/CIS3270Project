package users;

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

public class loginad extends JFrame {
    private final JTextField username = new JTextField(20);
    private final JTextField getUsername = new JTextField(20);
    private final Component password = new JPasswordField(30);
    private final JButton ok = new JButton("OK");
    private final JButton cancel = new JButton("Cancel");
    private final JButton Main = new JButton("Main");
    private final JTextField forgotpassword = new JTextField(20);
    private final JButton submit = new JButton("Submit");
    public loginad(){
     final JPanel login = new JPanel(new GridLayout(13,2,0,0));
        login.add(new JLabel("Log in"));
        login.add(new JLabel("Username"));
        login.add(username);
        login.add(new JLabel("Password"));
        login.add(password);
        ((JPasswordField)password).setEchoChar('*'); 
        login.add(ok);
        login.add(cancel);
        
   final JPanel forgotpass = new JPanel(new GridLayout(13,2,0,0));  
        forgotpass.add(Main);
        forgotpass.add(new JLabel("Forgot Password?"));
        forgotpass.add(new JLabel("Username"));
        forgotpass.add(getUsername);
        forgotpass.add(new JLabel("Security Question"));
        forgotpass.add(new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
                                       "What is your first car?","Where were your mother born?"}) );
        forgotpass.add(new JLabel("Answer"));
        forgotpass.add(forgotpassword); 
        forgotpass.add(submit);
        setLayout(new GridLayout(2,1,5,5));
        add(login);
        add(forgotpass);   
        
        Password pass = new Password();
        submit.addActionListener(pass);
        
        Main.addActionListener((ActionEvent ev) -> {
            JFrame frame = new MainMenu();
            frame.setTitle("Main Menu");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
     });
        ok.addActionListener((ActionEvent ev) -> {
            JFrame frame = new Customerbook();
            frame.setTitle("Book Flight");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
     });
    }
    

class Password implements ActionListener{
        private String getPassword;
        private String getAnswer;
        private String getAdmin;
        @Override
        public void actionPerformed(ActionEvent e) {
           try{     
   Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver loaded");
    // Establish a connection
    Connection connection = DriverManager.getConnection
      ("jdbc:mysql://localhost/cis3270","root","8731120q");
    System.out.println("Database connected");
    // Create a statement
    Statement statement = connection.createStatement();
    // Execute a statement
    ResultSet resultSet =statement.executeQuery
    ("select Answer, Password,Admin from customer where Username ='"+getUsername.getText()+"'");
    while (resultSet.next()){
      System.out.println(resultSet.getString(1) +"\t"+
      resultSet.getString(2)+"\t"+resultSet.getString(3));
      getPassword = resultSet.getString(2);
      getAnswer=resultSet.getString(1);
      getAdmin=resultSet.getString(3);}
    
    connection.close();
   }
    catch (ClassNotFoundException | SQLException ex){
        }      
     if ((forgotpassword.getText().equals(getAnswer))&&(getAdmin.equals("0"))){
        JOptionPane.showMessageDialog(null, "You are customer, You can't get password here!!");
            }
      else if ((forgotpassword.getText().equals(getAnswer))&&(getAdmin.equals("1"))){
        JOptionPane.showMessageDialog(null, "Your password is: "+getPassword);
            }
    else{JOptionPane.showMessageDialog(null, "Your Answer is wrong, please try again!!!!");}
        }   
    }
}