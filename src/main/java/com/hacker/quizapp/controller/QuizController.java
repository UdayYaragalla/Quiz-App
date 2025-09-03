package com.hacker.quizapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hacker.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	private QuizService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> getQuiz(@RequestParam String category, @RequestParam int numberOfQuestions, @RequestParam String title){
		return new ResponseEntity<>(service.createQuiz(category,numberOfQuestions,title), HttpStatus.OK);
	}
}