package main.java.model.pets;

public class Cat extends Pet{

	/**
	 * Create a Cat.
	 * 
	 * @param name    The dog's name.
	 * @param age     The dog's age in years.
	 * @param adopted Set to true if the dog has an owner; false otherwise.
	 */
	public Cat(String name, int age, boolean adopted) {
		super(name, age, adopted);
	}

    @Override 
	public String getSpecies() { return "Cat"; }
}
