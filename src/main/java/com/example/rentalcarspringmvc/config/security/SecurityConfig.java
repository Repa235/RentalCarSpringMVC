package com.example.rentalcarspringmvc.config.security;

import com.example.rentalcarspringmvc.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("customUserDetailService")
    private final CustomUserDetailService customUserDetailService;

    public SecurityConfig(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    public static final String[] ADMIN_URL_MATCHER = {
            "/prenotazione/visualizzaPrenotazioni",
            "/prenotazione/gestisciPrenotazione",
            "/utente/profiloSuperuser",
            "/utente/searchUtenti",
            "/utente/eliminaUtente",
            "/veicolo/formVeicolo",
            "/veicolo/aggiungiVeicolo",
    };

    public static final String[] USER_URL_MATCHER = {
            "/prenotazione/dateselector",
            "/prenotazione/selectVeicoloByDates",
            "/prenotazione/inserisciPrenotazione",
            "/veicolo/visualizzaVeicoliUtente",
    };


    public void configure(final HttpSecurity http) throws Exception {
        //L'ordine dei matcher conta, si va in ordine decrescente rispetto alle restrizioni
        http
                //Parti di codice liberamente accessibili
                .authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/veicolo").permitAll()
                //Riservate al superuser
                .antMatchers("/utente/**").access("hasAnyRole('ADMIN','USER')")
                .antMatchers(ADMIN_URL_MATCHER).access("hasRole('ADMIN')")
                //Riservate a customer e superuser
                .antMatchers(USER_URL_MATCHER).access("hasRole('USER')")
                .and()
                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/login/form") //Dove si trova il form di login
                .loginProcessingUrl("/login")
                .failureUrl("/login/form?error") //in caso di errore
                .usernameParameter("userId")
                .passwordParameter("password")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/login/form?forbidden")
                .and()
                .logout()
                .logoutUrl("/login/form?logout")
                .and().csrf().disable() //utile in fase di sviluppo ma da riattivare in fase operativa
        ;
    }

    public AuthenticationFilter authenticationFilter() throws Exception {
        AuthenticationFilter filter = new AuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationFailureHandler(failureHandler());
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
        return filter;

    }


    public SimpleUrlAuthenticationFailureHandler failureHandler() {
        return new SimpleUrlAuthenticationFailureHandler("/login/form?error");
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new SuccessHandler();
    }


}
