package com.example.quizztest.controller;

import com.example.quizztest.dto.QuestionDto;
import com.example.quizztest.dto.ThemeDto;
import com.example.quizztest.model.Question;
import com.example.quizztest.model.Theme;
import com.example.quizztest.service.question.IQuestionManager;
import com.example.quizztest.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@RestController
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private IQuestionManager questionManager;
    @Autowired
    private QuestionService questionService;
    @PostMapping("/addQuestion/{idLevel}")
    QuestionDto addQuestion(@RequestBody QuestionDto questionDto, @PathVariable("idLevel") Long idLevel) {
        return questionManager.addQuestion(questionDto, idLevel);
    }
    @GetMapping("/getQuestions/{idLevel}")
    List<QuestionDto> getQuestions(@PathVariable("idLevel") Long idLevel)  {
        return questionManager.getQuestions(idLevel);
    }
    @GetMapping("/getQuestion")
    public List<QuestionDto> getQuestion() {
        return questionManager.getQuestion();
    }

    @PutMapping("/updateQuestion/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Question updateQuestion = questionService.save(question);
        return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long id) {
        questionService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
