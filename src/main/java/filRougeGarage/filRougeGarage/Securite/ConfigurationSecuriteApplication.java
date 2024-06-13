package filRougeGarage.filRougeGarage.Securite;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.POST;


@Configuration
@EnableWebSecurity

public class ConfigurationSecuriteApplication {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtFilter jwtFilter;
    private final UserDetailsService userDetailsService;

    public ConfigurationSecuriteApplication(final BCryptPasswordEncoder bCryptPasswordEncoder, final JwtFilter jwtFilter, final UserDetailsService userDetailsService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;

    }

    //public ConfigurationSecuriteApplication(UserDetailsService userDetailsService) {
    // this.userDetailsService = userDetailsService;
    //}


    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
        return
                httpSecurity
                        .csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(
                                authorize ->
                                        authorize
                                                .requestMatchers(POST, "/inscription").permitAll()
                                                .requestMatchers(POST, "/login").permitAll()
                                                .requestMatchers(POST, "/activation").permitAll() //activer la route
                                                .requestMatchers(POST, "/send-email").permitAll()
                                                .anyRequest().authenticated()
                        )
                        .sessionManagement(httpSecuritySessionManagementConfigurer ->
                                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                        )
                        //.authenticationProvider(authenticationProvider())
                        .addFilterBefore(this.jwtFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
    }


    //encrypter le mot de passe ; créer un rôle pour utilisateur ; vérifier l'email de l'utilisateur
    //  on crée un bean qui nour permet crypter un mot de passe
    // @Bean
    //public BCryptPasswordEncoder passwordEncoder(){

    // return new BCryptPasswordEncoder();
    // }

    @Bean
    public AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // @Bean
    // public UserDetailsService userDetailsService(){

    // return new UtilisateurService();
    //   }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(this.bCryptPasswordEncoder);

        return daoAuthenticationProvider;

    }
}