package main.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

import main.java.model.pets.Dog;
import main.java.model.pets.Pet;

public class App {
	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();
		Reader reader = new FileReader("./src/main/resources/pets.json");

		// This is assuming one Pet in the file--there are 3. So it's wrong.
		Pet pet = gson.fromJson(reader, Pet.class);

		Dog dog = new Dog("Bolt", 1, false);

	}
}
