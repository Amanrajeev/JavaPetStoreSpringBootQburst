package com.example.demo.Petstore.user.service;

import com.example.demo.Petstore.pet.model.Response;
import com.example.demo.Petstore.user.model.UserModel;
import com.example.demo.Petstore.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    Response response;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Response getUser(String username) {
        UserModel user;
        if(!userRepository.existsUserModelByUserName(username)){
            response = new Response(404,"GET","User not Found");
            return response;
        }
        user = userRepository.findByUserName(username).get();
        response = new Response(200,"GET","Successfully Collected");
        response.setUserModel(user);
        return response;
    }

    public Response registerUser(UserModel userModel) {
        System.out.println(userModel.toString());
        if(userRepository.existsUserModelByUserName(userModel.getUsername())){
            response = new Response(400,"POST","User already Exist");
            return response;
        }
        else if(userModel.getUsername() == null || userModel.getFirstName()== null || userModel.getPassword() == null || userModel.getPhone() == null){
            response = new Response(400,"POST","Invalid Input1");
            return response;
        }
        else if(userModel.getUsername().equals("") || userModel.getFirstName().isEmpty() || userModel.getPassword().isEmpty() || userModel.getPhone().isEmpty()){
            response = new Response(400,"POST","Invalid Input2");
            return response;
        }
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(userModel);
        response = new Response(201,"POST","Successfully Created");
        return response;
    }

    public Response deleteUser(String username) {
        if(!userRepository.existsUserModelByUserName(username)){
            response = new Response(404,"DELETE","User not Found");
            return response;
        }
        Optional<UserModel> user=userRepository.findByUserName(username);
        userRepository.deleteById(user.get().getId());
        response = new Response(200,"DELETE","Successfully Deleted");
        return response;
    }


}