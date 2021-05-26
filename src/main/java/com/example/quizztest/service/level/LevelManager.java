package com.example.quizztest.service.level;

import com.example.quizztest.dto.LevelDto;
import com.example.quizztest.dto.ThemeDto;
import com.example.quizztest.model.Level;
import com.example.quizztest.model.OrikaBeanMapper;
import com.example.quizztest.model.Theme;
import com.example.quizztest.repository.ILevelRepository;
import com.example.quizztest.repository.IThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LevelManager implements ILevelManager {

    private ILevelService levelService;

    private ILevelRepository levelRepository;

    private OrikaBeanMapper orikaBeanMapper;

    private IThemeRepository themeRepository;

    @Autowired
    public LevelManager(ILevelService levelService, ILevelRepository levelRepository, OrikaBeanMapper orikaBeanMapper,
                        IThemeRepository themeRepository){
        this.levelService = levelService;
        this.levelRepository = levelRepository;
        this.orikaBeanMapper = orikaBeanMapper;
        this.themeRepository = themeRepository;
    }
    @Override
    public LevelDto addLevel(LevelDto levelDto, Long idTheme) {
        Theme theme = themeRepository.getOne(idTheme);
        Level level = orikaBeanMapper.map(levelDto, Level.class);
        return orikaBeanMapper.convertDTO(levelService.addLevel(level, theme), LevelDto.class);
    }

    @Override
    public List<LevelDto> getLevels(Long idTheme) {
        Theme theme = themeRepository.getOne(idTheme);
        List<Level> levels = theme.getLevels();
        return orikaBeanMapper.convertListDTO(levels, LevelDto.class);
    }

    @Override
    public LevelDto getLevel(Long idTheme) {
        return orikaBeanMapper.convertDTO(levelRepository.getOne(idTheme), LevelDto.class);
    }

    @Override
    public List<LevelDto> getAllLevels() {
        List<Level> levels = levelRepository.findAll();
        return orikaBeanMapper.convertListDTO(levels, LevelDto.class);
    }

}
