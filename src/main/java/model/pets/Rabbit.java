package main.java.model.pets;

public class Rabbit extends Pet{

	/**
	 * Create a Rabbit.
	 * 
	 * @param name    The rabbit's name.
	 * @param age     The rabbit's age in years.
	 * @param adopted Set to true if the rabbit has an owner; false otherwise.
	 */
	public Rabbit(String name, int age, boolean adopted) {
		super(name, age, adopted);
	}

    @Override 
	public String getSpecies() { return "Rabbit"; }
}
