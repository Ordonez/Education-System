package com.SpringbootTraining.Education.System.repository;

import com.SpringbootTraining.Education.System.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByName(String name);
}
