package com.example.examencc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDec ;

    LocalDate dateDeclaration ;

    boolean estTraitee ;

    LocalDate dateTraitement ;

    String description ;

    @OneToOne
    Propriete propriete;

    @ManyToOne
    Utilisateur policier;

    @ManyToOne
    Utilisateur victime;


}
