package com.hacker.quizapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hacker.quizapp.model.Question;
import com.hacker.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService service;

	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestions() {
		return service.getAllQuestions();
	}
	
	@GetMapping("/getQuestion/{questionId}")
	public Optional<Question> getQuestion(@PathVariable int questionId) {
		return service.getQuestion(questionId);
	}
	
	@PostMapping("/add")
	public String addQuestion(@RequestBody Question dto) {
		return service.addQuestion(dto);
	}

	@PutMapping("/update")
	public String updateQuestion(@RequestBody Question dto) {
		return service.updateQuestion(dto);
	}
	
	@DeleteMapping("/delete")
	public String deleteQuestion(@RequestParam int questionId) {
		return service.deleteQuestion(questionId);
	}
}












