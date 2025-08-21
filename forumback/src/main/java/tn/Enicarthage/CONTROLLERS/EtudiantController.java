package tn.Enicarthage.CONTROLLERS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Etudiant;
import tn.Enicarthage.SERVICES.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/ajouter")
    public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant newEtudiant = etudiantService.ajouterEtudiant(etudiant);
        return new ResponseEntity<>(newEtudiant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> trouverEtudiantParId(@PathVariable("id") Long id) {
        Etudiant etudiant = etudiantService.trouverEtudiant(id);
        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    

    @GetMapping("/tous")
    public ResponseEntity<List<Etudiant>> tousLesEtudiants() {
        List<Etudiant> etudiants = etudiantService.tousLesEtudiants();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerEtudiant(@PathVariable("id") Long id) {
        etudiantService.supprimerEtudiant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @PutMapping("/modifier/{id}")
    public Etudiant modifierEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant etudiant) {
        return etudiantService.modifierEtudiant(id, etudiant);
    }

}
