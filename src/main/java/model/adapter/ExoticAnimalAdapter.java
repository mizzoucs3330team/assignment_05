package main.java.model.adapter;

import main.java.model.ExoticAnimal;
import main.java.model.pets.Pet;

public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimal exoticAnimal;

    public ExoticAnimalAdapter(ExoticAnimal exoticAnimal){
        this.exoticAnimal = exoticAnimal;
        //map exotic animal properties to animal properties
    }
}
