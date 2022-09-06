package com.example.rentalcarspringmvc.util;

import com.example.rentalcarspringmvc.exception.DataParseException;

import java.time.LocalDate;

public class MetodiUtil {

    public static LocalDate parseDate(String d) {
        if (d == null || d.isEmpty()) {
            throw new DataParseException(d);
        } else {
            return LocalDate.parse(d);
        }
    }
}
