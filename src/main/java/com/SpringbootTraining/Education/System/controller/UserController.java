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

    //adding users
    @PostMapping("/addUsers")
    public Users addUsers (@RequestBody Users users) {
        return service.saveUsers(users);
    }
    @PostMapping("/addMultipleUsers")
    public List<Users> addMultipleUsers(@RequestBody List<Users> multipleUsers) {
        return service.saveUsers(multipleUsers);
    }

    @GetMapping("/ListUsers")
    public List<Users> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/Users/{id}")
    public Users findUsersById(@PathVariable int id) {
        return service.getUsersById(id);
    }

    @GetMapping("/Users/{name}")
    public Users findUsersByNmae(@PathVariable String name) {
        return service.getUsersByName(name);
    }

    @PutMapping ("/UpdateUsers")
    public Users updateUsers(@RequestBody Users users){
        return service.updateUser(users);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsers(@PathVariable int id) {
        return service.deleteUser(id);
    }

}
