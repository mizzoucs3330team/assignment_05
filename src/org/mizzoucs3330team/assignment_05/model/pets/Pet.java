package org.mizzoucs3330team.assignment_05.model.pets;

public abstract class Pet /*implements Comparable<Pet>*/{
    //initializers
    private String name;
    private int age;
    private String species;
    private boolean adopted;
    
    //getters/setters
    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getSpecies() {return species;}
    public void setSpecies(String species) {this.species = species;}

    public boolean getAdopted() {return adopted;}
    public void setAdopted(boolean adopted) {this.adopted = adopted;}
    
    //comparables
    //@Override
    //public int compareTo(Pet n){
    //    return this.name.compareTo(n.name);
    //}
}
