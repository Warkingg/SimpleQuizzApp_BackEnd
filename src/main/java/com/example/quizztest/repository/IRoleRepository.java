package com.example.quizztest.repository;

import com.example.quizztest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
