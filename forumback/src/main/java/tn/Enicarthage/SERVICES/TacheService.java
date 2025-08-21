package tn.Enicarthage.SERVICES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import tn.Enicarthage.ENTITIES.Etudiant;
import tn.Enicarthage.ENTITIES.Groupe;
import tn.Enicarthage.ENTITIES.Tache;
import tn.Enicarthage.REPOSITORIES.TacheRepository;

import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public class TacheService {

    @Autowired
    private TacheRepository tacheRepository;

    public Tache ajouterTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    public Tache trouverTache(Long id) {
        return tacheRepository.findById(id).orElse(null);
    }

    public List<Tache> toutesLesTaches() {
        return tacheRepository.findAll();
    }

    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);
    }
    public Tache modifierEtudiant(Long id, Tache t) {
        Tache existing = tacheRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setDateDebut(t.getDateDebut());
            existing.setDateFin(t.getDateFin());
            existing.setNom(t.getNom());
            existing.setFinish(t.isFinish());
            existing.setGroupe(t.getGroupe());
            return tacheRepository.save(existing);
        }
        return null;
    }
}