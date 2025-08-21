package tn.Enicarthage.SERVICES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Enicarthage.ENTITIES.Entreprise;
import tn.Enicarthage.ENTITIES.Etat;
import tn.Enicarthage.ENTITIES.Pack;
import tn.Enicarthage.REPOSITORIES.EntrepriseRepository;
import tn.Enicarthage.REPOSITORIES.PackRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    private PackRepository packRepository;

    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    public Entreprise getEntrepriseById(Integer id) {
        return entrepriseRepository.findById(id).orElse(null);
    }

    public Entreprise saveEntreprise(Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    public void deleteEntreprise(Integer id) {
        entrepriseRepository.deleteById(id);
    }
    
    public void deleteALLEntreprise() {
        entrepriseRepository.deleteAll();;
    }
    
    public Entreprise modifierEntreprise(Integer id, Entreprise entreprise) {
        Entreprise existing = entrepriseRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom(entreprise.getNom());
            existing.setNif(entreprise.getNif());
            existing.setNumtel(entreprise.getNumtel());
            existing.setAdresse(entreprise.getAdresse());
            existing.setMotPasse(entreprise.getMotPasse());
            existing.setEtat(entreprise.getEtat());
            existing.setPack(entreprise.getPack());
            return entrepriseRepository.save(existing);
        }
        return null;
    }
    
    public List<Entreprise> trouverEntreprisesAvecEtatPayer() {
        List<Entreprise> toutesLesEntreprises = entrepriseRepository.findAll();
        return toutesLesEntreprises.stream()
                .filter(entreprise -> entreprise.getEtat() == Etat.PAYER)
                .collect(Collectors.toList());
    }
    public List<Pack> trouverEntreprisesAvecPack() {
    	ArrayList<Pack> toutelesPack = (ArrayList<Pack>) packRepository.findAll();
        ArrayList<Pack> desp = new ArrayList<Pack> ();
        
        List<Entreprise> toutesLesEntreprises = entrepriseRepository.findAll();

        for( Pack p :toutelesPack  ) 
        {
        	List<Entreprise>a= toutesLesEntreprises.stream()
                .filter(entreprise -> entreprise.getPack().getType() == p.getType())
                .collect(Collectors.toList());
                
        	 if(p.getNbrePlaceLimite()> a.size()) {
                	desp.add(p);	
                }
        }
        return desp;
    }
    
    
    public int calculerSommePrixPackEntreprisesAvecEtatPayer() {
        List<Entreprise> entreprisesAvecEtatPayer = trouverEntreprisesAvecEtatPayer();
        int sommePrixPack = 0;
        for (Entreprise entreprise : entreprisesAvecEtatPayer) {
            sommePrixPack += entreprise.getPack().getPrix();
        }
        return sommePrixPack;
    }

}
