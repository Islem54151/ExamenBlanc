package com.example.examencc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser ;

    String nom;
    String prenom;
    String adresse;
    Long telephone;

    @Enumerated(EnumType.STRING)
    Role role;

    @OneToMany (mappedBy = "policier")
    Set<Declaration> declarations;

    @OneToMany (mappedBy = "victime")
    Set<Declaration> declaration;
}
