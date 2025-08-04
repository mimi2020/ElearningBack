package org.example.pfeamal.Services;

import org.example.pfeamal.Entities.Admin;
import org.example.pfeamal.Entities.Eleve;
import org.example.pfeamal.Repositories.AdminRepository;
import org.example.pfeamal.Repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleveService {

    @Autowired
    private EleveRepository eleveRepository;
    public Eleve createEleve(Eleve user) {
        return  eleveRepository.save(user);
    }
    public Eleve updateEleve(Eleve user) {
        return  eleveRepository.save(user);
    }
    public List<Eleve> allEleve() {
        return eleveRepository.findAll();
    }
    public Eleve findUserById(Long id) {
        return eleveRepository.findById(id).orElse(null);
    }
    public void deleteEleve(Long id) {
        eleveRepository.deleteById(id);
    }
}
