package com.example.quizztest.controller;

import com.example.quizztest.dto.ThemeDto;
import com.example.quizztest.model.Theme;
import com.example.quizztest.service.theme.IThemeManager;
import com.example.quizztest.service.theme.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@RestController
@CrossOrigin("*")
public class ThemeController {

    @Autowired
    private IThemeManager themeManager;
    @Autowired
    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }


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

    @PutMapping("/update")
    public ResponseEntity<Theme> updateTheme(@RequestBody Theme theme) {
        Theme updateTheme = themeService.save(theme);
        return new ResponseEntity<>(updateTheme, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTheme(@PathVariable("id") Long id) {
        themeService.deleteTheme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

