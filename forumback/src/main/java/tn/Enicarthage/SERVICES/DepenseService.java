package tn.Enicarthage.SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Depense;
import tn.Enicarthage.REPOSITORIES.DepenseRepository;

@Service
@Transactional
public class DepenseService {
    
    @Autowired
    private DepenseRepository depenseRepository;
    
    public Depense ajouterDepense(Depense depense) {
        return depenseRepository.save(depense);
    }
    
    public void supprimerDepense(Integer id) {
        depenseRepository.deleteById(id);
    }
    
    public List<Depense> afficherDepenses() {
        return (List<Depense>) depenseRepository.findAll();
    }
    
    public Depense getDepenseById(Integer id) {
        return depenseRepository.findById(id).orElse(null);
    }
    public Depense modifierDepense(Integer id, Depense depense) {
        Depense existing = depenseRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setMontant(depense.getMontant());
            existing.setDescription(depense.getDescription());
            existing.setNumFacture(depense.getNumFacture());
            existing.setLogistique(depense.getLogistique());
            return depenseRepository.save(existing);
        }
        return null;
    }
    public int calculerSommeMontantDepenses() {
        List<Depense> depenses = depenseRepository.findAll();
        int sommeMontant = 0;
        for (Depense depense : depenses) {
            sommeMontant += depense.getMontant();
        }
        return sommeMontant;
    }
}
