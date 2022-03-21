package com.example.demo.Petstore.security;

import com.example.demo.Petstore.user.model.UserModel;
import com.example.demo.Petstore.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceSecurity implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return new UserModel(user.get());
    }
}




//    Runnable r = ()-> System.out.print("Run method");
//    is equivalent to
//
//        Runnable r = new Runnable() {
//@Override
//public void run() {
//        System.out.print("Run method");
//        }
//        };


//    New Operator for lambda expression added in java 8
//
//        Lambda expression is the short way of method writing.
//        It is indirectly used to implement functional interface
//
//Primary Syntax : (parameters) -> { statements; }

//numbers = [1,2,3,4,5]
//        numbers.forEach(x -> sout(x))
//
//        Output
//        1
//        2
//        3
//        4
//        5