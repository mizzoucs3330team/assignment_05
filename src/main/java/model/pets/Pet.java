package main.java.model.pets;

public abstract class Pet implements Comparable<Pet> {
	private int id;
	private String name;
	private int age;
	private boolean adopted;

	/**
	 * Create a Pet.
	 * 
	 * @param id      Unique identifier for the pet.
	 * @param name    The pet's name.
	 * @param age     The age of the pet in years.
	 * @param adopted Set to true if the pet has an owner; otherwise false.
	 */
	public Pet(int id, String name, int age, boolean adopted) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.adopted = adopted;
	}

	/**
	 * Retrieves the pet's unique identifier.
	 * 
	 * @return Returns the pet's ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the pet's unique identifier.
	 * 
	 * @param id The pet's ID. Must be positive or 0
	 * @throws IllegalArgumentException for non-positive IDs
	 */
	public void setId(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be positive");
		}
		this.id = id;
	}

	/**
	 * Retrieves the pet's age.
	 * 
	 * @return Returns the age of the pet in years.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the pet's age.
	 * 
	 * @param age The age of the pet in years (must be non-negative)
	 * @throws IllegalArgumentException if age is negative
	 */
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age cannot be negative.");
		}
		this.age = age;
	}

	/**
	 * Retrieves the pet's name.
	 * 
	 * @return Returns the name of the pet.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the pet's name.
	 * 
	 * @param name The name to assign to the pet (cannot be null or blank)
	 */
	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be null or blank.");
		}
		this.name = name;
	}

	/**
	 * Retrieves the pet's adoption status.
	 * 
	 * @return true if the pet has been adopted, false otherwise
	 */
	public boolean getAdopted() {
		return adopted;
	}

	/**
	 * Sets the pet's adoption status.
	 * 
	 * @param adopted The adoption status to set (true = adopted, false = available)
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	// Is this in the spec?
	// Why wouldn't we just pet1.getName().comepareTo(pet2.getName()) ?
	/**
	 * Compares this pet to another by name
	 * 
	 * @param other The pet to compare against
	 * @return Negative if this pet's name comes first alphabetically, positive if
	 *         after, or 0 if names are equal
	 */
	@Override
	public int compareTo(Pet n) {
		return this.name.compareTo(n.name);
	}

	/**
	 * Retrieves the specific species classification of the pet.
	 * 
	 * @return A string representing the pet's species
	 */
	public abstract String getSpecies();

	/**
	 * Get a String representation of the pet.
	 * 
	 * @return Returns the pet's string.
	 */
	@Override
	public String toString() {
		return String.format("%s (ID: %d) - %d years old", name, id, age);
	}
}