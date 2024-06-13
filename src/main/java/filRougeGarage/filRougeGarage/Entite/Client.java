package filRougeGarage.filRougeGarage.Entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @OneToOne (cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    private Utilisateur utilisateur;



}