package com.example.quizztest.service.question;

import com.example.quizztest.dto.QuestionDto;

import java.util.List;

public interface IQuestionManager {

    QuestionDto addQuestion(QuestionDto questionDto, Long idLevel);

    List<QuestionDto> getQuestions(Long idLevel);
}
