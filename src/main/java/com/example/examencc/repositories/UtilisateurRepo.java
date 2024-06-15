package com.example.examencc.repositories;

import com.example.examencc.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long> {

    Utilisateur findByTelephone(long telephone);
   Optional<Utilisateur> findById(long idUtilisateur);

}
