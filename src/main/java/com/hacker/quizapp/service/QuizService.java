package com.hacker.quizapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacker.quizapp.dao.QuestionDAO;
import com.hacker.quizapp.dao.QuizDAO;
import com.hacker.quizapp.model.Question;
import com.hacker.quizapp.model.QuestionWraper;
import com.hacker.quizapp.model.Quiz;
import com.hacker.quizapp.model.Response;

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

	public List<QuestionWraper> getQuiz(int quizId) {
		// Check quiz id present or not
		Optional<Quiz> quiz = dao.findById(quizId);
		
		// Fetch the questions
		List<Question> questions = quiz.get().getQuestions();
		
		// Now wrap the question using the QuestionWraper class
		
		List<QuestionWraper> questionWraper = questions.stream()
				.map(obj -> new QuestionWraper(obj.getqId(), obj.getqTitle(), obj.getOption1(), obj.getOption2(), obj.getOption3(), obj.getOption4()))
				.collect(Collectors.toList());
		
		return questionWraper;
	}
	public Integer checkAnsers(List<Response> answeres) {
		long result = answeres.stream().filter(ans -> {
			int id = ans.getQuestionId();
			String actualAnswer = ans.getOption();
			Optional<Question> question = questionDAO.findById(id);
			String expectedAnswer = question.get().getCurrectOption();
			return actualAnswer.equals(expectedAnswer);
		}).count();
		return (int)result;
	}
}
