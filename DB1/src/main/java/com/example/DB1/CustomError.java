package com.example.DB1;

import java.util.Date;

public class CustomError {
    private Date timestamp;
    private int HttpCode;
    private String mensaje;
    public CustomError(Date timestamp, int HttpCode, String mensaje){
        super();
        this.timestamp=timestamp;
        this.HttpCode=HttpCode;
        this.mensaje=mensaje;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getHttpCode() {
        return HttpCode;
    }

    public String getMensaje() {
        return mensaje;
    }
}
