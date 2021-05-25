package com.example.quizztest.service.theme;

import com.example.quizztest.dto.ThemeDto;
import com.example.quizztest.model.OrikaBeanMapper;
import com.example.quizztest.model.Theme;
import com.example.quizztest.repository.IThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ThemeManager implements IThemeManager {
    private OrikaBeanMapper orikaBeanMapper;

    private IThemeRepository themeRepository;

    private IThemeService themeService;

    @Autowired
    public ThemeManager(OrikaBeanMapper orikaBeanMapper, IThemeService themeService, IThemeRepository themeRepository){
       this.orikaBeanMapper = orikaBeanMapper;
       this.themeService = themeService;
       this.themeRepository = themeRepository;
    }

    @Override
    public ThemeDto addTheme(ThemeDto themeDto) {
        Theme theme = orikaBeanMapper.map(themeDto, Theme.class);
        return orikaBeanMapper.convertDTO(themeService.addTheme(theme), ThemeDto.class);
    }

    @Override
    public List<ThemeDto> getThemes() {
        List<Theme> themes = themeRepository.findAll();
        return orikaBeanMapper.convertListDTO(themes, ThemeDto.class);
    }

    @Override
    public ThemeDto getTheme(Long idTheme) {
        return orikaBeanMapper.convertDTO(themeRepository.getOne(idTheme), ThemeDto.class);
    }
}
