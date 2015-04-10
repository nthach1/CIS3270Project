
package CIS3270Project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class logad extends JFrame {
    public logad(){
     final JPanel login = new JPanel(new GridLayout(13,2,0,0));
        login.add(new JLabel("Log in"));
        login.add(new JLabel("Username"));
        login.add(new JTextField(20));
        login.add(new JLabel("Password"));
        login.add(new JTextField(6));
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        login.add(ok);
        login.add(cancel);
   final JPanel forgotpass = new JPanel(new GridLayout(13,2,0,0));
        JButton Main = new JButton("Main");
        forgotpass.add(Main);
        forgotpass.add(new JLabel("Forgot Password?"));
        forgotpass.add(new JLabel("Username"));
        forgotpass.add(new JTextField(20));
        forgotpass.add(new JLabel("Email"));
        forgotpass.add(new JTextField(30));
        forgotpass.add(new JLabel("Security Question"));
        forgotpass.add(new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
                                       "What is your first car?","Where were your mother born?"}) );
        forgotpass.add(new JLabel("Answer"));
        forgotpass.add(new JTextField(50)); 
        setLayout(new GridLayout(2,1,5,5));
        add(login);
        add(forgotpass);   
        
        Main.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent ev){
         JFrame frame = new MainMenu();
         frame.setTitle("Main Menu");
         frame.setSize(800, 600);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
            }
        });
    }
}
