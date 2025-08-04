package org.example.pfeamal.Controllers;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.example.pfeamal.Entities.Admin;
import org.example.pfeamal.Entities.Eleve;
import org.example.pfeamal.Entities.Enseignant;
import org.example.pfeamal.Entities.User;
import org.example.pfeamal.Repositories.UserRepository;
import org.example.pfeamal.Services.AdminService;
import org.example.pfeamal.Services.EleveService;
import org.example.pfeamal.Services.EnseignantService;
import org.example.pfeamal.Services.UserService;
import org.example.pfeamal.payload.response.MessageResponse;
import org.example.pfeamal.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @Autowired
    PasswordEncoder encoder;




    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService  userService ;
    @Autowired
    EleveService eleveService ;
    @Autowired
    EnseignantService enseignantService ;

    @Autowired
    AdminService adminService ;
    @Autowired
    StorageService storageService ;


    @PostMapping("/registerStudent")
    public Eleve registerstudent(Eleve eleve) {
        eleve.setUsername(eleve.getNom_prenom_eleve());
        eleve.setPassword(encoder.encode(eleve.getPassword()));
        return eleveService.createEleve(eleve);
    }


    @PostMapping("/registerTeacher")
    public Enseignant registerTeachert(Enseignant enseignant ,@RequestParam("file") MultipartFile file) {
       String namecv=storageService.store(file);
       System.out.println("++++ cv name +++++"+namecv);
       enseignant.setCv(namecv);
       enseignant.setUsername(enseignant.getNom_prenom_ensignant());
       enseignant.setPassword(encoder.encode(enseignant.getPassword()));
     // enseignant.setPassword();


        return enseignantService.createEnseignant(enseignant);
    }




    @PostMapping("/AddAdmin")
    public Admin addadmin(Admin admin) {

        admin.setUsername(admin.getNom_prenom_admin());
        admin.setPassword(encoder.encode(admin.getPassword()));
        // enseignant.setPassword();


        return adminService.createAdmin(admin);
    }




    @GetMapping("/listusers")
    public List<User> listUsers() {

        return userService.allUsers();

    }


    @GetMapping("/getone/{id}")
    public User listone(@PathVariable Long id) {
        return userService.findUserById(id);

    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }



    @DeleteMapping("/deleteone/{id}")
    public HashMap<String, String> delete(@PathVariable Long id) {
        HashMap message = new HashMap<>();
        try {
            User um = userService.findUserById(id);
            if (um != null) {
                userService.deleteUser(id);
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
    public User Update(@PathVariable Long id,User um) {

        User um1=userService.findUserById(id);
        if (um1!=null){
            um.setId(id);

            return userService.updateUser(um);
        }else throw new RuntimeException("id user is not found");

    }


    @GetMapping("/confirm")
    public ResponseEntity<?> confirm( @RequestParam String email) {


        // Create new user's account
        User user = userRepository.findFirstByEmail(email);
        if(user != null){
            user.setConfirm(true);
            userRepository.save(user);
            return ResponseEntity.ok(new MessageResponse("user is confirmed"));
        }
        return ResponseEntity.ok(new MessageResponse("User not confirmed!"));
    }


}
