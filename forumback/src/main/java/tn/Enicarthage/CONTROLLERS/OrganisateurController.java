package tn.Enicarthage.CONTROLLERS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Etudiant;
import tn.Enicarthage.ENTITIES.Organisateur;
import tn.Enicarthage.SERVICES.OrganisateurService;

import java.util.List;

@RestController
@RequestMapping("/organisateurs")
public class OrganisateurController {

    @Autowired
    private OrganisateurService organisateurService;

    @PostMapping("/ajouter")
    public ResponseEntity<Organisateur> ajouterOrganisateur(@RequestBody Organisateur organisateur) {
        Organisateur savedOrganisateur = organisateurService.ajouterOrganisateur(organisateur);
        return new ResponseEntity<>(savedOrganisateur, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organisateur> trouverOrganisateur(@PathVariable("id") Long id) {
        Organisateur organisateur = organisateurService.trouverOrganisateur(id);
        if (organisateur != null) {
            return new ResponseEntity<>(organisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tous")
    public ResponseEntity<List<Organisateur>> tousLesOrganisateurs() {
        List<Organisateur> organisateurs = organisateurService.tousLesOrganisateurs();
        if (!organisateurs.isEmpty()) {
            return new ResponseEntity<>(organisateurs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerOrganisateur(@PathVariable("id") Long id) {
        organisateurService.supprimerOrganisateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/modifier/{id}")
    public Organisateur modifierOrganisateur(@PathVariable("id") Long id, @RequestBody Organisateur organisateur) {
        return organisateurService.modifierOrganisateur(id, organisateur);
    }

}
