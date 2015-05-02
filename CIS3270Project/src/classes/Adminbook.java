package classes;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public final class Adminbook extends JFrame {
        // Create data and header for table
	private final String[] column = {"Flightnumber", "Datetime",
			"Departure", "Destination", "SeatAvailable", "SeatOccupied" };
	private final Object[][] data = new Object[20][30];
	private final JTextField departure = new JTextField();
	private final JButton exDeparture = new JButton("Find");
	private final JTable jTable = new JTable(data, column) {
        // Made cell of table unchangable    
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private final TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable.getModel());
        //Establish connection
	public void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			// Establish a connection
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/cis3270", "root", "8731120q");
			System.out.println("Database connected");
			// Create a statement
			Statement statement = connection.createStatement();
			// Execute a statement
			ResultSet resultSet = statement
					.executeQuery("select * from flight");
			// value will be save
			for (int i = 0; i < data.length; i++) {
				while (resultSet.next()) {				
					data[i][0] = resultSet.getString(1);
					data[i][1] = resultSet.getString(2);
					data[i][2] = resultSet.getString(3);
					data[i][3] = resultSet.getString(4);
					data[i][4] = resultSet.getString(5);
					data[i][5] = resultSet.getString(6);
				}
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException ex) {
		}
	}
public Adminbook() {
		connection();
                //Add table to JScrollPane
		add(new JScrollPane(jTable));
                //Allow sort in row
		jTable.setRowSorter(sorter);
		JPanel panel = new JPanel(new java.awt.BorderLayout());
                //Add Label Flight
		panel.add(new JLabel("Flight "), BorderLayout.WEST);
                //Add textfield and button to panel
		panel.add(departure, BorderLayout.CENTER);
		panel.add(exDeparture, BorderLayout.EAST);
                //Add Jpanel to current class
		add(panel, BorderLayout.SOUTH);
		add(new JScrollPane(jTable), BorderLayout.CENTER);
                // Assign listener to button execution
		exDeparture.addActionListener((java.awt.event.ActionEvent e) -> {
			String text = departure.getText();
			if (text.trim().length() == 0)
				sorter.setRowFilter(null);
			else
				sorter.setRowFilter(RowFilter.regexFilter(text));
		});
	}

}
