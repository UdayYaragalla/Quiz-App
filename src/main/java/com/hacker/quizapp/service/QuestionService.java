package com.hacker.quizapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacker.quizapp.dao.QuestionDAO;
import com.hacker.quizapp.model.Question;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionDAO dao;
	
	public List<Question> getAllQuestions() {
		return dao.findAll();
	}

	public Optional<Question> getQuestion(int questionId) {
		return dao.findById(questionId);
	}

	public String addQuestion(Question dto) {
		Question added = dao.save(dto);
		return added != null ? "Success" : "Failed";
	}

	public String deleteQuestion(int questionId) {
		dao.deleteById(questionId);
		return "Success";
	}

	public String updateQuestion(Question dto) {
		Question added = dao.save(dto);
		return added != null ? "Success" : "Failed";
	}

}
