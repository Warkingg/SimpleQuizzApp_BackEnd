package com.example.quizztest.repository;

import com.example.quizztest.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoryRepository extends JpaRepository<History,Long> {
    History findHistoryBySore(int score);

    History findHistoryByUsername(String username);
}
