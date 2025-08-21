package tn.Enicarthage.ENTITIES;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;

@Setter
@Getter
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
@Table(name = "personnes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USR_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Personne  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "num_tele")
    private String numTele;

    @Column(name = "age")
    private int age;

    @Column(name = "cin")
    private String cin;

    @Column(name = "sexe")
    private String sexe;
}
