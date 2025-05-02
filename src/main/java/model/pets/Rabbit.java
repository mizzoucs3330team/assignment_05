package main.java.model.pets;

public class Rabbit extends Pet{
    private String breed;

	/**
	 * Create a Rabbit.
	 * 
	 * @param name    The rabbit's name.
	 * @param age     The rabbit's age in years.
	 * @param adopted Set to true if the rabbit has an owner; false otherwise.
	 */
	public Rabbit(int id, String name, int age, boolean adopted, String breed) {
		super(id, name, age, adopted);
        this.breed = breed;
    }

    /**
     * Retrieves the species of the rabbit.
     * 
     * @return The string "Rabbit"
     */
    @Override 
    public String getSpecies() { 
        return "Rabbit"; 
    }

    /**
     * Retrieves the breed of the rabbit.
     * 
     * @return The breed designation
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Updates the rabbit's breed.
     * 
     * @param breed The new breed to assign (cannot be null or blank)
     * @throws IllegalArgumentException if breed is null or empty
     */
    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be null or blank");
        }
        this.breed = breed;
    }

    /**
     * Provides formatted string representation including breed information.
     * 
     * @return Formatted string with pet details and breed
     */
    @Override
    public String toString() {
        return super.toString() + " - Breed: " + breed;
    }

}
