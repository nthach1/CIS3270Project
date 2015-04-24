package users;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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


public class registad extends JFrame{
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
        private final JPasswordField adminKey = new JPasswordField(30);
        
        public registad() {  
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
        detail.add(new JLabel("SSN"));
        detail.add(ssn);
        detail.add(new JLabel("First Name"));
        detail.add(fname);
        detail.add(new JLabel("Last Name"));
        detail.add(lname);
        detail.add(new JLabel("Address"));
        detail.add(address);
        detail.add(new JLabel("City"));
        detail.add(city);
        detail.add(new JLabel("State"));
        detail.add(state);
        detail.add(new JLabel("Zip"));
        detail.add(zip);
        detail.add(new JLabel("Username"));
        detail.add(username);
        detail.add(new JLabel("Password"));
        detail.add(password);
       ((JPasswordField)password).setEchoChar('*');
        detail.add(new JLabel("Email"));
        detail.add(email);
        detail.add(new JLabel("Security Question"));
        detail.add(new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
                                       "What is your first car?","Where were your mother born?"}) );
        detail.add(new JLabel("Answer"));
        detail.add(answer);
        detail.add(new JLabel("Administration Key"));
        detail.add(adminKey);
       ((JPasswordField)adminKey).setEchoChar('*');
       
        Save saveinfor = new Save();
        save.addActionListener(saveinfor);
        
        setLayout(new GridLayout(2,1,0,0));
        add(function);
        add(detail);
        
    }  
class Save implements ActionListener{

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
    statement.executeUpdate
      ("insert into customer(SSN,FirstName, LastName,Address, City,State,Zip,Username,Password,Email,Answer,Admin)"
        + " values('"+ ssn.getText() +"','"+fname.getText()+"','"+lname.getText()+"','"+address.getText()+"','"+city.getText()
        +"','"+state.getText()+"','"+zip.getText()+"','"+username.getText()+"','"+password.getPassword()+"','"+email.getText()
        +"','"+answer.getText()+"','1')");
    connection.close();
      JOptionPane.showMessageDialog(null, "You create account successfully!!");
   }
    catch (ClassNotFoundException | SQLException ex){
        }      
    }        
  }
}