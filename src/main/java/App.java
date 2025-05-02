package main.java;

import main.java.controller.PetController;

public class App {
    public static void main(String[] args) {
        try {
            //Initialize controller with dependency injection
            PetController petController = new PetController();
            
            //Load regular pets
            petController.loadPets("./src/main/resources/pets.json");
            System.out.println("LOADED PETS SUCCESSFULLY");
            
            //Load exotic animals
            petController.loadPets("./src/main/resources/exotic_animals.json");
            System.out.println("LOADED EXOTICS SUCCESSFULLY\n");

            //Display initial status
            petController.displayShelterStatus();
            
            //Sort and display
            System.out.println("\nSorted by Name:");
            petController.getShelter().sortPetsByName();
            petController.displayShelterStatus();

            //Adopt Pet 3 then display
            System.out.println("\nAdopting pet with ID: 3");
			petController.adoptPet(3);
            petController.displayShelterStatus();

            System.out.println("\nEOP\n");
        } catch (Exception e) {
            System.err.println("Critical error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
