package org.example.pfeamal.Controllers;


import org.example.pfeamal.Entities.*;
import org.example.pfeamal.Repositories.RessourcesRepository;
import org.example.pfeamal.Repositories.UserRepository;
import org.example.pfeamal.Services.*;
import org.example.pfeamal.payload.response.MessageResponse;
import org.example.pfeamal.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Ressource")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RessourceController {




    @Autowired
    private RessourcesService ressourcesService ;


    @Autowired
    CoursService coursService ;
    @Autowired
    StorageService storageService ;

@Autowired
    RessourcesRepository ressourcesRepository ;


    @PostMapping("/addResource/{idcours}")
    public Ressources addRessources(Ressources res ,@RequestParam("file") MultipartFile file,@PathVariable Long idcours) {
       String namefile=storageService.store(file);
       System.out.println("++++ file name +++++"+namefile);
       res.setContenuRes(namefile);
Cours c = coursService.findCoursById(idcours);
res.setCours(c);

        return ressourcesService.createRessources(res);
    }









    @GetMapping("/listRessource")
    public List<Ressources> listUsers() {

        return ressourcesService.allRessources();

    }


    @GetMapping("/getone/{id}")
    public Ressources listone(@PathVariable Long id) {
        return ressourcesService.findUserById(id);

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
            Ressources um = ressourcesService.findUserById(id);
            if (um != null) {
                ressourcesService.deleteRessources(id);
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
    public Ressources Update(@PathVariable Long id,@RequestParam("idCours") Long idc,Ressources um,@RequestParam("file") MultipartFile file) {

        Ressources um1=ressourcesService.findUserById(id);
        if (um1!=null){
            um.setId(id);

String namesup=storageService.store(file);
um.setContenuRes(namesup);
     Cours c = coursService.findCoursById(idc);
     if(c != null){
         um.setCours(c);
         System.out.println("**attached course ****");
     }
    else if(c == null){
        um.setCours(null);
        System.out.println("**null course ****");
     }

            ressourcesRepository.save(um);
        }
        else throw new RuntimeException("id ressource is not found");
return um;
    }




}
