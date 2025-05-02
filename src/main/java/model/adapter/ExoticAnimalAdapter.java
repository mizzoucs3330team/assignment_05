package main.java.model.adapter;

import main.java.model.ExoticAnimal;
import main.java.model.pets.Pet;

public class ExoticAnimalAdapter extends Pet {
    private final ExoticAnimal exoticAnimal;

    /**
     * Creates adapter for exotic animals
     * @param exoticAnimal Third-party animal to adapt
     */
    public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
        // Convert String ID to int ID
        super(convertId(exoticAnimal.getUniqueId()),
              exoticAnimal.getAnimalName(),
              exoticAnimal.getYearsOld(),
              false);  // start unadopted
        
        this.exoticAnimal = exoticAnimal;
    }

    /**
     * Converts exotic ID format ("exo001") to integer (1)
     * @param uniqueId Third-party ID string
     * @return Numeric portion as an int
     * @throws NumberFormatException for invalid formats
     */
    private static int convertId(String uniqueId) {
        try {
            return Integer.parseInt(uniqueId.replace("exo", ""));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("Invalid exotic ID format: " + uniqueId);
        }
    }

    /**
     * Retrieves species combining category and subspecies
     * @return Formatted species string
     */
    @Override
    public String getSpecies() {
        return exoticAnimal.getCategory() + ": " + exoticAnimal.getSubSpecies();
    }

    /**
     * Provides full exotic animal details
     * @return Formatted string with all information
     */
    @Override
    public String toString() {
        return String.format("%s (Exotic ID: %s) - %d years old",
            exoticAnimal.getAnimalName(), exoticAnimal.getUniqueId(), exoticAnimal.getYearsOld());
    }
}