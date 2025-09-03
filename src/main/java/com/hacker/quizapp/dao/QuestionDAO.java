package com.hacker.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hacker.quizapp.model.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{

	@Query(value = "SELECT * FROM question WHERE qCategory = :category ORDER BY RAND() LIMIT :numberOfQuestions", nativeQuery = true)
	List<Question> generateQuestions(String category, int numberOfQuestions);

}
