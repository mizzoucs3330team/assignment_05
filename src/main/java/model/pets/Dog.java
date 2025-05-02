package main.java.model.pets;

public class Dog extends Pet {
    private String breed;

    /**
     * Create a Dog.
     * 
     * @param id      Unique identifier
     * @param name    The dog's name
     * @param age     The age in years
     * @param adopted Adoption status
     * @param breed   Breed designation (e.g., Golden Retriever, German Shepherd)
     */
    public Dog(int id, String name, int age, boolean adopted, String breed) {
        super(id, name, age, adopted);
        this.breed = breed;
    }

    /**
     * Retrieves the species classification.
     * 
     * @return The string "Dog"
     */
    @Override
    public String getSpecies() {
        return "Dog";
    }

    /**
     * Retrieves the canine breed designation.
     * 
     * @return The dog's breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Updates the canine breed designation.
     * 
     * @param breed New breed value (cannot be null/blank)
     * @throws IllegalArgumentException for invalid breed
     */
    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be null or blank");
        }
        this.breed = breed;
    }

    /**
     * Provides formatted string representation.
     * 
     * @return String containing dog details and breed
     */
    @Override
    public String toString() {
        return super.toString() + " - Breed: " + breed;
    }
}
