package filRougeGarage.filRougeGarage.Repository;

import filRougeGarage.filRougeGarage.Entite.Particulier;
import filRougeGarage.filRougeGarage.Entite.Role;
import filRougeGarage.filRougeGarage.TypeDeRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {


    Role findByLibelle(TypeDeRole name);
}

