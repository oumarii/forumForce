package tn.Enicarthage.SERVICES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Etudiant;
import tn.Enicarthage.REPOSITORIES.EtudiantRepository;

import java.util.List;

@Service
@Transactional
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant trouverEtudiant(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public List<Etudiant> tousLesEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
    
    public Etudiant modifierEtudiant(Long id, Etudiant etudiant) {
        Etudiant existingEtudiant = etudiantRepository.findById(id).orElse(null);
        if (existingEtudiant != null) {
            existingEtudiant.setNiveau(etudiant.getNiveau());
            existingEtudiant.setEcole(etudiant.getEcole());
            existingEtudiant.setNom(etudiant.getNom());
            existingEtudiant.setPrenom(etudiant.getPrenom());
            existingEtudiant.setNumTele(etudiant.getNumTele());
            existingEtudiant.setAge(etudiant.getAge());
            existingEtudiant.setCin(etudiant.getCin());
            return etudiantRepository.save(existingEtudiant);
        }
        return null;
    }



}
