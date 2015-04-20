package users;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class registad extends JFrame{
  private final  JButton save = new JButton("Save");
  private final JButton cancel = new JButton("Cancel");
  private final JButton Main= new JButton("Main");
  private final JTextField fname = new JTextField(30);
  private final JTextField lname = new JTextField(30);
  private final JTextField email = new JTextField(30);
  private final JTextField Acode = new JTextField(30);
  private final JTextField username = new JTextField(30);
  private final JPasswordField password = new JPasswordField(30);
  private final JTextField answer = new JTextField(30);

    public registad(){   
        
        final JPanel function = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));        
        function.add(save);
        save.setHorizontalAlignment(4);
        cancel.setHorizontalAlignment(4);
        function.add(cancel);
        Main.setHorizontalAlignment(4);
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
        detail.add(new JLabel("Email"));
        detail.add(email);
        detail.add(new JLabel("Username"));
        detail.add(username);
        detail.add(new JLabel("Password"));
         detail.add(password);
       ((JPasswordField)password).setEchoChar('*');
        detail.add(new JLabel("Authorize code"));
        detail.add(Acode);
        detail.add(new JLabel("Security Question"));
        detail.add(new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
                                       "What is your first car?","Where were your mother born?"}) );
        detail.add(new JLabel("Answer"));
        detail.add(answer);    
        
        setLayout(new GridLayout(2,1,0,0));
        add(function);
        add(detail);       

    }
}