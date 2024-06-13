package filRougeGarage.filRougeGarage.Entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import org.springframework.ui.Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "marque_id")
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "modele_id")
    private Modele modele;







    private String carburant;
    private int kilometrage;

    @Column(name = "annee")
    private Date annee;

    @Column(name = "immatriculation")
    private String immatriculation;

}

