package main.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Pet Center Administrative Panel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(573, 426);
		setLocationRelativeTo(null); // Has the frame open in the center of the screen.
//		setResizable(false);
		getContentPane().setLayout(new BorderLayout());

		JLabel lblNewLabel = new JLabel("Pet Center Admin Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		String[] colNames = { "Pet ID", "Name", "Type", "Species", "Age", "Adopted?", "Actions" };
		Object[][] data = {};
		DefaultTableModel tableModel = new DefaultTableModel(data, colNames);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		// Doesn't seem to work.
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// Pet ID
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMinWidth(45);
		table.getColumnModel().getColumn(0).setMaxWidth(45);

		// Name
		table.getColumnModel().getColumn(1).setMaxWidth(100);

		// Type
		table.getColumnModel().getColumn(2).setMaxWidth(100);

		// Species
		table.getColumnModel().getColumn(3).setMaxWidth(100);

		// Age
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setMinWidth(35);
		table.getColumnModel().getColumn(4).setMaxWidth(35);

		// Adopted?
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setMinWidth(60);
		table.getColumnModel().getColumn(5).setMaxWidth(60);

		tableModel.addRow(new Object[] { 1, "Harold", "Pig", "Pink", 2, "No", "TODO: Delete Btn, etc." });

	}
}
