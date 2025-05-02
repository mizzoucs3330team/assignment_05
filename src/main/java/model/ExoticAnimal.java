package main.java.model;

public class ExoticAnimal {
    private int uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;

    public void exoticAnimal(int uniqueId, String animalName, String category, String subSpecies, int yearsOld){
        this.uniqueId = uniqueId;
        this.animalName = animalName;
        this.category = category;
        this.subSpecies = subSpecies;
        this.yearsOld = yearsOld;
    }
}

    /*
    "uniqueId": "exo002",
    "animalName": "Kaa",
    "category": "Reptile",
    "subSpecies": "Python",
    "yearsOld": 6
     */