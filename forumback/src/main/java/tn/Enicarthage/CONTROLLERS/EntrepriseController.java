package tn.Enicarthage.CONTROLLERS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Entreprise;
import tn.Enicarthage.ENTITIES.Pack;
import tn.Enicarthage.SERVICES.EntrepriseService;

@RestController
@RequestMapping("/entreprise")
@CrossOrigin("")
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;

   
    @PostMapping("/ajouter")
    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise) {
       return entrepriseService.saveEntreprise(entreprise);
    }
   
    @DeleteMapping("/supprimer/{id}")
    public void supprimerEntreprise(@PathVariable Integer id) {
        entrepriseService.deleteEntreprise(id);
    }
    @DeleteMapping("/supprimertous")
    public void supprimerTEntreprise() {
        entrepriseService.deleteALLEntreprise();
    }

    @GetMapping("/afficher")
    public List<Entreprise> afficherEntreprises() {
        return entrepriseService.getAllEntreprises();
    }

    @GetMapping("/{id}")
    public Entreprise getEntrepriseById(@PathVariable Integer id) {
        return entrepriseService.getEntrepriseById(id);
    }
    
    @PutMapping("/modifier/{id}")
    public Entreprise modifierEntreprise(@PathVariable("id") Integer id, @RequestBody Entreprise entreprise) {
        return entrepriseService.modifierEntreprise(id, entreprise);
    }
    @GetMapping("/etat-payer")
    public ResponseEntity<List<Entreprise>> trouverEntreprisesAvecEtatPayer() {
        List<Entreprise> entreprises = entrepriseService.trouverEntreprisesAvecEtatPayer();
        return new ResponseEntity<>(entreprises, HttpStatus.OK);
    }

    @GetMapping("/somme-etat-payer")
    public ResponseEntity<Integer> calculerSommePrixPackEntreprisesAvecEtatPayer() {
        int sommePrixPack = entrepriseService.calculerSommePrixPackEntreprisesAvecEtatPayer();
        return new ResponseEntity<>(sommePrixPack, HttpStatus.OK);
    }
    
    @GetMapping("/entreprises-avec-pack")
    public List<Pack> trouverEntreprisesAvecPack() {
        return entrepriseService.trouverEntreprisesAvecPack();
    }
}
