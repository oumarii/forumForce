package tn.Enicarthage.CONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Groupe;
import tn.Enicarthage.SERVICES.GroupeService;

import java.util.List;

@RestController
@RequestMapping("/api/groupes")
public class GroupeController {

    @Autowired
    private GroupeService groupeService;

    @PostMapping("/ajouter")
    public ResponseEntity<Groupe> ajouterGroupe(@RequestBody Groupe groupe) {
        Groupe nouveauGroupe = groupeService.ajouterGroupe(groupe);
        return new ResponseEntity<>(nouveauGroupe, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Groupe> trouverGroupe(@PathVariable("id") Long id) {
        Groupe groupe = groupeService.trouverGroupe(id);
        if (groupe != null) {
            return new ResponseEntity<>(groupe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tous")
    public ResponseEntity<List<Groupe>> tousLesGroupes() {
        List<Groupe> groupes = groupeService.tousLesGroupes();
        return new ResponseEntity<>(groupes, HttpStatus.OK);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> supprimerGroupe(@PathVariable("id") Long id) {
        groupeService.supprimerGroupe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/modifier/{id}")
    public Groupe modifierGroupe(@PathVariable("id") Long id, @RequestBody Groupe groupe) {
        return groupeService.modifierGroupe(id, groupe);
    }

}
