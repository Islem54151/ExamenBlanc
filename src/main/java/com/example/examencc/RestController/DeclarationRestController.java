package com.example.examencc.RestController;

import com.example.examencc.Service.IDeclaration;
import com.example.examencc.entities.Declaration;
import com.example.examencc.entities.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/declaration")
public class DeclarationRestController {

    @Autowired
    IDeclaration  declarationService;

    @PostMapping("/affecterPolicierADeclaration")
    public ResponseEntity<String> affecterPolicierADeclaration(@RequestParam long idUser,
                                                               @RequestParam long idDec) {
        declarationService.affecterPolicierADeclarataion(idUser, idDec);
        return ResponseEntity.ok("Policier affecté à la déclaration avec succès !");
    }
    @GetMapping("/traiterDeclarations")
    public String traiterDeclarationsAutomatiquement() {
        declarationService.traiterDeclarationAutomatiquement();
        return "Les déclarations ont été traitées automatiquement.";
    }
    @GetMapping("/traitees")
    public List<Declaration> getDeclarationsTraitees() {
        return declarationService.afficherDeclarationsTraitees();
    }
}
