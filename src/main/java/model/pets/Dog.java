package main.java.model.pets;

public class Dog extends Pet {

	/**
	 * Create a Dog.
	 * 
	 * @param name    The dog's name.
	 * @param age     The dog's age in years.
	 * @param adopted Set to true if the dog has an owner; false otherwise.
	 */
	public Dog(String name, int age, boolean adopted) {
		super(name, age, adopted);
	}

}
