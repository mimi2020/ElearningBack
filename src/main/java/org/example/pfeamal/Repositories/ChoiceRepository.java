package org.example.pfeamal.Repositories;

import org.example.pfeamal.Entities.Choice;
import org.example.pfeamal.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long> {}