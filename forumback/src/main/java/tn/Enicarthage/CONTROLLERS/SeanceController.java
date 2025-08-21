package tn.Enicarthage.CONTROLLERS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Entreprise;
import tn.Enicarthage.ENTITIES.Seance;
import tn.Enicarthage.SERVICES.SeanceService;

@RestController
@RequestMapping("/seance")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @PostMapping("/ajouter")
    public void ajouterSeance(@RequestBody Seance seance) {
        seanceService.ajouterSeance(seance);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerSeance(@PathVariable Integer id) {
        seanceService.supprimerSeance(id);
    }
    
    @PutMapping("/modifier/{id}")
    public Seance modifierSeance (@PathVariable("id") Integer id, @RequestBody Seance entreprise) {
        return seanceService.modifierSeance(id, entreprise);
    }
    

    
    @GetMapping("/afficher")
    public List<Seance> afficherSeances() {
        return seanceService.afficherSeances();
    }

    @GetMapping("/{id}")
    public Seance getSeanceById(@PathVariable Integer id) {
        return seanceService.getSeanceById(id);
    }



}