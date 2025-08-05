package org.example.pfeamal.Controllers;


import org.example.pfeamal.Entities.Cours;
import org.example.pfeamal.Entities.Matiere;
import org.example.pfeamal.Entities.Ressources;
import org.example.pfeamal.Services.AdminService;
import org.example.pfeamal.Services.CoursService;
import org.example.pfeamal.Services.MatireService;
import org.example.pfeamal.Services.RessourcesService;
import org.example.pfeamal.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Cours")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CoursController {




    @Autowired
    private CoursService coursService ;


    @Autowired
    MatireService matireService ;
    @Autowired
    StorageService storageService ;




    @PostMapping("/addCours/{idmatiere}")
    public Cours addRessources(Cours res,@PathVariable Long idmatiere) {
        Matiere mat = matireService.findMatiereById(idmatiere);
        if(mat != null) {
            System.out.println("matiere exist");
            res.setmatiere(mat);
        }
else if(res.getmatiere() == null) {
    res.setmatiere(null);
    System.out.println("matiere null");
        }

        return coursService.createCours(res);
    }




//    @PostMapping("/addCours")
//    public Cours addRessources(Cours res) {
//
//
//        return coursService.createCours(res);
//    }
//




    @GetMapping("/listCours")
    public List<Cours> listCours() {

        return coursService.allCours();

    }


    @GetMapping("/getone/{id}")
    public Cours listone(@PathVariable Long id) {
        return coursService.findCoursById(id);

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
            Cours um = coursService.findCoursById(id);
            if (um != null) {
                coursService.deleteCours(id);
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
    public Cours Update(@PathVariable Long id,Cours um) {

        Cours um1=coursService.findCoursById(id);
        if (um1!=null){
            um.setId(id);

            return coursService.updateCours(um);
        }else throw new RuntimeException("id Cours is not found");

    }




}
