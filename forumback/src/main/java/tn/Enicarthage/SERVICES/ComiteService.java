package tn.Enicarthage.SERVICES;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Comite;
import tn.Enicarthage.REPOSITORIES.ComiteRepo;

import java.util.List;

@Service
@Transactional
public class ComiteService {

    @Autowired
    private ComiteRepo comiteRepository;

    public Comite ajouterComite(Comite comite) {
        return comiteRepository.save(comite);
    }

    public Comite trouverComite(Long id) {
        return comiteRepository.findById(id).orElse(null);
    }

    public List<Comite> tousLesComites() {
        return (List<Comite>) comiteRepository.findAll();
    }

    public void supprimerComite(Long id) {
        comiteRepository.deleteById(id);
    }
    public Comite modifierComite(Long id, Comite comite) {
        Comite existing = comiteRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setAdmin(comite.getAdmin());
            existing.setListe_groupe(comite.getListe_groupe());
            return comiteRepository.save(existing);
        }
        return null;
    }

}
