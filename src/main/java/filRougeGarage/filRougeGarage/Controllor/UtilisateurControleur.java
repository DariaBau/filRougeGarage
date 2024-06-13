package filRougeGarage.filRougeGarage.Controllor;


import filRougeGarage.filRougeGarage.DTO.AuthentificationDTO;
import filRougeGarage.filRougeGarage.Entite.Utilisateur;
import filRougeGarage.filRougeGarage.Repository.UtilisateurRepository;
import filRougeGarage.filRougeGarage.Securite.JwtService;
import filRougeGarage.filRougeGarage.Services.UtilisateurService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UtilisateurControleur {


    private AuthenticationManager authenticationManager;
    private UtilisateurService utilisateurService;
    private JwtService jwtService;
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    //public UtilisateurControleur(AuthenticationManager authenticationManager, UtilisateurService utilisateurService, JwtService jwtService) {
    //   this.authenticationManager = authenticationManager;
    // this.utilisateurService = utilisateurService;
    // this.jwtService = jwtService;
    //}


    @PostMapping(path = "inscription")   // eto pomogaet inserer utilisateur v BDD
    public void inscription(@RequestBody Utilisateur utilisateur) {    //Dans cet exemple, lorsqu'une requête POST est envoyée à /inscription avec un corps JSON comme { "id": "mdp", "NOM": "EMAIL" }, Spring convertira automatiquement
        // ce JSON en un objet Utilisateur et le passera à la méthode ajouter.


        log.info("Inscription"); //enregistre un message d'information avec le texte "Inscription " dans le journal.

        this.utilisateurService.inscription(utilisateur);
    }

    @PostMapping(path = "activation")   // eto pomogaet inserer utilisateur v BDD
    public void activation(@RequestBody Map<String, String> activation) {
        log.info("Inscription");


        this.utilisateurService.activation(activation);
    }


    @PostMapping(path = "deconnexion")   //
    public void deconnexion() {
        this.jwtService.deconnexion();
    }


    @PostMapping(path = "login")
    public Map<String, String> connexion(@RequestBody AuthentificationDTO authentificationDTO) {
        final Authentication authenticate = authenticationManager.authenticate(       // authentiface un utilisateur dans mon systeme
                new UsernamePasswordAuthenticationToken(authentificationDTO.username(),
                        authentificationDTO.password())

        );


        if (authenticate.isAuthenticated()) {
            return this.jwtService.generate(authentificationDTO.username());
        }
        log.info("resultat {}", authenticate.isAuthenticated());
        return null;
    }

}