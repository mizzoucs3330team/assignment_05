package main.java;

import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

import main.java.model.pets.Dog;

public class App {
	public static void main(String[] args) {
		Gson gson = new Gson();
		Reader reader = new FileReader("./src/main/resources/pets.json");

		Dog dog = new Dog("Bolt", 1, false);

	}
}
