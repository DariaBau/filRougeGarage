package filRougeGarage.filRougeGarage.Services;


import filRougeGarage.filRougeGarage.Entite.*;
import filRougeGarage.filRougeGarage.Repository.*;
import filRougeGarage.filRougeGarage.TypeDeRole;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;


@AllArgsConstructor
@Service

public class UtilisateurService implements UserDetailsService {
    private AdresseRepository adresseRepository;
    private ClientRepository clientRepository;
    private RoleRepository roleRepository;
    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder passwordEncoder;
    // eto toge svayzano s bean kotorii encrypte le mot de passe
    private ValidationService validationService;
    private AdminRepository adminRepository;
    private EmployeRepository employeRepository;

    public void inscription(Utilisateur utilisateur) {

        if (!utilisateur.getEmail().contains("@")) {
            throw new RuntimeException("Votre mail invalide");
        }


        if (!utilisateur.getEmail().contains(".")) {
            throw new RuntimeException("Votre mail invalide");
        }


        final Optional<Utilisateur> utilisateurOptional = this.utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (utilisateurOptional.isPresent()) {
            throw new RuntimeException("Votre mail est déjà utilisé");
        }


        final String mdpCrypte = this.passwordEncoder.encode(utilisateur.getMdp());
        utilisateur.setMdp(mdpCrypte);
        final Adresse adresse = this.adresseRepository.save(utilisateur.getAdresse());
        utilisateur.setAdresse(adresse);

        Role roleClient=this.roleRepository.findByLibelle(utilisateur.getRole().getLibelle());
        utilisateur.setRole(roleClient);

        utilisateur.setActif(true);
        utilisateur = this.utilisateurRepository.save(utilisateur);
        if (utilisateur.getRole().getLibelle().equals(TypeDeRole.CLIENT)){
            final Client client = new Client();
            client.setUtilisateur(utilisateur);

            this.clientRepository.save(client);
        }

        if (utilisateur.getRole().getLibelle().equals(TypeDeRole.ADMINISTRATEUR)){
            final Admin admin = new Admin();
            admin.setUtilisateur(utilisateur);
            this.adminRepository.save(admin);
        }


        if (utilisateur.getRole().getLibelle().equals(TypeDeRole.EMPLOYE)){
            final Employe employe = new Employe();
            employe.setUtilisateur(utilisateur);

            this.employeRepository.save(employe);
        }




    }


    public void activation(final Map<String, String> activation) {  //???????????

        final Validation validation = this.validationService.lireEnFonctionDuCode(activation.get("code"));
        if (Instant.now().isAfter(validation.getExpiration())) {

            throw new RuntimeException("Votre code est expiré");
        }

        //chercher utilisateur dans BDD

        final Utilisateur utilisateurActiver = this.utilisateurRepository.findById(validation.getUtilisateur().getId()).orElseThrow(() -> new RuntimeException("Utilisateur inconnu"));
        utilisateurActiver.setActif(true);

        this.utilisateurRepository.save(utilisateurActiver);
    }
// si user on le retourn si no ...

    @Override
    public Utilisateur loadUserByUsername(final String username) throws UsernameNotFoundException {
        return this.utilisateurRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Aucun utilisateur ne corespond à cet identifiant"));
    }


}