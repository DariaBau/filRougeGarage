package filRougeGarage.filRougeGarage.Securite;


import filRougeGarage.filRougeGarage.Entite.Jwt;
import filRougeGarage.filRougeGarage.Entite.Utilisateur;
import filRougeGarage.filRougeGarage.Repository.JwtRepository;
import filRougeGarage.filRougeGarage.Services.UtilisateurService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import static io.jsonwebtoken.Jwts.builder;



@Transactional
@AllArgsConstructor
@Service
@NoArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    public String secret;

    public static final String BEARER = "bearer";
    private final String ENCRIPTION_KEY = secret;

    private UtilisateurService utilisateurService;
    private JwtRepository jwtRepository;


    // PROVERAYEM ESLI LI TOKEN V BDD

    public Jwt tokenByValue(String value) {
        return (Jwt) this.jwtRepository.findByValeur(value)
                .orElseThrow(() -> new RuntimeException("Token inconnu"));
    }

    public Map<String, String> generate (String username){
        Utilisateur utilisateur = this.utilisateurService.loadUserByUsername(username);

        final Map<String, String>  jwtMap = this.generateJwt(utilisateur);

        final Jwt jwt = new filRougeGarage.filRougeGarage.Entite.Jwt();

        jwt.setValeur(jwtMap.get(BEARER));
        jwt.setDesactive(false);
        jwt.setExpire(false);
        jwt.setUtilisateur(utilisateur);

        this.jwtRepository.save(jwt);
        return jwtMap;

    }

    public String extractUsername(String token) {
        return this.getClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        Date expirationDate = this.getClaim(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    private <T> T getClaim(String token, Function<Claims, T> function){
        Claims claims = getAllClaims(token);
        return function.apply(claims);
    }



    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }



    private Date getExpirationDateFromToken(String token) {
       return  this.getClaim(token, Claims::getExpiration);
    }

    //jeton son date expiration et nachalo deistviya
    private Map<String, String> generateJwt(Utilisateur utilisateur) {
        final long currentTime = System.currentTimeMillis();
        final long expirationTime = currentTime + 30*60*1000;

       final  Map<String, Object> claimes = Map.of(
                "nom", utilisateur.getNom(),
                "email", utilisateur.getEmail(),
                Claims.EXPIRATION,new Date(expirationTime),
                Claims.SUBJECT,utilisateur.getEmail()

        );
        // ustanavlivem vremay chtobi ponayt kogd on budet expirer ..

       final String bearer = builder()   //slovo bearer govorit o tom chto mi ispolzuem jwt
                .setIssuedAt(new Date(currentTime))// date creation
                .setExpiration(new Date(expirationTime))   //date d'expiration
                .setSubject(utilisateur.getEmail())   //definir la personne pour laquel on genere la tocken

                .setClaims(claimes)       //"claim" (ou assertion) est une déclaration contenue dans un jeton (token) d'authentification ou de sécurité. Les "claims" fournissent
                // des informations sur l'utilisateur authentifié et les
                // autorisations associées à ce dernier.
                .signWith(getKey(), SignatureAlgorithm.HS256)//definir la signature
                .compact();

        return Map.of(BEARER,bearer);
    }

    private Key getKey(){

       final byte[] decoder = Decoders.BASE64.decode(ENCRIPTION_KEY);

        return Keys.hmacShaKeyFor(decoder);
    }
// ici il faut recuperer l'utilisateur qui est connecté et de le deconnecter

    public void deconnexion() {
        Utilisateur utilisateur = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Jwt jwt = this.jwtRepository.findUtilisateurValidToken(
                utilisateur.getEmail(),
                false ,
                false
        ).orElseThrow(() -> new RuntimeException("Token invalide"));
// et ya hochu stocker jwt dans BDD
        jwt.setExpire(true);
        jwt.setExpire(true);
        this.jwtRepository.save(jwt);

    }
}
