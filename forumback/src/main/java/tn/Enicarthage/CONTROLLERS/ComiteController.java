package tn.Enicarthage.CONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Comite;
import tn.Enicarthage.SERVICES.ComiteService;

import java.util.List;

@RestController
@RequestMapping("/api/comites")
public class ComiteController {

    @Autowired
    private ComiteService comiteService;

    @PostMapping("/ajouter")
    public ResponseEntity<Comite> ajouterComite(@RequestBody Comite comite) {
        Comite nouveauComite = comiteService.ajouterComite(comite);
        return new ResponseEntity<>(nouveauComite, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comite> trouverComite(@PathVariable Long id) {
        Comite comite = comiteService.trouverComite(id);
        if (comite != null) {
            return new ResponseEntity<>(comite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tous")
    public ResponseEntity<List<Comite>> tousLesComites() {
        List<Comite> comites = comiteService.tousLesComites();
        return new ResponseEntity<>(comites, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerComite(@PathVariable Long id) {
        comiteService.supprimerComite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/modifier/{id}")
    public Comite modifierComite(@PathVariable("id") Long id, @RequestBody Comite comite) {
        return comiteService.modifierComite(id, comite);
    }

}
