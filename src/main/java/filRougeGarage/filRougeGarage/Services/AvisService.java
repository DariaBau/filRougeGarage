package filRougeGarage.filRougeGarage.Services;



import filRougeGarage.filRougeGarage.Entite.Avis;
import filRougeGarage.filRougeGarage.Entite.Utilisateur;
import filRougeGarage.filRougeGarage.Repository.AvisRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class AvisService {

    private final AvisRepository avisRepository;

    public void creer(Avis avis){
       Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        avis.setUtilisateur(utilisateur);
        this.avisRepository.save(avis);
    }
}
