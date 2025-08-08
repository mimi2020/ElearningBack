package org.example.pfeamal.Controllers;


import org.example.pfeamal.Entities.Choice;
import org.example.pfeamal.Entities.Question;
import org.example.pfeamal.Entities.Quiz;
import org.example.pfeamal.Repositories.ChoiceRepository;
import org.example.pfeamal.Repositories.EnseignantRepository;
import org.example.pfeamal.Repositories.QuestionRepository;
import org.example.pfeamal.Repositories.QuizRepo;
import org.example.pfeamal.Services.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/Question")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuestionController {




    @Autowired
    private ChoiceService choiceService ;
    @Autowired
    private EnseignantRepository enseignantRepository ;
    @Autowired
    private QuestionRepository questionRepository ;
    @Autowired
    QuizRepo quizRepo;


    @Autowired
    private ChoiceRepository choiceRepository ;

    @PostMapping("/addquestion/{idquiz}")

    public ResponseEntity<?> createQuestion(@PathVariable Long idquiz, Question q, Principal principal) {
        Quiz qz=quizRepo.findById(idquiz).get() ;
        q.setQuiz(qz);
        return ResponseEntity.ok(questionRepository.save(q));
    }


    @GetMapping("/listquestion/{idquiz}")
    public ResponseEntity<List<Question>> getAllQuestion(@PathVariable Long idquiz) {
        Quiz qz=quizRepo.findById(idquiz).get() ;
        return ResponseEntity.ok(questionRepository.findAllByQuiz(qz));
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
