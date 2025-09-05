package com.hacker.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hacker.quizapp.model.QuestionWraper;
import com.hacker.quizapp.model.Response;
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
	public ResponseEntity<String> create(@RequestParam String category, @RequestParam int numberOfQuestions, @RequestParam String title){
		return new ResponseEntity<>(service.createQuiz(category,numberOfQuestions,title), HttpStatus.OK);
	}
	
	@GetMapping("/get/{quizId}")
	public ResponseEntity<List<QuestionWraper>> get(@PathVariable int quizId){
		List<QuestionWraper> questions = service.getQuiz(quizId);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
	
	@PostMapping("/submit")
	public ResponseEntity<Integer> submitAnswer(@RequestBody List<Response> answeres){
		Integer result = service.checkAnsers(answeres);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}