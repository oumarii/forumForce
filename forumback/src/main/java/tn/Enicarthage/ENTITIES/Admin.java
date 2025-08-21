package tn.Enicarthage.ENTITIES;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.*;

@Data
@Setter

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Personne {

    @Column(name = "login")
    private String login;
    /*
 @OneToOne
private Comite comite;
 */
    @OneToOne(mappedBy = "admin", cascade = CascadeType.ALL)
    private Comite comite;

    @Column(name = "mot_de_passe")
    private String motDePasse;
    
 
}