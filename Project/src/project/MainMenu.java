
package project;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JFrame {
    public JButton login = new JButton("Login");
    public JButton register = new JButton("Register");
    public JButton Main = new JButton("Main");
    public JButton logcustomer = new JButton("Customer");
    public JButton logad= new JButton("Administrator");
    public JButton regcustomer = new JButton("Customer");
    public JButton regad = new JButton("Administrator");
    
    public MainMenu(){        
    final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,2,2));
    panel.add(login);
    panel.add(register);
    add(panel);
    panel.setVisible(true);
    
   final JPanel log = new JPanel(new FlowLayout(FlowLayout.CENTER,2,2));
    log.add(logcustomer);
    log.add(logad);
    log.add(Main);
    log.setVisible(false);
    
    final JPanel regist = new JPanel(new FlowLayout(FlowLayout.CENTER,2,2));
    regist.add(regcustomer);
    regist.add(regad);
    regist.add(Main);
    regist.setVisible(false);
    
    Main.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent ev){
        panel.setVisible(true);
        log.setVisible(false);
        regist.setVisible(false);
            }
        });
    
    login.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent ev){
        add(log);    
        panel.setVisible(false);
        regist.setVisible(false);
        log.setVisible(true);
            }
        });
    register.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent ev){
        add(regist);    
        panel.setVisible(false);
        log.setVisible(false);
        regist.setVisible(true);
            }
        });
     regcustomer.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent ev){
            JFrame frame = new regcustomer();
            frame.setTitle("Customer Account Registration");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            }
        });
    
     regad.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent ev){ 
            
            JFrame frame = new regad();
            frame.setTitle("Administrator Account Registration");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            }
        });
     logcustomer.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent ev){
            JFrame frame = new logcustomer();
            frame.setTitle("Customer Login");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            }
        });
     logad.addActionListener(new ActionListener(){  
        @Override
        public void actionPerformed(ActionEvent ev){
            JFrame frame = new logad();
            frame.setTitle("Administrator Log in");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            }
        });
    }
public static void main(String[] agrs){    
    JFrame frame = new MainMenu();
    frame.setTitle("Main Menu");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    }
 }
