package com.example.examencc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propriete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProp ;
    @Enumerated(EnumType.STRING)
    TypePropriete typepropriete ;
    String couleur ;
    String marque ;
    String matricule ;
    String numSerie ;

}
