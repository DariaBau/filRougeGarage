package filRougeGarage.filRougeGarage.Entite;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @OneToOne (cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    private Utilisateur utilisateur;



}