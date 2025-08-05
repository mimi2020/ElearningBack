package org.example.pfeamal.Services;

import org.example.pfeamal.Entities.Admin;
import org.example.pfeamal.Entities.Ressources;
import org.example.pfeamal.Repositories.AdminRepository;
import org.example.pfeamal.Repositories.RessourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourcesService {

    @Autowired
    private RessourcesRepository ressourcesrepo ;
    public Ressources createRessources(Ressources s) {
        return  ressourcesrepo.save(s);
    }
    public Ressources updateRessources(Ressources s) {
        return  ressourcesrepo.save(s);
    }
    public List<Ressources> allRessources() {
        return ressourcesrepo.findAll();
    }
    public Ressources findUserById(Long id) {
        return ressourcesrepo.findById(id).orElse(null);
    }
    public void deleteRessources(Long id) {
        ressourcesrepo.deleteById(id);
    }
}
