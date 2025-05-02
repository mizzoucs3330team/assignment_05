package main.java.model.pets;

public class Cat extends Pet {
    private String breed;

    /**
     * Create a Cat.
     * 
     * @param id      Unique identifier
     * @param name    The cat's name
     * @param age     The age in years
     * @param adopted Adoption status
     * @param breed   Breed designation
     */
    public Cat(int id, String name, int age, boolean adopted, String breed) {
        super(id, name, age, adopted);
        this.breed = breed;
    }

    /**
     * Retrieves the species classification.
     * 
     * @return The string "Cat"
     */
    @Override
    public String getSpecies() {
        return "Cat";
    }

    /**
     * Retrieves the specific breed designation.
     * 
     * @return The cat's breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Updates the feline breed designation.
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
     * @return String containing cat details and breed
     */
    @Override
    public String toString() {
        return super.toString() + " - Breed: " + breed;
    }
}
