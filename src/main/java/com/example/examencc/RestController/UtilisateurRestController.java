package com.example.examencc.RestController;

import com.example.examencc.Service.IUtilisateur;
import com.example.examencc.entities.Declaration;
import com.example.examencc.entities.Utilisateur;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/utilisateur-rest-controller")
public class UtilisateurRestController {
    IUtilisateur utilisateurService;
    @PostMapping(path ="/ajoutervictime")
    public Utilisateur ajouterVictime(@RequestBody Utilisateur victime){
       return utilisateurService.ajouterVictime(victime);

    }
    @PostMapping("/ajouterPoliciers")
    public String ajouterPoliciers(@RequestBody List<Utilisateur> policiers) {
        return utilisateurService.ajouterPoliciers(policiers);
    }
    @PostMapping("/ajouterDeclarationEtAffecterAVictime")
    public String ajouterDeclarationEtAffecterAVictime(@RequestBody Declaration declaration,
                                                       @RequestParam long telephone) {
        return utilisateurService.ajouterDeclarationEtAffecterAVictime(declaration, telephone);
    }

}

