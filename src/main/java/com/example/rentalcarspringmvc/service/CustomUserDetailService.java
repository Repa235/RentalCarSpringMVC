package com.example.rentalcarspringmvc.service;


import com.example.rentalcarspringmvc.entities.Utente;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    private final UtenteService utenteService;

    public CustomUserDetailService(UtenteService utenteService) {
        this.utenteService = utenteService;
    }
    private static final Logger LOGGER = Logger.getLogger("Customer detail service: ");
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username == null) {
            throw new UsernameNotFoundException("Username mancante");
        }
        Utente utente = utenteService.getUsersByUsername(username);
        if(utente==null){
            throw new UsernameNotFoundException("Utente non trovato");
        }
        LOGGER.info("Utente prelevato: " + utente.getNome() + " " + utente.getCognome());
        UserBuilder builder = User.withUsername(utente.getUsername());
        builder.password(utente.getPassword());
        if(utente.getTipo().equals("superuser")){
            builder.roles("ADMIN");
        } else {
            builder.roles("USER");
        }
        return builder.build();
    }
}
