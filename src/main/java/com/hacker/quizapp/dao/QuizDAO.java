package com.hacker.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hacker.quizapp.model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer>  {

}
