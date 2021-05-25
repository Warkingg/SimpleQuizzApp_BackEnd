package com.example.quizztest.controller;

import com.example.quizztest.dto.QuestionDto;
import com.example.quizztest.service.question.IQuestionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@RestController
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private IQuestionManager questionManager;

    @PostMapping("/addQuestion/{idLevel}")
    QuestionDto addQuestion(@RequestBody QuestionDto questionDto, @PathVariable("idLevel") Long idLevel) {
        return questionManager.addQuestion(questionDto, idLevel);
    }
    @GetMapping("/getQuestions/{idLevel}")
    List<QuestionDto> getQuestions(@PathVariable("idLevel") Long idLevel)  {
        return questionManager.getQuestions(idLevel);
    }
}
