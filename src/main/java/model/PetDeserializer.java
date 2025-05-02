package main.java.model;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import main.java.model.adapter.ExoticAnimalAdapter;
import main.java.model.pets.Cat;
import main.java.model.pets.Dog;
import main.java.model.pets.Pet;
import main.java.model.pets.Rabbit;

public class PetDeserializer implements JsonDeserializer<Pet> {

    /**
     * Converts JSON to Pet implementation
     * @param json Parsed JSON element
     * @param typeOfT Target type (Pet)
     * @param context Deserialization context
     * @return Concrete Pet instance
     * @throws JsonParseException for invalid JSON structures
     */
    @Override
    public Pet deserialize(JsonElement json, Type typeOfT, 
                         JsonDeserializationContext context) throws JsonParseException {
        
        JsonObject obj = json.getAsJsonObject();
        
        //Handle regular pets
        if (obj.has("id")) {
            int id = obj.get("id").getAsInt();
            String name = obj.get("name").getAsString();
            int age = obj.get("age").getAsInt();
            boolean adopted = obj.get("adopted").getAsBoolean();
            String species = obj.get("species").getAsString();
            String type = obj.get("type").getAsString().toLowerCase();

            switch(type) {
                case "dog":
                    return new Dog(id, name, age, adopted, species);
                case "cat":
                    return new Cat(id, name, age, adopted, species);
                case "rabbit":
                    return new Rabbit(id, name, age, adopted, species);
                default:
                    throw new JsonParseException("Unsupported pet type: " + type);
            }
        }
        
        //Handle exotic animals
        else if (obj.has("uniqueId")) {
            ExoticAnimal exotic = context.deserialize(json, ExoticAnimal.class);
            return new ExoticAnimalAdapter(exotic);
        }
        
        throw new JsonParseException("Unrecognized JSON schema - missing required fields");
    }
}
