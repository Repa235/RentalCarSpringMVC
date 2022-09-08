package com.example.rentalcarspringmvc.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

public class SuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger LOGGER = Logger.getLogger("SuccessHandler: ");
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        LOGGER.info("Roles:" + roles);
        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("utente/profiloSuperuser");
            LOGGER.info("Superuser");
        } else {
            httpServletResponse.sendRedirect("utente/profiloCustomer");
            LOGGER.info("Customer");
        }
    }

}
