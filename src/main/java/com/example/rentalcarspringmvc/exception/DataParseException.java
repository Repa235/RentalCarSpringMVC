package com.example.rentalcarspringmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Data non inserita")
public class DataParseException extends RuntimeException {
    private String dataIoF;

    public DataParseException(String dataIoF) {
        this.dataIoF = dataIoF;
    }

    public String getDataIoF() {
        return dataIoF;
    }

}
