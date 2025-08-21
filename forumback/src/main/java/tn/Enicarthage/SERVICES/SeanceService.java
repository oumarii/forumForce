package tn.Enicarthage.SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Etudiant;
import tn.Enicarthage.ENTITIES.Seance;
import tn.Enicarthage.ENTITIES.Tache;
import tn.Enicarthage.REPOSITORIES.SeanceRepository;

@Service
@Transactional
public class SeanceService {
    
    @Autowired
    private SeanceRepository seanceRepository;
    
    public void ajouterSeance(Seance seance) {
        seanceRepository.save(seance);
    }
    
    public void supprimerSeance(Integer id) {
        seanceRepository.deleteById(id);
    }
    
    public List<Seance> afficherSeances() {
        return seanceRepository.findAll();
    }
    
    public Seance getSeanceById(Integer id) {
        return seanceRepository.findById(id).orElse(null);
    }
    public Seance modifierSeance(Integer id, Seance nouvelleSeance) {
        Seance seanceExistante = seanceRepository.findById(id).orElse(null);
        if (seanceExistante != null) {
            seanceExistante.setTemp_deb(nouvelleSeance.getTemp_deb());
            seanceExistante.setTemp_fin(nouvelleSeance.getTemp_fin());
            seanceExistante.setSujet(nouvelleSeance.getSujet());
            seanceExistante.setAnimateurs(nouvelleSeance.getAnimateurs());
            seanceExistante.setLogistique(nouvelleSeance.getLogistique());
            return seanceRepository.save(seanceExistante);
        }
        return null;
    }



}
