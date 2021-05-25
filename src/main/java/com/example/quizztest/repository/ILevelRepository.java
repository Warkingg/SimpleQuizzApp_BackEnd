package com.example.quizztest.repository;

import com.example.quizztest.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILevelRepository extends JpaRepository <Level, Long> {
}
