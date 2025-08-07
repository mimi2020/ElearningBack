package org.example.pfeamal.Services;

import org.example.pfeamal.Entities.Quiz;
import org.example.pfeamal.Repositories.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {

    @Autowired
    private QuizRepo quizRepo ;
    public Quiz createQuiz(Quiz qz) {
        return  quizRepo.save(qz);
    }
    public Quiz updateQuiz(Quiz qz) {
        return  quizRepo.save(qz);
    }
    public List<Quiz> allQuiz() {
        return quizRepo.findAll();
    }
    public Quiz findQuizById(Long id) {
        return quizRepo.findById(id).orElse(null);
    }
    public void deleteQuiz(Long id) {
        quizRepo.deleteById(id);
    }
}
