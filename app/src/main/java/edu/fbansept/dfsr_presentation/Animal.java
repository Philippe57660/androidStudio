package edu.fbansept.dfsr_presentation;

import org.json.JSONException;
import org.json.JSONObject;

public class Animal {
    private String animal_type;
    private String animal_name;
    private String animal_image_link;

    public Animal(String animal_type, String animal_name, String animal_image_link) {
        this.animal_type = animal_type;
        this.animal_name = animal_name;
        this.animal_image_link = animal_image_link;
    }

    public String getAnimal_type() {
        return animal_type;
    }

    public void setAnimal_type(String animal_type) {
        this.animal_type = animal_type;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getAnimal_image_link() {
        return animal_image_link;
    }

    public void setAnimal_image_link(String animal_image_link) {
        this.animal_image_link = animal_image_link;
    }

    public Animal(JSONObject json) {

        try {
            this.animal_type = json.getString("animal_type");
            this.animal_name = json.getString("animal_name");
            this.animal_image_link = json.getString("animal_image_link");
        } catch (JSONException e) {
            e.printStackTrace();
            this.animal_type = "";
            this.animal_name = "";
            this.animal_image_link = "";
        }
    }
}
