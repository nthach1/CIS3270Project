
package CIS3270Project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class regad extends JFrame{
    public regad(){   
        
        final JPanel function = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));        
        JButton save = new JButton("Save");
        function.add(save);
        save.setHorizontalAlignment(4);
        JButton cancel = new JButton("Cancel");
        cancel.setHorizontalAlignment(4);
        function.add(cancel);
        JButton Main= new JButton("Main");
        Main.setHorizontalAlignment(4);
        function.add(Main);
        function.setSize(200, 300);
        
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
        
        final JPanel detail = new JPanel(new GridLayout(13,2,0,0));
        detail.add(new JLabel("First Name"));
        detail.add(new JTextField(30));
        detail.add(new JLabel("Last Name"));
        detail.add(new JTextField(30));
        detail.add(new JLabel("Email"));
        detail.add(new JTextField(50));
        detail.add(new JLabel("Username"));
        detail.add(new JTextField(20));
        detail.add(new JLabel("Password"));
        detail.add(new JTextField(6));
        detail.add(new JLabel("Authorize code"));
        detail.add(new JTextField(8));
        detail.add(new JLabel("Security Question"));
        detail.add(new JComboBox(new String[]{"What is your father middle name?","What is your first pet?",
                                       "What is your first car?","Where were your mother born?"}) );
        detail.add(new JLabel("Answer"));
        detail.add(new JTextField(50));    
        
        setLayout(new GridLayout(2,1,0,0));
        add(function);
        add(detail);
    }
}
