package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Animateur;

@Repository
public interface AnimateurRepository extends JpaRepository<Animateur, Integer> {
   
}
