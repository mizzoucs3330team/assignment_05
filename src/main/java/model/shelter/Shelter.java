package main.java.model.shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import main.java.model.pets.Pet;

public class Shelter<T extends Pet> {
    private final List<T> pets = new ArrayList<>();

    /**
     * Adds a pet to the shelter
     * @param pet Pet to add (cannot be null)
     * @throws IllegalArgumentException if pet is null or duplicate ID exists
     */
    public void addPet(T pet) throws IllegalArgumentException {
        if(pet == null) {
            throw new IllegalArgumentException("Cannot add null pet");
        }
        if(pets.stream().anyMatch(p -> p.getId() == pet.getId())) {
            throw new IllegalArgumentException("Duplicate pet ID: " + pet.getId());
        }
        pets.add(pet);
    }

    /**
     * Removes a pet from the shelter
     * @param pet Pet to remove
     * @return true if removal succeeded, false otherwise
     */
    public boolean removePet(T pet) {
        return pets.remove(pet);
    }

    /**
     * Retrieves unmodifiable list of pets
     * @return View of current pets
     */
    public List<T> getPets() {
        return Collections.unmodifiableList(pets);
    }

    /**
     * Sorts pets by name
     */
    public void sortPetsByName() {
        pets.sort(Comparator.naturalOrder());
    }

    /**
     * Sorts pets by age (ascending)
     */
    public void sortPetsById() {
        pets.sort(Comparator.comparingInt(Pet::getId));
    }

    /**
     * Sorts pets by age (ascending)
     */
    public void sortPetsByAge() {
        pets.sort(Comparator.comparingInt(Pet::getAge));
    }

    /**
     * Sorts pets by species
     */
    public void sortPetsBySpecies() {
        pets.sort(Comparator.comparing(Pet::getSpecies));
    }
    /**
     * Sorts pets by adoption status
     */
    public void sortPetsByAdoptable() {
        pets.sort(Comparator.comparing(Pet::getAdopted));
    }

    /**
     * Marks pet as adopted
     * @param pet Pet to adopt
     * @throws IllegalStateException if pet already adopted
     */
    public void adoptPet(T pet) throws IllegalStateException {
        if(pet.getAdopted()) {
            throw new IllegalStateException(pet.getName() + " already adopted");
        }
        pet.setAdopted(true);
    }

    /**
     * Displays formatted pet list to standard output
     */
    public void displayPets() {
        pets.forEach(p -> System.out.println(
            p + " - Status: " + (p.getAdopted() ? "Adopted" : "Available")
        ));
    }
}
