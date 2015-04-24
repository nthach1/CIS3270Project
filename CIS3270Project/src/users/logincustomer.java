package users;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 


public class logincustomer extends JFrame {
    private final JTextField username = new JTextField(20);
    private final Component password = new JPasswordField(30);
    private final JButton ok = new JButton("OK");
    private final JButton cancel = new JButton("Cancel");
    private final JButton Main = new JButton("Main");
    private final JTextField forgotpassword = new JTextField(20);
    private final JButton submit = new JButton("Submit");
    
public logincustomer(){
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
        forgotpass.add(new JTextField(20));
        forgotpass.add(new JLabel("Security Question"));
        forgotpass.add(new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
                                       "What is your first car?","Where were your mother born?"}) );
        forgotpass.add(new JLabel("Answer"));
        forgotpass.add(forgotpassword); 
        forgotpass.add(submit);
        setLayout(new GridLayout(2,1,5,5));
        add(login);
        add(forgotpass);   
        
        Main.addActionListener((ActionEvent ev) -> {
            JFrame frame = new MainMenu();
            frame.setTitle("Main Menu");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
     });
    }
class Password implements ActionListener{
   
        @Override
        public void actionPerformed(ActionEvent e) {
           Properties props = new Properties();
           Session session = Session.getDefaultInstance(props, null);

        String msgBody = "your password is";

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("qle3@student.gsu.edu"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress("lequan@student.gpc.edu"));
            msg.setSubject("Password Retrieved");
            msg.setText(msgBody);
            Transport.send(msg);

        } 
        catch (AddressException ex) {
            // ...
        } 
        catch (MessagingException en) {
            // ...
        }
        }
    }   
}