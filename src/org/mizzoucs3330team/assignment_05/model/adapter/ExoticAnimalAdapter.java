package org.mizzoucs3330team.assignment_05.model.adapter;

import org.mizzoucs3330team.assignment_05.model.ExoticAnimal;
import org.mizzoucs3330team.assignment_05.model.pets.Pet;

public class ExoticAnimalAdapter extends Pet {
    private ExoticAnimal exoticAnimal;

    public ExoticAnimalAdapter(ExoticAnimal exoticAnimal){
        this.exoticAnimal = exoticAnimal;
        //map exotic animal properties to animal properties
    }
}
