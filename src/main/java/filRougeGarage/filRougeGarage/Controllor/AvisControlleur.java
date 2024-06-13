package filRougeGarage.filRougeGarage.Controllor;



import filRougeGarage.filRougeGarage.Entite.Avis;
import filRougeGarage.filRougeGarage.Services.AvisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RequestMapping("avis")
@RestController
public class AvisControlleur {
    private final AvisService avisService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creer(@RequestBody Avis avis) {

        this.avisService.creer(avis);
    }
}