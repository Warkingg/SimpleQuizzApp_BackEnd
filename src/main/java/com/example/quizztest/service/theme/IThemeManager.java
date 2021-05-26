package com.example.quizztest.service.theme;

import com.example.quizztest.dto.LevelDto;
import com.example.quizztest.dto.ThemeDto;

import java.util.List;

public interface IThemeManager {
    ThemeDto addTheme(ThemeDto themeDto);

    List<ThemeDto> getThemes();

    ThemeDto getTheme(Long idTheme);
}
