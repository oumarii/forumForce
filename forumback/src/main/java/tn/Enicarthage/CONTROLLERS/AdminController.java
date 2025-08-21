package tn.Enicarthage.CONTROLLERS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.Enicarthage.ENTITIES.Admin;
import tn.Enicarthage.SERVICES.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
	


    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public ResponseEntity<Admin> ajouterAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.ajouterAdmin(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Admin> trouverAdmin(@PathVariable("id") Long id) {
        Admin admin = adminService.trouverAdmin(id);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @GetMapping("/all")
    public ResponseEntity<List<Admin>> tousLesAdmins() {
        List<Admin> admins = adminService.tousLesAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> supprimerAdmin(@PathVariable("id") Long id) {
        adminService.supprimerAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/modifier/{id}")
    public Admin modifierAdmin(@PathVariable("id") Long id, @RequestBody Admin admin) {
        return adminService.modifierAdmin(id, admin);
    }

}

