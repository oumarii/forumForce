package tn.Enicarthage.CONTROLLERS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Etudiant;
import tn.Enicarthage.ENTITIES.Tache;
import tn.Enicarthage.SERVICES.EtudiantService;
import tn.Enicarthage.SERVICES.TacheService;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @PostMapping("/add")
    public ResponseEntity<Tache> ajouterTache(@RequestBody Tache tache) {
        Tache nouvelleTache = tacheService.ajouterTache(tache);
        return new ResponseEntity<>(nouvelleTache, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tache> trouverTache(@PathVariable("id") Long id) {
        Tache tache = tacheService.trouverTache(id);
        if (tache != null) {
            return new ResponseEntity<>(tache, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tache>> toutesLesTaches() {
        List<Tache> taches = tacheService.toutesLesTaches();
        return new ResponseEntity<>(taches, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> supprimerTache(@PathVariable("id") Long id) {
        tacheService.supprimerTache(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/modifier/{id}")
    public Tache modifierEtudiant(@PathVariable("id") Long id, @RequestBody Tache etudiant) {
        return tacheService.modifierEtudiant(id, etudiant);
    }
}
