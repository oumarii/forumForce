package tn.Enicarthage.SERVICES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Organisateur;
import tn.Enicarthage.ENTITIES.Personne;
import tn.Enicarthage.REPOSITORIES.OrganisateurRepository;

import java.util.List;

@Service
@Transactional
public class OrganisateurService {

    @Autowired
    private OrganisateurRepository organisateurRepository;

    public Organisateur ajouterOrganisateur(Organisateur organisateur) {
        return organisateurRepository.save(organisateur);
    }

    public Organisateur trouverOrganisateur(Long id) {
        return organisateurRepository.findById(id).orElse(null);
    }

    public List<Organisateur> tousLesOrganisateurs() {
        return (List<Organisateur>) organisateurRepository.findAll();
    }

    public void supprimerOrganisateur(Long id) {
        organisateurRepository.deleteById(id);
    }
    public Organisateur modifierPersonne(Long id, Organisateur personne) {
        Organisateur existing = organisateurRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom(personne.getNom());
            existing.setPrenom(personne.getPrenom());
            existing.setNumTele(personne.getNumTele());
            existing.setAge(personne.getAge());
            existing.setCin(personne.getCin());
            return organisateurRepository.save(existing);
        }
        return null;
    }

	public Organisateur modifierOrganisateur(Long id, Organisateur organisateur) {
		// TODO Auto-generated method stub
		return null;
	}
}
