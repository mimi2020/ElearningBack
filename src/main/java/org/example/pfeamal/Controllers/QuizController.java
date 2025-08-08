package org.example.pfeamal.Controllers;


import org.example.pfeamal.Entities.*;
import org.example.pfeamal.Repositories.EnseignantRepository;
import org.example.pfeamal.Repositories.EvaluationQuizRepository;
import org.example.pfeamal.Repositories.QuizRepo;
import org.example.pfeamal.Repositories.UserRepository;
import org.example.pfeamal.Services.MatireService;
import org.example.pfeamal.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Quiz")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuizController {




    @Autowired
    private QuizService quizService ;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EnseignantRepository enseignantRepository;

    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    EvaluationQuizRepository evaluationRepository;

    @PostMapping("/addquiz")
    @PreAuthorize("hasRole('ENSEIGNANT')")
    public ResponseEntity<?> createQuiz( Quiz quiz, Principal principal) {
        Enseignant formateur = enseignantRepository.findByUsername(principal.getName()).get();
       // quiz.setFormateur(formateur); relation entre enseignt et quiz
        quiz.setEnseignant(formateur);
        return ResponseEntity.ok(quizRepo.save(quiz));
    }

@GetMapping("/listquiz")
    public ResponseEntity<List<Quiz>> getAllQuiz() {
        return ResponseEntity.ok(quizRepo.findAll());
}

    @GetMapping("/Onequiz/{id}")
    public Quiz getOneQuiz(@PathVariable Long id) {
        return quizRepo.findById(id).get();
    }





@PostMapping("/quiz/{quizId}/submit")
//@PreAuthorize("hasRole('ELEVE')")
public ResponseEntity<?> submitQuiz(@PathVariable Long quizId, @RequestBody Map<Long, Integer> reponses, Principal principal) {
    Quiz quiz = quizRepo.findById(quizId).orElseThrow();
    User user = userRepository.findByUsername(principal.getName()).get();

    double score = 0;
    int total = quiz.getQuestions().size();

    for (Question question : quiz.getQuestions()) {
        Integer reponseIndex = reponses.get(question.getId());
        if (reponseIndex != null && reponseIndex == question.getCorrectAnswerIndex()) {
            score++;
        }
    }

    EvaluationQuiz eval = new EvaluationQuiz();
    eval.setQuiz(quiz);
    eval.setUtilisateur(user);
    eval.setNote((score / total) * 20);
    eval.setReponses(reponses);

    evaluationRepository.save(eval);
    return ResponseEntity.ok("Votre note est " + eval.getNote() + " / 20");
}




    /*
    @PostMapping("/addMatiere")
    public Matiere addMatiere(Matiere mat) {

        return matireService.createMatiere(mat);
    }

    @GetMapping("/listMatiere")
    public List<Matiere> listMatiere() {

        return matireService.allMatiere();

    }


    @GetMapping("/getone/{id}")
    public Matiere listone(@PathVariable Long id) {
        return matireService.findMatiereById(id);

    }




    @DeleteMapping("/deleteone/{id}")
    public HashMap<String, String> delete(@PathVariable Long id) {
        HashMap message = new HashMap<>();
        try {
            Matiere um = matireService.findMatiereById(id);
            if (um != null) {
                matireService.deleteMatiere(id);
                message.put("etat", "deleted");
            } else {
                message.put("etat", "id was deleted");
            }
        } catch (Exception e) {
            message.put("etat", "error");


        }
        return message;
    }

    @PutMapping("/update/{id}")
    public Matiere Update(@PathVariable Long id,Matiere um) {

        Matiere um1=matireService.findMatiereById(id);
        if (um1!=null){
            um.setId(id);

            return matireService.updateMatiere(um);
        }else throw new RuntimeException("id Cours is not found");

    }

*/


}
