package com.example.demo.Petstore.user.controller;


import com.example.demo.Petstore.pet.model.Response;
import com.example.demo.Petstore.user.model.UserModel;
import com.example.demo.Petstore.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "petstore/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="{username}")
    public Response getUserByUsername(@PathVariable String username)
    {
        return userService.getUser(username);
    }

    @PostMapping
    public Response registerNewUser(@RequestBody UserModel userModel)
    {
        return userService.registerUser(userModel);
    }

    @DeleteMapping(path="{username}")
    public Response deleteByUserName(@PathVariable String username){
        return userService.deleteUser(username);
    }

}