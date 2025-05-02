package main.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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

		table = new JTable(new Object[][] {},
				new String[] { "Pet ID", "Name", "Adopted?", "Age", "Type", "Species", "Actions" });

		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(0).setMaxWidth(40);

		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(2).setMaxWidth(60);

		scrollPane.setViewportView(table);

//
//		JTable table = new JTable(data, columnNames);

	}
}
