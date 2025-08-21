package tn.Enicarthage.SERVICES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.Enicarthage.ENTITIES.Admin;
import tn.Enicarthage.REPOSITORIES.AdminRepository;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin ajouterAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin trouverAdmin(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public List<Admin> tousLesAdmins() {
        return (List<Admin>) adminRepository.findAll();
    }

    public void supprimerAdmin(Long id) {
        adminRepository.deleteById(id);
    }
    public Admin modifierAdmin(Long id, Admin admin) {
        Admin existing = adminRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNom(admin.getNom());
            existing.setPrenom(admin.getPrenom());
            existing.setNumTele(admin.getNumTele());
            existing.setAge(admin.getAge());
            existing.setCin(admin.getCin());
            existing.setSexe(admin.getSexe());
            existing.setLogin(admin.getLogin());
            existing.setComite(admin.getComite());
            existing.setMotDePasse(admin.getMotDePasse());
            return adminRepository.save(existing);
        }
        return null;
    }

}
