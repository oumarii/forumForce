package tn.Enicarthage.ENTITIES;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

@Data
@Setter
@Getter


@Entity
@Table(name = "tache")
public class Tache {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "date_debut")
    private LocalDate dateDebut;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "nom")
    private String nom;

    @Column(name = "finish")
    private boolean finish;

    @ManyToOne
     @JsonIgnoreProperties("taches")
    private Groupe groupe;
    
    
}