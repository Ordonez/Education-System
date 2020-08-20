package com.SpringbootTraining.Education.System.controller;


import com.SpringbootTraining.Education.System.entity.Users;
import com.SpringbootTraining.Education.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    //post api for adding users
    @PostMapping("/addUsers")
    public Users addUsers (@RequestBody Users users) {
        return service.saveUsers(users);
    }
    //post api for adding a list of multiple users
    @PostMapping("/addMultipleUsers")
    public List<Users> addMultipleUsers(@RequestBody List<Users> multipleUsers) {
        return service.saveUsers(multipleUsers);
    }

    //api to list all users
    @GetMapping("/allUsers")
    public List<Users> findAllUsers() {
        return service.getUsers();
    }

    //fetching users by id
    @GetMapping("/usersById/{id}")
    public Users findUsersById(@PathVariable int id) {
        return service.getUsersById(id);
    }

    //fetching users by name
    @GetMapping("/usersByName/{name}")
    public Users findUsersByName(@PathVariable String name) {
        return service.getUsersByName(name);
    }

    //Updating users 
    @PutMapping ("/updateUsers")
    public Users updateUsers(@RequestBody Users users){
        return service.updateUser(users);

    }
    
    //Deleting users by using userid
    @DeleteMapping("/delete/{id}")
    public String deleteUsers(@PathVariable int id) {
        return service.deleteUser(id);
    }

}
