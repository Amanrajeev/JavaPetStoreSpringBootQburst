package com.example.demo.Petstore.pet.model;

import com.example.demo.Petstore.user.model.UserModel;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private int code;

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    private UserModel userModel;

    public Pet getPet() {
        return pet;
    }

    private Pet pet;

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    private String type;
    private String message;

    public Response(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public List<Pet> getPets() {
        return pets;
    }

    private List<Pet> pets;

}
