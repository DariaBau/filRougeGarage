package filRougeGarage.filRougeGarage.Repository;

import filRougeGarage.filRougeGarage.Entite.Services;
import filRougeGarage.filRougeGarage.Entite.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeDao extends JpaRepository<Vehicule,String> {
}
