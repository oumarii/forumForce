package tn.Enicarthage.SERVICES;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Personne;
import tn.Enicarthage.REPOSITORIES.PersonneRepository;

import java.util.List;

@Service
@Transactional
public class PersonneService {

	 @Autowired
	    private PersonneRepository personneRepository;

	    public Personne ajouterPersonne(Personne personne) {
	        return personneRepository.save(personne);
	    }

	    public Personne trouverPersonne(Long id) {
	        return personneRepository.findById(id).orElse(null);
	    }

	    public List<Personne> toutesLesPersonnes() {
	        return (List<Personne>) personneRepository.findAll();
	    }

	    public void supprimerPersonne(Long id) {
	        personneRepository.deleteById(id);
	    }
	    public Personne modifierPersonne(Long id, Personne personne) {
	        Personne existing = personneRepository.findById(id).orElse(null);
	        if (existing != null) {
	            existing.setNom(personne.getNom());
	            existing.setPrenom(personne.getPrenom());
	            existing.setNumTele(personne.getNumTele());
	            existing.setAge(personne.getAge());
	            existing.setCin(personne.getCin());
	            return personneRepository.save(existing);
	        }
	        return null;
	    }

}
