package filRougeGarage.filRougeGarage.Entite;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Garage {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;
    protected String nom;
    protected  String rue;
    protected String cp;
    protected String ville;
    protected String tel;
    protected String email;
    protected String site_web;
}
