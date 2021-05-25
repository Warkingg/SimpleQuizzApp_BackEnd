package com.example.quizztest.service.question;

import com.example.quizztest.model.Level;
import com.example.quizztest.model.Question;
import com.example.quizztest.service.IGeneralService;

public interface IQuestionService extends IGeneralService <Question> {
    Question addQuestion(Question question, Level level);
}
