package com.example.rentalcarspringmvc.util;

import com.example.rentalcarspringmvc.exception.DataParseException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;

public class MetodiUtil {

    private MetodiUtil() {}

    public static LocalDate parseDate(String d) {
        if (d == null || d.isEmpty()) {
            throw new DataParseException(d);
        } else {
            return LocalDate.parse(d);
        }
    }

    public static String getUserFromSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
