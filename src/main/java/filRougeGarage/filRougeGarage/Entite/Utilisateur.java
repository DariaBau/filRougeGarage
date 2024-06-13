package filRougeGarage.filRougeGarage.Entite;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mot_de_passe")
    private String mdp;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Getter
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phone_number;

    @OneToOne (cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
   private Adresse adresse;


    private boolean actif = false; // par default utilisateur n'est pas actif
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    private Role role;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {  //avec getAuthorities mi daem role dlay utilisateurs
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+this.role.getLibelle()));
    }

    @Override
    public String getPassword() {
        return this.mdp;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() { // est ce que son compte est expiré
        return this.actif;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.actif;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.actif;
    }

    @Override
    public boolean isEnabled() { //est-ce que son compte est actif
        return this.actif;
    }


}