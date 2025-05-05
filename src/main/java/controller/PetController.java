package main.java.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import main.java.model.PetDeserializer;
import main.java.model.pets.Pet;
import main.java.model.shelter.Shelter;

public class PetController {
	private final Shelter<Pet> shelter;
	private final Gson gson;

	public PetController() {
		this.shelter = new Shelter<>();
		this.gson = new GsonBuilder().registerTypeAdapter(Pet.class, new PetDeserializer()).setPrettyPrinting()
				.create();
	}

	/**
	 * Loads pets from JSON file into shelter
	 * 
	 * @param filePath Path to JSON file
	 * @throws IOException        if file operations fail
	 * @throws JsonParseException for invalid JSON structures
	 */
	public void loadPets(String filePath) throws IOException, JsonParseException {
		try (Reader reader = new FileReader(filePath)) {
			Type petListType = new TypeToken<List<Pet>>() {
			}.getType();
			List<Pet> pets = gson.fromJson(reader, petListType);

			// Add duplicate check
			Set<Integer> ids = new HashSet<>();
			for (Pet pet : pets) {
				if (!ids.add(pet.getId())) {
					throw new JsonParseException("Duplicate pet ID in JSON: " + pet.getId());
				}
			}

			pets.forEach(shelter::addPet);
		}
	}

	/**
	 * Handles pet adoption process
	 * 
	 * @param petId ID of pet to adopt
	 * @throws IllegalArgumentException if pet not found
	 * @throws IllegalStateException    if pet already adopted
	 */
	public void adoptPet(int petId) throws IllegalArgumentException, IllegalStateException {
		Pet target = shelter.getPets().stream().filter(p -> p.getId() == petId).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Pet not found"));

		shelter.adoptPet(target);
	}

	/**
	 * Retrieves current shelter inventory
	 * 
	 * @return Unmodifiable list of pets
	 */
	public List<Pet> getAvailablePets() {
		return shelter.getPets().stream().filter(p -> !p.getAdopted()).toList();
	}

	/**
	 * Displays current shelter status
	 */
	public void displayShelterStatus() {
		System.out.println("Current Shelter Status:");
		shelter.displayPets();
		System.out.println("Total pets: " + shelter.getPets().size());
		System.out.println("Available for adoption: " + getAvailablePets().size());
	}

	/**
	 * Provides access to the underlying shelter instance
	 * 
	 * @return The managed shelter instance
	 */
	public Shelter<Pet> getShelter() {
		return this.shelter;
	}
	
	public void savePetsToFile(String filepath) throws IOException{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Pet> pets = this.getShelter().getPets();

		try (FileWriter writer = new FileWriter(filepath)) {
        	gson.toJson(pets, writer);
    	}
	}
}
