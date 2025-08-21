package tn.Enicarthage.CONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Etudiant;
import tn.Enicarthage.ENTITIES.Personne;
import tn.Enicarthage.SERVICES.PersonneService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/personnes")
public class PersonneController {

	
    @Autowired
    private PersonneService personneService;
    
    @PostMapping("/ajouter")
    public Personne ajouterPersonne(@RequestBody Personne depe) {
       return personneService.ajouterPersonne(depe);
       
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Personne> trouverPersonne(@PathVariable("id") Long id) {
        Personne personne = personneService.trouverPersonne(id);
        if (personne != null) {

            return new ResponseEntity<>(personne, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Personne>> toutesLesPersonnes() {
        List<Personne> personnes = personneService.toutesLesPersonnes();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> supprimerPersonne(@PathVariable("id") Long id) {
        personneService.supprimerPersonne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/modifier/{id}")
    public Personne modifierPersonne(@PathVariable("id") Long id, @RequestBody Personne personne) {
        return personneService.modifierPersonne(id, personne);
    }

}
