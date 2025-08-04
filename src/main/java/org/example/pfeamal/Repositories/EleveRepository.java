package org.example.pfeamal.Repositories;


import org.example.pfeamal.Entities.Admin;
import org.example.pfeamal.Entities.Eleve;
import org.example.pfeamal.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EleveRepository extends JpaRepository<Eleve,Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    User findFirstByEmail (String email);
    User findByPasswordResetToken(String passwordResetToken);
}
