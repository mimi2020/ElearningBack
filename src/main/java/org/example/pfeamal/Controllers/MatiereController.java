package org.example.pfeamal.Controllers;


import org.example.pfeamal.Entities.Cours;
import org.example.pfeamal.Entities.Matiere;
import org.example.pfeamal.Services.AdminService;
import org.example.pfeamal.Services.CoursService;
import org.example.pfeamal.Services.MatireService;
import org.example.pfeamal.utils.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/Matiere")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MatiereController {




    @Autowired
    private MatireService matireService ;


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




}
