package tn.Enicarthage.ENTITIES;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
@Data
@Setter
@Getter
@Entity
@Table(name = "groupe")
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nom_groupe")
    private String  nom_groupe;
    
    
   @ManyToOne
   @JsonIgnoreProperties("liste_groupe")
    private Comite comit;
   
   
   
    @OneToOne
    @JoinColumn(name = "id_organisateur")
    private Organisateur organisateur;
    
    
    @OneToMany
   
    private Set<Etudiant> liste_etudiant;
    
    @OneToMany
    @JoinColumn(name = "id_groupe")
    private Set<Tache> liste_taches;
}