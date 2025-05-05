package main.java.model.adapter;

import main.java.model.pets.Pet;

public class ExoticAnimal {
    private String uniqueId; //String type acc to exotic animals in the .json
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;

    public void exoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld){
        this.uniqueId = uniqueId;
        this.animalName = animalName;
        this.category = category;
        this.subSpecies = subSpecies;
        this.yearsOld = yearsOld;
    }
    
    /**
     * Retrieves the unique identifier
     * @return Third-party system's ID format
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Updates the unique identifier
     * @param uniqueId New ID value
     */
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * Retrieves the animal's name
     * @return Current name value
     */
    public String getAnimalName() {
        return animalName;
    }

    /**
     * Updates the animal's name
     * @param animalName New name value
     */
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    /**
     * Retrieves animal category
     * @return Classification group (Bird, Reptile, etc.)
     */
    public String getCategory() {
        return category;
    }

    /**
     * Updates animal category
     * @param category New classification
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Retrieves specific subspecies
     * @return Detailed classification
     */
    public String getSubSpecies() {
        return subSpecies;
    }

    /**
     * Updates subspecies designation
     * @param subSpecies New subspecies value
     */
    public void setSubSpecies(String subSpecies) {
        this.subSpecies = subSpecies;
    }

    /**
     * Retrieves age in years
     * @return Age value
     */
    public int getYearsOld() {
        return yearsOld;
    }

    /**
     * Updates age value
     * @param yearsOld New age (can't be negative)
     * @throws IllegalArgumentException for negative ages
     */
    public void setYearsOld(int yearsOld) {
        if(yearsOld < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.yearsOld = yearsOld;
    }
}