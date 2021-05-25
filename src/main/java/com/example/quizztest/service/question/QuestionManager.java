package com.example.quizztest.service.question;

import com.example.quizztest.dto.QuestionDto;
import com.example.quizztest.model.Level;
import com.example.quizztest.model.OrikaBeanMapper;
import com.example.quizztest.model.Question;
import com.example.quizztest.repository.ILevelRepository;
import com.example.quizztest.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class QuestionManager implements IQuestionManager{
    private OrikaBeanMapper orikaBeanMapper;

    private IQuestionRepository questionRepository;

    private ILevelRepository levelRepository;

    private QuestionService questionService;

    @Autowired
    public QuestionManager(OrikaBeanMapper orikaBeanMapper, IQuestionRepository questionRepository, ILevelRepository levelRepository,
                               QuestionService questionService) {
        this.orikaBeanMapper = orikaBeanMapper;
        this.questionRepository = questionRepository;
        this.levelRepository = levelRepository;
        this.questionService = questionService;
    }
    @Override
    public QuestionDto addQuestion(QuestionDto questionDto, Long idLevel) {
        Question question = orikaBeanMapper.map(questionDto, Question.class);
        Level level = levelRepository.getOne(idLevel);
        return orikaBeanMapper.convertDTO(questionService.addQuestion(question,level), QuestionDto.class);
    }

    @Override
    public List<QuestionDto> getQuestions(Long idLevel) {
        Level level = levelRepository.getOne(idLevel);
        List<Question> questions = level.getQuestions();
        return orikaBeanMapper.convertListDTO(questions, QuestionDto.class);
    }
}
