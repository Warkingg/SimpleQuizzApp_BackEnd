package com.example.quizztest.controller;

import com.example.quizztest.dto.ThemeDto;
import com.example.quizztest.service.theme.IThemeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@RestController
@CrossOrigin("*")
public class ThemeController {

    @Autowired
    private IThemeManager themeManager;

    @PostMapping("/addTheme")
    public ThemeDto addTheme(@RequestBody ThemeDto theme) {
        return themeManager.addTheme(theme);
    }

    @GetMapping("/getThemes")
    public List<ThemeDto> getThemes() {
        return themeManager.getThemes();
    }
    @GetMapping("/getTheme/{idTheme}")
    public ThemeDto getTheme(@PathVariable("idTheme") Long idTheme) {
        return themeManager.getTheme(idTheme);
    }
}

