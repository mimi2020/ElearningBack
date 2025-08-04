package org.example.pfeamal.Services;

import org.example.pfeamal.Entities.Admin;
import org.example.pfeamal.Entities.Enseignant;
import org.example.pfeamal.Repositories.AdminRepository;
import org.example.pfeamal.Repositories.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;
    public Enseignant createEnseignant(Enseignant user) {
        return  enseignantRepository.save(user);
    }
    public Enseignant updateEnseignant(Enseignant user) {
        return  enseignantRepository.save(user);
    }
    public List<Enseignant> allEnseignant() {
        return enseignantRepository.findAll();
    }
    public Enseignant findUserById(Long id) {
        return enseignantRepository.findById(id).orElse(null);
    }
    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }
}
