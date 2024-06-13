package filRougeGarage.filRougeGarage.Repository;


import filRougeGarage.filRougeGarage.Entite.Validation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ValidationRepository extends CrudRepository<Validation, Integer> {

    Optional<Validation> findByCode(String code);
}
