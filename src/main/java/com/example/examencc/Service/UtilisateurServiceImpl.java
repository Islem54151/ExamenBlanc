package com.example.examencc.Service;

import com.example.examencc.entities.Declaration;
import com.example.examencc.entities.Propriete;
import com.example.examencc.entities.Role;
import com.example.examencc.entities.Utilisateur;
import com.example.examencc.repositories.DeclarationRepo;
import com.example.examencc.repositories.ProprieteRepo;
import com.example.examencc.repositories.UtilisateurRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateur {
    @Autowired
    public UtilisateurRepo utilisateurRepo;
    @Autowired
    private DeclarationRepo declarationRepo;
    @Autowired
    private ProprieteRepo proprieteRepo;
    @Override
    public Utilisateur ajouterVictime(Utilisateur victime) {
        if (victime.getRole() == Role.POLICIER) {
            return new Utilisateur();
        }
        return utilisateurRepo.save(victime);


    }
    public String ajouterPoliciers(List<Utilisateur> policiers) {
        int nombreAjoutes = 0;

        for (Utilisateur policier : policiers) {

            if (policier.getRole() == Role.POLICIER) {
                utilisateurRepo.save(policier);
                nombreAjoutes++;
            }
        }

        return  " policiers sont ajoutés avec succès !";
    }

    @Override
    public String ajouterDeclarationEtAffecterAVictime(Declaration declaration, long telephone) {
        Utilisateur victime = utilisateurRepo.findByTelephone(telephone);
        if (victime == null) {
            return "Aucune victime trouvée avec ce numéro de téléphone : " + telephone;
        }

        Propriete propriete = new Propriete();
        propriete.setCouleur(declaration.getPropriete().getCouleur());
        propriete.setMarque(declaration.getPropriete().getMarque());
        propriete.setTypepropriete(declaration.getPropriete().getTypepropriete());
        proprieteRepo.save(propriete);


        Declaration declaration1 = new Declaration();
        declaration1.setVictime(victime);
        declaration1.setDateDeclaration(declaration.getDateDeclaration());
        declaration1.setDescription(declaration.getDescription());
        declaration1.setPropriete(propriete);

        declarationRepo.save(declaration1);
        declarationRepo.flush();

        return "Déclaration ajoutée et affectée à la victime avec succès !";
    }



}

