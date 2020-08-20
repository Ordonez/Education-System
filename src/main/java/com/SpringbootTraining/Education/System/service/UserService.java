package com.SpringbootTraining.Education.System.service;

import com.SpringbootTraining.Education.System.entity.Users;
import com.SpringbootTraining.Education.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    //Creating Post methods
    public Users saveUsers(Users users) {
       return repository.save(users);
    }
    public List<Users> saveUsers(List<Users> users) {
        return repository.saveAll(users);
    }

    //Creating Get methods to fetch users from database
    public List <Users> getUsers() {
        return repository.findAll();
    }
    public Users getUsersById(int id) {
        return repository.findById(id).orElse(null); // if an id is not picked up then return null
    }
    //To fetch data based on name
    public Users getUsersByName(String name) {
        return repository.findByName(name);
    }

    //Deleting users
    public String deleteUser(int id) {
        repository.deleteById(id);
        return "user removed" +id;
    }

    //Updating users
    public Users updateUser(Users users) {
    Users existingUsers=repository.findById(users.getId()).orElse(null);
    existingUsers.setName(users.getName());
    existingUsers.setClassification(users.getClassification());
    return repository.save(existingUsers);


    }
}
