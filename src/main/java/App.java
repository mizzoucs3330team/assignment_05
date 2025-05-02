package main.java;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

import main.java.controller.PetController;

public class App {
	public static void main(String[] args) {
		try {
			// Initialize petController
			PetController petController = new PetController();

			// Load regular pets
			petController.loadPets("./src/main/resources/pets.json");
			System.out.println("LOADED PETS SUCCESSFULLY");

			// Load exotic animals
			petController.loadPets("./src/main/resources/exotic_animals.json");
			System.out.println("LOADED EXOTICS SUCCESSFULLY\n");

			// Display initial status
			petController.displayShelterStatus();

			// Sort and display
			System.out.println("\nSorted by Name:");
			petController.getShelter().sortPetsByName();
			petController.displayShelterStatus();

			// Adopt pet 3 then display again
			System.out.println("\nAdopting pet with ID: 3");
			petController.adoptPet(3);
			petController.displayShelterStatus();

			System.out.println("\nEOP\n");

		} catch (Exception e) {
			System.err.println("Critical error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

		// ======================================================================
		// GUI stuff
		// Maybe move this into its own class.
		JFrame frame = new JFrame("Pet Center Administrative Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);

		String[] columnNames = { "Name", "Age" };

		JTable table = new JTable("Pets");

		JButton button = new JButton("Press");
		frame.getContentPane().add(button); // Adds Button to content pane

		frame.setVisible(true);

	}

}
