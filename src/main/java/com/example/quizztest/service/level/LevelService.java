package com.example.quizztest.service.level;


import com.example.quizztest.model.Level;
import com.example.quizztest.model.Theme;
import com.example.quizztest.repository.ILevelRepository;
import com.example.quizztest.repository.IThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
public class LevelService implements ILevelService {

    @Autowired
    private ILevelRepository levelRepository;

    @Autowired
    private IThemeRepository themeRepository;


    @Override
    public Level addLevel(Level level, Theme theme) {
        theme.addLevel(level);
        return levelRepository.save(level);
    }


    @Override
    public Iterable<Level> findAll() {
        return levelRepository.findAll();
    }

    @Override
    public Optional<Level> findById(Long id) {
        return levelRepository.findById(id);
    }

    @Override
    public Level save(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public void remove(Long id) {
        levelRepository.deleteById(id);
    }
}
