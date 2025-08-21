package tn.Enicarthage.CONTROLLERS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Logistique;
import tn.Enicarthage.SERVICES.LogistiqueService;
@CrossOrigin

@RestController
@RequestMapping("/logistique")
public class LogistiqueController {

    @Autowired
    private final LogistiqueService logistiqueService;

    public LogistiqueController(LogistiqueService logistiqueService) {
        this.logistiqueService = logistiqueService;
    }

    @PostMapping("/ajouter")
    public void ajouterLogistique(@RequestBody Logistique logistique) {
        logistiqueService.ajouterLogistique(logistique);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerLogistique(@PathVariable Integer id) {
        logistiqueService.supprimerLogistique(id);
    }

    @GetMapping("/afficher")
    public List<Logistique> afficherLogistiques() {
        return logistiqueService.afficherLogistiques();
    }

    @GetMapping("/{id}")
    public Logistique getLogistiqueById(@PathVariable Integer id) {
        return logistiqueService.getLogistiqueById(id);
    }
    @PutMapping("/modifier/{id}")
    public Logistique modifierLogistique(@PathVariable("id") Integer id, @RequestBody Logistique logistique) {
        return logistiqueService.modifierLogistique(id, logistique);
    }

}
