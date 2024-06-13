package filRougeGarage.filRougeGarage.Repository;


import filRougeGarage.filRougeGarage.Entite.Particulier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticulierDao extends JpaRepository<Particulier,String> {
}
