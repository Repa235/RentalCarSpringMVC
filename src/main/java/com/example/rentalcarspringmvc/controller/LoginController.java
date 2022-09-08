package com.example.rentalcarspringmvc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login/form")
public class LoginController {
    @GetMapping
    public String getLogin(Model model) {
        return "login";
    }


    @PostMapping
    public String getLoginPost(HttpServletRequest request, HttpServletResponse response) {

        String[] test = request.getParameterValues("logout");

        if (test != null) {
            HttpSession session = request.getSession(false);
            SecurityContextHolder.clearContext();
            session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            for (Cookie cookie : request.getCookies()) {
                cookie.setMaxAge(0);
            }


        }
        return "redirect:/login/form?logout";
    }
}
