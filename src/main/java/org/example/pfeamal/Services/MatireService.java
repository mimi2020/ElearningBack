package org.example.pfeamal.Services;

import org.example.pfeamal.Entities.Cours;
import org.example.pfeamal.Entities.Matiere;
import org.example.pfeamal.Repositories.CoursRepository;
import org.example.pfeamal.Repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatireService {

    @Autowired
    private MatiereRepository  matiereRepository  ;
    public Matiere createMatiere(Matiere s) {
        return  matiereRepository.save(s);
    }
    public Matiere updateMatiere(Matiere s) {
        return  matiereRepository.save(s);
    }
    public List<Matiere> allMatiere() {
        return matiereRepository.findAll();
    }
    public Matiere findMatiereById(Long id) {
        return matiereRepository.findById(id).orElse(null);
    }
    public void deleteMatiere(Long id) {
        matiereRepository.deleteById(id);
    }
}
