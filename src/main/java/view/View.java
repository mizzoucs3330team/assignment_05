/*
 * WARNING: DO NOT USE THE DESIGN TAB. IT IS TOO EASY TO BREAK THINGS.
 */

package main.java.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import main.java.controller.PetController;
import main.java.model.pets.Pet;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	DefaultTableModel tableModel;
	
	private PetController petController;

	/**
	 * Create the frame
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
		table.getColumnModel().getColumn(6).setCellRenderer(new AdoptButtonEditorRenderer());
		table.getColumnModel().getColumn(6).setCellEditor(new AdoptButtonEditorRenderer());

		//dummy row
		//tableModel.addRow(new Object[] { 1, "Harold", "Pig", "Pink", 2, "No", "TODO: Delete Btn, etc." });

		// Southern Buttons
		JPanel btnPanel = new JPanel();
		btnPanel.add(new JButton("Add Pet"));
		btnPanel.add(new JButton("Save All"));

		//Sort Buttons
		//currently have: Name, Age, and ID
		JButton btnSortByAvailable = new JButton("Sort by Available");
		btnSortByAvailable.addActionListener(e -> {
			petController.getShelter().sortPetsByAdoptable();
			refreshPetTable();
		});
		btnPanel.add(btnSortByAvailable);
		
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
				"Adopt"
			});
		}

	}
	
	/**
	 * Table cell renderer and editor for the "Adopt" button in the Actions column.
	 * Displays an Adopt button for each pet, enabling marking pets as adopted.
	 * Disables the button if the pet is already adopted.
	 */
	class AdoptButtonEditorRenderer extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
		private final JButton button = new JButton("Adopt");
		private int row = -1;

		/**
		 * Constructs the Adopt button renderer/editor and sets up its action listener.
		 */
		public AdoptButtonEditorRenderer() {
			button.addActionListener(e -> {
				int modelRow = table.convertRowIndexToModel(row);
				int petId = (int) tableModel.getValueAt(modelRow, 0);
				Pet pet = petController.getShelter().getPets().stream()
						.filter(p -> p.getId() == petId)
						.findFirst()
						.orElse(null);
				if (pet != null && !pet.getAdopted()) {
					pet.setAdopted(true);
					refreshPetTable();
				} else if (pet != null) {
					JOptionPane.showMessageDialog(View.this, pet.getName() + " is already adopted.");
				}
			});
		}
		/**
		 * Returns the component used for drawing the cell in the table.
		 * This method configures the "Adopt" button to be enabled only if the pet is not adopted.
		 *
		 * @param table     the JTable that is asking the renderer to draw; can be null
		 * @param value     the value of the cell to be rendered
		 * @param isSelected true if the cell is to be rendered with the selection highlighted; otherwise false
		 * @param hasFocus  if true, render cell appropriately
		 * @param row       the row index of the cell being drawn
		 * @param column    the column index of the cell being drawn
		 * @return the component used for drawing the cell
		 */
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
													boolean hasFocus, int row, int column) {
			int modelRow = table.convertRowIndexToModel(row);
			boolean adopted = "Yes".equals(tableModel.getValueAt(modelRow, 5));
			button.setEnabled(!adopted);
			return button;
		}

		/**
		 * Returns the component that should be added to the table cell when editing.
		 * This method configures the "Adopt" button to be enabled only if the pet is not adopted.
		 *
		 * @param table      the JTable that is asking the editor to edit; can be null
		 * @param value      the value of the cell to be edited
		 * @param isSelected true if the cell is to be rendered with the selection highlighted; otherwise false
		 * @param row        the row index of the cell being edited
		 * @param column     the column index of the cell being edited
		 * @return			 the component for editing
		 */
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
													int row, int column) {
			this.row = row;
			int modelRow = table.convertRowIndexToModel(row);
			boolean adopted = "Yes".equals(tableModel.getValueAt(modelRow, 5));
			button.setEnabled(!adopted);
			return button;
		}

		/**
		 * Returns the value contained in the editor.
		 * Just the string "Adopt".
		 *
		 * @return the value contained in the editor
		 */
		@Override
		public Object getCellEditorValue() {
			return "Adopt";
		}

	}
}
