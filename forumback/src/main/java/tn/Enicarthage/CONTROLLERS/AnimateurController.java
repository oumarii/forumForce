package tn.Enicarthage.CONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Animateur;
import tn.Enicarthage.SERVICES.AnimateurService;

import java.util.List;

@RestController
@RequestMapping("/api/animateurs")
public class AnimateurController {

    @Autowired
    private AnimateurService animateurService;

    @PostMapping("/add")
    public ResponseEntity<Void> addAnimateur(@RequestBody Animateur animateur) {
        animateurService.ajouterAnimateur(animateur);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animateur> getAnimateurById(@PathVariable Integer id) {
        Animateur animateur = animateurService.getAnimateurById(id);
        if (animateur != null) {
            return new ResponseEntity<>(animateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Animateur>> getAllAnimateurs() {
        List<Animateur> animateurs = animateurService.afficherAnimateurs();
        if (!animateurs.isEmpty()) {
            return new ResponseEntity<>(animateurs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/modifier/{id}")
    public Animateur modifierAnimateur(@PathVariable("id") Integer id, @RequestBody Animateur animateur) {
        return animateurService.modifierAnimateur(id, animateur);
    }

}
