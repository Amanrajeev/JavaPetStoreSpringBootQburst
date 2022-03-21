package com.example.demo.Petstore.pet.controller;


import com.example.demo.Petstore.pet.model.Pet;
import com.example.demo.Petstore.pet.model.Response;
import com.example.demo.Petstore.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "PetStore/pet")
public class PetController {
    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public Response getPet(){

        return petService.getAllPet();
    }


    @PostMapping
    public Response petRegister(@RequestBody Pet pet) {

        return petService.addNewPet(pet);
    }


    @DeleteMapping(path="{id}")
    public Response deletePet(@PathVariable ("id") String id){
        return petService.deletePet(id);

    }

    @PutMapping
    public Response updatePet(@RequestBody Pet pet){
        return petService.updatePet(pet);
    }

    @GetMapping(path="{id}")
    public Response FindPet(@PathVariable ("id") String id){
            return petService.findPet(id);

    }

}
