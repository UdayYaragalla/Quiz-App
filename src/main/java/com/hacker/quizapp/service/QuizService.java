package com.hacker.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacker.quizapp.dao.QuestionDAO;
import com.hacker.quizapp.dao.QuizDAO;
import com.hacker.quizapp.model.Question;
import com.hacker.quizapp.model.Quiz;

@Service
public class QuizService {
	
	@Autowired
	private QuizDAO dao;
	
	@Autowired
	private QuestionDAO questionDAO;

	public String createQuiz(String category, int numberOfQuestions, String title) {
		
		List<Question> questions = questionDAO.generateQuestions(category, numberOfQuestions);
		
		Quiz quiz = new Quiz();
		
		quiz.setTitle(title);
		quiz.setCategory(category);
		quiz.setQuestions(questions);
		
		Quiz result = dao.save(quiz);
		return result != null ? "Success" : "Failure";
	}

}
