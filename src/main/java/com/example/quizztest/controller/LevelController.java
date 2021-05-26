package com.example.quizztest.controller;

import com.example.quizztest.dto.LevelDto;
import com.example.quizztest.dto.ThemeDto;
import com.example.quizztest.model.Level;
import com.example.quizztest.service.level.ILevelManager;
import com.example.quizztest.service.level.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@RestController
@CrossOrigin("*")
public class LevelController {

    private ILevelManager levelManager;

    @Autowired
    public LevelController(ILevelManager levelManager, LevelService levelService) {
        this.levelManager = levelManager;
        this.levelService = levelService;
    }

    @Autowired
    private final LevelService levelService;

    @PostMapping("/addLevel/{idTheme}")
    public LevelDto addLevel(@RequestBody LevelDto level, @PathVariable("idTheme") Long idTheme) {
        return levelManager.addLevel(level, idTheme);
    }

    @GetMapping("/getLevels/{idTheme}")
    public List<LevelDto> getLevels(@PathVariable("idTheme") Long idTheme) {
        return levelManager.getLevels(idTheme);
    }


    @GetMapping("/getLevel/{idTheme}")
    public LevelDto getLevel(@PathVariable("idTheme") Long idTheme) {
        return levelManager.getLevel(idTheme);
    }

    @GetMapping("/getAllLevels")
    public List<LevelDto> getAllLevels() {
        return levelManager.getAllLevels();
    }

    @PutMapping("/updateLevel")
    public ResponseEntity<Level> updateLevel(@RequestBody Level level) {
        Level updateLevel = levelService.save(level);
        return new ResponseEntity<>(updateLevel, HttpStatus.OK);
    }

    @DeleteMapping("/deleteLevel/{id}")
    public ResponseEntity<?> deleteLevel(@PathVariable("id") Long id) {
        levelService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

