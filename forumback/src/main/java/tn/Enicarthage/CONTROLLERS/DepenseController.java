package tn.Enicarthage.CONTROLLERS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Depense;
import tn.Enicarthage.SERVICES.DepenseService;

@RestController
@RequestMapping("/depense")
public class DepenseController {

    @Autowired
    private DepenseService depenseService;

   
    @PostMapping("/ajouter")
    public Depense ajouterDepense(@RequestBody Depense depense) {
       return depenseService.ajouterDepense(depense);
    }


    
    @DeleteMapping("/supprimer/{id}")
    public void supprimerDepense(@PathVariable Integer id) {
        depenseService.supprimerDepense(id);
    }

    @GetMapping("/afficher")
    public List<Depense> afficherDepenses() {
        return depenseService.afficherDepenses();
    }

    @GetMapping("/{id}")
    public Depense getDepenseById(@PathVariable Integer id) {
        return depenseService.getDepenseById(id);
    }

    @PutMapping("/modifier/{id}")
    public Depense modifierDepense(@PathVariable("id") Integer id, @RequestBody Depense depense) {
        return depenseService.modifierDepense(id, depense);
    }

    @GetMapping("/somme-montant")
    public ResponseEntity<Integer> calculerSommeMontantDepenses() {
        int sommeMontant = depenseService.calculerSommeMontantDepenses();
        return new ResponseEntity<>(sommeMontant, HttpStatus.OK);
    }
}
