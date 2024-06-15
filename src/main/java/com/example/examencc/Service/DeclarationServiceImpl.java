package com.example.examencc.Service;

import com.example.examencc.entities.Declaration;
import com.example.examencc.entities.Utilisateur;
import com.example.examencc.repositories.DeclarationRepo;
import com.example.examencc.repositories.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeclarationServiceImpl implements IDeclaration {

    @Autowired
    DeclarationRepo declarationRepo;

    @Autowired
    UtilisateurRepo utilisateurRepo;

    @Override
    public void affecterPolicierADeclarataion(long idUtilisateur, long idDec) {
        Utilisateur user = utilisateurRepo.findById(idUtilisateur).orElse(null);
        declarationRepo.findById(idDec).ifPresent(declaration -> {
            declaration.setPolicier(user);
            declarationRepo.save(declaration); // Save the updated declaration
        });
    }
    @Override
    public void traiterDeclarationAutomatiquement() {

        List<Declaration> nonTreatedDeclarations = declarationRepo.findByEstTraiteeFalse();

        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        List<Declaration> declarationsToBeTreated = nonTreatedDeclarations.stream()
                .filter(declaration -> declaration.getDateDeclaration().isBefore(oneMonthAgo))
                .collect(Collectors.toList());

        declarationsToBeTreated.forEach(declaration -> {
            declaration.setEstTraitee(true);
            declaration.setDateTraitement(LocalDate.now());
        });

        declarationRepo.saveAll(declarationsToBeTreated);
    }
    @Override
    public List<Declaration> afficherDeclarationsTraitees() {

        return declarationRepo.findByEstTraitee(true);
    }
}

