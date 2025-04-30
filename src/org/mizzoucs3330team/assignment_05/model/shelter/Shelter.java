package org.mizzoucs3330team.assignment_05.model.shelter;

import java.util.ArrayList;
import java.util.List;

import org.mizzoucs3330team.assignment_05.model.pets.Pet;

public class Shelter <T extends Pet>{
    private List<T> pets = new ArrayList<>();

    public void addPet(T pet) {
        pets.add(pet);
    }

    //comparator operations
}
