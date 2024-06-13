package filRougeGarage.filRougeGarage.Securite;

import filRougeGarage.filRougeGarage.Entite.Jwt;
import filRougeGarage.filRougeGarage.Entite.Utilisateur;
import filRougeGarage.filRougeGarage.Services.UtilisateurService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service

public class JwtFilter extends OncePerRequestFilter {
    private UtilisateurService utilisateurService;
    private JwtService jwtService;

    public JwtFilter(UtilisateurService utilisateurService,JwtService jwtService) {
        this.utilisateurService = utilisateurService;
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain){
        String username = null;
        String token;
        Jwt tokenDansLaBDD = null;
        boolean  isTokenExpired = true;


       final String authorization = request.getHeader("Authorization");
       if (authorization != null && authorization.startsWith("Bearer ")){
// a est li token v BDD
           token = authorization.substring(7); //eto smotret v token v header v postmane
          // this.jwtService.tokenByValue(token);
           //utilisateurService.loadUserByUsername()
           isTokenExpired = jwtService.isTokenExpired(token);
           username=jwtService.extractUsername(token);

       }

       //TEPER NUGNO SVERAYEM TOKEN KOTORII V BDD I TOKEN KOTORII SEICHAS VVODIT POLZOVATEL
        //proverayem LA VALIDITÉ DU TOKEN
        // VERIFIER LA CONCORDANCE DES USERNAME
        if (
                !isTokenExpired
                       // && username != null
                       // && tokenDansLaBDD.getUtilisateur().getEmail().equals(username)
                        && SecurityContextHolder.getContext().getAuthentication() == null
        ){


          UserDetails userDetails =  utilisateurService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        try {
            filterChain.doFilter(request,response);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ServletException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
