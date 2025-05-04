package main.java;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.google.gson.JsonParseException;

import main.java.controller.PetController;
import main.java.view.View;

public class App {
	public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
        try {
			//create petController
            PetController petController = new PetController();
            try {
				//load pets
                petController.loadPets("./src/main/resources/pets.json");
                petController.loadPets("./src/main/resources/exotic_animals.json");
                System.out.println("LOADED ALL PETS SUCCESSFULLY");
            } catch (IOException | JsonParseException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                    "Error loading pets: " + e.getMessage(),
                    "File Error",
                    JOptionPane.ERROR_MESSAGE);
            }
			//create frame
			//pass petController variable to assign petController to View
            View frame = new View(petController);
			
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    });
	}

}
