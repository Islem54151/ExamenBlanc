package com.example.examencc.repositories;

import com.example.examencc.entities.Declaration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeclarationRepo extends JpaRepository<Declaration,Long> {
    List<Declaration> findByEstTraiteeFalse();
    List<Declaration> findByEstTraitee(boolean estTraitee);
}
