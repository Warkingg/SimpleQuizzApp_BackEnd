package com.example.quizztest.service.history;

import com.example.quizztest.model.History;
import com.example.quizztest.repository.IHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HistoryService implements IHistoryService {
    @Autowired
    IHistoryRepository historyRepository;

    @Override
    public History addHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public History editHistory(History history, History history1) {
        history.setUsername(history1.getUsername());
        history.setLevelName(history1.getLevelName());
        history.setThemeName(history1.getThemeName());
        history.setSore(history1.getSore());
        history.setTotal(history1.getTotal());
        return historyRepository.save(history);
    }

    @Override
    public Iterable<History> findAll() {
        return null;
    }

    @Override
    public Optional<History> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public History save(History history) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
