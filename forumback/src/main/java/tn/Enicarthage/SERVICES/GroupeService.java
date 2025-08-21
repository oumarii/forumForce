package tn.Enicarthage.SERVICES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Groupe;
import tn.Enicarthage.REPOSITORIES.GroupeRepo;

import java.util.List;

@Service
@Transactional
public class GroupeService {

    @Autowired
    private GroupeRepo groupeRepository;

    public Groupe ajouterGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    public Groupe trouverGroupe(Long id) {
        return groupeRepository.findById(id).orElse(null);
    }

    public List<Groupe> tousLesGroupes() {
        return (List<Groupe>) groupeRepository.findAll();
    }

    public void supprimerGroupe(Long id) {
        groupeRepository.deleteById(id);
    }
    public Groupe modifierGroupe(Long id, Groupe groupe) {
        Groupe existing = groupeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom_groupe(groupe.getNom_groupe());
            existing.setComit(groupe.getComit());
            existing.setOrganisateur(groupe.getOrganisateur());
            existing.setListe_etudiant(groupe.getListe_etudiant());
            existing.setListe_taches(groupe.getListe_taches());
            return groupeRepository.save(existing);
        }
        return null;
    }

}
