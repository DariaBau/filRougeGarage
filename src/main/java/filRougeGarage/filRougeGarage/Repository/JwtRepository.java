package filRougeGarage.filRougeGarage.Repository;

import filRougeGarage.filRougeGarage.Entite.Jwt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface JwtRepository  extends CrudRepository<Jwt,Integer> {

    Optional<Jwt> findByValeur(String value);

    Optional <Jwt> findByValeurAndDesactiveAndExpire(String valeur,boolean desactive,boolean expire);


     @Query("FROM Jwt j WHERE j.expire = :expire AND j.desactive = :desactive AND j.utilisateur.email = :email")
    Optional <Jwt> findUtilisateurValidToken(String email,boolean desactive,boolean expire);

    @Query("FROM Jwt j WHERE  j.utilisateur.email = :email")
    Stream<Jwt> findUtilisateur(String email);
}
