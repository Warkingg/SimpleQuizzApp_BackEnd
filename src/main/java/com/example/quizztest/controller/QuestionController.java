package com.example.quizztest.controller;

import com.example.quizztest.dto.QuestionDto;
import com.example.quizztest.dto.ThemeDto;
import com.example.quizztest.model.Level;
import com.example.quizztest.model.Question;
import com.example.quizztest.model.Theme;
import com.example.quizztest.service.level.ILevelService;
import com.example.quizztest.service.question.IQuestionManager;
import com.example.quizztest.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@ResponseBody
@RestController
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private ILevelService levelService;
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
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question, @PathVariable Long id) {
        Optional<Question> questionOptional = questionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        question.setId(questionOptional.get().getId());
        return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);

    }



    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable("id") Long id) {
        questionService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
