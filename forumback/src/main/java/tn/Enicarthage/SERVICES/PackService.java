package tn.Enicarthage.SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Pack;
import tn.Enicarthage.REPOSITORIES.PackRepository;

@Service
@Transactional
public class PackService {
    
    @Autowired
    private PackRepository packRepository;
    
    public Pack ajouterPack(Pack pack) {
        return packRepository.save(pack);
    }
    
    public void supprimerPack(Integer id) {
        packRepository.deleteById(id);
    }
    
    public List<Pack> afficherPacks() {
        return packRepository.findAll();
    }
    
    public Pack getPackById(Integer id) {
        return packRepository.findById(id).orElse(null);
    }
    public Pack modifierPack(Integer id, Pack pack) {
        Pack existing = packRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setPrix(pack.getPrix());
            existing.setType(pack.getType());
            existing.setDescription(pack.getDescription());
            existing.setNbrePlaceLimite(pack.getNbrePlaceLimite());
            existing.setEntreprises(pack.getEntreprises());
            return packRepository.save(existing);
        }
        return null;
    }

}