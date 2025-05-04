/*
 * WARNING: DO NOT USE THE DESIGN TAB. IT IS TOO EASY TO BREAK THINGS.
 */

package main.java.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.java.controller.PetController;
import main.java.model.pets.Pet;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	DefaultTableModel tableModel;
	private PetController petController;

	/**
	 * Create the frame.
	 */
	public View(PetController petController) {
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
		tableModel = new DefaultTableModel(data, colNames);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);

		//dummy row
		//tableModel.addRow(new Object[] { 1, "Harold", "Pig", "Pink", 2, "No", "TODO: Delete Btn, etc." });

		// Southern Buttons
		JPanel btnPanel = new JPanel();
		btnPanel.add(new JButton("Add Pet"));
		btnPanel.add(new JButton("Save All"));

		//Sort Buttons
		//currently have: Name, Age, and ID
		JButton btnSortByAge = new JButton("Sort by Age");
		btnSortByAge.addActionListener(e -> {
			petController.getShelter().sortPetsByAge();
			refreshPetTable();
		});
		btnPanel.add(btnSortByAge);
		
		JButton btnSortByID = new JButton("Sort by ID");
		btnSortByID.addActionListener(e -> {
			petController.getShelter().sortPetsById();
			refreshPetTable();
		});
		btnPanel.add(btnSortByID);
		JButton btnSortBySpecies = new JButton("Sort by Species");
		btnSortBySpecies.addActionListener(e -> {
			petController.getShelter().sortPetsBySpecies();
			refreshPetTable();
		});
		btnPanel.add(btnSortBySpecies);
		getContentPane().add(btnPanel, BorderLayout.SOUTH);

		//instantiate petController instance here and load pets
		this.petController = petController;
		refreshPetTable();

	}
	/**
	 * Fetch all pets from the controller and call setPets method to update the table
	 * 
	 */
	private void refreshPetTable() {
		java.util.List<Pet> pets = petController.getShelter().getPets();
		setPets(pets.toArray(new Pet[0]));
	}
	
	/**
	 * Set the pets that are displayed inside the table.
	 * 
	 * @param pets The pets to display.
	 */
	public void setPets(Pet[] pets) {
		// Remove all existing rows.
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}

		for (Pet pet : pets) {

			String typeString = pet.getClass().getSimpleName();
			String speciesString = pet.getSpecies();
		
			tableModel.addRow(new Object[] {
				pet.getId(),
				pet.getName(),
				typeString,
				speciesString,
				pet.getAge(),
				pet.getAdopted() ? "Yes" : "No",
				"TODO: Delete Btn, other actions etc."
			});
		}

	}
}
