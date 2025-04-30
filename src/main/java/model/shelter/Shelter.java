package main.java.model.shelter;

import java.util.ArrayList;
import java.util.List;

import main.java.model.pets.Pet;

public class Shelter <T extends Pet>{
    private List<T> pets = new ArrayList<>();

    public void addPet(T pet) {
        pets.add(pet);
    }

    //comparator operations
}
