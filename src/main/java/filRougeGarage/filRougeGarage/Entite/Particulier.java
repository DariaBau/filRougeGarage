package filRougeGarage.filRougeGarage.Entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.Year;

@Getter
@Setter
@Entity
public class Particulier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;
    protected String marque;
    protected String modele;
    @Column(name = "annee", nullable = false)
    private Year annee;

}