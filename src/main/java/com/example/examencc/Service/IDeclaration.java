package com.example.examencc.Service;

import com.example.examencc.entities.Declaration;
import com.example.examencc.entities.Utilisateur;

import java.util.List;

public interface IDeclaration {
    void affecterPolicierADeclarataion(long idUtilisateur, long idDec);
    public void traiterDeclarationAutomatiquement();
    public List<Declaration>afficherDeclarationsTraitees();
}
