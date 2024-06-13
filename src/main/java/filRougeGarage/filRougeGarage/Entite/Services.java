package filRougeGarage.filRougeGarage.Entite;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    protected Integer Id;
    protected String libelle;
    protected String description;

    private int idGarage;
}