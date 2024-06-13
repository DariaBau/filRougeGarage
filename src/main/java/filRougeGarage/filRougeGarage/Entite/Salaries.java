package filRougeGarage.filRougeGarage.Entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.sql.Date;

@Getter
@Setter
@Entity
public class Salaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    protected Integer Id;
    protected String nom;
    protected String prenom;
    protected String motDePasse;
    protected String email;
    protected String tel;
    protected String rue;
    protected  String cp;
    protected String ville;
    protected String poste;
    private Date entryDate;
    private int idGarage;


}