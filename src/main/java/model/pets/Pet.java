package main.java.model.pets;

public abstract class Pet /* implements Comparable<Pet> */ {
	// initializers
	private String name;
	private int age;
	private boolean adopted;
//    Species should probably be implemented via subclasses.
//    private String species;
//    public String getSpecies() {return species;}
//    public void setSpecies(String species) {this.species = species;}

	/**
	 * Create a Pet.
	 * 
	 * @param name    The pet's name.
	 * @param age     The age of the pet in years.
	 * @param adopted Set to true if the pet has an owner; otherwise false.
	 */
	public Pet(String name, int age, boolean adopted) {
		this.name = name;
		this.age = age;
		this.adopted = adopted;
	}

	/*
	 * Evan, these all need JavaDoc comments. One comment for all of them will mean
	 * deducted points for us.
	 */
	// getters/setters
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	// comparables
	// @Override
	// public int compareTo(Pet n){
	// return this.name.compareTo(n.name);
	// }
}
