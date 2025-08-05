package org.example.pfeamal.Repositories;


import org.example.pfeamal.Entities.Cours;
import org.example.pfeamal.Entities.Ressources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RessourcesRepository extends JpaRepository<Ressources,Long> {

}
