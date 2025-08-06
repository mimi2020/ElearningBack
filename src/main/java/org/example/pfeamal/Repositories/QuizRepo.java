package org.example.pfeamal.Repositories;


import org.example.pfeamal.Entities.Question;
import org.example.pfeamal.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Long> {
}
/*
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {}
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {}

 */