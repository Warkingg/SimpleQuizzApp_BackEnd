package com.example.quizztest.service.theme;

import com.example.quizztest.model.Theme;
import com.example.quizztest.service.IGeneralService;
import org.springframework.stereotype.Service;

public interface IThemeService extends IGeneralService <Theme> {
    Theme addTheme(Theme theme);
}
