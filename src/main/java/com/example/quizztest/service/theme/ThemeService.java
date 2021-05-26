package com.example.quizztest.service.theme;

import com.example.quizztest.model.Theme;
import com.example.quizztest.repository.IThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@Transactional
public class ThemeService implements IThemeService {

    @Autowired
    private IThemeRepository themeRepository;

    @Override
    public Theme addTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    @Override
    public void deleteTheme(Long id) {
        themeRepository.deleteById(id);
    }

    @Override
    public Iterable<Theme> findAll() {

        return themeRepository.findAll();
    }

    @Override
    public Optional<Theme> findById(Long id) {

        return themeRepository.findById(id);
    }

    @Override
    public Theme save(Theme theme) {

        return themeRepository.save(theme);
    }

    @Override
    public void remove(Long id) {
        themeRepository.deleteById(id);
    }
}