package com.example.quizztest.service.level;

import com.example.quizztest.dto.LevelDto;
import com.example.quizztest.dto.ThemeDto;

import java.util.List;

public interface ILevelManager {
    LevelDto addLevel(LevelDto levelDto, Long idTheme);

    List<LevelDto> getLevels(Long idTheme);

    LevelDto getLevel(Long idTheme);

    List<LevelDto> getAllLevels();
}
