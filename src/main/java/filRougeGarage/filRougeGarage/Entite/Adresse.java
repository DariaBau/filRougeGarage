package filRougeGarage.filRougeGarage.Entite;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "adresse")
public class Adresse {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rue;


    protected String cp;

    protected String ville;

    protected String pays;

    //@OneToOne (cascade = {CascadeType.MERGE,CascadeType.REMOVE})
   // private Utilisateur utilisateur;
}
