package filRougeGarage.filRougeGarage.Services;


import filRougeGarage.filRougeGarage.Entite.Utilisateur;
import filRougeGarage.filRougeGarage.Entite.Validation;
import filRougeGarage.filRougeGarage.Repository.ValidationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Random;

import static java.time.temporal.ChronoUnit.MINUTES;

@AllArgsConstructor
@Service
public class ValidationService {

    private ValidationRepository validationRepository;
    private NotificationService notificationService;
//utilisateur moget activer son compte sur le système


    public void enregistrer(Utilisateur utilisateur) {


        Validation validation = new Validation();    // definir utilisateur
        validation.setUtilisateur(utilisateur);

        Instant creation = Instant.now();
        validation.setCreation(creation);
        Instant expiration = creation.plus(10, MINUTES); // expiration ici c'est 10 minutes
        validation.setExpiration(expiration);
        Random random = new Random();
        int randomInteger = random.nextInt(999999);
        String code = String.format("%06d", randomInteger);
        validation.setCode(code);

        this.validationRepository.save(validation);
        this.notificationService.envoyer(validation);


    }

    public Validation lireEnFonctionDuCode(String code) {
        return this.validationRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Votre code est invalide"));
    }


}