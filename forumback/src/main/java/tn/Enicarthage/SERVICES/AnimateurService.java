package tn.Enicarthage.SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Animateur;
import tn.Enicarthage.REPOSITORIES.AnimateurRepository;

@Service
@Transactional
public class AnimateurService {
    
    @Autowired
    private AnimateurRepository animateurRepository;
    
    public void ajouterAnimateur(Animateur animateur) {
        animateurRepository.save(animateur);
    }
    
    public void supprimerAnimateur(Integer id) {
        animateurRepository.deleteById(id);
    }
    
    public List<Animateur> afficherAnimateurs() {
        return animateurRepository.findAll();
    }
    
    public Animateur getAnimateurById(Integer id) {
        return animateurRepository.findById(id).orElse(null);
    }
    public Animateur modifierAnimateur(Integer id, Animateur animateur) {
        Animateur existing = animateurRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom(animateur.getNom());
            existing.setPrenom(animateur.getPrenom());
            existing.setNumTele(animateur.getNumTele());
            existing.setAge(animateur.getAge());
            existing.setCin(animateur.getCin());
            existing.setSexe(animateur.getSexe());
            existing.setDomaie_exp(animateur.getDomaie_exp());
            existing.setSceannce(animateur.getSceannce());
            return animateurRepository.save(existing);
        }
        return null;
    }

}
