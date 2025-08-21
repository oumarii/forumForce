package tn.Enicarthage.CONTROLLERS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Pack;
import tn.Enicarthage.SERVICES.PackService;

@RestController
@RequestMapping("/pack")
public class PackController {

    @Autowired
    private PackService packService;

    @PostMapping("/ajouter")
    public Pack ajouterPack(@RequestBody Pack pack) {
       return packService.ajouterPack(pack);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimerPack(@PathVariable Integer id) {
        packService.supprimerPack(id);
    }

    @GetMapping("/afficher")
    public List<Pack> afficherPacks() {
        return packService.afficherPacks();
    }

    @GetMapping("/{id}")
    public Pack getPackById(@PathVariable Integer id) {
        return packService.getPackById(id);
    }
    @PutMapping("/modifier/{id}")
    public Pack modifierPack(@PathVariable("id") Integer id, @RequestBody Pack pack) {
        return packService.modifierPack(id, pack);
    }

}