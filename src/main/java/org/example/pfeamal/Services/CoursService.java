package org.example.pfeamal.Services;

import org.example.pfeamal.Entities.Cours;
import org.example.pfeamal.Entities.Ressources;
import org.example.pfeamal.Repositories.CoursRepository;
import org.example.pfeamal.Repositories.RessourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursrepo ;
    public Cours createCours(Cours s) {
        return  coursrepo.save(s);
    }
    public Cours updateCours(Cours s) {
        return  coursrepo.save(s);
    }
    public List<Cours> allCours() {
        return coursrepo.findAll();
    }
    public Cours findCoursById(Long id) {
        return coursrepo.findById(id).orElse(null);
    }
    public void deleteCours(Long id) {
        coursrepo.deleteById(id);
    }
}
