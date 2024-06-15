package com.example.examencc.Service;

import com.example.examencc.entities.Declaration;
import com.example.examencc.entities.Utilisateur;

import java.util.List;

public interface IUtilisateur {
    Utilisateur ajouterVictime(Utilisateur victime);
    public String ajouterPoliciers(List<Utilisateur> policiers);
    String ajouterDeclarationEtAffecterAVictime(Declaration declaration, long telephone);



}
