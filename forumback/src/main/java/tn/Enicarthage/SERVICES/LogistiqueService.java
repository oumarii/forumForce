package tn.Enicarthage.SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Logistique;
import tn.Enicarthage.REPOSITORIES.LogistiqueRepository;

@Service
@Transactional
public class LogistiqueService {
    
    @Autowired
    private LogistiqueRepository logistiqueRepository;
    
    public void ajouterLogistique(Logistique logistique) {
        logistiqueRepository.save(logistique);
    }
    
    public void supprimerLogistique(Integer id) {
        logistiqueRepository.deleteById(id);
    }
    
    public List<Logistique> afficherLogistiques() {
        return logistiqueRepository.findAll();
    }
    
    public Logistique getLogistiqueById(Integer id) {
        return logistiqueRepository.findById(id).orElse(null);
    }
    public Logistique modifierLogistique(Integer id, Logistique logistique) {
        Logistique existing = logistiqueRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setDateEv(logistique.getDateEv());
            existing.setLieu(logistique.getLieu());
            existing.setSeances(logistique.getSeances());
            existing.setDepenses(logistique.getDepenses());
            return logistiqueRepository.save(existing);
        }
        return null;
    }

}
