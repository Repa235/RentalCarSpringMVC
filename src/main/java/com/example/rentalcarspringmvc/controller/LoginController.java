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
@RequestMapping
public class LoginController {
    @GetMapping("/login/form")
    public String getLogin(Model model) {
        return "login";
    }


    @GetMapping("/logout")
    public String getLoginPost(HttpServletRequest request, HttpServletResponse response) {
            SecurityContextHolder.clearContext();
            HttpSession session = request.getSession();
            if (session != null) {
                session.invalidate();
            }
            for (Cookie cookie : request.getCookies()) {
                cookie.setMaxAge(-1);
            }

        return "redirect:/Homepage";
    }
}
