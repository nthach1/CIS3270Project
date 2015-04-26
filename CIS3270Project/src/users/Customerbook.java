
package users;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public final class Customerbook extends JFrame{
    
    private final String [] column = {"Book","Flightnumber", "Datetime","Departure","Destination","SeatAvailable","SeatOccupied"};
    private final Object [][] data = new Object[20][30];
    private final JTextField departure = new JTextField();
    private final JButton exDeparture = new JButton("Find");
    ArrayList<JCheckBox> checkbox= new ArrayList<>(20);  
    private final JTable jTable =new JTable(data,column){  
      @Override
      public boolean isCellEditable(int row, int column){
       return false;        
      }  
      @Override
      public Class getColumnClass(int column){
          return getValueAt(0,column).getClass();
      }
    };
    private final TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable.getModel());
    
    public void connection(){
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
    ("select * from flight");
    for(int j=0;j<data.length;j++){
        checkbox.add(new JCheckBox());
        }
    for (int i=0;i<data.length;i++) {
    while (resultSet.next()){
            data[i][0] = checkbox.get(i);
            data[i][1] = resultSet.getString(1);
            data[i][2] = resultSet.getString(2);
            data[i][3] = resultSet.getString(3);
            data[i][4] = resultSet.getString(4);
            data[i][5] = resultSet.getString(5);
            data[i][6] = resultSet.getString(6);
        }
}
    connection.close();
                }
    catch (ClassNotFoundException | SQLException ex){
            }  
    }

    public Customerbook(){
        connection();
        add(new JScrollPane(jTable));
        jTable.setRowSorter(sorter);
        JPanel panel = new JPanel(new java.awt.BorderLayout());
        panel.add(new JLabel("Flight "),
        BorderLayout.WEST);
        panel.add(departure, BorderLayout.CENTER);
        panel.add(exDeparture, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(jTable), BorderLayout.CENTER);

        exDeparture.addActionListener((java.awt.event.ActionEvent e) -> {
            String text = departure.getText();
            if (text.trim().length() == 0)
                sorter.setRowFilter(null);
            else
                sorter.setRowFilter(RowFilter.regexFilter(text));
        });
            }       
    }  

