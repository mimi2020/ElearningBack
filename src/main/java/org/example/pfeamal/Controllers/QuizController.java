package org.example.pfeamal.Controllers;


import org.example.pfeamal.Entities.Enseignant;
import org.example.pfeamal.Entities.Matiere;
import org.example.pfeamal.Entities.Quiz;
import org.example.pfeamal.Entities.User;
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

@RestController
@RequestMapping("/Quiz")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuizController {




    @Autowired
    private QuizService quizService ;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepo quizRepo;

    @PostMapping("/addquiz")
    @PreAuthorize("hasRole('FORMATEUR')")
    public ResponseEntity<?> createQuiz(@RequestBody Quiz quiz, Principal principal) {
        User formateur = userRepository.findByUsername(principal.getName()).get();
       // quiz.setFormateur(formateur); relation entre enseignt et quiz
        return ResponseEntity.ok(quizRepo.save(quiz));
    }


/*




@PostMapping("/quiz/{quizId}/submit")
@PreAuthorize("hasRole('ETUDIANT')")
public ResponseEntity<?> submitQuiz(@PathVariable Long quizId, @RequestBody Map<Long, Integer> reponses, Principal principal) {
    Quiz quiz = quizRepository.findById(quizId).orElseThrow();
    Utilisateur user = utilisateurRepository.findByUsername(principal.getName()).get();

    double score = 0;
    int total = quiz.getQuestions().size();

    for (Question question : quiz.getQuestions()) {
        Integer reponseIndex = reponses.get(question.getId());
        if (reponseIndex != null && reponseIndex == question.getCorrectAnswerIndex()) {
            score++;
        }
    }

    Evaluation eval = new Evaluation();
    eval.setQuiz(quiz);
    eval.setUtilisateur(user);
    eval.setNote((score / total) * 20);
    eval.setReponses(reponses);

    evaluationRepository.save(eval);
    return ResponseEntity.ok("Votre note est " + eval.getNote() + " / 20");
}



*/
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
