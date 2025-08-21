package tn.Enicarthage.ENTITIES;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
@Data
@Setter
@Getter
@Entity
@Table(name = "comite")
public class Comite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @OneToOne
    @JoinColumn(name = "admin_id", unique = true)
    @JsonIgnore

    private Admin admin;
    
   /*  @OneToOne(mappedBy="comite")   
    private Admin admin;
*/
    @OneToMany(mappedBy="comit")
       private Set<Groupe> liste_groupe;
}